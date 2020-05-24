package guentreview.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dao.EnterpriseReviewDAO;


public class EntreviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = new ActionForward();
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
	   
	   String gid = request.getParameter("GID");
	   System.out.println(gid);
	   int sn = Integer.parseInt(request.getParameter("SN"));
	    	System.out.println(sn);
	  EnterpriseReviewDAO dao=new EnterpriseReviewDAO();
	    int result = dao.delete(gid, sn);
	    System.out.println("결과는 : " + result);
	  if(result==1) {
			try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('삭제되었습니다');");
				out.println("location.href='entreviewlist.guuser';");
				out.println("</script>");
				out.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	/*    forward.setRedirect(true);
	    forward.setPath("entreviewlist.guuser");
	    return forward;
	*/
	  return null;
	
	}

}
