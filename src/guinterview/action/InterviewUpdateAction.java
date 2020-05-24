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

public class InterviewUpdateAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();

    }
    InterviewReviewDAO dao = new InterviewReviewDAO();
    InterviewReview vo = new InterviewReview();
    response.setContentType("text/html;charset=UTF-8");

    boolean result = false;
    vo.setENAME(request.getParameter("ENAME"));
    vo.setDUTY(request.getParameter("DUTY"));
    vo.setGID(request.getParameter("GID"));
    vo.setSN(Integer.parseInt(request.getParameter("SN")));
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
  /* vo.setRGS_DTM((String)request.getParameter("UPT_DTM"));*/
    result = dao.update(vo);
    if (result == false) {
      System.out.println("수정 실패");
      return null;
    }
    	
    // 수정 성공의 경우
    System.out.println(" 수정 완료.");
    try {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('수정되었습니다.');");
		out.println("location.href='interviewlist.guuser';");
		out.println("</script>");
		out.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return null;
    
    
    
    /*
    forward.setRedirect(false);
    forward.setPath("interviewlist.guuser");

    return forward;*/


  }

}
