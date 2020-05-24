package euperson.action;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class EuPersonListAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();



    try {
      request.setCharacterEncoding("UTF-8");
    } catch (Exception e) {
      e.printStackTrace();
    }


    ResumeDAO resumedao = new ResumeDAO();
    // Resume resumedata = new Resume();

    List<Resume> resumelist = new ArrayList<Resume>();

    int page = 1;
    int limit = 10;

    if (request.getParameter("page") != null) {
      page = Integer.parseInt(request.getParameter("page"));
    }
    System.out.println("�Ѿ�� ������ = " + page);

    HttpSession session = request.getSession();
    if (session.getAttribute("limit") != null) {
      limit = Integer.parseInt(session.getAttribute("limit").toString());

    }
    if (request.getParameter("limit") != null) {
      limit = Integer.parseInt(request.getParameter("limit"));
      session.setAttribute("limit", limit);
      System.out.println("limit" + limit);
    }

    int listcount = resumedao.getListCount();

    resumelist = resumedao.getResumeList(page, limit);

    int maxpage = (listcount + limit - 1) / limit;
    System.out.println("���������� =" + maxpage);

    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("���� �������� ������ ���� �������� =" + startpage);

    int endpage = startpage + 10 - 1;
    System.out.println("���� �������� ������ ������ �������� =" + endpage);


    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page); // ���� ������ ��
    request.setAttribute("maxpage", maxpage); // �ִ� ������ ��

    // ���� �������� ǥ���� ù ������ ��
    request.setAttribute("startpage", startpage);

    // ���� �������� ǥ���� �� ������ ��
    request.setAttribute("endpage", endpage);

    request.setAttribute("listcount", listcount); // �� ���� ��

    // �ش� �������� �� ����� ���� �ִ� ����Ʈ
    request.setAttribute("resumelist", resumelist);
    request.setAttribute("limit", limit);

    forward.setRedirect(false);
    forward.setPath("eu/person/personlist.jsp");
    return forward;
  }

}
