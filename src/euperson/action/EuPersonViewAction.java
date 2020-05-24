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

    // 파라미터로 전달받은 답변할 글번호를 num변수에 저장
    String gid = request.getParameter("gid");
    int sn = Integer.parseInt(request.getParameter("sn"));
    System.out.println("넘느" + request.getParameter("gid"));
    // 글번호 num에 해당하는 내용을 Faddata 객체에 저장
    resumedata = resumedao.getResumeDetail(gid, sn);


    // 글내용이 없는 경우
    if (resumedata == null) {
      System.out.println("페이지 이동 실패");
      return null;
    }
    System.out.println("페이지 이동 완료");

    // 원본글을 보여주기 위해
    // faqdata객체를 request객체에 저장
    request.setAttribute("resumedata", resumedata);

    forward.setRedirect(false);
    forward.setPath("eu/person/personview.jsp");

    return forward;
  }

}
