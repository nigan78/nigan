package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import svc.FileBiz;
import svc.UploadBiz;
import vo.User;

@WebServlet("/fileUpload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 600, maxFileSize = 1024 * 1024 * 100, 
maxRequestSize = 1024 * 1024 * 400)
public class FileUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR="upfolder";

    public FileUp() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String applicationPath1 = request.getServletContext().getRealPath("/");
		System.out.println("1"+applicationPath1);
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		
		String applicationPath = "C:\\";
		String uploadFilePath = applicationPath + UPLOAD_DIR;
		System.out.println("LOG :: [서버 루트 경로] :: " + applicationPath);
		System.out.println("LOG :: [파일 저장 경로] :: " + uploadFilePath);
		File fileSaveDir = new File(uploadFilePath);
		if(!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}
	String fileName = null;
	for(Part part : request.getParts()) {
		getPartConfig(part);
		if(part.getSize()!=0) {
		fileName = "(id="+ user.getId() + ")" + getFileName(part);
		
		System.out.println("LOG :: [업로드 파일 경로] :: " + uploadFilePath + File.separator + fileName);
		part.write(uploadFilePath + File.separator + fileName);
		} 
	}
	UploadBiz uploadBiz = new UploadBiz();
	String file = uploadBiz.insert(fileName, user.getId());
	System.out.println(file);
	FileBiz fileBiz = new FileBiz();
	String[] list = fileBiz.getFileList(user.getId());
	for(int i = 0; i < list.length; i++){ 
		session.setAttribute("file"+i, list[i]);
		}
	request.setAttribute("fileName", fileName);
	getServletContext().getRequestDispatcher("/download.jsp").forward(request, response);
	}
	
	private void getPartConfig(Part part) {
		System.out.println("-----------------------------------------");
		System.out.println("LOG :: [HTML의 form 이름] :: " + part.getName());
		System.out.println("LOG :: [ 파일 사이즈 ] :: " + part.getSize());
		for(String name : part.getHeaderNames()) {
			System.out.println("LOG :: HeaderName :: " + name + ", HeaderValue :: " + part.getHeader(name) + "\n");
		}
		System.out.println("-----------------------------------------");
	}
	
	private String getFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		System.out.println("LOG :: content-disposition 헤더 :: = " + contentDisp);
		String[] tokens = contentDisp.split(";");
		for(String token : tokens) {
			if(token.trim().startsWith("filename")) {
				System.out.println("LOG :: 파일 이름 :: " + token);
				return token.substring(token.indexOf("=") + 2, token.length() - 1);
			}
		}
		return "";
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
