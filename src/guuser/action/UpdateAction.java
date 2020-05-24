package guuser.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class UpdateAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }

    ActionForward forward = new ActionForward();
    boolean result = false;

    System.out.println(request.getParameter("num"));
    int num = Integer.parseInt(request.getParameter("num"));
    String gid = request.getParameter("GID");
    ResumeDAO dao = new ResumeDAO();
    Resume vo = new Resume();

    vo.setGID(gid);
    System.out.println(request.getParameter("GID"));
    vo.setSN(num);
    vo.setSUBJECT(request.getParameter("SUBJECT"));
    System.out.println(request.getParameter("SUBJECT"));
    vo.setNAME(request.getParameter("NAME"));
    vo.setBIRTH(request.getParameter("BIRTH"));
    vo.setGENDER(request.getParameter("GENDER"));
    vo.setEMAIL(request.getParameter("EMAIL"));
    vo.setPHONE(request.getParameter("PHONE"));
    vo.setADDR(request.getParameter("ADDR"));
    vo.setPHOTO(request.getParameter("PHOTO"));
    vo.setSTYPE(request.getParameter("STYPE"));
    vo.setSNAME(request.getParameter("SNAME"));
    vo.setSDOA(request.getParameter("SDOA"));
    vo.setSDOG(request.getParameter("SDOG"));
    vo.setMAJOR(request.getParameter("MAJOR"));
    vo.setGRADE(request.getParameter("GRADE"));
    vo.setENAME(request.getParameter("ENAME"));
    vo.setDEPT(request.getParameter("DEPT"));
    vo.setDOA(request.getParameter("DOA"));
    vo.setDOG(request.getParameter("DOG"));
    vo.setRANK(request.getParameter("RANK"));
    vo.setCERTNAME(request.getParameter("CERTNAME"));
    vo.setPUBLISHER(request.getParameter("PUBLISHER"));
    vo.setCACDATE(request.getParameter("CACDATE"));
    vo.setLANNAME(request.getParameter("LANNAME"));
    vo.setRATING(request.getParameter("RATING"));
    vo.setLACDATE(request.getParameter("LACDATE"));
    vo.setPRSUBJECT(request.getParameter("PRSUBJECT"));
    vo.setPRCONTENT(request.getParameter("PRCONTENT"));
    vo.setJTYPE(request.getParameter("JTYPE"));
    vo.setDESSAL(request.getParameter("DESSAL"));
    vo.setREGION(request.getParameter("REGION"));
    vo.setDUTY(request.getParameter("DUTY"));
    vo.setINDUSTRY(request.getParameter("INDUSTRY"));
    vo.setRGS_DTM(request.getParameter("RGS_DTM"));
    vo.setUPT_DTM(request.getParameter("UPT_DTM"));

    result = dao.update(vo);

    if (result == false) {
      System.out.println("이력서 수정 실패");
      return null;
    }
    System.out.println("이력서 수정 성공");

    forward.setRedirect(true);
    forward.setPath("./resumeview.guuser?gid=" + vo.getGID() + "&sn=" + vo.getSN());

    return forward;
  }

}
