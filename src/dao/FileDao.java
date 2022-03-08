package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.DbUtil;
import vo.File;

public class FileDao extends DbUtil{
	Connection con;
	public FileDao(Connection con) {
		super();
		this.con = con;
	}
	public String[] getFileList(String id) {
		String[] list = new String[99];
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		try {
			String sql = "select * from list where id=? and name like ? order by name";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, "(id="+id+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				File file = new File();
				file.setName(rs.getString("name"));
				file.setId(rs.getString("id"));
				list[i] = file.getName();
				i++;
			}
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt); close(rs);}
		return list;
	}
	public String[] search(String id, String search) {
		String[] list = new String[99];
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int i = 0;
		try {
			String sql = "select * from list where id=? and name like ? and name like ? order by name";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, "(id="+id+"%");
			pstmt.setString(3, "%"+search+"%");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				File file = new File();
				file.setName(rs.getString("name"));
				file.setId(rs.getString("id"));
				list[i] = file.getName();
				i++;
			}
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt); close(rs);}
		return list;
	}
}
