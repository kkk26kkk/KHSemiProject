package eumain.action;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.RecruitDAO;
import dao.Res_Rec_Map_DAO;
import vo.Recruit;
import vo.Resume;

public class EuMainAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");

    RecruitDAO recdao = new RecruitDAO();
    List<Recruit> reclist = recdao.getRecruitList(eid);

    List<Resume> applicantlist = new ArrayList<>();
    Res_Rec_Map_DAO resdao = new Res_Rec_Map_DAO();
    applicantlist = resdao.getApplicantList(eid);

    request.setAttribute("reclist", reclist);
    request.setAttribute("applicantlist", applicantlist);

    forward.setRedirect(false);
    forward.setPath("eu/main/main.jsp");

    return forward;
  }

}
