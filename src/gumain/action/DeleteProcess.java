package gumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import common.Action;
import common.ActionForward;
import dao.GeneralUserDAO;

public class DeleteProcess implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    // 비밀번호 입력 후 확인 작업
    // deleteGuUser(String gid);
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
      String gid = request.getParameter("gid");
      String pw = request.getParameter("pw");

      GeneralUserDAO gudao = new GeneralUserDAO();

      int result = gudao.isId(gid, pw);
      gudao.deleteGuUser(gid);

      if (result == 1) {
        HttpSession session = request.getSession();
        session.invalidate();
      }
      System.out.println("회원탈퇴 완료");
      forward.setPath("main.gumain");
      forward.setRedirect(true);

    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    return forward;
  }
}
