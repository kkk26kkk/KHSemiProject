package gumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;
import vo.GeneralUser;

// ȸ������ ó�� �� ������������ ���ư��� �׼�
public class JoinAction implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    GeneralUser gu = new GeneralUser();
    gu.setGID(request.getParameter("gid"));
    gu.setNAME(request.getParameter("name"));
    gu.setPW(request.getParameter("pw"));
    gu.setEMAIL(request.getParameter("email"));
    gu.setPHONE(request.getParameter("phone"));

    GeneralUserDAO gudao = new GeneralUserDAO();
    int result = gudao.insertGuUser(gu);

    if (result == 1) {
      System.out.println("���������� ��ϵǾ����ϴ�.");
      forward.setRedirect(true);
      forward.setPath("./main.gumain");
      return forward;
    } else {
      System.out.println("���������� ��ϵ��� �ʾҽ��ϴ�.");
      return null;
    }
  }
}
