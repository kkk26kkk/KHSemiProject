package guentreview.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Action;
import common.ActionForward;
import dao.EnterpriseReviewDAO;
import vo.EnterpriseReview;

public class EntreviewHomeAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
	  try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  ActionForward forward = new ActionForward();
	  EnterpriseReviewDAO dao=new EnterpriseReviewDAO();
		List<EnterpriseReview> vo=new ArrayList<EnterpriseReview>();
		
		int page=1;
		int limit=10;
		
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("�Ѿ��������="+page);
		
		 HttpSession session = request.getSession();

		    if (session.getAttribute("limit") != null) {
		      limit = Integer.parseInt(session.getAttribute("limit").toString());
		    }
		    if (request.getParameter("limit") != null) {
		      limit = Integer.parseInt(request.getParameter("limit"));
		      session.setAttribute("limit", limit);
		      System.out.println("limit = " + limit);
		    }
		int listcount=dao.getListCount();
		
		
		
	
		vo=dao.getBoardList(page,limit);
		
		
		

		
		int maxpage=(listcount+limit-1)/limit;
		System.out.println("����������="+maxpage);
		
		
		int startpage= ((page-1)/10)*10+1;
		System.out.println("���� �������� ������ ���� �������� ��="+startpage);
		
	
		int endpage=startpage+10-1;
		System.out.println("���� �������� ������ ������ ������ ��="+endpage);
		
		
		
		if(endpage>maxpage) endpage=maxpage;
		
		request.setAttribute("page", page);//���� ������ ��
		request.setAttribute("maxpage", maxpage);//�ִ� ������ ��
		
	
		request.setAttribute("startpage",startpage);
		
		
		request.setAttribute("endpage",endpage);
		
		request.setAttribute("listcount",listcount);//�� ���� ��
		
	
		request.setAttribute("vo",vo);
		 request.setAttribute("limit", limit);
		
	  
		 forward.setRedirect(false);
    forward.setPath("gu/entreview/home.jsp");
    return forward;
  }

}
