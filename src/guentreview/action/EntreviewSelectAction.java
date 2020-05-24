package guentreview.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import common.Action;
import common.ActionForward;
import dao.EnterpriseReviewDAO;
import vo.EnterpriseReview;

public class EntreviewSelectAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		 ActionForward forward = new ActionForward();

		    try {
		      request.setCharacterEncoding("UTF-8");
		    } catch (UnsupportedEncodingException e) {
		      e.printStackTrace();
		    }

		    EnterpriseReviewDAO resdao = new EnterpriseReviewDAO();

		    String gid = request.getParameter("ename");
		    	System.out.println(gid);
		    JSONArray array = resdao.Ajexist(gid);

		    response.setContentType("text/html;charset=utf-8");

		    response.setHeader("cache-control", "no-cache,no-store");

		    PrintWriter out;
		    try {
		      out = response.getWriter();
		      out.print(array);
		      System.out.println(array);
		    } catch (IOException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }


		    return null;
	
		
		
		
		
	
	}

}
