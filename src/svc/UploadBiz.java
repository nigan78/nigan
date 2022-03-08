package svc;

import java.sql.Connection;

import dao.UploadDao;
import util.DbUtil;

public class UploadBiz extends DbUtil{
	public String insert(String fileName, String id) {
		Connection con = getConnection();
		UploadDao uploadDao = new UploadDao(con);
		String file = uploadDao.setFileList(fileName, id);
		close(con);
		return file;
	}
}
