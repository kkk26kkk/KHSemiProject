package gumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;
import vo.GeneralUser;

public class UpdateinfoAction implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();
    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    GeneralUserDAO gudao = new GeneralUserDAO();
    HttpSession session = request.getSession();
    String gid = (String) session.getAttribute("gid");
    System.out.println("action id=" + gid);
    GeneralUser gu = gudao.getGuInfo(gid);

    forward.setRedirect(false);
    forward.setPath("gu/main/memberinfo.jsp");
    request.setAttribute("gu", gu);
    return forward;
  }
}
