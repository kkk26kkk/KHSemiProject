package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import vo.Resume;

// 지원자 DAO
public class ResumeDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public ResumeDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  public int insertRes(Resume res, String gid) {
    String sn_sql = "select nvl(max(sn), 0) from RESUME where GID=?";
    int sn = 0;
    String ins_sql = "insert into RESUME values "
        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sn_sql);
      pstmt.setString(1, gid);

      rs = pstmt.executeQuery();

      if (rs.next())
        sn = rs.getInt(1) + 1;

      rs.close();
      pstmt.close();

      pstmt = conn.prepareStatement(ins_sql);
      pstmt.setString(1, gid);
      pstmt.setInt(2, sn);
      pstmt.setString(3, res.getSUBJECT());
      pstmt.setString(4, res.getNAME());
      pstmt.setString(5, res.getBIRTH());
      pstmt.setString(6, res.getGENDER());
      pstmt.setString(7, res.getEMAIL());
      pstmt.setString(8, res.getPHONE());
      pstmt.setString(9, res.getADDR());
      pstmt.setString(10, res.getPHOTO());
      pstmt.setString(11, res.getSTYPE());
      pstmt.setString(12, res.getSNAME());
      pstmt.setString(13, res.getSDOA());
      pstmt.setString(14, res.getSDOG());
      pstmt.setString(15, res.getMAJOR());
      pstmt.setString(16, res.getGRADE());
      pstmt.setString(17, res.getENAME());
      pstmt.setString(18, res.getDEPT());
      pstmt.setString(19, res.getDOA());
      pstmt.setString(20, res.getDOG());
      pstmt.setString(21, res.getRANK());
      pstmt.setString(22, res.getCERTNAME());
      pstmt.setString(23, res.getPUBLISHER());
      pstmt.setString(24, res.getCACDATE());
      pstmt.setString(25, res.getLANNAME());
      pstmt.setString(26, res.getRATING());
      pstmt.setString(27, res.getLACDATE());
      pstmt.setString(28, res.getPRSUBJECT());
      pstmt.setString(29, res.getPRCONTENT());
      pstmt.setString(30, res.getJTYPE());
      pstmt.setString(31, res.getDESSAL());
      pstmt.setString(32, res.getREGION());
      pstmt.setString(33, res.getDUTY());
      pstmt.setString(34, res.getINDUSTRY());

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
  } // insertRes() end

  // 이력서 상세 보기
  public Resume getResumeDetail(String gid, int sn) {
    String sql = "select * from RESUME where GID=? and SN=?";
    // String sql =
    // "select a.*, b.DCODE, c.ICODE, d.RCODE " + "from RESUME a " + "inner join DUTY_CODE b "
    // + "on b.SN = a.DUTY " + "inner join INDUSTRY_CODE c " + "on c.SN = a.INDUSTRY "
    // + "inner join REGION_CODE d " + "on d.SN = a.REGION " + "where a.gid = ? and a.sn = ?";
    Resume res = new Resume();
    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);
      pstmt.setInt(2, sn);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        res.setGID(rs.getString("GID"));
        res.setSN(rs.getInt("SN"));
        res.setSUBJECT(rs.getString("SUBJECT"));
        res.setNAME(rs.getString("NAME"));
        res.setBIRTH(rs.getString("BIRTH"));
        res.setGENDER(rs.getString("GENDER"));
        res.setEMAIL(rs.getString("EMAIL"));
        res.setPHONE(rs.getString("PHONE"));
        res.setADDR(rs.getString("ADDR"));
        res.setPHOTO(rs.getString("PHOTO"));
        res.setSTYPE(rs.getString("STYPE"));
        res.setSNAME(rs.getString("SNAME"));
        res.setSDOA(rs.getString("SDOA"));
        res.setSDOG(rs.getString("SDOG"));
        res.setMAJOR(rs.getString("MAJOR"));
        res.setGRADE(rs.getString("GRADE"));
        res.setENAME(rs.getString("ENAME"));
        res.setDEPT(rs.getString("DEPT"));
        res.setDOA(rs.getString("DOA"));
        res.setDOG(rs.getString("DOG"));
        res.setRANK(rs.getString("RANK"));
        res.setCERTNAME(rs.getString("CERTNAME"));
        res.setPUBLISHER(rs.getString("PUBLISHER"));
        res.setCACDATE(rs.getString("CACDATE"));
        res.setLANNAME(rs.getString("LANNAME"));
        res.setRATING(rs.getString("RATING"));
        res.setLACDATE(rs.getString("LACDATE"));
        res.setPRSUBJECT(rs.getString("PRSUBJECT"));
        res.setPRCONTENT(rs.getString("PRCONTENT"));
        res.setJTYPE(rs.getString("JTYPE"));
        res.setDESSAL(rs.getString("DESSAL"));
        res.setREGION(rs.getString("REGION"));
        res.setDUTY(rs.getString("DUTY"));
        res.setINDUSTRY(rs.getString("INDUSTRY"));
      }
    } catch (Exception ex) {
      System.out.println("getListCount() 에러: " + ex);
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

    return res;
  }

  public List<Resume> getResumeList(String gid) {
    List<Resume> list = new ArrayList<>();

    String sql = "select * from RESUME where gid=?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        Resume res = new Resume();
        res.setGID(rs.getString("GID"));
        res.setSN(rs.getInt("SN"));
        res.setSUBJECT(rs.getString("SUBJECT"));
        res.setNAME(rs.getString("NAME"));
        res.setBIRTH(rs.getString("BIRTH"));
        res.setGENDER(rs.getString("GENDER"));
        res.setEMAIL(rs.getString("EMAIL"));
        res.setPHONE(rs.getString("PHONE"));
        res.setADDR(rs.getString("ADDR"));
        res.setPHOTO(rs.getString("PHOTO"));
        res.setSTYPE(rs.getString("STYPE"));
        res.setSNAME(rs.getString("SNAME"));
        res.setSDOA(rs.getString("SDOA"));
        res.setSDOG(rs.getString("SDOG"));
        res.setMAJOR(rs.getString("MAJOR"));
        res.setGRADE(rs.getString("GRADE"));
        res.setENAME(rs.getString("ENAME"));
        res.setDEPT(rs.getString("DEPT"));
        res.setDOA(rs.getString("DOA"));
        res.setDOG(rs.getString("DOG"));
        res.setRANK(rs.getString("RANK"));
        res.setCERTNAME(rs.getString("CERTNAME"));
        res.setPUBLISHER(rs.getString("PUBLISHER"));
        res.setCACDATE(rs.getString("CACDATE"));
        res.setLANNAME(rs.getString("LANNAME"));
        res.setRATING(rs.getString("RATING"));
        res.setLACDATE(rs.getString("LACDATE"));
        res.setPRSUBJECT(rs.getString("PRSUBJECT"));
        res.setPRCONTENT(rs.getString("PRCONTENT"));
        res.setJTYPE(rs.getString("JTYPE"));
        res.setDESSAL(rs.getString("DESSAL"));
        res.setREGION(rs.getString("REGION"));
        res.setDUTY(rs.getString("DUTY"));
        res.setINDUSTRY(rs.getString("INDUSTRY"));
        list.add(res);
      }
      return list;
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

  public List<Resume> getResumeList(int page, int limit) {
    String sql = "select * from(select rownum rnum,GID,SN,SUBJECT,NAME,BIRTH,GENDER,EMAIL,PHONE,"
        + "ADDR,PHOTO,STYPE,SDOA,SDOG,MAJOR,GRADE,ENAME,"
        + "DEPT,DOA,DOG,RANK,JTYPE,DESSAL,REGION,DUTY,INDUSTRY,RGS_DTM,UPT_DTM from"
        + "(select * from resume order by RGS_DTM desc)) " + "where rnum>=? and rnum<=?";

    List<Resume> list = new ArrayList<Resume>();
    int startrow = (page - 1) * limit + 1;
    int endrow = startrow + limit - 1;

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, page);
      pstmt.setInt(2, limit);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Resume r = new Resume();
        r.setGID(rs.getString("GID"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setSN(rs.getInt("SN"));
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
        r.setRGS_DTM(rs.getString("RGS_DTM"));
        list.add(r);
      }
      return list;
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

  public int getListCount() {
    int x = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement("select count(*) from resume");
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

  public List<Resume> getBoardList(int page, int limit, String gid) {
    System.out.println(gid);
    System.out.println("page = " + page + "limit " + limit + "gid " + gid);

    String board_list_sql =
        "select * from " + "(select rownum rnum,SUBJECT,SN,DUTY,NAME,INDUSTRY,RGS_DTM from resume "
            + "where gid=? order by rnum ) " + "where rnum>=? and rnum<=? ";

    List<Resume> list = new ArrayList<Resume>();
    // 한 페이지당 10개씩 목록인 경우 1페이지, 2페이지, 3페이지, 4페이지 ...
    int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호(1 11 21 31 ...
    int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10 20 30 40 ...

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(board_list_sql);
      pstmt.setString(1, gid);
      pstmt.setInt(2, startrow);
      pstmt.setInt(3, endrow);

      rs = pstmt.executeQuery();

      // DB에서 가져온 데이터를 VO객체에 담습니다.
      while (rs.next()) {
        Resume r = new Resume();
        r.setGID(gid);
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setSN(rs.getInt("SN"));
        r.setDUTY(rs.getString("DUTY"));
        r.setNAME(rs.getString("NAME"));
        r.setINDUSTRY(rs.getString("INDUSTRY"));
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
  }// getBoardList()메서드 end

  // 인재 검색할 때 전체 이력서 리스트 할 때 쓰고
  public List<Resume> getBoardList(int page, int limit) {
    String board_list_sql =
        "select * from " + "(select rownum rnum,DUTY,NAME,INDUSTRY,RGS_DTM from recruit "
            + "order by rnum asc) " + "where rnum>=? and rnum<=?";

    List<Resume> list = new ArrayList<Resume>();
    // 한 페이지당 10개씩 목록인 경우 1페이지, 2페이지, 3페이지, 4페이지 ...
    int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호(1 11 21 31 ...
    int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10 20 30 40 ...

    String gid = null;
    int sn = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(board_list_sql);
      pstmt.setInt(1, startrow);
      pstmt.setInt(2, endrow);
      rs = pstmt.executeQuery();

      // DB에서 가져온 데이터를 VO객체에 담습니다.
      while (rs.next()) {
        Resume r = new Resume();
        r.setGID(gid);
        r.setSN(sn);
        r.setDUTY(rs.getString("DUTY"));
        r.setNAME(rs.getString("NAME"));
        r.setINDUSTRY(rs.getString("INDUSTRY"));
        r.setRGS_DTM(rs.getString("RGS_DTM"));
        list.add(r); // 값을 담은 객체를 리스트에 저장합니다.
      }
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
  }// getBoardList()메서드 end



  public List<Resume> getResumeAjaxList(Map<String, String> map) {
    String sql = "select * from resume where 1 = 1";

    List<Resume> list = new ArrayList<Resume>();
    for (Map.Entry<String, String> e : map.entrySet()) {
      String k = e.getKey();
      String v = e.getValue();
      String whereClause = String.format("and %s = '%s'", k, v);
      // IN foo()
      sql += whereClause;
    }
    try {

      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      rs = pstmt.executeQuery();
      while (rs.next()) {
        Resume res = new Resume();
        res.setGID(rs.getString("GID"));
        res.setSN(rs.getInt("SN"));
        res.setSUBJECT(rs.getString("SUBJECT"));
        res.setNAME(rs.getString("NAME"));
        res.setBIRTH(rs.getString("BIRTH"));
        res.setGENDER(rs.getString("GENDER"));
        res.setEMAIL(rs.getString("EMAIL"));
        res.setPHONE(rs.getString("PHONE"));
        res.setADDR(rs.getString("ADDR"));
        res.setPHOTO(rs.getString("PHOTO"));
        res.setSTYPE(rs.getString("STYPE"));
        res.setSNAME(rs.getString("SNAME"));
        res.setSDOA(rs.getString("SDOA"));
        res.setSDOG(rs.getString("SDOG"));
        res.setMAJOR(rs.getString("MAJOR"));
        res.setGRADE(rs.getString("GRADE"));
        res.setENAME(rs.getString("ENAME"));
        res.setDEPT(rs.getString("DEPT"));
        res.setDOA(rs.getString("DOA"));
        res.setDOG(rs.getString("DOG"));
        res.setRANK(rs.getString("RANK"));
        res.setCERTNAME(rs.getString("CERTNAME"));
        res.setPUBLISHER(rs.getString("PUBLISHER"));
        res.setCACDATE(rs.getString("CACDATE"));
        res.setLANNAME(rs.getString("LANNAME"));
        res.setRATING(rs.getString("RATING"));
        res.setLACDATE(rs.getString("LACDATE"));
        res.setPRSUBJECT(rs.getString("PRSUBJECT"));
        res.setPRCONTENT(rs.getString("PRCONTENT"));
        res.setJTYPE(rs.getString("JTYPE"));
        res.setDESSAL(rs.getString("DESSAL"));
        res.setREGION(rs.getString("REGION"));
        res.setDUTY(rs.getString("DUTY"));
        res.setINDUSTRY(rs.getString("INDUSTRY"));
        res.setRGS_DTM(rs.getString("RGS_DTM"));
        list.add(res);
      }

      return list;
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

  public JSONArray getList(String eid_sn) {
    String sql = "select subject,name from RESUME where SN=?";
    JSONArray array = new JSONArray();
    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, Integer.parseInt(eid_sn));

      rs = pstmt.executeQuery();

      while (rs.next()) {
        JSONObject res = new JSONObject();
        res.put("subject", rs.getString(1));
        res.put("name", rs.getString(2));
        array.add(res);
      }
    } catch (Exception ex) {
      System.out.println("getListCount() 에러: " + ex);
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

    return array;
  }

  public boolean update(Resume vo) {
    String sql = "update resume set SUBJECT= ?,NAME= ?,BIRTH= ?,"
        + "GENDER= ?,EMAIL= ?,PHONE= ?,ADDR= ?,PHOTO= ?,SNAME=?,"
        + "STYPE= ?,SDOA= ?,SDOG= ?,MAJOR= ?,GRADE= ?,ENAME= ?,"
        + "DEPT= ?,DOA= ?,DOG= ?,RANK= ?,CERTNAME= ?,PUBLISHER= ?,"
        + "CACDATE= ?,LANNAME= ?,RATING= ?,LACDATE= ?,PRSUBJECT= ?,"
        + "PRCONTENT= ?,JTYPE= ?,DESSAL= ?,REGION= ?,DUTY= ?,INDUSTRY= ?,"
        + "RGS_DTM= ?,UPT_DTM= ? where SN= ? ";

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      // pstmt.setString(1, vo.getGID());
      pstmt.setString(1, vo.getSUBJECT());
      pstmt.setString(2, vo.getNAME());
      pstmt.setString(3, vo.getBIRTH());
      pstmt.setString(4, vo.getGENDER());
      pstmt.setString(5, vo.getEMAIL());
      pstmt.setString(6, vo.getPHONE());
      pstmt.setString(7, vo.getADDR());
      pstmt.setString(8, vo.getPHOTO());
      pstmt.setString(9, vo.getSNAME());
      pstmt.setString(10, vo.getSTYPE());
      pstmt.setString(11, vo.getSDOA());
      pstmt.setString(12, vo.getSDOG());
      pstmt.setString(13, vo.getMAJOR());
      pstmt.setString(14, vo.getGRADE());
      pstmt.setString(15, vo.getENAME());
      pstmt.setString(16, vo.getDEPT());
      pstmt.setString(17, vo.getDOA());
      pstmt.setString(18, vo.getDOG());
      pstmt.setString(19, vo.getRANK());
      pstmt.setString(20, vo.getCERTNAME());
      pstmt.setString(21, vo.getPUBLISHER());
      pstmt.setString(22, vo.getCACDATE());
      pstmt.setString(23, vo.getLANNAME());
      pstmt.setString(24, vo.getRATING());
      pstmt.setString(25, vo.getLACDATE());
      pstmt.setString(26, vo.getPRSUBJECT());
      pstmt.setString(27, vo.getPRCONTENT());
      pstmt.setString(28, vo.getJTYPE());
      pstmt.setString(29, vo.getDESSAL());
      pstmt.setString(30, vo.getREGION());
      pstmt.setString(31, vo.getDUTY());
      pstmt.setString(32, vo.getINDUSTRY());
      pstmt.setString(33, vo.getRGS_DTM());
      pstmt.setString(34, vo.getUPT_DTM());
      pstmt.setInt(35, vo.getSN());
      pstmt.executeUpdate();
      return true;
    } catch (Exception ex) {
      System.out.println("update() 에러: " + ex);
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
    return false;
  }

  public boolean Delete(int sn, String gid) {
    String delete_sql = "delete from resume where SN=?";
    int result = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(delete_sql);
      pstmt.setInt(1, sn);

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
      if (conn != null)
        try {
          conn.close();
        } catch (SQLException ex) {
        }
    }
    return false;
  }
}
