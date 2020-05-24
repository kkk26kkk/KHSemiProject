package gusalary.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.SalaryDAO;
import vo.SalaryInfo;

public class SalaryDetailAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	  try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  ActionForward forward = new ActionForward();
   
	String gid=request.getParameter("GID");
	int sn = Integer.parseInt(request.getParameter("SN"));
	SalaryDAO dao=new SalaryDAO();
	SalaryInfo vo=dao.Infosalary(gid,sn);
	forward.setRedirect(false);
	 request.setAttribute("vo",vo);
    forward.setPath("gu/salary/salaryview.jsp");
    return forward;

   /* forward.setRedirect(false);
    forward.setPath("gu/salary/salaryview.jsp");
    return forward;*/
  }

}
