package emp;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/login/*")
public class LoginController extends HttpServlet {

	private static String ARTICLE_IMAGE_REPO = "/Users/choehyegeun/Downloads/test";
	private EmpService empService;

	public void init() throws ServletException { // application 이올라가면 자동 생성됨. 스프링의 원리.
		empService = new EmpService();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "";
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		String action = request.getPathInfo();
		System.out.println(action);
		if (action == null) {
			url = "/views/LoginMain.jsp";

		} else if (action.equals("/register")) {
			url = "/views/register.jsp";
		} else if (action.equals("/registerUser")) {
			String result = request.getParameter("memberForm");
			Map<String, String> memberMap = upload(request, response);
			empService.registerEmp(memberMap);
			PrintWriter pw = response.getWriter();
			pw.print("<script>" + "  alert('회원등록 완료.');" + " location.href='" + request.getContextPath() + "/login';"
					+ "</script>");

			return;
		} else if (action.equals("/userLogin")) {
			boolean chk = false;
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			boolean loginStatus = empService.login(id, pw);
			System.out.println(loginStatus);
			if(request.getSession().getAttribute("login")!=null) {
				chk = (boolean) request.getSession().getAttribute("login");
			}
			if(chk) {
				loginStatus = true;
			}
			if (loginStatus) {
				url = "/views/MainPage.jsp";
				request.getSession().setAttribute("id", id);
				PrintWriter out = response.getWriter();
				out.print("<script>alert('ok');</script>");
				request.getSession().setAttribute("login", true);
			} else {
				PrintWriter print = response.getWriter();
				url = "/views/LoginMain.jsp";
			}
		}else if(action.equals("/allUser")) {
			url = "/views/userList.jsp";
			List<EmpVo> list = empService.getAll();
			request.setAttribute("list", list);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	private Map<String, String> upload(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Map<String, String> articleMap = new HashMap<String, String>();
		String encoding = "utf-8";
		File currentDirPath = new File(ARTICLE_IMAGE_REPO);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(currentDirPath);
		factory.setSizeThreshold(1024 * 1024);
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List items = upload.parseRequest(request);
			for (int i = 0; i < items.size(); i++) {
				FileItem fileItem = (FileItem) items.get(i);
				if (fileItem.isFormField()) {
					System.out.println(fileItem.getFieldName() + "=" + fileItem.getString(encoding));
					articleMap.put(fileItem.getFieldName(), fileItem.getString(encoding));
				} else {
					System.out.println("파일명:" + fileItem.getFieldName());
					System.out.println("파일크기:" + fileItem.getSize() + "bytes");
					if (fileItem.getSize() > 0) {
						int idx = fileItem.getName().lastIndexOf("\\");
						if (idx == -1) {
							idx = fileItem.getName().lastIndexOf("/");
						}

						String fileName = fileItem.getName().substring(idx + 1);
						System.out.println("파일명:" + fileName);
						articleMap.put(fileItem.getFieldName(), fileName); // �ͽ��÷η����� ���ε� ������ ��� ���� �� map��
																			// ���ϸ� ����
						File uploadFile = new File(currentDirPath + "/temp/" + fileName);
						fileItem.write(uploadFile);

					} // end if
				} // end if
			} // end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		return articleMap;
	}
}
