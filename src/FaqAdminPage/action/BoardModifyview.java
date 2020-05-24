package FaqAdminPage.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;


public class BoardModifyview implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    ActionForward forward = new ActionForward();


    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();

    // 파라미터로 전달받은 수정할 글 번호를 num변수에 저장합니다.
    int num = Integer.parseInt(request.getParameter("num"));

    // 글 내용을 불러와서 boarddata객체에 저장합니다.
    boarddata = boarddao.getDetail(num);

    // 글 내용 불러오기 실패한 경우입니다.
    if (boarddata == null) {
      System.out.println("(수정)상세보기 실패");
      return null;
    }
    System.out.println("(수정)상세보기 성공");

    // 수정 폼 페이지로 이동할 때 원문 글 내용을 보여주기 때문에 boarddata
    // 객체를 request 객체에 저장합니다.
    request.setAttribute("boarddata", boarddata);
    forward.setRedirect(false);
    // 글 수정 폼 페이지로 이동하기위해 경로를 설정합니다.
    forward.setPath("FAQ/BoardModify.jsp");
    return forward;
  }
}
