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
import vo.InterviewReview;

// 기업 리뷰 DAO
public class InterviewReviewDAO {
  DataSource ds;
  Connection conn;
  PreparedStatement pstmt;
  ResultSet rs;
  int result;

  public InterviewReviewDAO() {
    try {
      Context init = new InitialContext();
      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    } catch (Exception e) {
      System.out.println("DB 연결 실패 : " + e);
      return;
    }
  }

  // 등록
  public int insertInterrev(InterviewReview vo, String gid) {
    String sn_sql = "select nvl(max(sn), 0) from interview where gid=?";
    int sn = 0;

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sn_sql);
      pstmt.setString(1, gid);

      rs = pstmt.executeQuery();
      if (rs.next())
        sn = rs.getInt(1) + 1;

      rs.close();
      pstmt.close();

      pstmt = conn.prepareStatement(
          "insert into interview " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)");
      pstmt.setString(1, vo.getGID());
      pstmt.setInt(2, sn);
      pstmt.setString(3, vo.getENAME());
      pstmt.setString(4, vo.getDUTY());
      pstmt.setString(5, vo.getINDUSTRY());
      pstmt.setString(6, vo.getJTYPE());
      pstmt.setString(7, vo.getCAREER());
      pstmt.setString(8, vo.getREGION());
      pstmt.setString(9, vo.getEXP());
      pstmt.setString(10, vo.getPROC());
      pstmt.setString(11, vo.getQUE());
      pstmt.setString(12, vo.getANS());
      pstmt.setString(13, vo.getDIFF());
      pstmt.setString(14, vo.getINTDATE());

