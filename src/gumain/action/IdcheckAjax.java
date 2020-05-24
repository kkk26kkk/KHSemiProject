package gumain.action;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;

public class IdcheckAjax implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    GeneralUserDAO gudao = new GeneralUserDAO();
    String gid = request.getParameter("gid");
    int result = gudao.isId(gid);
    System.out.println("result = " + result);
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out;
    try {
      out = response.getWriter();
      out.print(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return null;
  }
}
