package gumain.action;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.gumain")
public class GuMainController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public GuMainController() {
    super();
    // TODO Auto-generated constructor stub
  }

  protected void doProcess(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    /*
     * ��û�� ��ü URL �߿��� ��Ʈ ��ȣ �������� ������ ���ڿ����� ��ȯ�˴ϴ�. ��)http://localhost:8088/JspProject/login.net�� ���
     * "/JspProject/login.net"��ȯ�˴ϴ�.
     */
    String RequestURI = request.getRequestURI();
    System.out.println("*.gumain requestURI = " + RequestURI);

    // getContexPath():���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
    // contextPath��"/JspProject"�� ��ȯ�˴ϴ�.
    String contextPath = request.getContextPath();
    System.out.println("*.gumain contextPath = " + contextPath);

    // RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
    // ������ ��ġ ���ڱ��� �����մϴ�.
    // command�� "/login.net"��ȯ�˴ϴ�.
    String command = RequestURI.substring(contextPath.length());
    System.out.println("*.gumain command = " + command);

    ActionForward forward = null;
    Action action = null;

    List<String> cmds = Arrays.asList("/join.gumain", "/login.gumain", "/delete.gumain");
    List<String> urls =
        Arrays.asList("gu/main/joinForm.jsp", "gu/main/loginForm.jsp", "gu/main/deleteForm.jsp");

    for (int i = 0; i < cmds.size(); i++) {
      String cmd = cmds.get(i);
      if (cmd.equals(command)) {
        forward = new ActionForward();
        forward.setRedirect(false);
        forward.setPath(urls.get(i));
      }
    }

    if (forward != null) {
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
      dispatcher.forward(request, response);
      return;
    }

    // �ּ� ����
    if ("/main.gumain".equals(command)) {
      action = new MainAction();
      forward = action.execute(request, response);
    } else if ("/joinProcess.gumain".equals(command)) {
      action = new JoinAction();
      forward = action.execute(request, response);
    } else if ("/loginProcess.gumain".equals(command)) {
      action = new LoginAction();
      forward = action.execute(request, response);
    } else if ("/logout.gumain".equals(command)) {
      action = new LogoutAction();
      forward = action.execute(request, response);
    } else if ("/updateinfo.gumain".equals(command)) {
      action = new UpdateinfoAction();
      forward = action.execute(request, response);
    } else if ("/memberinfoProcess.gumain".equals(command)) {
      action = new MemberinfoProcess();
      forward = action.execute(request, response);
    } else if ("/deleteProcess.gumain".equals(command)) {// ȸ��Ż�������� ��й�ȣ �Է� �� ��ġ�ϸ�
      action = new DeleteProcess();// DeleteProcess Action���� ȸ������ ���� ��������
      forward = action.execute(request, response);
    } else if ("/IdcheckAjax.gumain".equals(command)) {// ȸ��Ż�������� ��й�ȣ �Է� �� ��ġ�ϸ�
      action = new IdcheckAjax();// DeleteProcess Action���� ȸ������ ���� ��������
      forward = action.execute(request, response);
    } else if ("/delete.gumain".equals(command)) {// gumain���� ȸ��Ż�� ���� ������
      forward = new ActionForward();
      forward.setRedirect(false);
      forward.setPath("gu/main/deleteForm.jsp");// ȸ��Ż�������� �̵�
    } else {
      System.out.println("Command not matched : " + command);
    }

    if (forward == null) {
      System.out.println("No forward defined");
      return;
    }

    if (forward.isRedirect()) {
      // �����̷�Ʈ �˴ϴ�.
      response.sendRedirect(forward.getPath());
    } else {
      // �������˴ϴ�
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
      dispatcher.forward(request, response);
    }

  }

  // doProcess(request,response)�޼��带 �����Ͽ� ��û�� GET����̵�
  // POST������� ���۵Ǿ� ���� ���� �޼��忡�� ��û�� ó���� �� �ֵ��� �Ͽ����ϴ�.
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doProcess(request, response);
  }
}
