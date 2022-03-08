package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DbUtil;

public class MemDao extends DbUtil{
	Connection con;
	public MemDao(Connection con) {
		super();
		this.con = con;
	}
	public String[] allID() {
		String[] allID = new String[99];
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		try {
			String sql = "select * from member order by id";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				allID[i] = rs.getString("id");
				i++;
			}
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt); close(rs);}
		return allID;
	}
	public String findID(int tel) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String id = null;
		try {
			String sql = "select * from member where tel=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tel);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				id = rs.getString("id");
			}
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt); close(rs);}
		return id;
	}
	public String findPW(int tel, String nickname) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String pw = null;
		try {
			String sql = "select * from member where tel=? and nickname=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, tel);
			pstmt.setString(2, nickname);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pw = rs.getString("pass");
			}
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt); close(rs);}
		return pw;
	}
}
