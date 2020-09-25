

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/uploadCos")
public class UploadCos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String upload_path = "upload_images/";
		String saveDir = request.getServletContext().getRealPath("/upload_images/");
		System.out.println("saveDir: " + saveDir);
		int maxSize = 1024*1024*100;
		String encType = "UTF-8";
		
		MultipartRequest multipartRequest
		= new MultipartRequest(request, saveDir, maxSize, encType, new DefaultFileRenamePolicy());
			
	    log("이름 : " + multipartRequest.getParameter("name") + "<br>");
	    log("파일 : " + multipartRequest.getParameter("file") + "<br>"); //null 값을 갖는다.
	    log("업로드파일명 : " + multipartRequest.getFilesystemName("file") + "<br>");
	    log("원래파일명 : " + multipartRequest.getOriginalFileName("file") + "<br>");
	    
	    File file = multipartRequest.getFile("file");
	    
	    //사진 보여주기에 사용
	    String filename = multipartRequest.getFilesystemName("file");
	    //사진 다운로드(서블릿으로 전달하기 위해)에 사용-- request에 담지 않고 session에 붙이고 getSession으로 받으니까 잘 되네... >>
		//이 페이지에서 a 태그로 다시 서버 서블릿 호출하면 request에 담아지는 것이 아닌가보네 ㅋㅋ
	    request.getSession().setAttribute("filename", filename);
	    
	    
	}

}
