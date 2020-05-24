package guuser.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class ResumeViewAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    ResumeDAO resdao = new ResumeDAO();
    Resume res = new Resume();

    String gid = request.getParameter("gid");
    int sn = Integer.parseInt(request.getParameter("sn"));

    res = resdao.getResumeDetail(gid, sn);

    request.setAttribute("res", res);

    forward.setRedirect(false);
    forward.setPath("gu/user/resumeview.jsp");
    return forward;
  }

}
