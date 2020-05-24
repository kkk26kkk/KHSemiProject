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

    // WebContent�Ʒ��� �� ���� �����ϼ���
    String saveFolder = "boardupload";

    int fileSize = 5 * 1024 * 1024; // ���ε��� ������ �ִ� ������ �Դϴ�.5MB

    // ���� ���� ��θ� �����մϴ�.
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

      // BoardBean ��ü�� �� ��� ������ �Է� ���� �������� �����մϴ�.

      boarddata.setUSERID(multi.getParameter("USERID"));
      boarddata.setPASS(multi.getParameter("PASS"));
      boarddata.setSUBJECT(multi.getParameter("SUBJECT"));
      boarddata.setCONTENT(multi.getParameter("CONTENT"));

      // ���ε��� ���ϸ��� ���ε��� ������ ��ü ��ο��� ���� �̸��� �����մϴ�.
      boarddata.setFA_FILE(multi.getFilesystemName((String) multi.getFileNames().nextElement()));
      System.out.println("file�� name �Ӽ��� = " + multi.getFileNames().nextElement());
      // file�� name �Ӽ��� = BOARD_FILE

      // �� ��� ó���� ���� DAO�� boardInsert()�޼��带 ȣ���մϴ�.
      // �� ��� ������ �Է��� ������ ����Ǿ� �ִ� boarddata��ü�� �����մϴ�.
      result = boarddao.faqInsert(boarddata);

      // �� ��Ͽ� ������ ��� null�� ��ȯ�մϴ�.
      if (result == false) {
        System.out.println("�Խ��� ��� ����");
        return null;
      }
      System.out.println("�Խ��� ��� �Ϸ�");

      // �� ����� �Ϸ�Ǹ� �� ����� �ܼ��� �����ֱ⸸ �� ���̹Ƿ�
      // Redirect���θ� true�� �����մϴ�.
      forward.setRedirect(true);
      // �̵��� ��θ� �����մϴ�.
      forward.setPath("./boardList.FA");
      return forward;
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return null;
  }
}
