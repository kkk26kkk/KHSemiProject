package guuser.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class ResumeDelete implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }

    Resume vo = new Resume();
    ResumeDAO dao = new ResumeDAO();

    boolean result = false;
    boolean usercheck = false;

    int sn = Integer.parseInt(request.getParameter("sn"));
    String gid = request.getParameter("gid");
    System.out.println("gid=" + gid);
    System.out.println("sn=" + sn);

    result = dao.Delete(sn, gid);
    if (result == false) {
      System.out.println("게시판 삭제 실패");
      return null;
    }



    System.out.println("게시판 삭제 성공");

    forward.setPath("/resumelist.guuser?gid=" + gid);
    forward.setRedirect(false);
    return forward;
  }

}
