package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.RegBiz;

@WebServlet("/reg")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public RegServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String telString = request.getParameter("tel1") + request.getParameter("tel2") + request.getParameter("tel3");
		int tel = Integer.parseInt(telString);
		String nickname = request.getParameter("nickname");
		RegBiz regBiz = new RegBiz();
		regBiz.reg(id, pass, tel, nickname);
		response.sendRedirect("/box");
	}

}
