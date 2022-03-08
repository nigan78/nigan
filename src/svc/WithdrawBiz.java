package svc;

import java.sql.Connection;

import dao.WithdrawDao;
import util.DbUtil;

public class WithdrawBiz extends DbUtil {
	public void withdraw(String id, String pass) {
		Connection con = getConnection();
		WithdrawDao withdrawDao = new WithdrawDao(con);
		withdrawDao.withdraw(id, pass);
		close(con);
		}
}
