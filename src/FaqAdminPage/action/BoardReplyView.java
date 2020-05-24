// 답변
package FaqAdminPage.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;

public class BoardReplyView implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();

    // 파라미터로 전달받은 답변할 글번호를 num변수에 저장
    int num = Integer.parseInt(request.getParameter("num"));
    System.out.println("넘느" + request.getParameter("num"));
    // 글번호 num에 해당하는 내용을 Faddata 객체에 저장
    boarddata = boarddao.getDetail(num);


    // 글내용이 없는 경우
    if (boarddata == null) {
      System.out.println("답장페이지 이동 실패");
      return null;
    }
    System.out.println("답장 페이지 이동 완료");

    // 원본글을 보여주기 위해
    // faqdata객체를 request객체에 저장
    request.setAttribute("boarddata", boarddata);

    forward.setRedirect(false);
    forward.setPath("FAQ/BoardReply.jsp");

    return forward;
  }

}
