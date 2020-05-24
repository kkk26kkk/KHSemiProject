package FaqAdminPage.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;

public class BoardModify implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    ActionForward forward = new ActionForward();
    boolean result = false;

    // 전달받은 파라미터 num 변수에 저장합니다.
    System.out.print(request.getParameter("num"));

    int num = Integer.parseInt(request.getParameter("num"));

    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();


    // 글쓴이 인지 확인하기 위해 저장된 비밀번호와 입력한 비밀번호를 비교합니다.
    boolean usercheck = boarddao.isBoardWriter(num, request.getParameter("PASS"));

    // 비밀번호가 다른 경우
    if (usercheck == false) {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out;
      try {
        out = response.getWriter();
        out.println("<script>");
        out.println("alert('비밀번호가 다릅니다.');");
        out.println("history.back();");
        out.println("</script>");
        out.close();
        return null;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    // 비밀번호가 일치하는 경우
    // 수정 내용을 설정합니다.
    boarddata.setSN(num);
    boarddata.setSUBJECT(request.getParameter("SUBJECT"));
    boarddata.setCONTENT(request.getParameter("CONTENT"));



    // DAO에서 수정 메서드 호출하여 수정합니다.
    result = boarddao.Modify(boarddata);
    // 수정에 실패한 경우
    if (result == false) {
      System.out.println("게시판 수정 실패");
      return null;
    }
    // 수정 성공의 경우
    System.out.println("게시판 수정 완료");

    forward.setRedirect(true);
    // 수정한 글 내용을 보여주기 위해 글 내용 보기 보기 페이지로 이동하기위해 경로를 설정합니다.
    forward.setPath("./boardDetail.FA?num=" + boarddata.getSN());
    return forward;
  }
}
