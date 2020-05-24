package gumain.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;
import vo.GeneralUser;

public class MemberinfoProcess implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    GeneralUserDAO gudao = new GeneralUserDAO();
    GeneralUser gu = new GeneralUser();
    gu.setGID(request.getParameter("gid"));
    gu.setNAME(request.getParameter("name"));
    gu.setPW(request.getParameter("pw"));
    gu.setEMAIL(request.getParameter("email"));
    gu.setPHONE(request.getParameter("phone"));

    int result = gudao.Memberupdate(gu);
    // forward.setRedirect(false);
    // forward.setPath("gu/main/memberinfo.jsp");
    // request.setAttribute("gu", gu);

    PrintWriter out = null;
    try {
      out = response.getWriter();
      response.setContentType("text/html;charset=UTF-8");
      if (result == 1) {
        out.println("<script>");
        out.println("alert('update ok')");
        out.println("location.href='login.gumain'");
        out.println("</script>");
      } else {
        out.println("<script>");
        out.println("alert('update fail')");
        out.println("history.back();");
        out.println("</script>");
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return forward;
  }
}
