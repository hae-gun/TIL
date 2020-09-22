package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/member3")
public class MemberServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request,HttpServletResponse response)  throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      MemberDAO dao=new MemberDAO();
      PrintWriter out=response.getWriter();
      String command=request.getParameter("command");
      
      //command parameter의 값이 addMember일 경우
      if(command!= null && command.equals("addMember")){
		 String _id=request.getParameter("id");
		 String _pwd=request.getParameter("pwd");
		 String _name=request.getParameter("name");
		 String _email=request.getParameter("email");
		 //폼 값을 받아서 MemberVO 객체에 저장
		 MemberVO vo=new MemberVO();
		 vo.setId(_id);
		 vo.setPwd(_pwd);
		 vo.setName(_name);
		 vo.setEmail(_email);
		 //dao 객체의 addMember 메소드 실행
	     dao.addMember(vo);
	   //command parameter의 값이 delMember일 경우
      }else if(command!= null && command.equals("delMember")) {
    	  String id = request.getParameter("id");
    	//dao 객체의 delMember 메소드 실행
    	  dao.delMember(id);
      }
      
      //insert나  delete가 끝나고 나면 다시 dao 객체의 listMembers 메소드 실행하여 회원 조회
       List list=dao.listMembers();
     out.print("<html><body>");
     out.print("<table border=1><tr align='center' bgcolor='lightgreen'>");
     out.print("<td>���̵�</td><td>��й�ȣ</td><td>�̸�</td><td>�̸���</td><td>������</td><td >����</td></tr>");
    
     for (int i=0; i<list.size();i++){
 		MemberVO memberVO=(MemberVO) list.get(i);
 		String id=memberVO.getId();
 		String pwd = memberVO.getPwd();
 		String name = memberVO.getName();
 		String email =memberVO.getEmail();
 		Date joinDate = memberVO.getJoinDate();
 		out.print("<tr><td>"+id+"</td><td>"
 			                +pwd+"</td><td>"
 			                +name+"</td><td>"
 			                +email+"</td><td>"
 			                +joinDate+"</td><td>"
 		                    +"<a href='/pro07/member3?command=delMember&id="+id+"'>삭제 </a></td></tr>");

 	 }
 	 out.print("</table></body></html>");
     out.print("<a href='/pro07/memberForm.html'>회원가입</a");
   }
}
