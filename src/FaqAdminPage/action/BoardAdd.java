package FaqAdminPage.action;


import java.io.UnsupportedEncodingException;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import common.Action;
import common.ActionForward;
import dao.BoardDAO;
import vo.BoardVo;

public class BoardAdd implements Action {
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {

    BoardDAO boarddao = new BoardDAO();

    BoardVo boarddata = new BoardVo();
    ActionForward forward = new ActionForward();

    try {
      request.setCharacterEncoding("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }

    String realFolder = "";

    // WebContent아래에 꼭 폴더 생성하세요
    String saveFolder = "boardupload";

    int fileSize = 5 * 1024 * 1024; // 업로드할 파일의 최대 사이즈 입니다.5MB

    // 실제 저장 경로를 지정합니다.
    ServletContext sc = request.getServletContext();
    realFolder = sc.getRealPath(saveFolder);
    /*
     * realFolder= request.getSession().getServletContext().getRealPath(saveFolder);
     */
    System.out.println("realFolder= " + realFolder);
    boolean result = false;

    try {
      MultipartRequest multi = null;
      multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
          new DefaultFileRenamePolicy());

      // BoardBean 객체에 글 등록 폼에서 입력 받은 정보들을 저장합니다.

      boarddata.setUSERID(multi.getParameter("USERID"));
      boarddata.setPASS(multi.getParameter("PASS"));
      boarddata.setSUBJECT(multi.getParameter("SUBJECT"));
      boarddata.setCONTENT(multi.getParameter("CONTENT"));

      // 업로드의 파일명은 업로드한 파일의 전체 경로에서 파일 이름만 저장합니다.
      boarddata.setFA_FILE(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
      System.out.println("file의 name 속성값 = " + multi.getFileNames().nextElement());
      // file의 name 속성값 = BOARD_FILE

      // 글 등록 처리를 위해 DAO의 boardInsert()메서드를 호출합니다.
      // 글 등록 폼에서 입력한 정보가 저장되어 있는 boarddata객체를 전달합니다.
      result = boarddao.faqInsert(boarddata);

      // 글 등록에 실패할 경우 null을 반환합니다.
      if (result == false) {
        System.out.println("게시판 등록 실패");
        return null;
      }
      System.out.println("게시판 등록 완료");

      // 글 등록이 완료되면 글 목록을 단순히 보여주기만 할 것이므로
      // Redirect여부를 true로 설정합니다.
      forward.setRedirect(true);
      // 이동할 경로를 지정합니다.
      forward.setPath("./boardList.FA");
      return forward;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
