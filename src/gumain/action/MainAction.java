package gumain.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.RecruitDAO;
import vo.Recruit;

public class MainAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    RecruitDAO recdao = new RecruitDAO();
    List<Recruit> reclist = recdao.getRecruitList();

    request.setAttribute("reclist", reclist);

    forward.setRedirect(false);
    forward.setPath("home.gurecruit");
    return forward;
  }

}
