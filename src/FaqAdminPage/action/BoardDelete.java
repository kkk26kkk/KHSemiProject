package FaqAdminPage.action;


import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;

public class BoardDelete implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    ActionForward forward = new ActionForward();

    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();

    boolean result = false;
    boolean usercheck = false;

    System.out.println(usercheck);

    int num = Integer.parseInt(request.getParameter("num"));

    // usercheck = boarddao.isBoardWriter(num, request.getParameter("PASS"));

    // if (usercheck == false) {
    // response.setContentType("text/html;charset=UTF-8");
    // try {
    // PrintWriter out = response.getWriter();
    // out.println("<script>");
    // out.println("alert('비밀번호가 다릅니다.')");
    // out.println("history.back();");
    // out.println("</script>");
    // out.close();
    // return null;
    // } catch (IOException e) {
    // e.printStackTrace();
    // }
    // }

    result = boarddao.BoardDelete(num);

    if (result == false) {
      System.out.println("게시판 삭제 실패");
      return null;
    }
    System.out.println("게시판 삭제 성공");

    forward.setRedirect(false);
    forward.setPath("/boardList.FA");

    return forward;
  }

}
