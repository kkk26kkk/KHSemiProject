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

    // ���޹��� �Ķ���� num ������ �����մϴ�.
    System.out.print(request.getParameter("num"));

    int num = Integer.parseInt(request.getParameter("num"));

    BoardDAO boarddao = new BoardDAO();
    BoardVo boarddata = new BoardVo();


    // �۾��� ���� Ȯ���ϱ� ���� ����� ��й�ȣ�� �Է��� ��й�ȣ�� ���մϴ�.
    boolean usercheck = boarddao.isBoardWriter(num, request.getParameter("PASS"));

    // ��й�ȣ�� �ٸ� ���
    if (usercheck == false) {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out;
      try {
        out = response.getWriter();
        out.println("<script>");
        out.println("alert('��й�ȣ�� �ٸ��ϴ�.');");
        out.println("history.back();");
        out.println("</script>");
        out.close();
        return null;
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

    }
    // ��й�ȣ�� ��ġ�ϴ� ���
    // ���� ������ �����մϴ�.
    boarddata.setSN(num);
    boarddata.setSUBJECT(request.getParameter("SUBJECT"));
    boarddata.setCONTENT(request.getParameter("CONTENT"));



    // DAO���� ���� �޼��� ȣ���Ͽ� �����մϴ�.
    result = boarddao.Modify(boarddata);
    // ������ ������ ���
    if (result == false) {
      System.out.println("�Խ��� ���� ����");
      return null;
    }
    // ���� ������ ���
    System.out.println("�Խ��� ���� �Ϸ�");

    forward.setRedirect(true);
    // ������ �� ������ �����ֱ� ���� �� ���� ���� ���� �������� �̵��ϱ����� ��θ� �����մϴ�.
    forward.setPath("./boardDetail.FA?num=" + boarddata.getSN());
    return forward;
  }
}
