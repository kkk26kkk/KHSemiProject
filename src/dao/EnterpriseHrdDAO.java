package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import vo.EnterpriseHrd;

// 기업 리뷰 DAO
public class EnterpriseHrdDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public EnterpriseHrdDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  public int insertEhrd(EnterpriseHrd ehrd, String eid) {
    String sn_sql = "select nvl(max(rownum), 0) from ENTERPRISEUSER where ENAME=?";
    int sn = 0;

    String ins_sql = "insert into ENTERPRISEHRD values(?,?,?,?,?,?,sysdate,sysdate)";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sn_sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();
      if (rs.next()) {
        sn = rs.getInt(1) + 1;
      }

      rs.close();
      pstmt.close();

      pstmt = conn.prepareStatement(ins_sql);
      pstmt.setString(1, ehrd.getEID());
      pstmt.setInt(2, sn);
      pstmt.setString(3, ehrd.getPW());
      pstmt.setString(4, ehrd.getHRDNAME());
      pstmt.setString(5, ehrd.getPHONE());
      pstmt.setString(6, ehrd.getEMAIL());

      result = pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  } // insertEhrd() end

  public int isId(String eid, String pw) {
    String sql = "select EID, PW from ENTERPRISEHRD where EID=?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        if (rs.getString(2).equals(pw)) {
          result = 1; // 아이디와 비밀번호가 일치하는 경우
        } else {
          result = 0; // 아이디와 비밀번호가 일치하지 않는 경우
        }
      } else {
        result = -1;
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }

}
