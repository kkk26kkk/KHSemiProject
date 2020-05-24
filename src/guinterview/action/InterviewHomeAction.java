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
    System.out.println("�Ѿ��������=" + page);
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
    System.out.println("����������=" + maxpage);


    int startpage = ((page - 1) / 10) * 10 + 1;
    System.out.println("���� �������� ������ ���� �������� ��=" + startpage);

    // endpage:���� ������ �׷쿡�� ������ ������ ������ ��([10],[20],[30]��)
    int endpage = startpage + 10 - 1;
    System.out.println("���� �������� ������ ������ ������ ��=" + endpage);

    /*
     * ������ �׷��� ������ ������ ���� �ִ� ������ ���Դϴ�. ���� ������ ������ �׷��� [21]~[30]�� ��� ����������(startpage=21)�� ������
     * ������(endpage=30) ������������(maxpage)�� 25��� [21~25]������ ǥ�õǵ��� �մϴ�.
     * 
     */

    if (endpage > maxpage)
      endpage = maxpage;

    request.setAttribute("page", page);// ���� ������ ��
    request.setAttribute("maxpage", maxpage);// �ִ� ������ ��

    // ���� �������� ǥ���� ù ������ ��
    request.setAttribute("startpage", startpage);

    // ���� �������� ǥ���� �� ������ ��
    request.setAttribute("endpage", endpage);

    request.setAttribute("listcount", listcount);// �� ���� ��

    // �ش� �������� �� ����� ���� �ִ� ����Ʈ
    request.setAttribute("vo", vo);
    request.setAttribute("limit", limit);

    // ���� ��� �������� �̵��ϱ� ���� ��θ� �����մϴ�.

    forward.setRedirect(false);
    forward.setPath("gu/interview/home.jsp");
    return forward;
  }

}
