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

import vo.SalaryInfo;

public class SalaryDAO {
	 DataSource ds;
	  Connection conn;
	  PreparedStatement pstmt;
	  ResultSet rs;
	  int result;
	  public SalaryDAO()  {
	    try {
	      Context init = new InitialContext();
	      ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	    } catch (Exception e) {
	      System.out.println("DB 연결 실패 : " + e);
	      return;
	    }
	  }

	public int getListCount() {
		int x= 0;
		try{
			conn=ds.getConnection();
			pstmt=conn.prepareStatement(
					"select count(*) from salary");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount() 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}
			                catch(SQLException ex){}
			if(conn!=null) try{conn.close();}catch(SQLException ex){}
		}
		return x;
	}

	public List<SalaryInfo> getSalarylists(int page, int limit) {
		
		List<SalaryInfo> list=new ArrayList<SalaryInfo>();
		int startrow=(page-1)* limit + 1; 
		int endrow= startrow + limit - 1;
		try {
			conn=ds.getConnection();
String get_list="select*from(select rownum rnum,GID,SN,ENAME,DUTY,SAL,UPT_DTM from salary) "
		+ "where rnum>=? and rnum<=?";
/*"select ENAME,DUTY,SAL,RGS_DTM from salary ";*/
				
			pstmt=conn.prepareStatement(get_list);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs=pstmt.executeQuery();
		
		while(rs.next()) {
			SalaryInfo vo=new SalaryInfo();
			vo.setGID(rs.getString("GID"));
	        vo.setSN(rs.getInt("SN"));
			vo.setENAME(rs.getString("ENAME"));
			vo.setDUTY(rs.getString("DUTY"));
			vo.setSAL(rs.getInt("SAL"));
			vo.setUPT_DTM(rs.getDate("UPT_DTM"));
			
			list.add(vo);
			
			
		}
		return list;
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		return null;
	}

	public int insertSalary(SalaryInfo vo,String gid) {
		String sn_sql = "select nvl(max(sn), 0) from salary where gid=?";
	    int sn = 0;
	try {
		conn=ds.getConnection();
		 pstmt = conn.prepareStatement(sn_sql);
		pstmt.setString(1,gid);
		rs=pstmt.executeQuery();
		if(rs.next())
		sn = rs.getInt(1) + 1;
		 rs.close();
	      pstmt.close();
		
		pstmt=conn.prepareStatement("insert into salary "
+    "values(?,?,?,?,?,?,?,?,?,?,?,?,sysdate,sysdate)");
		pstmt.setString(1,vo.getGID());
		pstmt.setInt(2,sn);
		pstmt.setString(3,vo.getENAME());
		pstmt.setString(4,vo.getCF());
		pstmt.setString(5,vo.getDUTY());
		pstmt.setString(6,vo.getINDUSTRY());
		pstmt.setString(7,vo.getJTYPE());
		pstmt.setString(8,vo.getRANK());
		pstmt.setString(9,vo.getCAREER());
		pstmt.setString(10,vo.getREGION());
		pstmt.setInt(11,vo.getSAL());
		pstmt.setInt(12, vo.getINCENTIVE());
		result = pstmt.executeUpdate();
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	return result;
		
		
		
	}

	public SalaryInfo Infosalary(String gid,int sn) {
		SalaryInfo vo=new SalaryInfo();
		try {
			conn=ds.getConnection();
			String sql="select*from salary where GID=? AND SN=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,gid);
			pstmt.setInt(2,sn);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				vo.setENAME(rs.getString("ENAME"));
				vo.setCF(rs.getString("CF"));
				vo.setDUTY(rs.getString("DUTY"));
				vo.setINDUSTRY(rs.getString("INDUSTRY"));
				vo.setJTYPE(rs.getString("JTYPE"));
				vo.setRANK(rs.getString("RANK"));
				vo.setCAREER(rs.getString("CAREER"));
				vo.setREGION(rs.getString("REGION"));
				vo.setSAL(rs.getInt("SAL"));
				vo.setINCENTIVE(rs.getInt("INCENTIVE"));
				vo.setGID(rs.getString("GID"));
				vo.setSN(rs.getInt("SN"));
			
		}
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	return vo;	
	
	
	




	}

	public boolean update(SalaryInfo vo) {
		String sql="update salary set ENAME=?, CF=?, DUTY=?,INDUSTRY=?, "
				+"JTYPE=?,RANK=?,CAREER=?,REGION=?,SAL=?,INCENTIVE=?,UPT_DTM=sysdate "
				+ "where GID=? and SN=? ";
			/*	+  "JTYPE=?,RANK=?,CAREER=?,REGION=?, "
				+  "SAL=?,INCENTIVE=? where ENAME=? " ;*/
		
		try {
	conn=ds.getConnection();
			
	pstmt=conn.prepareStatement(sql);		
	pstmt.setString(1,vo.getENAME());
	pstmt.setString(2,vo.getCF());
	pstmt.setString(3,vo.getDUTY());
	pstmt.setString(4,vo.getINDUSTRY());
	pstmt.setString(5,vo.getJTYPE());
	pstmt.setString(6,vo.getRANK());
	pstmt.setString(7,vo.getCAREER());
	pstmt.setString(8,vo.getREGION());
	pstmt.setInt(9,vo.getSAL());
	pstmt.setInt(10,vo.getINCENTIVE());
	pstmt.setString(11,vo.getGID());	
	pstmt.setInt(12,vo.getSN());
	
	pstmt.executeUpdate();
		return true;
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		return false;
		
	}

	public void delete(String GID, int sn) {
	try {
		conn=ds.getConnection();
		String sql = "delete from salary where GID=? and SN=?";
		pstmt=conn.prepareStatement(sql);
		 pstmt.setString(1, GID);
	      pstmt.setInt(2, sn);
		pstmt.executeUpdate();
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		if(rs!=null) {
			try {
				rs.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(pstmt!=null) {
			try {
				pstmt.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
		if(conn!=null) {
			try {
				conn.close();
			}catch(SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	}

	public List<SalaryInfo> getSalarylists2(int page, int limit, String gid) {
		List<SalaryInfo> list=new ArrayList<SalaryInfo>();
		int startrow=(page-1)*limit + 1; 
		int endrow= startrow + limit - 1;
		try {
			conn=ds.getConnection();
String get_list="select*from(select rownum rnum,GID,SN,ENAME,DUTY,SAL,UPT_DTM from salary ) "
		+ "where rnum>=? and rnum<=? and gid=?" ;
/*"select ENAME,DUTY,SAL,RGS_DTM from salary ";*/
				
			pstmt=conn.prepareStatement(get_list);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			pstmt.setString(3, gid);
			rs=pstmt.executeQuery();
		
		while(rs.next()) {
			SalaryInfo vo=new SalaryInfo();
			vo.setGID(rs.getString("GID"));
	        vo.setSN(rs.getInt("SN"));
			vo.setENAME(rs.getString("ENAME"));
			vo.setDUTY(rs.getString("DUTY"));
			vo.setSAL(rs.getInt("SAL"));
			vo.setUPT_DTM(rs.getDate("UPT_DTM"));
			
			list.add(vo);
			
			
		}
		return list;
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				}catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
				}catch(SQLException ex) {
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
		      pstmt = conn.prepareStatement("select count(*) from salary where gid=?");
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

	


