package guuser.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;
import vo.GeneralUser;

public class ResumeWriteAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    GeneralUser gu = new GeneralUser();
    GeneralUserDAO gudao = new GeneralUserDAO();

    HttpSession session = request.getSession();
    String gid = (String) session.getAttribute("gid");

    gu = gudao.getGuInfo(gid);

    request.setAttribute("gu", gu);

    forward.setRedirect(false);
    forward.setPath("gu/user/resumeForm.jsp");

    return forward;
  }

}
