package gumain.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;

// 로그인 처리 액션
public class LoginAction implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    String gid = request.getParameter("gid");
    String pw = request.getParameter("pw");

    GeneralUserDAO gudao = new GeneralUserDAO();
    int result = gudao.isId(gid, pw);
    System.out.println("결과는" + result);
    HttpSession session = request.getSession();

    try {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      if (session.getAttribute("gid") != null || result == 1) {
        // 로그인 처리를 위해 dao에서 id체크 메소드를 불러온다.
        // id체크
        // 로그인 성공
        System.out.print("로그인 성공!");
        // alert("로그인이 되셨습니다.");
        if (result == 1)
          session.setAttribute("gid", gid);

        out.println("<script>");
        out.println("alert('로그인 성공되었습니다.');");
        out.println("location.href='main.gumain'");
        out.println("</script>");
        out.close();

      } else {
        String message = "";
        if (result == 0)
          message = "아이디가 존재하지 않습니다.";
        else
          message = "비밀번호가 일치하지 않습니다.";

        out.println("<script>");
        out.println("alert('" + message + "');");
        out.println("location.href='./main.gumain'");
        out.println("</script>");
        out.close();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
