package eurecruit.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.RecruitDAO;
import vo.Recruit;

public class RecruitAddAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    RecruitDAO rdao = new RecruitDAO();
    Recruit r = new Recruit();

    r.setSUBJECT(request.getParameter("SUBJECT"));
    r.setENAME(request.getParameter("ENAME"));
    r.setCAREER(request.getParameter("CAREER"));
    r.setEDU(request.getParameter("EDU"));
    r.setJTYPE(request.getParameter("JTYPE"));
    r.setDUTY(request.getParameter("DUTY"));
    r.setRECNUM(request.getParameter("RECNUM"));
    r.setINDUSTRY(request.getParameter("INDUSTRY"));
    r.setREVENUE(request.getParameter("REVENUE"));
    r.setKIND(request.getParameter("KIND"));
    r.setPAY(request.getParameter("PAY"));
    r.setJOB(request.getParameter("JOB"));
    r.setELIGI(request.getParameter("ELIGI"));
    r.setWTYPE(request.getParameter("WTYPE"));
    r.setREGION(request.getParameter("REGION"));
    r.setSTARTDATE(request.getParameter("STARTDATE"));
    r.setENDDATE(request.getParameter("ENDDATE"));
    r.setNOTICE(request.getParameter("NOTICE"));
    r.setWDAY(request.getParameter("WDAY"));
    r.setWTIME(request.getParameter("WTIME"));

    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");
    int result = rdao.insertRecruit(r, eid);

    if (result == 1) {
      System.out.println("정상적으로 등록되었습니다.");
    } else {
      System.out.println("안돼");
    }

    forward.setRedirect(true);
    forward.setPath("./recruitlist.eurecruit");

    return forward;
  }

}
