package App;

import dao.DeptDAO;
import vo.DeptVO;

public class Application {

	public static void main(String[] args) {
		DeptDAO dao = new DeptDAO();
//		dao.insertDept("12","34");
		
		dao.deleteDept(50);
		
		for(DeptVO data : dao.deptList()) {
			
			System.out.printf("%2d  |   %10s |  %10s|\n",data.getDeptno(),data.getDname(),data.getLoc());
			
		}
		
		
		
		
		
		System.out.println("END");
	}

}
