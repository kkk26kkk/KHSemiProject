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
    System.out.println("�Ѿ�� ������ =" + page);

    // �� ����Ʈ ���� �޾ƿɴϴ�.
    int listcount = rrmdao.getListCount();

    // ����Ʈ�� �޾ƿɴϴ�.
    applicantlist = rrmdao.getApplicantList(page, limit, eid);

    int maxpage = (listcount + limit - 1) / limit;
    System.out.println("�� �������� =" + maxpage);

    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("���� �������� ������ ���� ������ �� =" + startpage);

    int endpage = startpage + 10 - 1;
    System.out.println("���� �������� ������ ������ ������ ��=" + endpage);

    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page); // ���� ������ ��
    request.setAttribute("maxpage", maxpage); // �ִ� ������ ��

    request.setAttribute("startpage", startpage);

    request.setAttribute("endpage", endpage);

    request.setAttribute("listcount", listcount); // �� ���� ��

    request.setAttribute("applicantlist", applicantlist);

    forward.setRedirect(false);
    forward.setPath("eu/recruit/applicantlist.jsp");

    return forward;
  }

}
