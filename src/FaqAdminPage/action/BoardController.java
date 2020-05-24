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
     * 요청된 전체 URL 중에서 포트 번호 다음부터 마지막 문자열까지 반환됩니다. 예)http://localhost:8088/JspProject/login.net인 경우
     * "/JspProject/login.net"반환됩니다.
     */
    String RequestURI = request.getRequestURI();
    System.out.println("*.guentreview RequestURI=" + RequestURI);

    // getContexPath():컨텍스트 경로가 반환됩니다.
    // contextPath는"/JspProject"가 반환됩니다.
    String contextPath = request.getContextPath();
    System.out.println("*.guentreview contextPath=" + contextPath);

    // RequestURI에서 컨텍스트 경로 길이 값의 인덱스 위치의 문자부터
    // 마지막 위치 문자까지 추출합니다.
    // command는 "/login.net"반환됩니다.
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
      // 리다이렉트 됩니다.
      response.sendRedirect(forward.getPath());
    } else {
      // 포워딩됩니다
      RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
      dispatcher.forward(request, response);
    }
  }

  // doProcess(request,response)메서드를 구현하여 요청이 GET방식이든
  // POST방식으로 전송되어 오든 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doProcess(request, response);

  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    doProcess(request, response);

  }

}
