package svc;

import java.sql.Connection;

import dao.MemDao;
import util.DbUtil;

public class MemBiz extends DbUtil{
	public String[] allID() {
		Connection con = getConnection();
		MemDao memDao = new MemDao(con);
		String[] allID = memDao.allID();
		close(con);
		return allID;
	}
	public String findID(int tel) {
		Connection con = getConnection();
		MemDao memDao = new MemDao(con);
		String findID = memDao.findID(tel);
		close(con);
		return findID;
	}
	public String findPW(int tel, String nickname) {
		Connection con = getConnection();
		MemDao memDao = new MemDao(con);
		String findID = memDao.findPW(tel, nickname);
		close(con);
		return findID;
	}
}
