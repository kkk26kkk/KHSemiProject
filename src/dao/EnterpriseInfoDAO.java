package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import vo.EnterpriseInfo;

// 기업 리뷰 DAO
public class EnterpriseInfoDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public EnterpriseInfoDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  public int insertEntInfo(EnterpriseInfo einfo) {
    String sql = "insert into ENTERPRISEINFO values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, einfo.getEID());
      pstmt.setString(2, einfo.getENAME());
      pstmt.setString(3, einfo.getOWNERNAME());
      pstmt.setString(4, einfo.getDOE());
      pstmt.setString(5, einfo.getETYPE());
      pstmt.setString(6, einfo.getDUTY());
      pstmt.setString(7, einfo.getINDUSTRY());
      pstmt.setString(8, einfo.getENUM());
      pstmt.setString(9, einfo.getEADDR());
      pstmt.setString(10, einfo.getEADDR1());
      pstmt.setString(11, einfo.getEADDR2());
      pstmt.setString(12, einfo.getPAGEADDR());
      pstmt.setString(13, einfo.getREVENUE());
      pstmt.setString(14, einfo.getLOGO());

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

  public EnterpriseInfo getInsertInfo(String eid) {
    String sql = "select * from ENTERPRISEINFO where EID=?";
    EnterpriseInfo ep = new EnterpriseInfo();

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();
      while (rs.next()) {
        ep.setEID(rs.getString(1));
        ep.setENAME(rs.getString(2));
        ep.setENUM(rs.getString(3));
        ep.setEADDR(rs.getString(4));
        ep.setOWNERNAME(rs.getString(5));
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
    return ep;
  } // getEuuserInfo() end

  public boolean updateEntInfo(EnterpriseInfo einfo) {
    String sql = "update ENTERPRISEINFO " + "set ENAME=?,OWNERNAME=?,DOE=?,ETYPE=?,DUTY=?, "
        + "INDUSTRY=?,ENUM=?,EADDR=?,PAGEADDR=?,REVENUE=?,LOGO=? " + "where EID=? ";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, einfo.getENAME());
      pstmt.setString(2, einfo.getOWNERNAME());
      pstmt.setString(3, einfo.getDOE());
      pstmt.setString(4, einfo.getETYPE());
      pstmt.setString(5, einfo.getDUTY());
      pstmt.setString(6, einfo.getINDUSTRY());
      pstmt.setString(7, einfo.getENUM());
      pstmt.setString(8, einfo.getEADDR());
      pstmt.setString(9, einfo.getPAGEADDR());
      pstmt.setString(10, einfo.getREVENUE());
      pstmt.setString(11, einfo.getLOGO());
      pstmt.setString(12, einfo.getEID());

      pstmt.executeUpdate();
      return true;
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
    return false;
  }
}
