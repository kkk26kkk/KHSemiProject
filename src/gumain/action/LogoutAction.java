package gumain.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;

// 로그아웃 후 메인페이지로 돌아가는 액션
public class LogoutAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      request.setCharacterEncoding("UTF-8");
      HttpSession session = request.getSession();
      session.invalidate();
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out;
      try {
        out = response.getWriter();
        out.println("<script>");
        out.println("alert('로그아웃 되었습니다.');");
        out.println("location.href='main.gumain'");
        out.println("</script>");
        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return null;
  }
}
