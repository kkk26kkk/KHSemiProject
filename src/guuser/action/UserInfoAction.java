package guuser.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;

public class UserInfoAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    // ȸ�� ���� ����

    forward.setRedirect(false);
    forward.setPath("gu/user/userinfoForm.jsp");
    return forward;
  }

}
