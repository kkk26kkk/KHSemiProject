package eurecruit.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import common.Action;
import common.ActionForward;
import dao.Res_Rec_Map_DAO;

public class Ajax implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    Res_Rec_Map_DAO rrmdao = new Res_Rec_Map_DAO();

    HttpSession session = request.getSession();

    String eid = (String) session.getAttribute("eid");
    int eid_sn = Integer.parseInt(request.getParameter("eid_sn"));

    JSONArray array = rrmdao.getList(eid, eid_sn);

    response.setContentType("text/html;charset=utf-8");

    response.setHeader("cache-control", "no-cache,no-store");

    PrintWriter out;
    try {
      out = response.getWriter();
      out.print(array);
    } catch (IOException e) {
      e.printStackTrace();
    }

    return null;
  }

}
