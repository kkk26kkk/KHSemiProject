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

import com.sun.javafx.geom.RectangularShape;

import vo.EnterpriseReview;
import vo.InterviewReview;

// 기업 리뷰 DAO
public class EnterpriseReviewDAO {
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;

	public EnterpriseReviewDAO() {
		try {
			Context init = new InitialContext();
			ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		} catch (Exception e) {
			System.out.println("DB 연결 실패 : " + e);
			return;
		}
	}

	

	public int insertEntereview(EnterpriseReview vo, String gid) {
		String sn_sql = "select nvl(max(sn), 0) from review where gid=?";
		int sn = 0;
		try {

			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sn_sql);
			pstmt.setString(1, gid);

			rs = pstmt.executeQuery();
			if (rs.next())
				sn = rs.getInt(1) + 1;
			rs.close();

			pstmt = conn
					.prepareStatement("insert into review " + "values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)");

			pstmt.setString(1, vo.getGID());
			pstmt.setInt(2, sn);
			pstmt.setString(3, vo.getENAME());
			pstmt.setString(4, vo.getCF());
			pstmt.setString(5, vo.getDUTY());
			pstmt.setString(6, vo.getINDUSTRY());
			pstmt.setString(7, vo.getJTYPE());
			pstmt.setString(8, vo.getCAREER());
			pstmt.setString(9, vo.getREGION());
			pstmt.setString(10, vo.getTHINK());
			pstmt.setString(11, vo.getADV());
			pstmt.setString(12, vo.getDADV());
			pstmt.setInt(13, vo.getPOINT());
			pstmt.setString(14, vo.getSTORY());
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

	public int getListCount() {
		int x = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement("select count(*) from review");
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

	public List<EnterpriseReview> getBoardList(int page, int limit) {
		List<EnterpriseReview> list = new ArrayList<EnterpriseReview>();
		int startrow = (page - 1) * limit + 1;
		int endrow = startrow + limit - 1;
		try {
			conn = ds.getConnection();
			String get_list = "select * from (select rownum rnum, GID, SN, ENAME, DUTY, REGION, UPT_DTM from review order by rnum) "

					+ "where rnum>=? and rnum<=? ";

			pstmt = conn.prepareStatement(get_list);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			/*pstmt.setString(3, GID);*/
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EnterpriseReview vo = new EnterpriseReview();
				vo.setGID(rs.getString("GID"));
				vo.setSN(rs.getInt("SN"));
				vo.setENAME(rs.getString("ENAME"));
				vo.setDUTY(rs.getString("DUTY"));
				vo.setREGION(rs.getString("REGION"));
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

	public EnterpriseReview infoEntreview(String gid, int sn) {
		EnterpriseReview vo = new EnterpriseReview();
		String sql = "select*from review where GID=? AND SN=?";
		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gid);
			pstmt.setInt(2, sn);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				vo.setENAME(rs.getString("ENAME"));
				vo.setCF(rs.getString("CF"));
				vo.setDUTY(rs.getString("DUTY"));
				vo.setINDUSTRY(rs.getString("INDUSTRY"));
				vo.setJTYPE(rs.getString("JTYPE"));
				vo.setCAREER(rs.getString("CAREER"));
				vo.setREGION(rs.getString("REGION"));
				vo.setTHINK(rs.getString("THINK"));
				vo.setADV(rs.getString("ADV"));
				vo.setDADV(rs.getString("DADV"));
				vo.setPOINT(rs.getInt("POINT"));
				vo.setSTORY(rs.getString("STORY"));
				vo.setUPT_DTM(rs.getDate("UPT_DTM"));
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

	public int delete(String gid, int sn) {
		String sql = "delete from review where GID=? and SN=?";
		try {
			conn = ds.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, gid);
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

	public boolean update(EnterpriseReview vo) {
		String sql = /*"update review set ENAME=? where GID=? and SN=?"*/
		
		 "update review set ENAME=?, CF=?, DUTY=?,INDUSTRY=?, "
		  +"JTYPE=?,CAREER=?,REGION=?,THINK=?,ADV=?, DADV=?, POINT=?, STORY=?, UPT_DTM=sysdate " 
		 +"where GID=? and SN=? ";
		
		int result = 0;
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getENAME());
			
			 pstmt.setString(2,vo.getCF()); 
			 pstmt.setString(3,vo.getDUTY());
			 pstmt.setString(4,vo.getINDUSTRY()); 
			 pstmt.setString(5,vo.getJTYPE());
			 pstmt.setString(6,vo.getCAREER()); 
			 pstmt.setString(7,vo.getREGION());
			 pstmt.setString(8,vo.getTHINK()); 
			 pstmt.setString(9,vo.getADV());
			 pstmt.setString(10,vo.getDADV()); 
			 pstmt.setInt(11,vo.getPOINT());
			 pstmt.setString(12, vo.getSTORY());
			 pstmt.setString(13, vo.getGID());
			 pstmt.setInt(14, vo.getSN());
		
		pstmt.executeUpdate();
			return true;
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
		return false;
	}



	public List<EnterpriseReview> getBoardList2(int page, int limit, String gid) {
		List<EnterpriseReview> list = new ArrayList<EnterpriseReview>();
		int startrow = (page - 1) * limit + 1;
		int endrow = startrow + limit - 1;
		try {
			conn = ds.getConnection();
			String get_list = "select * from (select rownum rnum, GID, SN, ENAME, DUTY, REGION, UPT_DTM from review order by rnum) "

					+ "where rnum>=? and rnum<=? and gid=?";

			pstmt = conn.prepareStatement(get_list);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			pstmt.setString(3, gid);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				EnterpriseReview vo = new EnterpriseReview();
				vo.setGID(rs.getString("GID"));
				vo.setSN(rs.getInt("SN"));
				vo.setENAME(rs.getString("ENAME"));
				vo.setDUTY(rs.getString("DUTY"));
				vo.setREGION(rs.getString("REGION"));
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







	public List<EnterpriseReview> getBoardSearch(String ename) {
List<EnterpriseReview> list2 = new ArrayList<EnterpriseReview>();
try {
	conn = ds.getConnection();
	String get_list ="select ename,duty,region,upt_dtm where ename=?";

	pstmt = conn.prepareStatement(get_list);
	pstmt.setString(1, ename);

	rs = pstmt.executeQuery();
	while (rs.next()) {
		EnterpriseReview vo2 = new EnterpriseReview();
	
		vo2.setENAME(rs.getString("ENAME"));
		vo2.setDUTY(rs.getString("DUTY"));
		vo2.setREGION(rs.getString("REGION"));
		vo2.setUPT_DTM(rs.getDate("UPT_DTM"));
		list2.add(vo2);
	}
	return list2;

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



	
		
		public JSONArray Ajexist(String ENAME) {
			String sql = "select ENAME,DUTY,REGION,UPT_DTM from review where ENAME=?";
		    JSONArray array = new JSONArray();
		    try {
		        conn = ds.getConnection();

		        pstmt = conn.prepareStatement(sql);
		        pstmt.setString(1, ENAME);

		        rs = pstmt.executeQuery();

		        while (rs.next()) {
		        JSONObject res=new JSONObject();
		         res.put("ENAME",rs.getString(1));
		         res.put("DUTY", rs.getString(2));
		         res.put("REGION", rs.getString(3)); 
		         res.put("UPT_DTM", rs.getString(4));
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



		public int getListCount2(String gid) {
			 int x = 0;
			    try {
			      conn = ds.getConnection();
			      pstmt = conn.prepareStatement("select count(*) from review where gid=?");
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



		public EnterpriseReview infoEntreview2(String gid ) {
			EnterpriseReview vo = new EnterpriseReview();
			String sql = "select*from review where ENAME=? ";
			try {
				conn = ds.getConnection();

				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, gid);
				/*pstmt.setString(2, gid2);*/
				rs = pstmt.executeQuery();
				if (rs.next()) {
					vo.setENAME(rs.getString("ENAME"));
					vo.setCF(rs.getString("CF"));
					vo.setDUTY(rs.getString("DUTY"));
					vo.setINDUSTRY(rs.getString("INDUSTRY"));
					vo.setJTYPE(rs.getString("JTYPE"));
					vo.setCAREER(rs.getString("CAREER"));
					vo.setREGION(rs.getString("REGION"));
					vo.setTHINK(rs.getString("THINK"));
					vo.setADV(rs.getString("ADV"));
					vo.setDADV(rs.getString("DADV"));
					vo.setPOINT(rs.getInt("POINT"));
					vo.setSTORY(rs.getString("STORY"));
					vo.setUPT_DTM(rs.getDate("UPT_DTM"));
				/*	vo.setGID(rs.getString("GID"));
					vo.setSN(rs.getInt("SN"));*/
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



	



	

	
}
