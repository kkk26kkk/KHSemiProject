package guuser.action;

import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class ResumeAddAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    // ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Resume res = new Resume();
    ResumeDAO resdao = new ResumeDAO();

    res.setSUBJECT(request.getParameter("SUBJECT"));
    res.setNAME(request.getParameter("NAME"));
    res.setBIRTH(request.getParameter("BIRTH"));
    res.setGENDER(request.getParameter("GENDER"));
    res.setEMAIL(request.getParameter("EMAIL"));
    res.setPHONE(request.getParameter("PHONE"));
    res.setADDR(request.getParameter("ADDR"));
    res.setPHOTO(request.getParameter("PHOTO"));
    res.setSTYPE(request.getParameter("STYPE"));
    res.setSNAME(request.getParameter("SNAME"));
    res.setSDOA(request.getParameter("SDOA"));
    res.setSDOG(request.getParameter("SDOG"));
    res.setMAJOR(request.getParameter("MAJOR"));
    res.setGRADE(request.getParameter("GRADE"));
    res.setENAME(request.getParameter("ENAME"));
    res.setDEPT(request.getParameter("DEPT"));
    res.setDOA(request.getParameter("DOA"));
    res.setDOG(request.getParameter("DOG"));
    res.setRANK(request.getParameter("RANK"));
    res.setCERTNAME(request.getParameter("CERTNAME"));
    res.setPUBLISHER(request.getParameter("PUBLISHER"));
    res.setCACDATE(request.getParameter("CACDATE"));
    res.setLANNAME(request.getParameter("LANNAME"));
    res.setRATING(request.getParameter("RATING"));
    res.setLACDATE(request.getParameter("LACDATE"));
    res.setPRSUBJECT(request.getParameter("PRSUBJECT"));
    res.setPRCONTENT(request.getParameter("PRCONTENT"));
    res.setJTYPE(request.getParameter("JTYPE"));
    res.setDESSAL(request.getParameter("DESSAL"));
    res.setREGION(request.getParameter("REGION"));
    res.setDUTY(request.getParameter("DUTY"));
    res.setINDUSTRY(request.getParameter("INDUSTRY"));

    HttpSession session = request.getSession();
    String gid = (String) session.getAttribute("gid");

    int result = resdao.insertRes(res, gid);

    // if (result == 1)
    // System.out.println("정상적으로 등록되었습니다.");
    // else
    // System.out.println("등록 안됐어요");

    try {
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();

      if (result == 1) {
        out.println("<script>");
        out.println("alert('정상적으로 등록되었습니다.');");
        out.println("location.href='./resumelist.guuser'");
        out.println("</script>");
        out.close();
      } else {
        out.println("<script>");
        out.println("alert('등록에 실패했습니다.');");
        out.println("history.back(-1);'");
        out.println("</script>");
        out.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    // forward.setRedirect(true);
    // forward.setPath("./resumelist.guuser");
    //
    // return forward;
    return null;
  }

}
