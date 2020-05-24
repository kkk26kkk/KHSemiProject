package euperson.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class EuPersonViewAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    ActionForward forward = new ActionForward();


    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e1) {
      e1.printStackTrace();
    }

    ResumeDAO resumedao = new ResumeDAO();
    Resume resumedata = new Resume();

    // �Ķ���ͷ� ���޹��� �亯�� �۹�ȣ�� num������ ����
    String gid = request.getParameter("gid");
    int sn = Integer.parseInt(request.getParameter("sn"));
    System.out.println("�Ѵ�" + request.getParameter("gid"));
    // �۹�ȣ num�� �ش��ϴ� ������ Faddata ��ü�� ����
    resumedata = resumedao.getResumeDetail(gid, sn);


    // �۳����� ���� ���
    if (resumedata == null) {
      System.out.println("������ �̵� ����");
      return null;
    }
    System.out.println("������ �̵� �Ϸ�");

    // �������� �����ֱ� ����
    // faqdata��ü�� request��ü�� ����
    request.setAttribute("resumedata", resumedata);

    forward.setRedirect(false);
    forward.setPath("eu/person/personview.jsp");

    return forward;
  }

}
