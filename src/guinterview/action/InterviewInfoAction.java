package guinterview.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.InterviewReviewDAO;
import vo.InterviewReview;

public class InterviewInfoAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String gid = request.getParameter("GID");
    int sn = Integer.parseInt(request.getParameter("SN"));

    InterviewReviewDAO dao = new InterviewReviewDAO();
    InterviewReview vo = dao.Infointerview(gid, sn);

    request.setAttribute("vo", vo);
    forward.setPath("gu/interview/interviewmodify.jsp");
    forward.setRedirect(false);
    return forward;
  }

}
