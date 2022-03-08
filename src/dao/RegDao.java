package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DbUtil;

public class RegDao extends DbUtil{
	Connection con;
	public RegDao(Connection con) {
		super();
		this.con = con;
	}
	public void reg(String id, String pass, int tel, String nickname) {
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into member values(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			pstmt.setInt(3, tel);
			pstmt.setString(4, nickname);
			pstmt.executeUpdate();
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt);}
	}
}
