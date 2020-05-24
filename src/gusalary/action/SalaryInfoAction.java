package gusalary.action;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dao.SalaryDAO;
import vo.SalaryInfo;

public class SalaryInfoAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionForward forward=new ActionForward();
		  String gid = request.getParameter("GID");
		    int sn = Integer.parseInt(request.getParameter("SN"));
		SalaryDAO dao=new SalaryDAO();
		SalaryInfo vo=dao.Infosalary(gid,sn);
		
		forward.setPath("gu/salary/salarymodify.jsp");
		forward.setRedirect(false);
		  request.setAttribute("vo",vo);
		    return forward;
	}

}
