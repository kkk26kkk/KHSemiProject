package guinterview.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.InterviewReviewDAO;
import vo.InterviewReview;

public class InterviewApplyAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    InterviewReviewDAO dao = new InterviewReviewDAO();
    InterviewReview vo = new InterviewReview();

    vo.setGID(request.getParameter("GID"));
    vo.setENAME(request.getParameter("ENAME"));
    vo.setDUTY(request.getParameter("DUTY"));
    vo.setINDUSTRY(request.getParameter("INDUSTRY"));
    vo.setJTYPE(request.getParameter("JTYPE"));
    vo.setCAREER(request.getParameter("CAREER"));
    vo.setREGION(request.getParameter("REGION"));
    vo.setEXP(request.getParameter("EXP"));
    vo.setPROC(request.getParameter("PROC"));
    vo.setQUE(request.getParameter("QUE"));
    vo.setANS(request.getParameter("ANS"));
    vo.setDIFF(request.getParameter("DIFF"));
    vo.setINTDATE(request.getParameter("INTDATE"));

    int result = dao.insertInterrev(vo, request.getParameter("GID"));
    System.out.println("결과는 : " + result);
    if(result == 1) {
    	System.out.println("됐다");
    	try {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('등록되었습니다.');");
			out.println("location.href='interviewlist.guuser';");
			out.println("</script>");
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }return null;
    
  /* forward.setRedirect(true);
  forward.setPath("./interviewlist.guuser");
  
    return forward;*/
  }

}
