package guinterview.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.InterviewReviewDAO;


public class InterviewDeleteAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String gid = request.getParameter("GID");
    int sn = Integer.parseInt(request.getParameter("SN"));

    InterviewReviewDAO dao = new InterviewReviewDAO();

    int result = dao.delete(gid, sn);
    System.out.println("결과는 : " + result);
    if(result==1) {
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다');");
			out.println("location.href='interviewlist.guuser';");
			out.println("</script>");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }return null;
   
    
    
    
    
    /* forward.setRedirect(true);
    forward.setPath("interviewlist.guuser");
    return forward;*/
  }

}
