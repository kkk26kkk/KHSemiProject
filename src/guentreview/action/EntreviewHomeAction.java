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
		System.out.println("넘어온페이지="+page);
		
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
		System.out.println("총페이지수="+maxpage);
		
		
		int startpage= ((page-1)/10)*10+1;
		System.out.println("현재 페이지에 보여줄 시작 페이지의 수="+startpage);
		
	
		int endpage=startpage+10-1;
		System.out.println("현재 페이지에 보여줄 마지막 페이지 수="+endpage);
		
		
		
		if(endpage>maxpage) endpage=maxpage;
		
		request.setAttribute("page", page);//현재 페이지 수
		request.setAttribute("maxpage", maxpage);//최대 페이지 수
		
	
		request.setAttribute("startpage",startpage);
		
		
		request.setAttribute("endpage",endpage);
		
		request.setAttribute("listcount",listcount);//총 글의 수
		
	
		request.setAttribute("vo",vo);
		 request.setAttribute("limit", limit);
		
	  
		 forward.setRedirect(false);
    forward.setPath("gu/entreview/home.jsp");
    return forward;
  }

}
