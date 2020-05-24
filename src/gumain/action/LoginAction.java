package gumain.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;

// �α��� ó�� �׼�
public class LoginAction implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    String gid = request.getParameter("gid");
    String pw = request.getParameter("pw");

    GeneralUserDAO gudao = new GeneralUserDAO();
    int result = gudao.isId(gid, pw);
    System.out.println("�����" + result);
    HttpSession session = request.getSession();

    try {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      if (session.getAttribute("gid") != null || result == 1) {
        // �α��� ó���� ���� dao���� idüũ �޼ҵ带 �ҷ��´�.
        // idüũ
        // �α��� ����
        System.out.print("�α��� ����!");
        // alert("�α����� �Ǽ̽��ϴ�.");
        if (result == 1)
          session.setAttribute("gid", gid);

        out.println("<script>");
        out.println("alert('�α��� �����Ǿ����ϴ�.');");
        out.println("location.href='main.gumain'");
        out.println("</script>");
        out.close();

      } else {
        String message = "";
        if (result == 0)
          message = "���̵� �������� �ʽ��ϴ�.";
        else
          message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";

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
