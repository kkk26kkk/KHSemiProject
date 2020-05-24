package gurecruit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import common.Action;
import common.ActionForward;
import dao.Res_Rec_Map_DAO;
import vo.Res_Rec_Map;

// 입사 지원 처리 액션
public class ApplyProcessAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Res_Rec_Map rrm = new Res_Rec_Map();
    rrm.setGID(request.getParameter("GID"));
    rrm.setGID_SN(Integer.parseInt(request.getParameter("GID_SN")));
    rrm.setEID(request.getParameter("EID"));
    rrm.setEID_SN(Integer.parseInt(request.getParameter("EID_SN")));

    Res_Rec_Map_DAO rrmdao = new Res_Rec_Map_DAO();
    int result = rrmdao.insert(rrm);

    response.setContentType("text/html; charset=UTF-8");
    PrintWriter out;
    if (result == 1) {
      try {
        out = response.getWriter();

        out.println("<script>");
        out.println("alert('정상적으로 지원 처리 되었습니다.');");
        out.println("window.close();");
        out.println("</script>");

        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    } else {
      try {
        out = response.getWriter();

        out.println("<script>");
        out.println("alert('지원 처리하지 못하였습니다.');");
        out.println("window.close();");
        out.println("</script>");

        out.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

    return null;
  }
}
