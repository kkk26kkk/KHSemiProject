package gurecruit.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.RecruitDAO;
import vo.Recruit;

public class RecruitViewAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse respnse) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String eid = request.getParameter("eid");
    int sn = Integer.parseInt(request.getParameter("sn"));

    RecruitDAO recdao = new RecruitDAO();
    Recruit rec = recdao.recruitDetail(eid, sn);

    request.setAttribute("rec", rec);

    forward.setRedirect(false);
    forward.setPath("gu/recruit/recruitview.jsp");
    return forward;
  }

}
