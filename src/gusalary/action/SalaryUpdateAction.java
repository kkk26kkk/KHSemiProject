package gusalary.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dao.SalaryDAO;
import vo.SalaryInfo;

public class SalaryUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ActionForward forward=new ActionForward();
		SalaryDAO dao=new SalaryDAO();
		SalaryInfo vo=new SalaryInfo();
		 response.setContentType("text/html;charset=UTF-8");
		/* response.setContentType("text/html;charset=EUC-KR");*/
		 boolean result=false;
		 vo.setGID(request.getParameter("GID"));
		 vo.setSN(Integer.parseInt(request.getParameter("SN")));
		vo.setENAME(request.getParameter("ENAME"));
		vo.setCF(request.getParameter("CF"));
		vo.setDUTY(request.getParameter("DUTY"));
		vo.setINDUSTRY(request.getParameter("INDUSTRY"));
		vo.setJTYPE(request.getParameter("JTYPE"));
		vo.setRANK(request.getParameter("RANK"));
		vo.setCAREER(request.getParameter("CAREER"));
		vo.setREGION(request.getParameter("REGION"));
		vo.setSAL(Integer.parseInt(request.getParameter("SAL")));
		vo.setINCENTIVE(Integer.parseInt(request.getParameter("INCENTIVE")));
		
		
		
		result=dao.update(vo);
		if(result==false) {
			System.out.println("���� ����");
			return null;
		}
	
		//���� ������ ���
		System.out.println(" ���� �Ϸ�.");
		   try {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out=response.getWriter();
				out.println("<script>");
				out.println("alert('�����Ǿ����ϴ�.');");
				out.println("location.href='salarylist.guuser';");
				out.println("</script>");
				out.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  
		    return null;
		/*forward.setRedirect(true);
		forward.setPath("./salarylist.guuser");
		 
		    return forward;*/
	}

}
