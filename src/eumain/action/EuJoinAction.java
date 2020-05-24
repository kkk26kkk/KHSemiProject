package eumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.EnterpriseHrdDAO;
import dao.EnterpriseUserDAO;
import vo.EnterpriseHrd;
import vo.EnterpriseUser;

public class EuJoinAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    EnterpriseUser eu = new EnterpriseUser();
    eu.setEID(request.getParameter("EID"));
    eu.setENAME(request.getParameter("ENAME"));
    eu.setENUM(request.getParameter("ENUM"));
    eu.setEADDR(request.getParameter("EADDR"));
    eu.setEADDR1(request.getParameter("EADDR1"));
    eu.setEADDR2(request.getParameter("EADDR2"));
    eu.setOWNERNAME(request.getParameter("OWNERNAME"));

    EnterpriseHrd ehrd = new EnterpriseHrd();
    ehrd.setEID(request.getParameter("EID"));
    ehrd.setSN(request.getParameter("SN"));
    ehrd.setPW(request.getParameter("PW"));
    ehrd.setHRDNAME(request.getParameter("HRDNAME"));
    ehrd.setPHONE(request.getParameter("PHONE"));
    ehrd.setEMAIL(request.getParameter("EMAIL"));

    EnterpriseUserDAO eudao = new EnterpriseUserDAO();
    int result = eudao.insertEuUser(eu);
    System.out.println("insertEuUser 결과는 : " + result);

    EnterpriseHrdDAO ehrddao = new EnterpriseHrdDAO();
    int result2 = ehrddao.insertEhrd(ehrd, request.getParameter("ENAME"));
    System.out.println("insertEhrd 결과는 : " + result2);

    forward.setRedirect(true);
    forward.setPath("./main.gumain");

    return forward;
  }

}
