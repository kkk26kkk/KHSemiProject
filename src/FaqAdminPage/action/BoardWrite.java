package FaqAdminPage.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;

public class BoardWrite implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("utf-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    forward.setRedirect(false);
    forward.setPath("FAQ/BoardWrite.jsp");

    return forward;
  }

}
