package FaqAdminPage.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;

public class BoardDetail implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    // �۹�ȣ �Ķ���� ���� num������ �����մϴ�.
    int num = Integer.parseInt(request.getParameter("num"));
    System.out.println("num=" + num);

    // ������ Ȯ���� ���� ��ȸ���� ������ŵ�ϴ�.
    boarddao.setReadCountUpdate(num);

    // ���� ������ DAO���� ���� �� ���� ����� boarddata ��ü�� �����մϴ�.
    boarddata = boarddao.getDetail(num);

    // DAO���� ���� ������ ���� ������ ��� null�� ��ȯ�մϴ�.
    if (boarddata == null) {
      System.out.println("�󼼺��� ����");
      return null;
    }
    System.out.println("�󼼺��� ����");

    // boarddata ��ü�� Request ��ü�� �����մϴ�.
    request.setAttribute("boarddata", boarddata);
    ActionForward forward = new ActionForward();
    forward.setRedirect(false);

    // �� ���� ���� �������� �̵��ϱ� ���� ��θ� �����մϴ�.
    forward.setPath("FAQ/Boardview2.jsp");
    return forward;
  }
}
