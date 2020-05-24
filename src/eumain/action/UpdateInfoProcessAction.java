package eumain.action;

import java.io.UnsupportedEncodingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.Action;
import common.ActionForward;
import dao.EnterpriseInfoDAO;
import vo.EnterpriseInfo;

public class UpdateInfoProcessAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();
    String eid = (String) session.getAttribute("eid");

    EnterpriseInfo einfo = new EnterpriseInfo();
    EnterpriseInfoDAO einfodao = new EnterpriseInfoDAO();

    response.setContentType("text/html;charset=UTF-8");

    boolean result = false;
    String saveFolder = "boardupload";

    int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈 입니다. 5MB

    // 실제 저장 경로를 지정합니다.
    ServletContext sc = request.getServletContext();
    String realFolder = sc.getRealPath(saveFolder);
    /*
     * realFolder = request.getSession().getServletContext().getRealPath(saveFolder);
     */
    System.out.println("realFolder = " + realFolder);
    try {
      MultipartRequest multi = null;

      multi = new MultipartRequest(request, realFolder, fileSize, "euc-kr",
          new DefaultFileRenamePolicy());

      einfo.setEID(multi.getParameter("EID"));
      einfo.setENAME(multi.getParameter("ENAME"));
      einfo.setOWNERNAME(multi.getParameter("OWNERNAME"));
      einfo.setDOE(multi.getParameter("DOE"));
      einfo.setETYPE(multi.getParameter("ETYPE"));
      einfo.setDUTY(multi.getParameter("DUTY"));
      einfo.setINDUSTRY(multi.getParameter("INDUSTRY"));
      einfo.setENUM(multi.getParameter("ENUM"));
      einfo.setEADDR(multi.getParameter("EADDR"));
      einfo.setPAGEADDR(multi.getParameter("PAGEADDR"));
      einfo.setREVENUE(multi.getParameter("REVENUE"));
      einfo.setLOGO(multi.getParameter("LOGO"));

      System.out.println("file의 name 속성값 = " + multi.getFileNames().nextElement());

      einfodao.updateEntInfo(einfo);

      request.setAttribute("eu", einfo);
      forward.setRedirect(false);
      forward.setPath("main.eumain");

      return forward;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
