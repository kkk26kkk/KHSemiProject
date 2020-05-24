package guentreview.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.EnterpriseReviewDAO;
import vo.EnterpriseReview;

public class EntreviewDetail2Action implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();
    try {
        request.setCharacterEncoding("UTF-8");
      } catch (UnsupportedEncodingException e) {
        e.printStackTrace();
      }
    
    String gid=request.getParameter("ENAME");
  /*  String gid2=request.getParameter("REGION");*/
    /*String gid2=request.getParameter("DUTY");*/
    
    EnterpriseReviewDAO dao=new EnterpriseReviewDAO();
    EnterpriseReview vo=dao.infoEntreview2(gid);
    request.setAttribute("vo", vo);

    forward.setRedirect(false);
    forward.setPath("gu/entreview/entreview.jsp");
    return forward;
  }

}