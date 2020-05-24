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

public class EuEntinfoAddAction implements Action {

  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    HttpSession session = request.getSession();

    EnterpriseInfo einfo = new EnterpriseInfo();
    EnterpriseInfoDAO einfodao = new EnterpriseInfoDAO();

    String realFolder = "";
    String saveFolder = "logo";
    int fileSize = 5 * 1024 * 1024; // 최대 파일 크기 5MB
    ServletContext sc = request.getServletContext();
    realFolder = sc.getRealPath(saveFolder);

    int result = 0;

    try {
      MultipartRequest multi = null;
      multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
          new DefaultFileRenamePolicy());

      einfo.setEID((String) session.getAttribute("eid"));
      einfo.setENAME(multi.getParameter("ENAME"));
      einfo.setOWNERNAME(multi.getParameter("OWNERNAME"));
      einfo.setDOE(multi.getParameter("DOE"));
      einfo.setETYPE(multi.getParameter("ETYPE"));
      einfo.setDUTY(multi.getParameter("DUTY"));
      einfo.setINDUSTRY(multi.getParameter("INDUSTRY"));
      einfo.setENUM(multi.getParameter("ENUM"));
      einfo.setEADDR(multi.getParameter("EADDR"));
      einfo.setEADDR1(multi.getParameter("EADDR1"));
      einfo.setEADDR2(multi.getParameter("EADDR2"));
      einfo.setPAGEADDR(multi.getParameter("PAGEADDR"));
      einfo.setREVENUE(multi.getParameter("REVENUE"));
      // 파일 경로만 저장
      einfo.setLOGO(multi.getFilesystemName((String) multi.getFileNames().nextElement()));

      System.out.println("file의 name 속성값 = " + multi.getFileNames().nextElement());

      result = einfodao.insertEntInfo(einfo);

      System.out.println("insertEntInfo 결과는 : " + result);

      forward.setRedirect(true);
      forward.setPath("./main.eumain");
      return forward;
    } catch (Exception e) {
      e.printStackTrace();
    }

    return null;
  }

}
