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
import org.apache.tomcat.util.buf.StringUtils;
import vo.Recruit;

// 채용 공고 DAO
public class RecruitDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public RecruitDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  // 공고 등록
  public int insertRecruit(Recruit r, String eid) {
    String sn_sql = "select nvl(max(sn), 0) from RECRUIT where eid=?";
    int sn = 0;

    String einfo_sql =
        "select ENUM, DOE, ETYPE, PAGEADDR, REVENUE, EADDR, EADDR1, EADDR2, LOGO from ENTERPRISEINFO where eid=?";
    String e_num = "", doe = "", etype = "", pageaddr = "", revenue = "", eaddr = "", eaddr1 = "",
        eaddr2 = "", logo = "";

    String ins_sql = "insert into RECRUIT values "
        + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sn_sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();
      if (rs.next())
        sn = rs.getInt(1) + 1;

      rs.close();
      pstmt.close();
      // sn_sql end

      pstmt = conn.prepareStatement(einfo_sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();
      if (rs.next()) {
        e_num = rs.getString(1);
        doe = rs.getString(2);
        etype = rs.getString(3);
        pageaddr = rs.getString(4);
        revenue = rs.getString(5);
        eaddr = rs.getString(6);
        eaddr1 = rs.getString(7);
        eaddr2 = rs.getString(8);
        logo = rs.getString(9);
      }

      rs.close();
      pstmt.close();

      // einfo_sql end

      pstmt = conn.prepareStatement(ins_sql);

      pstmt.setString(1, eid);
      pstmt.setInt(2, sn);
      pstmt.setString(3, r.getSUBJECT());
      pstmt.setString(4, r.getENAME());
      pstmt.setString(5, r.getCAREER());
      pstmt.setString(6, r.getEDU());
      pstmt.setString(7, r.getJTYPE());
      pstmt.setString(8, r.getDUTY());
      pstmt.setString(9, r.getINDUSTRY());
      pstmt.setString(10, e_num);
      pstmt.setString(11, doe);
      pstmt.setString(12, etype);
      pstmt.setString(13, pageaddr);
      pstmt.setString(14, revenue);
      pstmt.setString(15, r.getKIND());
      pstmt.setString(16, r.getPAY());
      pstmt.setString(17, r.getJOB());
      pstmt.setString(18, r.getELIGI());
      pstmt.setString(19, r.getRECNUM());
      pstmt.setString(20, r.getWTYPE());
      pstmt.setString(21, r.getREGION());
      pstmt.setString(22, r.getSTARTDATE());
      pstmt.setString(23, r.getENDDATE());
      pstmt.setString(24, r.getNOTICE());
      pstmt.setString(25, eaddr);
      pstmt.setString(26, eaddr1);
      pstmt.setString(27, eaddr2);
      pstmt.setString(28, r.getWDAY());
      pstmt.setString(29, r.getWTIME());
      pstmt.setString(30, logo);


      result = pstmt.executeUpdate();

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
    return result;
  }

  // 공고 상세 보기
  public Recruit recruitDetail(String eid, int sn) {
    String sql = "select * from RECRUIT where EID=? and SN=?";
    // String sql =
    // "select a.*, b.DCODE, c.ICODE, d.RCODE " + "from RECRUIT a " + "inner join DUTY_CODE b "
    // + "on b.SN = a.DUTY " + "inner join INDUSTRY_CODE c " + "on c.SN = a.INDUSTRY "
    // + "inner join REGION_CODE d " + "on d.SN = a.REGION " + "where a.EID = ? and a.SN = ?";
    Recruit r = new Recruit();
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);
      pstmt.setInt(2, sn);

      rs = pstmt.executeQuery();
      if (rs.next()) {
        r.setEID(rs.getString("EID"));
        r.setSN(rs.getInt("SN"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setENAME(rs.getString("ENAME"));
        r.setCAREER(rs.getString("CAREER"));
        r.setEDU(rs.getString("EDU"));
        r.setJTYPE(rs.getString("JTYPE"));
        // r.setDUTY(rs.getString("DCODE")); // DUTY
        r.setDUTY(rs.getString("DUTY")); // DUTY
        // r.setINDUSTRY(rs.getString("ICODE")); // INDUSTRY
        r.setINDUSTRY(rs.getString("INDUSTRY")); // INDUSTRY
        r.setENUM(rs.getString("ENUM"));
        r.setDOE(rs.getString("DOE"));
        r.setETYPE(rs.getString("ETYPE"));
        r.setPAGEADDR(rs.getString("PAGEADDR"));
        r.setREVENUE(rs.getString("REVENUE"));
        r.setKIND(rs.getString("KIND"));
        r.setPAY(rs.getString("PAY"));
        r.setJOB(rs.getString("JOB"));
        r.setELIGI(rs.getString("ELIGI"));
        r.setRECNUM(rs.getString("RECNUM"));
        r.setWTYPE(rs.getString("WTYPE"));
        // r.setREGION(rs.getString("RCODE")); // REGION
        r.setREGION(rs.getString("REGION")); // REGION
        r.setSTARTDATE(rs.getString("STARTDATE"));
        r.setENDDATE(rs.getString("ENDDATE"));
        r.setNOTICE(rs.getString("NOTICE"));
        r.setEADDR(rs.getString("EADDR"));
        r.setEADDR1(rs.getString("EADDR1"));
        r.setEADDR2(rs.getString("EADDR2"));
        r.setWDAY(rs.getString("WDAY"));
        r.setWTIME(rs.getString("WTIME"));
        r.setLOGO(rs.getString("LOGO"));

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

  public void updateRecruit(Recruit r) {
    String sql = "update Recruit set xx = ?, upt_dtm = sysdate where eid = ? and sn = ?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);

      // TODO set

      pstmt.executeUpdate();

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

  }

  public void deleteRecruit(String gid, int sn) {
    String sql = "delete from Recruit where eid = ? and sn = ?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);

      // TODO set

      pstmt.executeUpdate();

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
  }

  // 목록 개수 가져오기
  public int getListCount() {
    int x = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement("select count(*) from recruit");
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
  } // getListCount() end

  public List<Recruit> getBoardList(int page, int limit, String eid) {
    // page : 페이지
    // limit : 페이지 당 목록의 수
    // BOARD_RE_REF desc, BOARD_RE_SEQ asc에 의해 정렬한 것을
    // 조건절에 맞는 rnum의 범위 만큼 가져오는 쿼리문입니다.
    String board_list_sql =
        "select * from " + "(select rownum rnum,SN,SUBJECT,KIND,JOB,RGS_DTM from recruit "
            + "where eid=? order by rnum) " + "where rnum>=? and rnum<=?";

    List<Recruit> list = new ArrayList<Recruit>();
    // 한 페이지당 10개씩 목록인 경우 1페이지, 2페이지, 3페이지, 4페이지 ...
    int startrow = (page - 1) * limit + 1; // 읽기 시작할 row 번호(1 11 21 31 ...
    int endrow = startrow + limit - 1; // 읽을 마지막 row 번호(10 20 30 40 ...

    // int sn = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(board_list_sql);
      pstmt.setString(1, eid);
      pstmt.setInt(2, startrow);
      pstmt.setInt(3, endrow);
      rs = pstmt.executeQuery();

      // DB에서 가져온 데이터를 VO객체에 담습니다.
      while (rs.next()) {
        Recruit r = new Recruit();
        r.setEID(eid);
        r.setSN(rs.getInt("sn"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setKIND(rs.getString("KIND"));
        r.setJOB(rs.getString("JOB"));
        r.setRGS_DTM(rs.getDate("RGS_DTM"));
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
  } // getBoardList()메서드 end



  // 공고 리스트(기업용 리스트)
  public List<Recruit> getRecruitList(String eid) {
    List<Recruit> list = new ArrayList<>();

    String sql = "select * from RECRUIT where eid=?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, eid);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        Recruit r = new Recruit();
        r.setEID(rs.getString("EID"));
        r.setSN(rs.getInt("SN"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setENAME(rs.getString("ENAME"));
        r.setCAREER(rs.getString("CAREER"));
        r.setEDU(rs.getString("EDU"));
        r.setJTYPE(rs.getString("JTYPE"));
        r.setDUTY(rs.getString("DUTY")); // DUTY
        r.setINDUSTRY(rs.getString("INDUSTRY")); // INDUSTRY
        r.setENUM(rs.getString("ENUM"));
        r.setDOE(rs.getString("DOE"));
        r.setETYPE(rs.getString("ETYPE"));
        r.setPAGEADDR(rs.getString("PAGEADDR"));
        r.setREVENUE(rs.getString("REVENUE"));
        r.setKIND(rs.getString("KIND"));
        r.setPAY(rs.getString("PAY"));
        r.setJOB(rs.getString("JOB"));
        r.setELIGI(rs.getString("ELIGI"));
        r.setRECNUM(rs.getString("RECNUM"));
        r.setWTYPE(rs.getString("WTYPE"));
        r.setREGION(rs.getString("REGION")); // REGION
        r.setSTARTDATE(rs.getString("STARTDATE"));
        r.setENDDATE(rs.getString("ENDDATE"));
        r.setNOTICE(rs.getString("NOTICE"));
        r.setEADDR(rs.getString("EADDR"));
        r.setEADDR1(rs.getString("EADDR1"));
        r.setEADDR2(rs.getString("EADDR2"));
        r.setWDAY(rs.getString("WDAY"));
        r.setWTIME(rs.getString("WTIME"));
        r.setLOGO(rs.getString("LOGO"));
        r.setRGS_DTM(rs.getDate("RGS_DTM"));
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

  // 시험용
  public List<Recruit> getRecruitList() {
    List<Recruit> list = new ArrayList<>();

    String sql = "select * from RECRUIT";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        Recruit r = new Recruit();
        r.setEID(rs.getString("EID"));
        r.setSN(rs.getInt("SN"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setENAME(rs.getString("ENAME"));
        r.setCAREER(rs.getString("EDU"));
        r.setEDU(rs.getString("JTYPE"));
        r.setDUTY(rs.getString("INDUSTRY"));
        r.setENUM(rs.getString("ENUM"));
        r.setDOE(rs.getString("ETYPE"));
        r.setPAGEADDR(rs.getString("PAGEADDR"));
        r.setREVENUE(rs.getString("REVENUE"));
        r.setKIND(rs.getString("KIND"));
        r.setJOB(rs.getString("JOB"));
        r.setELIGI(rs.getString("ELIGI"));
        r.setRECNUM(rs.getString("RECNUM"));
        r.setWTYPE(rs.getString("WTYPE"));
        r.setREGION(rs.getString("REGION"));
        r.setSTARTDATE(rs.getString("STARTDATE"));
        r.setENDDATE(rs.getString("ENDDATE"));
        r.setNOTICE(rs.getString("NOTICE"));
        r.setEADDR(rs.getString("EADDR"));
        r.setWDAY(rs.getString("WDAY"));
        r.setWTIME(rs.getString("WTIME"));
        r.setLOGO(rs.getString("LOGO"));
        r.setRGS_DTM(rs.getDate("RGS_DTM"));
        r.setUPT_DTM(rs.getDate("UPT_DTM"));
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

  // 채용 정보 공고 가져오기
  public List<Recruit> getRecruitList(int page, int limit) {
    String recruit_list_sql =
        "select * from " + "(select rownum rnum, EID, SN, SUBJECT, ENAME from recruit "
            + "order by RGS_DTM asc) " + "where rnum>=? and rnum <=?";

    List<Recruit> list = new ArrayList<>();

    int startrow = (page - 1) * limit + 1;
    int endrow = startrow + limit - 1;

    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement(recruit_list_sql);
      pstmt.setInt(1, startrow);
      pstmt.setInt(2, endrow);
      rs = pstmt.executeQuery();

      while (rs.next()) {
        Recruit r = new Recruit();
        r.setEID(rs.getString("EID"));
        r.setSN(rs.getInt("SN"));
        r.setENAME(rs.getString("ENAME"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        list.add(r);
      }
      return list;
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
  } // getRecruitList() end

  // 공고 필터링 용
  public List<Recruit> getRecruitList(Map<String, String> m) {
    List<Recruit> list = new ArrayList<>();
    String sql = "select * from Recruit where 1 = 1";
    for (Map.Entry<String, String> e : m.entrySet()) {
      String k = e.getKey();
      String v = e.getValue();
      String whereClause = String.format("and %s = '%s'", k, v);
      sql += whereClause;
    }

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);

      rs = pstmt.executeQuery();

      while (rs.next()) {
        Recruit r = new Recruit();
        r.setEID(rs.getString("EID"));
        r.setSN(rs.getInt("SN"));
        r.setSUBJECT(rs.getString("SUBJECT"));
        r.setENAME(rs.getString("ENAME"));
        r.setCAREER(rs.getString("EDU"));
        r.setEDU(rs.getString("JTYPE"));
        r.setDUTY(rs.getString("INDUSTRY"));
        r.setENUM(rs.getString("ENUM"));
        r.setDOE(rs.getString("ETYPE"));
        r.setPAGEADDR(rs.getString("PAGEADDR"));
        r.setREVENUE(rs.getString("REVENUE"));
        r.setKIND(rs.getString("KIND"));
        r.setJOB(rs.getString("JOB"));
        r.setELIGI(rs.getString("ELIGI"));
        r.setRECNUM(rs.getString("RECNUM"));
        r.setWTYPE(rs.getString("WTYPE"));
        r.setREGION(rs.getString("REGION"));
        r.setSTARTDATE(rs.getString("STARTDATE"));
        r.setENDDATE(rs.getString("ENDDATE"));
        r.setNOTICE(rs.getString("NOTICE"));
        r.setEADDR(rs.getString("EADDR"));
        r.setWDAY(rs.getString("WDAY"));
        r.setWTIME(rs.getString("WTIME"));
        r.setLOGO(rs.getString("LOGO"));
        r.setRGS_DTM(rs.getDate("RGS_DTM"));
        r.setUPT_DTM(rs.getDate("UPT_DTM"));
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

  public void foo(List<String> params) {
    List<String> l = new ArrayList<>();
    for (String param : params) {
      l.add("'" + param + "'");
    }
    String s = "(" + StringUtils.join(l, ',') + ")";
  }
}
