package gurecruit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
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
import dao.RecruitDAO;
import vo.Recruit;

public class RecruitListAjaxAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    // ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Map<String, String> filtermap = new HashMap<>();
    if (request.getParameter("DUTY") != null)
      filtermap.put("DUTY", request.getParameter("DUTY"));
    if (request.getParameter("REGION") != null)
      filtermap.put("REGION", request.getParameter("REGION"));
    if (request.getParameter("CAREER") != null)
      filtermap.put("CAREER", request.getParameter("CAREER"));
    if (request.getParameter("EDU") != null)
      filtermap.put("EDU", request.getParameter("EDU"));
    if (request.getParameter("ETYPE") != null)
      filtermap.put("ETYPE", request.getParameter("ETYPE"));
    if (request.getParameter("JTYPE") != null)
      filtermap.put("JTYPE", request.getParameter("JTYPE"));

    System.out.println(request.getParameter("EDU"));

    RecruitDAO recdao = new RecruitDAO();
    List<Recruit> reclist = new ArrayList<>();
    reclist = recdao.getRecruitList(filtermap);

    JSONArray jsonarray = new JSONArray();
    for (int i = 0; i < reclist.size(); i++) {
      JSONObject sObject = new JSONObject();
      sObject.put("EID", reclist.get(i).getEID());
      sObject.put("SUBJECT", reclist.get(i).getSUBJECT());
      sObject.put("ENAME", reclist.get(i).getENAME());
      sObject.put("SN", reclist.get(i).getSN());
      jsonarray.add(sObject);
    }

    response.setContentType("text/html; charset=UTF-8");
    response.setHeader("cache-control", "no-cache, no-store");

    PrintWriter out;
    try {
      out = response.getWriter();
      out.print(jsonarray);
      System.out.println(jsonarray);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

}
