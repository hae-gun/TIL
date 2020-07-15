package mybatis;

//브라우저 내부 여러 서블릿/jsp 객체 공유 : session(HttpSession타입)
//spring mvc : session 같은 방법으로 사용.

//mybatis : SqlSession타입. 웹과는 다른 session(jdbc Connection과 같음) (session은 기본 연결이라는 의미로 갖는다.)

import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class EmpMain {

	public static void main(String[] args) throws Exception {

		// 1.
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		// 2. SqlSessionFactory = 연결 설정파일 읽어라.
		// sql 매핑 파일명.
		SqlSessionFactory factory = builder.build(Resources.getResourceAsReader("mybatis/mybatis-config.xml"));
		// 3. SqlSession = jdbc Connection 유사 SqlSession = 연결 생성.
		SqlSession session = factory.openSession(true);
		// mybatis는 자동으로 트랜잭션 처리 안함.(commit 안해줌.)
		System.out.println(session.getConnection().getAutoCommit());// null이면 문제있음.
/////////////////여기까지는 메인 역할.
		EmpDAO dao = new EmpDAO();
		dao.setSession(session);

		// test1
//		List<EmpVO> list = dao.getAllEmp();
//		for (EmpVO vo : list) {
//			System.out.println(vo.getEmployee_id() + " : " + vo.getFirst_name());
//		}
//		// test2
//		EmpVO vo = dao.getOneEmp(200);
//		System.out.println(vo.getEmployee_id()+" : "+vo.getFirst_name());
//		// test3
//		List<EmpVO> list = dao.getNameEmp("Steven");
//		for(EmpVO data:list) {
//			System.out.println(data.getEmployee_id() + " : " + data.getFirst_name());
//		}
		//test4
//		List<EmpVO> list = dao.getIdEmp();
//		for (EmpVO data : list) {
//			System.out.println(data.getEmployee_id() + " : " + data.getFirst_name() + "---" + data.getHire_date());
//		}
		//test5 : 새로운 사원 등록. : insert sql 문장 수행.
		// 1000, 홍, gil@multi.com, sysdate, 'IT_PROG' 
		// insert into employees(employee_id,last_name,email,hire_date,job_id) values(1000,'홍','email',sysdate,'IT_PROG') 
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(1002); // 중복 불가능
//		vo.setFirst_name("길동");
//		vo.setLast_name("홍");
//		vo.setEmail("gil2@multi.com"); // 중복 불가능
//		vo.setJob_id("IT_PROG");//SQL 키워드는 대소문자구분X(값은 대소문자 구분.)
		
		//DML구문 insert/delete/update/
//		dao.insertEmp(vo);//insert문 수행
//		System.out.println("신규사원등록");
		//test6 : 1001 사번 이름 석천, 이메일변경 hong@multi.com
		//<update id="updateemp" parameterType="emp">
		//update employees set first_name = #{}, email = #{} where employee_id = #{}
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(1001);
//		vo.setFirst_name("석천");
//		vo.setEmail("hong@multi.com");
//		int row = dao.updateEmp(vo);
//		System.out.println(row + "개의 레코드 수정완료");
		//test7: 삭제 1001번 사원 삭제.
		// delete employees where first_name like '홍%'
//		int id = 1001;
//		int row = dao.deleteEmp(id);
//		System.out.println(row+"개 행 삭제");
		
		//test8 페이지당 10개 출력.
		int pagenum = 2;
		int cnt = 10;
		int param[] = new int[2];
		param[0] = (pagenum-1)*cnt+1;
		param[1] = pagenum*cnt;
		List<EmpVO> list = dao.pagingEmp(param);
		for(EmpVO vo : list) {
			System.out.println(vo.getFirst_name()+" : "+vo.getHire_date());
		}
	}

}
