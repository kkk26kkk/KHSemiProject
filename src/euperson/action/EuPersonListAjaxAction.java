package euperson.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class EuPersonListAjaxAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    Map<String, String> map = new HashMap<>();
    if (request.getParameter("DUTY") != null)
      map.put("DUTY", request.getParameter("DUTY"));
    if (request.getParameter("REGION") != null)
      map.put("REGION", request.getParameter("REGION"));
    if (request.getParameter("RANK") != null)
      map.put("RANK", request.getParameter("RANK"));
    if (request.getParameter("DESSAL") != null)
      map.put("DESSAL", request.getParameter("DESSAL"));
    if (request.getParameter("INDUSTRY") != null)
      map.put("INDUSTRY", request.getParameter("INDUSTRY"));
    if (request.getParameter("JTYPE") != null)
      map.put("JTYPE", request.getParameter("JTYPE"));
    if (request.getParameter("STYPE") != null)
      map.put("STYPE", request.getParameter("STYPE"));

    System.out.println("넘어온값" + map);

    ResumeDAO resdao = new ResumeDAO();
    List<Resume> reslist = new ArrayList<>();
    reslist = resdao.getResumeAjaxList(map);

    JSONArray jsonarray = new JSONArray();
    for (int i = 0; i < reslist.size(); i++) {
      JSONObject object = new JSONObject();
      object.put("GID", reslist.get(i).getGID());
      object.put("SN", reslist.get(i).getSN());
      object.put("SUBJECT", reslist.get(i).getSUBJECT());
      object.put("NAME", reslist.get(i).getNAME());
      object.put("BIRTH", reslist.get(i).getBIRTH());
      object.put("GENDER", reslist.get(i).getGENDER());
      object.put("EMAIL", reslist.get(i).getEMAIL());
      object.put("PHONE", reslist.get(i).getPHONE());
      object.put("ADDR", reslist.get(i).getADDR());
      object.put("PHOTO", reslist.get(i).getPHOTO());
      object.put("SNAME", reslist.get(i).getSNAME());
      object.put("STYPE", reslist.get(i).getSTYPE());
      object.put("SDOA", reslist.get(i).getSDOA());
      object.put("SDOG", reslist.get(i).getSDOG());
      object.put("MAJOR", reslist.get(i).getMAJOR());
      object.put("GRADE", reslist.get(i).getGRADE());
      object.put("ENAME", reslist.get(i).getENAME());
      object.put("DEPT", reslist.get(i).getDEPT());
      object.put("DOA", reslist.get(i).getDOA());
      object.put("DOG", reslist.get(i).getDOG());
      object.put("RANK", reslist.get(i).getRANK());
      object.put("CERTNAME", reslist.get(i).getCERTNAME());
      object.put("PUBLISHER", reslist.get(i).getPUBLISHER());
      object.put("CACDATE", reslist.get(i).getCACDATE());
      object.put("LANNAME", reslist.get(i).getLANNAME());
      object.put("LACDATE", reslist.get(i).getLACDATE());
      object.put("PRSUBJECT", reslist.get(i).getPRSUBJECT());
      object.put("PRCONTENT", reslist.get(i).getPRCONTENT());
      object.put("JTYPE", reslist.get(i).getJTYPE());
      object.put("DESSAL", reslist.get(i).getDESSAL());
      object.put("REGION", reslist.get(i).getREGION());
      object.put("DUTY", reslist.get(i).getDUTY());
      object.put("INDUSTRY", reslist.get(i).getINDUSTRY());
      object.put("RGS_DTM", reslist.get(i).getRGS_DTM());
      jsonarray.add(object);

    }


    response.setContentType("text/html;charset=UTF-8");
    response.setHeader("cache-control", "no-cache, no-store");

    PrintWriter out;
    try {
      out = response.getWriter();
      out.print(jsonarray);
      System.out.println(jsonarray);
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}
