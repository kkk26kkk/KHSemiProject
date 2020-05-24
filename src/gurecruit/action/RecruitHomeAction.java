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

    // ���� ����Ʈ���� ���� �� �� �ֵ���
    RecruitDAO recdao = new RecruitDAO();
    // List<Recruit> reclist = recdao.getRecruitList();
    List<Recruit> reclist = new ArrayList<>();

    int page = 1;
    int limit = 10;

    if (request.getParameter("page") != null) {
      page = Integer.parseInt(request.getParameter("page"));
    }
    System.out.println("�Ѿ�� ������ = " + page);

    int listcount = recdao.getListCount();
    // HttpSession session = request.getSession();

    reclist = recdao.getRecruitList(page, limit);

    int maxpage = (listcount + limit - 1) / limit;

    request.setAttribute("reclist", reclist);
    System.out.println("�� �������� =" + maxpage);

    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("���� �������� ������ ���� ������ �� =" + startpage);

    int endpage = startpage + 10 - 1;
    System.out.println("���� �������� ������ ������ ������ ��=" + endpage);

    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page); // ���� ������ ��
    request.setAttribute("maxpage", maxpage); // �ִ� ������ ��
    // ���� �������� ǥ���� ù ������ ��
    request.setAttribute("startpage", startpage);
    // ���� �������� ǥ���� �� ������ ��
    request.setAttribute("endpage", endpage);
    request.setAttribute("listcount", listcount); // �� ���� ��

    forward.setRedirect(false);
    forward.setPath("gu/recruit/home.jsp");
    return forward;
  }

}
