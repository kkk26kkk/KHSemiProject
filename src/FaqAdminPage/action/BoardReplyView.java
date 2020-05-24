// �亯
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

    // �Ķ���ͷ� ���޹��� �亯�� �۹�ȣ�� num������ ����
    int num = Integer.parseInt(request.getParameter("num"));
    System.out.println("�Ѵ�" + request.getParameter("num"));
    // �۹�ȣ num�� �ش��ϴ� ������ Faddata ��ü�� ����
    boarddata = boarddao.getDetail(num);


    // �۳����� ���� ���
    if (boarddata == null) {
      System.out.println("���������� �̵� ����");
      return null;
    }
    System.out.println("���� ������ �̵� �Ϸ�");

    // �������� �����ֱ� ����
    // faqdata��ü�� request��ü�� ����
    request.setAttribute("boarddata", boarddata);

    forward.setRedirect(false);
    forward.setPath("FAQ/BoardReply.jsp");

    return forward;
  }

}
