package guentreview.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Action;
import common.ActionForward;
import dao.EnterpriseReviewDAO;
import vo.EnterpriseReview;

public class EntreviewUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ActionForward forward=new ActionForward();
		  
		EnterpriseReviewDAO dao=new EnterpriseReviewDAO();
		    EnterpriseReview vo=new EnterpriseReview();
		    response.setContentType("text/html;charset=UTF-8");
		    boolean result=false;
		
		    
		    vo.setGID(request.getParameter("GID"));
			 vo.setSN(Integer.parseInt(request.getParameter("SN")));
			 vo.setENAME(request.getParameter("ENAME"));
			 vo.setCF(request.getParameter("CF"));
			 vo.setDUTY(request.getParameter("DUTY"));
			 vo.setINDUSTRY(request.getParameter("INDUSTRY"));
			 vo.setJTYPE(request.getParameter("JTYPE"));
			 vo.setCAREER(request.getParameter("CAREER"));
			 vo.setREGION(request.getParameter("REGION"));
			  vo.setTHINK(request.getParameter("THINK"));
			 vo.setADV(request.getParameter("ADV"));
			 vo.setDADV(request.getParameter("DADV"));
			 vo.setPOINT(Integer.parseInt(request.getParameter("POINT")));
			 vo.setSTORY(request.getParameter("STORY"));
		   
			 result=dao.update(vo);
			 if (result == false) {
				System.out.println("수정실패");
					
			    }
			
			    System.out.println(" 수정 완료.");
			    try {
					response.setContentType("text/html;charset=UTF-8");
					PrintWriter out=response.getWriter();
					out.println("<script>");
					out.println("alert('수정되었습니다.');");
					out.println("location.href='entreviewlist.guuser';");
					out.println("</script>");
					out.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			  
			    return null;
			    
			    
			    
			    /* forward.setRedirect(false);
			    forward.setPath("entreviewlist.guuser");
			    
			    return forward;*/
			 
			 }
		
		    }


