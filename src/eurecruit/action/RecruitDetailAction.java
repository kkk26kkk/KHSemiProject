package eurecruit.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.RecruitDAO;
import vo.Recruit;

public class RecruitDetailAction implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    RecruitDAO rdao = new RecruitDAO();

    String eid = request.getParameter("eid");
    int sn = Integer.parseInt(request.getParameter("sn"));

    Recruit r = rdao.recruitDetail(eid, sn);
    System.out.println("r=" + r);
    if (r == null) {
      System.out.println("상세보기 실패.");
      return null;
    } else {
      System.out.println("상세보기 성공");
    }

    request.setAttribute("rec", r);

    forward.setRedirect(false);
    forward.setPath("eu/recruit/recruitview.jsp");
    return forward;
  }

}