      result = pstmt.executeUpdate();


    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }

      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }

    return result;
  }

  // 목록 개수 가져오기
  public int getListCount() {
    int x = 0;
    try {
      conn = ds.getConnection();
      pstmt = conn.prepareStatement("select count(*) from interview");
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
  }

  // 리스트 얻어오기
  public List<InterviewReview> getInterrevList(int page, int limit ) {
    List<InterviewReview> list = new ArrayList<InterviewReview>();
    int startrow = (page - 1) * limit + 1;
    int endrow = startrow + limit - 1;

    try {
      conn = ds.getConnection();
      String get_list =
          "select * from (select rownum rnum, GID, SN, ENAME, DUTY, DIFF, UPT_DTM from interview  order by UPT_DTM ) "

              + "where rnum>=? and rnum<=? " ;

      /*
       * "select*from(select rownum rnum,ENAME,DUTY,DIFF,RGS_DTM from interview order by rnum asc) "
       * 
       * + "where rnum>=? and rnum<=?";
       */
      pstmt = conn.prepareStatement(get_list);
      pstmt.setInt(1, startrow);
      pstmt.setInt(2, endrow);
     /* pstmt.setString(3, GID);*/
      rs = pstmt.executeQuery();
      while (rs.next()) {
        InterviewReview vo = new InterviewReview();
        vo.setGID(rs.getString("GID"));
        vo.setSN(rs.getInt("SN"));
        vo.setENAME(rs.getString("ENAME"));
        vo.setDUTY(rs.getString("DUTY"));
        vo.setDIFF(rs.getString("DIFF"));
        vo.setUPT_DTM(rs.getDate("UPT_DTM"));
        list.add(vo);
      }
      return list;

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }

    return null;

  }

  // 상세보기
  public InterviewReview Infointerview(String gid, int sn) {
    InterviewReview vo = new InterviewReview();
    String sql = "select * from interview where GID=? AND SN=?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, gid);
      pstmt.setInt(2, sn);

      rs = pstmt.executeQuery();
      if (rs.next()) {
        /*vo.setSN(rs.getInt("SN"));*/
    	vo.setENAME(rs.getString("ENAME"));
        vo.setDUTY(rs.getString("DUTY"));
        vo.setINDUSTRY(rs.getString("INDUSTRY"));
        vo.setJTYPE(rs.getString("JTYPE"));
        vo.setCAREER(rs.getString("CAREER"));
        vo.setREGION(rs.getString("REGION"));
        vo.setEXP(rs.getString("EXP"));
        vo.setPROC(rs.getString("PROC"));
        vo.setQUE(rs.getString("QUE"));
        vo.setANS(rs.getString("ANS"));
        vo.setDIFF(rs.getString("DIFF"));
        vo.setINTDATE(rs.getString("INTDATE"));
        vo.setGID(rs.getString("GID"));
        vo.setSN(rs.getInt("SN"));
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }

    return vo;
  }

  // 삭제
  public int delete(String GID, int sn) {
    String sql = "delete from interview where GID=? and SN=?";

    try {
      conn = ds.getConnection();

      pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, GID);
      pstmt.setInt(2, sn);

      result = pstmt.executeUpdate();

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (rs != null) {
        try {
          rs.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }

    return result;
  }

  // 수정
  public boolean update(InterviewReview vo) {
    String sql = "update interview set ENAME=?,DUTY=?,INDUSTRY=?,JTYPE=?, "
    		+ "CAREER=?,REGION=?,EXP=?,PROC=?,QUE=?,ANS=?,DIFF=?,INTDATE=? , UPT_DTM=sysdate where GID=? and SN=? ";
  		/*+ "DUTY=?,INDUSTRY=? where GID=? and SN=? "*/
      /*  + "JTYPE=?,CAREER=?,REGION=?,EXP=?,PROC=?,QUE=?,ANS=?, " 
    	+ "DIFF=?,INTDATE=? where GID=? and SN=?";*/
    		
    try {
    	conn = ds.getConnection();
    	pstmt = conn.prepareStatement(sql);
      
      pstmt.setString(1, vo.getENAME());
      pstmt.setString(2, vo.getDUTY());
  
    pstmt.setString(3, vo.getINDUSTRY());
      pstmt.setString(4, vo.getJTYPE());
     pstmt.setString(5, vo.getCAREER());
      pstmt.setString(6, vo.getREGION());
      pstmt.setString(7, vo.getEXP());
      pstmt.setString(8, vo.getPROC());
      pstmt.setString(9, vo.getQUE());
      pstmt.setString(10, vo.getANS());
      pstmt.setString(11, vo.getDIFF());
      pstmt.setString(12, vo.getINTDATE());
      pstmt.setString(13, vo.getGID());
      pstmt.setInt(14,vo.getSN()); 
      
      pstmt.executeUpdate();
      return true;
     
      } catch (Exception e) {
      e.printStackTrace();
    } finally {
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (pstmt != null) {
        try {
          pstmt.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          ex.printStackTrace();
        }
      }
    }
    return false;
  }

public List<InterviewReview> getInterrevList2(int page, int limit, String gid) {
	 List<InterviewReview> list = new ArrayList<InterviewReview>();
	    int startrow = (page - 1) * limit + 1;
	    int endrow = startrow + limit - 1;

	    try {
	      conn = ds.getConnection();
	      String get_list =
	          "select * from (select rownum rnum, GID, SN, ENAME, DUTY, DIFF, UPT_DTM from interview  order by UPT_DTM desc ) "

	              + "where rnum>=? and rnum<=? and gid=?" ;

	      /*
	       * "select*from(select rownum rnum,ENAME,DUTY,DIFF,RGS_DTM from interview order by rnum asc) "
	       * 
	       * + "where rnum>=? and rnum<=?";
	       */
	      pstmt = conn.prepareStatement(get_list);
	      pstmt.setInt(1, startrow);
	      pstmt.setInt(2, endrow);
	     pstmt.setString(3, gid);
	      rs = pstmt.executeQuery();
	      while (rs.next()) {
	        InterviewReview vo = new InterviewReview();
	        vo.setGID(rs.getString("GID"));
	        vo.setSN(rs.getInt("SN"));
	        vo.setENAME(rs.getString("ENAME"));
	        vo.setDUTY(rs.getString("DUTY"));
	        vo.setDIFF(rs.getString("DIFF"));
	        vo.setUPT_DTM(rs.getDate("UPT_DTM"));
	        list.add(vo);
	      }
	      return list;

	    } catch (Exception e) {
	      e.printStackTrace();
	    } finally {
	      if (rs != null) {
	        try {
	          rs.close();
	        } catch (SQLException ex) {
	          ex.printStackTrace();
	        }
	      }
	      if (pstmt != null) {
	        try {
	          pstmt.close();
	        } catch (SQLException ex) {
	          ex.printStackTrace();
	        }
	      }
	      if (pstmt != null) {
	        try {
	          pstmt.close();
	        } catch (SQLException ex) {
	          ex.printStackTrace();
	        }
	      }
	      if (conn != null) {
	        try {
	          conn.close();
	        } catch (SQLException ex) {
	          ex.printStackTrace();
	        }
	      }
	    }

	    return null;	
}

public int getListCount2(String gid) {
	 int x = 0;
	    try {
	      conn = ds.getConnection();
	      pstmt = conn.prepareStatement("select count(*) from interview where gid=?");
	      pstmt.setString(1, gid);
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
}


}
