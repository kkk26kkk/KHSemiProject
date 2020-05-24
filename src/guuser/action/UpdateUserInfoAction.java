package guuser.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class UpdateUserInfoAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }

    ResumeDAO dao = new ResumeDAO();
    Resume vo = new Resume();


    int sn = Integer.parseInt(request.getParameter("sn"));
    String gid = request.getParameter("gid");

    System.out.println("gid" + gid + "sn" + sn);

    vo = dao.getResumeDetail(gid, sn);
    System.out.println(vo);

    if (vo == null) {
      System.out.println("(수정)상세보기 실패");
      return null;
    }
    System.out.println("(수정)상세보기 성공");

    request.setAttribute("vo", vo);
    System.out.println("vo값은=" + vo);

    forward.setRedirect(false);
    forward.setPath("gu/user/updateinfoForm.jsp");

    return forward;
  }

}
