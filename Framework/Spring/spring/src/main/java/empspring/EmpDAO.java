package empspring;

public class EmpDAO {
//FORM - 사원정보 - DB 저장 메소드.
// 사원정보 조회 - HTML 브라우저 출력.
	
	EmpVO vo;

	public EmpDAO() {
		System.out.println("EmpDAO 생성자 호출.");
	}
	
	public void setVo(EmpVO vo) {
		this.vo = vo;
	}

	public void insertEmp() {
//spring 요청 - EmpVO 객체 1개 생성(김사원 10000 교육부)
		System.out.println(vo.getName() + " 사원은 "+vo.getSalary()+" 급여를 받으며 "+vo.getDeptname()+" 부서에 근무합니다.");
	}
}
