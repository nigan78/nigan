package controller;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDown")
public class FileDown extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public FileDown() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String fileName=request.getParameter("fileName");
		String uploadFilePath = "C:\\upfolder\\";
		String filePath = uploadFilePath + fileName;
		System.out.println("LOG [업로드된 파일 경로] :: " + uploadFilePath);
		System.out.println("LOG [파일 전체 경로] :: " + filePath);
		byte[] b = new byte[4096];
		FileInputStream fileInputStream = new FileInputStream(filePath);
		String mimeType = getServletContext().getMimeType(filePath);
		if(mimeType == null) {
			mimeType = "application/octet-stream";
		}
		response.setContentType(mimeType);
		String sEncoding = new String(fileName.getBytes("UTF-8"), "8859_1");
		response.setHeader("Content-Disposition", "attachment; fileName= " + sEncoding);
		ServletOutputStream servletOutStream = response.getOutputStream();
		int read;
		while((read = fileInputStream.read(b, 0, b.length)) != -1) {
			servletOutStream.write(b, 0, read);
		}
		servletOutStream.flush();
		servletOutStream.close();
		fileInputStream.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
