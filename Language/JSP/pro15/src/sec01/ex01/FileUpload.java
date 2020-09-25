package sec01.ex01;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUpload
 */
@WebServlet("/upload.do")
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// form 에서 multi-part 로 오면 getParameter 로 뽑아낼 수 없다.
		System.out.println(request.getParameter("param1")); // null
		String encoding = "utf-8";
		// File 객체는 경로를 지정해 주는 객체.
		File currentDirPath = new File("/Users/choehyegeun/Downloads/test");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 저장 경로를 factory 객체에 set.
		factory.setRepository(currentDirPath);
		// 메모리 사이즈 제한. 1mb. 
		factory.setSizeThreshold(1024 * 1024);

		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);

				if (fileItem.isFormField()) {
					
//					System.out.println("input name>>>>"+fileItem.getFieldName());
//					System.out.println("input values>>>>"+fileItem.getString(encoding));
					System.out.println(fileItem.getFieldName()+"-"+fileItem.getString(encoding));
					
				} else { // binary data 인 경우
					System.out.println("Field Name :" + fileItem.getFieldName());
					System.out.println("Name :" + fileItem.getName());
					System.out.println("Size :" + fileItem.getSize() + "bytes");

					if (fileItem.getSize() > 0) { // 빈 파일이 아닐 때.
						// window 인 경우
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {// "\\" 가 없음. linux
							// unix 인 경우
							idx = fileItem.getName().lastIndexOf("/");
						}
						System.out.println("idx>>>>>"+idx);
						// 추출한 idx 로 파일 이름만 잘라냄.
						String fileName = fileItem.getName().substring(idx + 1);
						// in Mac
						// 저장 경로에 추출한 파일 이름 붙이기. 최정적으로 저장경로 파일객체 생성.
						File uploadFile = new File(currentDirPath + "/" + fileName);
						// in Window
						// File uploadFile = new File(currentDirPath + "\\" + fileName);
						// 생성한 파일 저장.
						fileItem.write(uploadFile);
						System.out.println("Done");
					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
