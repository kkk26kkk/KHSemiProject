package gurecruit.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.RecruitDAO;
import vo.Recruit;

public class RecruitHomeAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    // 공고 리스트들이 전부 뜰 수 있도록
    RecruitDAO recdao = new RecruitDAO();
    // List<Recruit> reclist = recdao.getRecruitList();
    List<Recruit> reclist = new ArrayList<>();

    int page = 1;
    int limit = 10;

    if (request.getParameter("page") != null) {
      page = Integer.parseInt(request.getParameter("page"));
    }
    System.out.println("넘어온 페이지 = " + page);

    int listcount = recdao.getListCount();
    // HttpSession session = request.getSession();

    reclist = recdao.getRecruitList(page, limit);

    int maxpage = (listcount + limit - 1) / limit;

    request.setAttribute("reclist", reclist);
    System.out.println("총 페이지수 =" + maxpage);

    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("현재 페이지에 보여줄 시작 페이지 수 =" + startpage);

    int endpage = startpage + 10 - 1;
    System.out.println("현재 페이지에 보여줄 마지막 페이지 수=" + endpage);

    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page); // 현재 페이지 수
    request.setAttribute("maxpage", maxpage); // 최대 페이지 수
    // 현재 페이지에 표시할 첫 페이지 수
    request.setAttribute("startpage", startpage);
    // 현재 페이지에 표시할 끝 페이지 수
    request.setAttribute("endpage", endpage);
    request.setAttribute("listcount", listcount); // 총 글의 수

    forward.setRedirect(false);
    forward.setPath("gu/recruit/home.jsp");
    return forward;
  }

}
