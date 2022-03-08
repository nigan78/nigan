package svc;

import java.sql.Connection;

import dao.LoginDao;
import vo.User;
import util.DbUtil;

public class LoginBiz extends DbUtil{
	public User getUserLogin(String id, String pass) {
		Connection con = getConnection();
		LoginDao loginDao = new LoginDao(con);
		User user = loginDao.getUserLogin(id, pass);
		close(con);
		return user;
	}
}
