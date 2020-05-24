package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import vo.GeneralUser;

// �Ϲ� ȸ�� DAO
public class GeneralUserDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public GeneralUserDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB ���� ���� : " + e);
      return;
    }
  }

  // ���̵�, ��й�ȣ Ȯ��
  public int isId(String gid, String pw) {
    String sql = "SELECT gid, pw FROM GENERALUSER WHERE gid=?";

    try {
      conn = ds.getConnection();
      System.out.println("getConnection");

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        if (rs.getString(2).equals(pw)) {
          result = 1; // ���̵�� ��й�ȣ�� ��ġ�ϴ� ���
        } else {
          result = 0; // ���̵�� ��й�ȣ�� ��ġ���� �ʴ� ���
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

  // ���̵� ���� ���� Ȯ��
  public int isId(String gid) {
    int result = 0;
    try {
      conn = ds.getConnection();
      System.out.println("getconnection");

      String sql = "select gid, pw from generaluser where gid = ?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);
      rs = pstmt.executeQuery();

      if (rs.next()) {
        System.out.println(rs.getString(2));
        result = 1;// ���̵� �ִ� ���
      } else {
        result = 0; // ���̵� ���� ���
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
    }
    return result;
  }

  // �Ϲ� ȸ�� ���
  public int insertGuUser(GeneralUser gu) {
    String sql = "insert into GENERALUSER values(?,?,?,?,?,sysdate,sysdate)";
    result = 0;

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gu.getGID());
      pstmt.setString(2, gu.getNAME());
      pstmt.setString(3, gu.getPW());
      pstmt.setString(4, gu.getEMAIL());
      pstmt.setString(5, gu.getPHONE());

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
  }

  // �Ϲ� ȸ�� ���� ��������(�̷¼� �� ��)
  public GeneralUser getGuInfo(String gid) {
    String sql = "select * from GENERALUSER where GID=?";
    GeneralUser gu = new GeneralUser();

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);

      rs = pstmt.executeQuery();

      if (rs.next()) {
        gu.setGID(rs.getString(1));
        gu.setNAME(rs.getString(2));
        gu.setPW(rs.getString(3));
        gu.setEMAIL(rs.getString(4));
        gu.setPHONE(rs.getString(5));
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
    return gu;
  }

  // ȸ������
  public int deleteGuUser(String gid) {
    result = 0;
    try {
      conn = ds.getConnection();
      System.out.println("getconnection");

      String sql = "delete from generaluser where gid=?";

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);
      result = pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null)
        try {
          pstmt.close();
        } catch (Exception e) {
          e.printStackTrace();
        }
    }
    if (conn != null) {
      try {
        conn.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    return result;
  }

  // ȸ������ ����
  public int Memberupdate(GeneralUser gu) {
    result = 0;
    try {
      conn = ds.getConnection();
      System.out.println("getconnection");

      String sql = "update generaluser set name=?, pw=?, phone=?, email=? where gid=?";
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gu.getNAME());
      pstmt.setString(2, gu.getPW());
      pstmt.setString(3, gu.getPHONE());
      pstmt.setString(4, gu.getEMAIL());
      pstmt.setString(5, gu.getGID());
      result = pstmt.executeUpdate();
      System.out.println("rs.next() �� id =" + gu.getGID());
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
        } catch (SQLException e) {
          e.printStackTrace();
        }
      }
    }
    return result;
  }
}
