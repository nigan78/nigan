package svc;

import java.sql.Connection;

import dao.FileDao;
import util.DbUtil;

public class FileBiz extends DbUtil{
	public String[] getFileList(String id) {
		Connection con = getConnection();
		FileDao FileDao = new FileDao(con);
		String[] file = FileDao.getFileList(id);
		close(con);
		return file;
	}
	public String[] search(String id, String search) {
		Connection con = getConnection();
		FileDao FileDao = new FileDao(con);
		String[] file = FileDao.search(id, search);
		close(con);
		return file;
	}
}
