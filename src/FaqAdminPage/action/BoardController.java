package FaqAdminPage.action;

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
@WebServlet("*.FA")
public class BoardController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public BoardController() {
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
    System.out.println("*.guentreview RequestURI=" + RequestURI);

    // getContexPath():���ؽ�Ʈ ��ΰ� ��ȯ�˴ϴ�.
    // contextPath��"/JspProject"�� ��ȯ�˴ϴ�.
    String contextPath = request.getContextPath();
    System.out.println("*.guentreview contextPath=" + contextPath);

    // RequestURI���� ���ؽ�Ʈ ��� ���� ���� �ε��� ��ġ�� ���ں���
    // ������ ��ġ ���ڱ��� �����մϴ�.
    // command�� "/login.net"��ȯ�˴ϴ�.
    String command = RequestURI.substring(contextPath.length());
    System.out.println("*.guentreview command=" + command);


    ActionForward forward = null;
    Action action = null;

    List<String> cmds = Arrays.asList("/fawi.FA");
    List<String> urls = Arrays.asList("/FAQ/BoardWrite.jsp");

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

    if ("/boardList.FA".equals(command)) {
      action = new BoardList();
      forward = action.execute(request, response);
    } else if ("/boardwrite.FA".equals(command)) {
      action = new BoardWrite();
      forward = action.execute(request, response);
    } else if ("/boardAdd.FA".equals(command)) {
      action = new BoardAdd();
      forward = action.execute(request, response);
    } else if ("/boardview.FA".equals(command)) {
      action = new BoardReplyView();
      forward = action.execute(request, response);
    } else if ("/boardDelete.FA".equals(command)) {
      action = new BoardDelete();
      forward = action.execute(request, response);
    } else if ("/boardDetail.FA".equals(command)) {
      action = new BoardDetail();
      forward = action.execute(request, response);
    } else if ("/boardModifyView.FA".equals(command)) {
      action = new BoardModifyview();
      forward = action.execute(request, response);
    } else if ("/boardModify.FA".equals(command)) {
      action = new BoardModify();
      forward = action.execute(request, response);
    } else if ("/boardReplyView.FA".equals(command)) {
      action = new BoardReplyView();
      forward = action.execute(request, response);
    } else if ("/boardReply.FA".equals(command)) {
      action = new BoardReply();
      forward = action.execute(request, response);
    } else if ("/boardFileDown.FA".endsWith(command)) {
      action = new BoardDown();
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
