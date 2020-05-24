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

    // �Ķ���ͷ� ���޹��� ������ �� ��ȣ�� num������ �����մϴ�.
    int num = Integer.parseInt(request.getParameter("num"));

    // �� ������ �ҷ��ͼ� boarddata��ü�� �����մϴ�.
    boarddata = boarddao.getDetail(num);

    // �� ���� �ҷ����� ������ ����Դϴ�.
    if (boarddata == null) {
      System.out.println("(����)�󼼺��� ����");
      return null;
    }
    System.out.println("(����)�󼼺��� ����");

    // ���� �� �������� �̵��� �� ���� �� ������ �����ֱ� ������ boarddata
    // ��ü�� request ��ü�� �����մϴ�.
    request.setAttribute("boarddata", boarddata);
    forward.setRedirect(false);
    // �� ���� �� �������� �̵��ϱ����� ��θ� �����մϴ�.
    forward.setPath("FAQ/BoardModify.jsp");
    return forward;
  }
}
