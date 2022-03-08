package svc;

import java.sql.Connection;

import dao.RegDao;
import util.DbUtil;

public class RegBiz extends DbUtil{
	public void reg(String id, String pass, int tel, String nickname) {
		Connection con = getConnection();
		RegDao regDao = new RegDao(con);
		regDao.reg(id, pass, tel, nickname);
		close(con);
	}
}
