package guuser.action;

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
@WebServlet("*.guuser")
public class GuUserController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public GuUserController() {
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
    System.out.println("*.guuser RequestURI=" + RequestURI);

    // getContexPath():���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
    // contextPath��"/JspProject"�� ��ȯ�˴ϴ�.
    String contextPath = request.getContextPath();
    System.out.println("*.guuser contextPath=" + contextPath);

    // RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
    // ������ ��ġ ���ڱ��� �����մϴ�.
    // command�� "/login.net"��ȯ�˴ϴ�.
    String command = RequestURI.substring(contextPath.length());
    System.out.println("*.guuser command=" + command);


    ActionForward forward = null;
    Action action = null;

    List<String> cmds = Arrays.asList("");
    List<String> urls = Arrays.asList("");

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

    if ("/applylist.guuser".equals(command)) { // �Ի� ���� ��Ȳ
      action = new ApplyListAction();
      forward = action.execute(request, response);
    } else if ("/resumelist.guuser".equals(command)) { // �̷¼� ����
      action = new ResumeListAction();
      forward = action.execute(request, response);
    } else if ("/entreviewlist.guuser".equals(command)) { // ��� ���� �ۼ� ����
      action = new EntreviewListAction();
      forward = action.execute(request, response);
    } else if ("/salarylist.guuser".equals(command)) { // ��� ���� �ۼ� ����
      action = new SalaryListAction();
      forward = action.execute(request, response);
    } else if ("/interviewlist.guuser".equals(command)) {
      action = new InterviewListAction();
      forward = action.execute(request, response);
    } else if ("/resumewrite.guuser".equals(command)) {
      action = new ResumeWriteAction();
      forward = action.execute(request, response);
    } else if ("/resumeview.guuser".equals(command)) { // �ڽ��� �� �̷¼� �� ����
      action = new ResumeViewAction();
      forward = action.execute(request, response);
    } else if ("/userinfo.guuser".equals(command)) { // ȸ�� ���� ����
      action = new UserInfoAction();
      forward = action.execute(request, response);
    } else if (("/resumeAdd.guuser").equals(command)) {
      action = new ResumeAddAction();
      forward = action.execute(request, response);
    } else if (("/updateuserinfo.guuser").equals(command)) {
      action = new UpdateUserInfoAction();
      forward = action.execute(request, response);
    } else if (("/resumeupdate.guuser").equals(command)) {
      action = new UpdateUserInfoAction();
      forward = action.execute(request, response);
    } else if (("/resumeupdateAction.guuser").equals(command)) {
      action = new UpdateAction();
      forward = action.execute(request, response);
    } else if (("/resumedelete.guuser").equals(command)) {
      action = new ResumeDelete();
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
