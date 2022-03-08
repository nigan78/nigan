package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DbUtil;
import vo.User;

public class LoginDao extends DbUtil{
	Connection con;
	public LoginDao(Connection con) {
		super();
		this.con = con;
	}
	public User getUserLogin(String id, String pass) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		User user = null;
		try {
			String sql = "select * from member where id=? and pass=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				user = new User();
				user.setId(rs.getString("id"));
				user.setPass(rs.getString("pass"));
				user.setTel(rs.getInt("tel"));
				user.setNickname(rs.getString("nickname"));
			}
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt); close(rs);}
		return user;
	}
}
