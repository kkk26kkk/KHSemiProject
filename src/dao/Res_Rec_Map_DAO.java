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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import vo.Res_Rec_Map;
import vo.Resume;

// 지원자 DAO
public class Res_Rec_Map_DAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public Res_Rec_Map_DAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  public int insert(Res_Rec_Map rrm) {
    String sql = "insert into RES_REC_MAP values(?,?,?,?)";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, rrm.getGID());
      pstmt.setInt(2, rrm.getGID_SN());
      pstmt.setString(3, rrm.getEID());
      pstmt.setInt(4, rrm.getEID_SN());

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

  public JSONArray getList(String eid, int eid_sn) {
    String sql = "select b.* " + "from RES_REC_MAP a " + "inner join RESUME b "
        + "on a.GID = b.GID " + "and a.GID_SN = b.SN " + "where a.EID = ? and a.EID_SN = ?";
    JSONArray array = new JSONArray();

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);
      pstmt.setInt(2, eid_sn);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        JSONObject res = new JSONObject();
        res.put("GID", rs.getString("GID"));
        res.put("SN", rs.getInt("SN"));
        res.put("SUBJECT", rs.getString("SUBJECT"));
        res.put("NAME", rs.getString("NAME"));
        array.add(res);
      }
    } catch (Exception e) {
      e.printStackTrace();
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
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException ex) {
        }
    }
    return array;
  }

  // 기업 회원 지원자 관리 리스트
  public List<Resume> getApplicantList(String eid) {
    List<Resume> applicantlist = new ArrayList<>();
    String sql = "select b.* " + "from RES_REC_MAP a " + "inner join RESUME b "
        + "on a.GID = b.GID " + "and a.GID_SN = b.SN " + "where a.EID = ?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        Resume res = new Resume();
        res.setSUBJECT(rs.getString("SUBJECT"));
        res.setNAME(rs.getString("NAME"));
        applicantlist.add(res);
      }

      return applicantlist;
    } catch (Exception ex) {
      System.out.println("getBoardList() 에러 : " + ex);
      ex.printStackTrace();
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
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException ex) {
        }
    }
    return null;
  }

  public int getListCount() {
    int x = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement("select count(*) from RES_REC_MAP");
      rs = pstmt.executeQuery();

      if (rs.next()) {
        x = rs.getInt(1);
      }
    } catch (Exception ex) {
      System.out.println("getListCount() 에러: " + ex);
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
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException ex) {
        }
    }
    return x;
  }// getListCount() end

  public List<Resume> getApplicantList(int page, int limit, String eid) {
    // String board_list_sql =
    // "select * from " + "(select rownum rnum,SN,SUBJECT,NAME,DUTY,RGS_DTM from resume "
    // + "where gid='aaa' order by rnum ) " + "where rnum>=1 and rnum<=10 ";
    String board_list_sql = "select * from " + "(select rownum rnum, b.*" + " from RES_REC_MAP a"
        + " inner join RESUME b" + " on a.GID = b.GID" + " and a.GID_SN = b.SN" + " where a.EID = ?"
        + " order by rnum)" + " where rnum >=? and rnum <=?";

    List<Resume> list = new ArrayList<Resume>();
    // 한 페이지당 10개씩 목록인 경우 1페이지, 2페이지, 3페이지, 4페이지 ...
    int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호(1 11 21 31 ...
    int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10 20 30 40 ...

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(board_list_sql);
      pstmt.setString(1, eid);
      pstmt.setInt(2, startrow);
      pstmt.setInt(3, endrow);

      rs = pstmt.executeQuery();

      // DB에서 가져온 데이터를 VO객체에 담습니다.
      while (rs.next()) {
        Resume r = new Resume();
        r.setGID(rs.getString("GID"));
        r.setSN(rs.getInt("SN"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setNAME(rs.getString("NAME"));
        r.setDUTY(rs.getString("DUTY"));
        r.setRGS_DTM(rs.getString("RGS_DTM"));
        list.add(r); // 값을 담은 객체를 리스트에 저장합니다.
        System.out.println("확인용 = " + rs.getInt("SN"));
      }
      System.out.println("list=" + list);
      return list; // 값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
    } catch (Exception ex) {
      System.out.println("getBoardList() 에러 : " + ex);
      ex.printStackTrace();
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
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException ex) {
        }
    }
    return null;
  }

  public Resume applicantDetail(String gid, int sn) {
    String sql = "select * from RESUME where GID=? and SN=? ";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);
      pstmt.setInt(2, sn);

      rs = pstmt.executeQuery();
      if (rs.next()) {
        Resume r = new Resume();
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setNAME(rs.getString("NAME"));
        r.setBIRTH(rs.getString("BIRTH"));
        r.setGENDER(rs.getString("GENDER"));
        r.setEMAIL(rs.getString("EMAIL"));
        r.setPHONE(rs.getString("PHONE"));
        r.setADDR(rs.getString("ADDR"));
        r.setPHOTO(rs.getString("PHOTO"));
        r.setSTYPE(rs.getString("STYPE"));
        r.setSDOA(rs.getString("SDOA"));
        r.setSDOG(rs.getString("SDOG"));
        r.setMAJOR(rs.getString("MAJOR"));
        r.setGRADE(rs.getString("GRADE"));
        r.setENAME(rs.getString("ENAME"));
        r.setDEPT(rs.getString("DEPT"));
        r.setDOA(rs.getString("DOA"));
        r.setDOG(rs.getString("DOG"));
        r.setRANK(rs.getString("RANK"));
        r.setJTYPE(rs.getString("JTYPE"));
        r.setDESSAL(rs.getString("DESSAL"));
        r.setREGION(rs.getString("REGION"));
        r.setDUTY(rs.getString("DUTY"));
        r.setINDUSTRY(rs.getString("INDUSTRY"));

        return r;
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
    return null;
  }

}
