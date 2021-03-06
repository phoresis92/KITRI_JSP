package com.young.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.young.dto.MDto;

public class MDao {

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	MDto dto = null;
	int result = 0 ;
	
	public MDao(){
		try {
		Class.forName("oracle.jdbc.OracleDriver");
		con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", "hr", "hr");
		System.out.println("jdbc connection OK");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	} // constructor
	
	public int regi(String name, String birth, String gender, String fn, String mn, String ln, String phone) {
		
		try{
			System.out.println("MDao.regi");
			con.setAutoCommit(false);
			
			String sql = "insert into memtest (name, birth, gender, front_num, mid_num, last_num, phone) values (?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, gender);
			pstmt.setString(4, fn);
			pstmt.setString(5, mn);
			pstmt.setString(6, ln);
			pstmt.setString(7, phone);
			result = pstmt.executeUpdate();
			
			if(result == 0) System.out.println("register fail");
			if(result != 0) System.out.println("register success");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}finally {
			try {
				con.commit();
				con.setAutoCommit(true);
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				System.out.println("connection close");
				System.out.println("===============================================");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	} //regi method end
	
	public MDto getMember(String phone) {
		
		try {
			System.out.println("MDao.getMember");
			con.setAutoCommit(false);
			
			String sql = "SELECT name, birth, gender, front_num, mid_num, last_num, phone FROM memtest WHERE phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				
				dto = new MDto(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}finally {
			try {
				con.commit();
				con.setAutoCommit(true);
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				System.out.println("connection close");
				System.out.println("===============================================");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	} // getMember method end
	
	public int update(String name, String birth, String gender, String fn, String mn, String ln, String phone, String origin_num) {
		
		try{
			System.out.println("MDao.update");
			con.setAutoCommit(false);
			
			String sql = "update memtest set name=?, birth=?, gender=?, front_num=?, mid_num=?, last_num=?, phone=? WHERE phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, birth);
			pstmt.setString(3, gender);
			pstmt.setString(4, fn);
			pstmt.setString(5, mn);
			pstmt.setString(6, ln);
			pstmt.setString(7, phone);
			pstmt.setString(8, origin_num);
			result = pstmt.executeUpdate();
			
			if(result == 0) System.out.println("update fail");
			if(result != 0) System.out.println("update success");
			
			
		}catch(SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}finally {
			try {
				con.commit();
				con.setAutoCommit(true);
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				System.out.println("connection close");
				System.out.println("===============================================");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	} //update method end
	
	public int delMember(String phone) {
		
		try {
			System.out.println("MDao.getMember");
			con.setAutoCommit(false);
			
			String sql = "delete memtest where phone = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			result = pstmt.executeUpdate();

			if(result == 0) System.out.println("delete fail");
			if(result != 0) System.out.println("delete success");
			
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}finally {
			try {
				con.commit();
				con.setAutoCommit(true);
				if(pstmt!=null) pstmt.close();
				if(con!=null) con.close();
				System.out.println("connection close");
				System.out.println("===============================================");
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
		
	}
	
}
