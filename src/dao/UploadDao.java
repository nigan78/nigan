package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import util.DbUtil;
import vo.File;

public class UploadDao extends DbUtil{
	Connection con;
	public UploadDao(Connection con) {
		super();
		this.con = con;
	}
	public String setFileList(String fileName, String id) {
		String list = null;
		PreparedStatement pstmt = null;
		try {
			String sql = "insert into list values(?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, fileName);
			pstmt.setString(2, id);
			pstmt.executeUpdate();
				File file = new File();
				file.setName(fileName);
				file.setId(id);
				list = file.getName();
		} catch(Exception e) {e.printStackTrace();
		} finally {close(pstmt);}
		return list;
	}
}
