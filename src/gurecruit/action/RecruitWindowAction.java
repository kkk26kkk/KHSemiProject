package gurecruit.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class RecruitWindowAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse respnse) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    List<Resume> reslist = new ArrayList<>();
    ResumeDAO resdao = new ResumeDAO();

    String gid = request.getParameter("gid");
    reslist = resdao.getResumeList(gid); // sn Ãß°¡

    request.setAttribute("reslist", reslist);
    request.setAttribute("eid", request.getParameter("eid"));
    request.setAttribute("eid_sn", request.getParameter("sn"));

    forward.setRedirect(false);
    forward.setPath("gu/recruit/applywindow.jsp");

    return forward;
  }

}
