package guentreview.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dao.EnterpriseReviewDAO;
import vo.EnterpriseReview;

public class EntreviewInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 ActionForward forward = new ActionForward();
		 try {
		        request.setCharacterEncoding("UTF-8");
		      } catch (UnsupportedEncodingException e) {
		        e.printStackTrace();
		      }String gid=request.getParameter("GID");
		      int sn = Integer.parseInt(request.getParameter("SN"));
		      EnterpriseReviewDAO dao=new EnterpriseReviewDAO();
		      EnterpriseReview vo=dao.infoEntreview(gid,sn);
		      request.setAttribute("vo", vo);

		      forward.setRedirect(false);
		      forward.setPath("gu/entreview/entreviewmodify.jsp");
		      return forward;
		    
	}

}
