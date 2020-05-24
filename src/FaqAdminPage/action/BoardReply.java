package FaqAdminPage.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;

public class BoardReply implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    ActionForward forward = new ActionForward();
    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();
    int result = 0;
    boarddata.setSN(Integer.parseInt(request.getParameter("SN")));
    boarddata.setUSERID(request.getParameter("USERID"));
    boarddata.setPASS(request.getParameter("PASS"));
    boarddata.setSUBJECT(request.getParameter("SUBJECT"));
    boarddata.setCONTENT(request.getParameter("CONTENT"));
    boarddata.setRE_REF(Integer.parseInt(request.getParameter("RE_REF")));
    boarddata.setRE_LEV(Integer.parseInt(request.getParameter("RE_LEV")));
    boarddata.setRE_SEQ(Integer.parseInt(request.getParameter("RE_SEQ")));

    result = boarddao.boardReply(boarddata);


    if (result == 0) {
      System.out.println("답장 실패");
      return null;
    }

    System.out.println("답장완료");
    forward.setRedirect(true);
    forward.setPath("./boardDetail.FA?num=" + result);
    return forward;
  }

}
