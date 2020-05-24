package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import vo.EnterpriseUser;

// 기업 리뷰 DAO
public class EnterpriseUserDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public EnterpriseUserDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  public int insertEuUser(EnterpriseUser eu) {
    String sql = "insert into ENTERPRISEUSER values(?,?,?,?,?,?,?,sysdate,sysdate)";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eu.getEID());
      pstmt.setString(2, eu.getENAME());
      pstmt.setString(3, eu.getENUM());
      pstmt.setString(4, eu.getEADDR());
      pstmt.setString(5, eu.getEADDR1());
      pstmt.setString(6, eu.getEADDR2());
      pstmt.setString(7, eu.getOWNERNAME());

      result = pstmt.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception e) {
        }
      if (conn != null)
        try {
          conn.close();
        } catch (Exception e) {
        }
    }

    return result;
  } // insertEuUser() end

  public EnterpriseUser getEuuserInfo(String eid) {
    String sql = "select * from ENTERPRISEUSER where EID=?";
    EnterpriseUser eu = new EnterpriseUser();
    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        eu.setENAME(rs.getString("ENAME"));
        eu.setENUM(rs.getString("ENUM"));
        eu.setEADDR(rs.getString("EADDR"));
        eu.setEADDR1(rs.getString("EADDR1"));
        eu.setEADDR2(rs.getString("EADDR2"));
        eu.setOWNERNAME(rs.getString("OWNERNAME"));
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null)
        try {
          rs.close();
        } catch (Exception e) {
        }
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception e) {
        }
      if (conn != null)
        try {
          conn.close();
        } catch (Exception e) {
        }
    }

    return eu;
  } // getEuuserInfo() end
}
