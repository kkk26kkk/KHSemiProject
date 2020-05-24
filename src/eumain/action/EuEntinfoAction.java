package eumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.EnterpriseInfoDAO;
import dao.EnterpriseUserDAO;
import vo.EnterpriseInfo;
import vo.EnterpriseUser;

public class EuEntinfoAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");

    EnterpriseUserDAO eudao = new EnterpriseUserDAO();
    EnterpriseUser eu = eudao.getEuuserInfo(eid);

    EnterpriseInfoDAO epdao = new EnterpriseInfoDAO();
    EnterpriseInfo ep = epdao.getInsertInfo(eid);

    request.setAttribute("eu", eu);
    request.setAttribute("ep", ep);

    forward.setRedirect(false);
    forward.setPath("eu/main/insertInfoForm.jsp");

    return forward;
  }
}
