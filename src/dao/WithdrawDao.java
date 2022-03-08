package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DbUtil;

public class WithdrawDao extends DbUtil{
	Connection con;
	public WithdrawDao(Connection con) {
		super();
		this.con = con;
	}
	public void withdraw(String id, String pass) {
		PreparedStatement pstmt = null;
		try {
		String sql1 = "Delete list where id=?";
		pstmt = con.prepareStatement(sql1);
		pstmt.setString(1, id);
		pstmt.executeUpdate();
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt);}
		pstmt = null;
		try { 
			String sql = "Delete member where id=? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.executeUpdate();
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt);}

	}
}
