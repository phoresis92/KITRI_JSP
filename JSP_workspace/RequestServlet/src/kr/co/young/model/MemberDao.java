package kr.co.young.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//멤버관련된 작업을 database에 연결하여 처리하는 객체
public class MemberDao {
	
	//insert 하여 db값 입력할 수 있도록 구성하기
	
	public int addMember(String name, String email) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int cnt = 0;
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		
			con = DriverManager.getConnection("jdbc:oracle:thin:@183.101.196.162:1521:xe", "hr", "hr");
			
			String sql = "insert into employees_test(first_name, email) values(? , ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			cnt = pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return cnt;
	}
	
	public ArrayList<MemberBean> getMember(String name){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<MemberBean> list = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@183.101.196.162:1521:xe", "hr", "hr");
			
			String sql = "select first_name, email from employees_test where first_name = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			ResultSet rs = pstmt.executeQuery();
			
			MemberBean select_mem = null;
			list = new ArrayList<MemberBean>();
			while(rs.next()) {
				String get_name = rs.getString("first_name");
				String get_email = rs.getString("email");
				select_mem = new MemberBean(get_name,get_email);
			}
			list.add(select_mem);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		return list;
	}

	public int modify(String name, String email, String origin) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		System.out.println(name +"  "+ email + "  " + origin);
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@183.101.196.162:1521:xe", "hr", "hr");
			
			String sql = "update employees_test set first_name = ?, email = ? where first_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setString(3, origin);
			result = pstmt.executeUpdate();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return result;
		
	}

	public ArrayList<MemberBean> showList() {
		
		System.out.println("dao.showlist 진입");
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ArrayList<MemberBean> list = null;
		
		
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@183.101.196.162:1521:xe", "hr", "hr");
			
			String sql = "select * from employees_test";
			pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			list = new ArrayList<MemberBean>();
			while(rs.next()) {
				
				MemberBean mb = new MemberBean(rs.getString("first_name"),rs.getString("email"));
				list.add(mb);
				
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null) {
					pstmt.close();
				}
				if(con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	public int delete(String name) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@183.101.196.162:1521:xe", "hr", "hr");
		
		con.setAutoCommit(false);
		
		String sql = "DELETE employees_test WHERE first_name = ?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		result = pstmt.executeUpdate();
		
		if(result == 0) {
			con.rollback();
		}else if(result !=0) {
			con.commit();
		}
		
		
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
			//쿼리문 에러 발생시 catch 영역
			try {
				con.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			//Connection 과 PreparedStatement 닫기
			try {
				con.commit();
				con.setAutoCommit(true); // 트랜젝션 마무리 후 오토커밋 활성화
			if(pstmt!=null) pstmt.close();
			if(con!=null) con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result; 
	}
	
	
}
