package eurecruit.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.EnterpriseUserDAO;
import vo.EnterpriseUser;

public class EuRecruitRegAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");

    EnterpriseUser eu = new EnterpriseUser();
    EnterpriseUserDAO eudao = new EnterpriseUserDAO();

    eu = eudao.getEuuserInfo(eid);
    request.setAttribute("eu", eu);
    System.out.println(eu.getENAME());

    forward.setRedirect(false);
    forward.setPath("eu/recruit/recruitForm.jsp");

    return forward;
  }
}
