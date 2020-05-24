package guuser.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.ResumeDAO;
import vo.Resume;

public class ResumeListAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    ResumeDAO resdao = new ResumeDAO();
    List<Resume> reslist = new ArrayList<>();
    HttpSession session = request.getSession();
    String gid = (String) session.getAttribute("gid");

    reslist = resdao.getResumeList(gid);

    request.setAttribute("reslist", reslist);

    forward.setRedirect(false);
    forward.setPath("gu/user/resumelist.jsp");
    return forward;
  }

}
