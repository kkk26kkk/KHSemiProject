package eumain.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.EnterpriseHrdDAO;

public class EuLoginAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String eid = request.getParameter("EID");
    String pw = request.getParameter("PW");

    EnterpriseHrdDAO ehrddao = new EnterpriseHrdDAO();
    int result = ehrddao.isId(eid, pw);
    System.out.println("����� " + result);

    PrintWriter out = null;
    try {
      HttpSession session = request.getSession();
      response.setContentType("text/html; charset=UTF-8");
      out = response.getWriter();

      if (result == 1) {
        session.setAttribute("eid", eid);

        out.println("<script>");
        out.println("alert('�α��� �����Ǿ����ϴ�.');");
        out.println("location.href='main.eumain'");
        out.println("</script>");
        out.close();

      } else {
        String message = "";

        if (result == -1)
          message = "���̵� �������� �ʽ��ϴ�.";
        else
          message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";

        out.println("<script>");
        out.println("alert('" + message + "');");
        out.println("location.href='login.eumain'");
        out.println("</script>");
        out.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

}
