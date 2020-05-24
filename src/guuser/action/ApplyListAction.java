package guuser.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;

public class ApplyListAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    // 입사 지원 현황 가져옴

    forward.setRedirect(false);
    forward.setPath("gu/user/applylist.jsp");
    return forward;
  }

}
