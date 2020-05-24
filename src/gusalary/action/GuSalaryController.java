package gusalary.action;

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
@WebServlet("*.gusalary")
public class GuSalaryController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public GuSalaryController() {
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
    System.out.println("*.gusalary RequestURI=" + RequestURI);

    // getContexPath():���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
    // contextPath��"/JspProject"�� ��ȯ�˴ϴ�.
    String contextPath = request.getContextPath();
    System.out.println("*.gusalary contextPath=" + contextPath);

    // RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
    // ������ ��ġ ���ڱ��� �����մϴ�.
    // command�� "/login.net"��ȯ�˴ϴ�.
    String command = RequestURI.substring(contextPath.length());
    System.out.println("*.gusalary command=" + command);


    ActionForward forward = null;
    Action action = null;

    List<String> cmds = Arrays.asList("/write.gusalary");
    List<String> urls = Arrays.asList("gu/salary/salaryForm.jsp");

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
    if ("/home.gusalary".equals(command)) {
      action = new SalaryHomeAction();
      forward = action.execute(request, response);
    } else if ("/salaryDetail.gusalary".equals(command)) {
      action = new SalaryDetailAction();
      forward = action.execute(request, response);
    } else if ("/salaryApply.gusalary".equals(command)) {
      action = new SalaryApplyAction();
      forward = action.execute(request, response);
    }
    
    
    else if("/salaryInfo.gusalary".equals(command)) {
    	action = new SalaryInfoAction();
        forward = action.execute(request, response);
    }else if("/salaryUpdate.gusalary".equals(command)) {
    	action = new SalaryUpdateAction();
        forward = action.execute(request, response);
    }else if("/salaryDelete.gusalary".equals(command)) {
    	action = new SalaryDeleteAction();
        forward = action.execute(request, response);
    }
    
    else {
      System.out.println("Command not matched : " + command);
    }



    // �ּ� ó��
    if (forward != null) {
      if (forward.isRedirect()) {// �����̷�Ʈ �˴ϴ�.
        response.sendRedirect(forward.getPath());
      } else {// �������˴ϴ�
        RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);
      }
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
