package eumain.action;

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
@WebServlet("*.eumain")
public class EuMainController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public EuMainController() {
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
    System.out.println("*.eumain RequestURI=" + RequestURI);

    // getContexPath():���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
    // contextPath��"/JspProject"�� ��ȯ�˴ϴ�.
    String contextPath = request.getContextPath();
    System.out.println("*.eumain contextPath=" + contextPath);

    // RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
    // ������ ��ġ ���ڱ��� �����մϴ�.
    // command�� "/login.net"��ȯ�˴ϴ�.
    String command = RequestURI.substring(contextPath.length());
    System.out.println("*.eumain command=" + command);


    ActionForward forward = null;
    Action action = null;

    List<String> cmds = Arrays.asList("/join.eumain", "/login.eumain", "/insertinfoform.eumain");
    List<String> urls = Arrays.asList("eu/main/joinForm.jsp", "eu/main/loginForm.jsp",
        "eu/main/insertInfoForm.jsp");

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
    if (command.equals("/main.eumain")) {
      action = new EuMainAction();
      forward = action.execute(request, response);
    } else if ("/joinProcess.eumain".equals(command)) {
      action = new EuJoinAction();
      forward = action.execute(request, response);
    } else if ("/loginProcess.eumain".equals(command)) {
      action = new EuLoginAction();
      forward = action.execute(request, response);
    } else if ("/logout.eumain".equals(command)) {
      action = new EuLogoutAction();
      forward = action.execute(request, response);
    } else if ("/entinfo.eumain".equals(command)) {
      action = new EuEntinfoAction();
      forward = action.execute(request, response);
    } else if ("/entinfoadd.eumain".equals(command)) { // ��� ������ �̵���
      action = new EuEntinfoAddAction();
      forward = action.execute(request, response);
    } else if ("/infoaddProcess.eumain".equals(command)) { // ���� ��� ó��
      action = new AddInfoProcessAction();
      forward = action.execute(request, response);
    } else if ("/updateinfo.eumain".equals(command)) {
      action = new UpdateInfoAction();
      forward = action.execute(request, response);
    } else if ("/updateinfoProcess.eumain".equals(command)) {
      action = new UpdateInfoProcessAction();
      forward = action.execute(request, response);
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
