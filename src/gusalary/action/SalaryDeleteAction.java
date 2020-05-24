package gusalary.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dao.SalaryDAO;

public class SalaryDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionForward forward=new ActionForward();
		
		 int sn = Integer.parseInt(request.getParameter("SN"));
		 String gid = request.getParameter("GID");	
		SalaryDAO dao=new SalaryDAO();
		dao.delete(gid,sn);
		try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제되었습니다');");
			out.println("location.href='salarylist.guuser';");
			out.println("</script>");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}return null;
			/* forward.setRedirect(true);
			    forward.setPath("salarylist.guuser");
			    return forward;*/
	}

}
