package eumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.EnterpriseInfoDAO;
import vo.EnterpriseInfo;

public class UpdateInfoAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");

    boolean result = false;

    System.out.println(eid);
    EnterpriseInfoDAO epdao = new EnterpriseInfoDAO();
    EnterpriseInfo einfo = new EnterpriseInfo();

    result = epdao.updateEntInfo(einfo);
    if (result == false) {
      System.out.println("���� ����");
      return null;
    }

    // ���� ������ ���
    System.out.println(" ���� �Ϸ�.");

    request.setAttribute("einfo", einfo);
    forward.setPath("eu/main/updateinfoForm.jsp");
    forward.setRedirect(false);
    return forward;
  }
}
