package eumain.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;

public class EuLogoutAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      HttpSession session = request.getSession();
      session.invalidate();
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out;
      try {
        out = response.getWriter();
        out.println("<script>");
        out.println("alert('로그아웃 되었습니다.');");
        out.println("location.href='main.eumain'");
        out.println("</script>");
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}
