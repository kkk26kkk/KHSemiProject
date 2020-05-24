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

public class EntreviewApplyAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response)  {
	ActionForward forward = new ActionForward();
    EnterpriseReviewDAO dao=new EnterpriseReviewDAO();
    EnterpriseReview vo=new EnterpriseReview();
   try {
	request.setCharacterEncoding("UTF-8");
   } catch (UnsupportedEncodingException e) {
	
	e.printStackTrace();
}
    vo.setGID(request.getParameter("GID"));
   
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
    System.out.println(request.getParameter("POINT"));
    
    int result = dao.insertEntereview(vo,request.getParameter("GID"));
    
    
    if(result == 1) {
    	System.out.println("됐다");
    	try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('등록되었습니다.');");
			out.println("location.href='entreviewlist.guuser';");
			out.println("</script>");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	/*forward.setRedirect(true);
      
    	forward.setPath("./entreviewlist.guuser");
        return forward;*/
    }
   /* else {
    	System.out.println("안됬다");
    	return null;
    }	*/
    return null;
  
  
  
  
  }

}
