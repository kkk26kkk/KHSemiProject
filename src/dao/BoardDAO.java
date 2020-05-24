package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import vo.BoardVo;

public class BoardDAO {

  DataSource ds;
  Connection con;
  PreparedStatement pstmt;
  ResultSet rs;

  public BoardDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB연결 실패 :" + e);
      return;
    }
  }

  public int getListCount() {
    int x = 0;
    try {
      con = ds.getConnection();// 컨넥트
      pstmt = con.prepareStatement("select count(*) from faqadmin");
      rs = pstmt.executeQuery();

      if (rs.next()) {
        x = rs.getInt(1);
      }

    } catch (Exception ex) {
      System.out.println("getListCount() 에러: " + ex);
      ex.printStackTrace();
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException e1) {
          System.out.println(e1);
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException e2) {
          System.out.println(e2);
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException e3) {
          System.out.println(e3);
        }
    }
    return x;
  }// Count() end


  // 글목록보기
  public List<BoardVo> getFaqList(int page, int limit) {

    String fqa_list_sql = "select * from " + "(select rownum rnum,SN,USERID,NAME,"
        + "PASS,SUBJECT,CONTENT,RE_REF,RE_LEV," + "RE_SEQ,READCOUNT,RGS_DTM from"
        + "(select * from faqadmin " + "order by RE_REF desc," + "RE_SEQ asc)) "
        + "where rnum>=? and rnum<=?";

    List<BoardVo> list = new ArrayList<BoardVo>();
    int startrow = (page - 1) * limit + 1; // 시작 row 1 11 21
    int endrow = startrow + limit - 1; // 마지막 row 10 20 30

    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(fqa_list_sql);
      pstmt.setInt(1, startrow);
      pstmt.setInt(2, endrow);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        BoardVo faq = new BoardVo();
        faq.setSN(rs.getInt("SN"));
        faq.setUSERID(rs.getString("USERID"));
        faq.setNAME(rs.getString("NAME"));
        faq.setSUBJECT(rs.getString("SUBJECT"));
        faq.setCONTENT(rs.getString("CONTENT"));
        faq.setRE_REF(rs.getInt("RE_REF"));
        faq.setRE_LEV(rs.getInt("RE_LEV"));
        faq.setRE_SEQ(rs.getInt("RE_SEQ"));
        faq.setREADCOUNT(rs.getInt("READCOUNT"));
        faq.setRGS_DTM(rs.getDate("RGS_DTM"));
        list.add(faq);// 값을 리스트에 담는다.
      }
      return list; // 값을 담은 리스트를 호출할곳으로 가져간다.
    } catch (Exception ex) {
      System.out.println("getBoardList() 에러 : " + ex);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException ex) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return null;
  }// getBoardList()메서드 end


  public BoardVo getDetail(int num) {
    BoardVo boarddata = new BoardVo();
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement("select * from faqadmin where SN = ?");
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        boarddata = new BoardVo();
        boarddata.setSN(rs.getInt("SN"));
        boarddata.setUSERID(rs.getString("USERID"));
        boarddata.setNAME(rs.getString("NAME"));
        boarddata.setSUBJECT(rs.getString("SUBJECT"));
        boarddata.setCONTENT(rs.getString("CONTENT"));
        boarddata.setFA_FILE(rs.getString("FA_FILE"));
        boarddata.setRE_REF(rs.getInt("RE_REF"));
        boarddata.setRE_LEV(rs.getInt("RE_LEV"));
        boarddata.setRE_SEQ(rs.getInt("RE_SEQ"));
        boarddata.setREADCOUNT(rs.getInt("READCOUNT"));
        boarddata.setRGS_DTM(rs.getDate("RGS_DTM"));


      }
      return boarddata;
    } catch (Exception ex) {
      System.out.println("getDetail() 에러: " + ex);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException ex) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return null;
  }// getDetail()메서드 end

  public void setReadCountUpdate(int num) {
    String sql = "update faqadmin " + "set READCOUNT= READCOUNT+1 " + "where SN = ?";
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.executeUpdate();
    } catch (SQLException ex) {
      System.out.println("setReadCountUpdate() 에러: " + ex);
    } finally {
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
  }// setReadCountUpdate()메서드 end

  public boolean faqInsert(BoardVo faqdata) {

    int num = 0;
    String sql = "";
    int result = 0;
    try {
      con = ds.getConnection();
      String max_sql = "select max(sn) from faqadmin";
      pstmt = con.prepareStatement(max_sql);
      rs = pstmt.executeQuery();

      if (rs.next())
        num = rs.getInt(1) + 1;// 최대값보다 1만큼 큰값을 지정
      else
        num = 1;// 처음 데이터를 등록하는경우

      sql = "insert into faqadmin " + "(SN,USERID,NAME,PASS,SUBJECT, "
          + "CONTENT,FA_FILE,RE_REF,RE_LEV,RE_SEQ,READCOUNT, RGS_DTM ) "
          + "values(?,?,?,?,?,?,?,?,?,?,?,sysdate ) ";

      // 글등록
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setString(2, faqdata.getUSERID());
      pstmt.setString(3, faqdata.getNAME());
      pstmt.setString(4, faqdata.getPASS());
      pstmt.setString(5, faqdata.getSUBJECT());
      pstmt.setString(6, faqdata.getCONTENT());
      pstmt.setString(7, faqdata.getFA_FILE());
      pstmt.setInt(8, num); // BOARD_RE_REF 필드
      // 원문의 경우 BOARD_RE_LEV, BOARD_RE_SEQ 필드 값은 0 입니다.
      pstmt.setInt(9, 0); // BOARD_RE_LEV 필드
      pstmt.setInt(10, 0); // BOARD_RE_SEQ 필드
      pstmt.setInt(11, 0); // BOARD_READCOUNT 필드


      result = pstmt.executeUpdate();
      if (result == 0)
        return false;
      return true;
    } catch (Exception ex) {
      System.out.println("faqInsert() 에러: " + ex);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException ex) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return false;
  }// boardInsert()메서드 end


  // 글삭제 비밀번호 확인/
  public boolean isBoardWriter(int num, String pass) {

    String sql = "select * from faqadmin where SN= ? ";
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      rs = pstmt.executeQuery();
      if (rs.next()) {
        if (pass.equals(rs.getString("PASS"))) {
          return true;
        }
      } else {
        System.out.println("업다");
      }
    } catch (SQLException ex) {
      System.out.println("isboardWriter() 에러 : " + ex);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException ex) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return false;
  }// isBoardWr

  public boolean BoardDelete(int num) {

    String delete_sql = "delete from faqadmin where SN=?";
    int result = 0;
    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(delete_sql);
      pstmt.setInt(1, num);

      result = pstmt.executeUpdate();
      if (result == 0)
        return false;
      return true;


    } catch (Exception ex) {
      System.out.println("boardDelete() 에러: " + ex);
    } finally {
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return false;
  }// boardDelete()메서드 end

  public boolean Modify(BoardVo boarddata) {
    String sql = "update faqadmin set SUBJECT= ?, CONTENT=? where SN= ? ";

    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(sql);
      pstmt.setString(1, boarddata.getSUBJECT());
      pstmt.setString(2, boarddata.getCONTENT());
      pstmt.setInt(3, boarddata.getSN());
      System.out.println(boarddata.getSUBJECT());
      System.out.println(boarddata.getCONTENT());
      System.out.println(boarddata.getSN());
      pstmt.executeUpdate();
      return true;
    } catch (Exception ex) {
      System.out.println("Modify() 에러: " + ex);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException ex) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return false;
  }// boardModify()메서드 end

  public int boardReply(BoardVo boarddata) {
    String board_max_sql = "select max(SN) from faqadmin";

    String sql = "";
    int num = 0;



    int re_ref = boarddata.getRE_REF();

    int re_lev = boarddata.getRE_LEV();

    int re_seq = boarddata.getRE_SEQ();

    try {
      con = ds.getConnection();
      pstmt = con.prepareStatement(board_max_sql);
      rs = pstmt.executeQuery();

      if (rs.next())
        num = rs.getInt(1) + 1;
      else
        num = 1;

      sql = "update faqadmin " + "set RE_SEQ=RE_SEQ + 1 " + "where RE_REF = ? " + "and RE_SEQ > ?";

      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, re_ref);
      pstmt.setInt(2, re_seq);
      pstmt.executeUpdate();


      re_seq = re_seq + 1;
      re_lev = re_lev + 1;

      sql = "insert into faqadmin " + "(SN,USERID,NAME,PASS,SUBJECT, "
          + "CONTENT,RE_REF,RE_LEV,RE_SEQ,READCOUNT, RGS_DTM ) "
          + "values(?,?,?,?,?,?,?,?,?,?,sysdate ) ";

      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, num);
      pstmt.setString(2, boarddata.getUSERID());
      pstmt.setString(3, boarddata.getNAME());
      pstmt.setString(4, boarddata.getPASS());
      pstmt.setString(5, boarddata.getSUBJECT());
      pstmt.setString(6, boarddata.getCONTENT());
      pstmt.setInt(7, re_ref);
      pstmt.setInt(8, re_lev);
      pstmt.setInt(9, re_seq);
      pstmt.setInt(10, 0); // BOARD_READCOUNT(조회수)는 0
      pstmt.executeUpdate();
      return num;// 글번호

    } catch (SQLException ex) {
      System.out.println("boardReply() 에러 : " + ex);
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (SQLException ex) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (SQLException ex) {
        }
      if (con != null)
        try {
          con.close();
        } catch (SQLException ex) {
        }
    }
    return 0;
  }


}
