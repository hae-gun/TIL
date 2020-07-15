package mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class EmpDAO {
	SqlSession session;
	public void setSession(SqlSession session) {
		this.session = session;
	}
	
	// test1 : 여러개 레코드 리턴 조회.
	public List<EmpVO> getAllEmp() {
		List<EmpVO> list = session.selectList("allemp");// session.selectxxx
		return list;
	}


	// test2 : 한개 레코드 리턴 조회.
	public EmpVO getOneEmp(int id) {
		EmpVO vo = session.selectOne("oneemp", id);// session.selectxxx
		return vo;
	}
//		

	// test3 : 뒤에 parameter 추가
	public List<EmpVO> getNameEmp(String name) {
		List<EmpVO> list = session.selectList("nameemp", name);// session.selectxxx
		return list;
	}
//	

	// test4: 부등호 사용한 sql 문장 실행 (cdata 색션 실행)
	public List<EmpVO> getIdEmp() {
		List<EmpVO> list = session.selectList("idemp");// session.selectxxx
		return list;
	}
	//insert는 리턴할 값이 없다.
	public void insertEmp(EmpVO vo) {
		//<insert id="newemp" parameterType="emp"> insert...</insert>
		session.insert("newemp", vo);
	}
	public int updateEmp(EmpVO vo) {
		int row = session.update("updateemp",vo); //행 갯수가 리턴됨.
		return row;
	}
	public int deleteEmp(int id) {
		int row = session.delete("deleteemp",id);
		return row;
	}
	public List<EmpVO> pagingEmp(int[] param){
		List<EmpVO> list = session.selectList("pagingemp",param);
		return list;
	}

}
