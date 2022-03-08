package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemBiz;

@WebServlet("/FindPWServlet")
public class FindPWServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindPWServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String telString = request.getParameter("tel1")+request.getParameter("tel2")+request.getParameter("tel3");
		String nickname = request.getParameter("nickname");
		int tel = Integer.parseInt(telString);
		MemBiz memBiz = new MemBiz();
		String pw = memBiz.findPW(tel, nickname);
		System.out.println(pw);
		response.setContentType("text/html; charset=utf-8;");
		showPW(request, response, pw);
	}
	public void showPW(HttpServletRequest request, HttpServletResponse response, String pw) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<script>");
		out.print("alert('당신의 비번 : ' + ");
		out.print("'" + pw + "'" + ");");
		out.print("document.location.href='home';");
		out.print("</script>");
	}
}
