package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.FileBiz;
import svc.LoginBiz;
import vo.User;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		LoginBiz loginBiz = new LoginBiz();
		User user = loginBiz.getUserLogin(id, pass);
		FileBiz fileBiz = new FileBiz();
		String[] file = fileBiz.getFileList(id);
		if(user != null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			for(int i = 0; i < file.length; i++){ 
			session.setAttribute("file"+i, file[i]);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("download.jsp");
			dispatcher.forward(request, response);
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>");
			out.print("alert('로그인 실패');");
			out.print("document.location.href='home';");
			out.print("</script>");
		}
	}

}
