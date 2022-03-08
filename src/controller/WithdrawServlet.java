package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.WithdrawBiz;

@WebServlet("/WithdrawServlet")
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public WithdrawServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String withdraw = request.getParameter("withdraw");
		System.out.println(withdraw);
		if(withdraw!=null) {
		WithdrawBiz withdrawBiz = new WithdrawBiz();
		withdrawBiz.withdraw(id, pass);
		response.sendRedirect("/box");
		} else {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out=response.getWriter();
			out.print("<script>");
			out.print("alert('탈퇴 여부에 체크 하세요.');");
			out.print("document.location.href='withdraw';");
			out.print("</script>");
		}
	}
}
