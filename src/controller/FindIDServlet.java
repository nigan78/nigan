package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.MemBiz;

@WebServlet("/FindIDServlet")
public class FindIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FindIDServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String telString = request.getParameter("tel1")+request.getParameter("tel2")+request.getParameter("tel3");
		int tel = Integer.parseInt(telString);
		MemBiz memBiz = new MemBiz();
		String id = memBiz.findID(tel);
		System.out.println(id);
		response.setContentType("text/html; charset=utf-8;");
		showID(request, response, id);
	}
	public void showID(HttpServletRequest request, HttpServletResponse response, String id) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.print("<script>");
		out.print("alert('당신의 id : ' + ");
		out.print("'" + id + "'" + ");");
		out.print("document.location.href='home';");
		out.print("</script>");
	}
}
