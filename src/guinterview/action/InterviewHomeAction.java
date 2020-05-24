package guinterview.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.InterviewReviewDAO;
import vo.InterviewReview;

public class InterviewHomeAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    InterviewReviewDAO dao = new InterviewReviewDAO();
    List<InterviewReview> vo = new ArrayList<InterviewReview>();

    int page = 1;
    int limit = 10;

    if (request.getParameter("page") != null) {
      page = Integer.parseInt(request.getParameter("page"));
     
    }
    System.out.println("넘어온페이지=" + page);
    HttpSession session = request.getSession();
    if (session.getAttribute("limit") != null) {
      limit = Integer.parseInt(session.getAttribute("limit").toString());
    }
    if (request.getParameter("limit") != null) {
      limit = Integer.parseInt(request.getParameter("limit"));
      session.setAttribute("limit", limit);
      System.out.println("limit = " + limit);
    }
    int listcount = dao.getListCount();
    /*String gid = (String) session.getAttribute("gid");*/
    vo = dao.getInterrevList(page, limit);
    int maxpage = (listcount + limit - 1) / limit;
    System.out.println("총페이지수=" + maxpage);


    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("현재 페이지에 보여줄 시작 페이지의 수=" + startpage);

    // endpage:현재 페이지 그룹에서 보여줄 마지막 페이지 수([10],[20],[30]등)
    int endpage = startpage + 10 - 1;
    System.out.println("현재 페이지에 보여줄 마지막 페이지 수=" + endpage);

    /*
     * 마지막 그룹의 마지막 페이지 값은 최대 페이지 값입니다. 예로 마지막 페이지 그룹이 [21]~[30]인 경우 시작페이지(startpage=21)와 마지막
     * 페이지(endpage=30) 마지막페이지(maxpage)가 25라면 [21~25]까지만 표시되도록 합니다.
     * 
     */

    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page);// 현재 페이지 수
    request.setAttribute("maxpage", maxpage);// 최대 페이지 수

    // 현재 페이지에 표시할 첫 페이지 수
    request.setAttribute("startpage", startpage);

    // 현재 페이지에 표시할 끝 페이지 수
    request.setAttribute("endpage", endpage);

    request.setAttribute("listcount", listcount);// 총 글의 수

    // 해당 페이지의 글 목록을 갖고 있는 리스트
    request.setAttribute("vo", vo);
    request.setAttribute("limit", limit);

    // 글의 목록 페이지로 이동하기 위해 경로를 설정합니다.

    forward.setRedirect(false);
    forward.setPath("gu/interview/home.jsp");
    return forward;
  }

}
