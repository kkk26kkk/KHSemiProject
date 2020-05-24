package eurecruit.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.Res_Rec_Map_DAO;
import vo.Resume;

public class EuApplicantListAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");

    List<Resume> applicantlist = new ArrayList<>();
    // ResumeDAO resdao = new ResumeDAO();
    // applicantlist = resdao.getBoardList(page, limit, eid);
    Res_Rec_Map_DAO rrmdao = new Res_Rec_Map_DAO();

    int page = 1;
    int limit = 10;

    if (request.getParameter("page") != null) {
      page = Integer.parseInt(request.getParameter("page"));
    }
    System.out.println("넘어온 페이지 =" + page);

    // 총 리스트 수를 받아옵니다.
    int listcount = rrmdao.getListCount();

    // 리스트를 받아옵니다.
    applicantlist = rrmdao.getApplicantList(page, limit, eid);

    int maxpage = (listcount + limit - 1) / limit;
    System.out.println("총 페이지수 =" + maxpage);

    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("현재 페이지에 보여줄 시작 페이지 수 =" + startpage);

    int endpage = startpage + 10 - 1;
    System.out.println("현재 페이지에 보여줄 마지막 페이지 수=" + endpage);

    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page); // 현재 페이지 수
    request.setAttribute("maxpage", maxpage); // 최대 페이지 수

    request.setAttribute("startpage", startpage);

    request.setAttribute("endpage", endpage);

    request.setAttribute("listcount", listcount); // 총 글의 수

    request.setAttribute("applicantlist", applicantlist);

    forward.setRedirect(false);
    forward.setPath("eu/recruit/applicantlist.jsp");

    return forward;
  }

}
