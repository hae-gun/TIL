package emp;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmpService {
	EmpDao empDao;
	
	public EmpService() {
		empDao = new EmpDao();
	}
	
	public void registerEmp(Map<String, String> memberMap) {
		int empNo = Integer.parseInt(memberMap.get("empno"));
		String eName = memberMap.get("ename");
		String empId = memberMap.get("empid");
		String empPassword = memberMap.get("emppassword");
		String email = memberMap.get("email");
		int salary = Integer.parseInt(memberMap.get("salary"));

		
		EmpVo vo = new EmpVo(empNo, eName, empId, empPassword, email, salary);
		empDao.register(vo);
	}
	
	public List<EmpVo> memberList(){
		ArrayList<EmpVo> memberList = (ArrayList<EmpVo>)empDao.getAllMember();
		return memberList;
	}

	public boolean login(String id, String pw) {
		EmpVo loginUser = empDao.getUser(id,pw);
		
		if(loginUser==null) {
			return false;
		}else {
			return true;
		}
		
	}

	public List<EmpVo> getAll() {
		return empDao.getAllMember();
	}
}
