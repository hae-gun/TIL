package dbConn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 이런식으로 사용.
 ConnectionHelper.getConnection("mysql") or ("oracle") 
 dsn ==> data source name 
 */
//*

public class ConnectionHelper {
	
	public static Connection getConnection(String dsn) {
		Connection conn = null;
		
		try {
			
			if(dsn.equals("mysql")) {
				Class.forName("con.mysql.jdbc.Driver");
				conn = DriverManager.getConnection( //ojdbc6.jar 가 오라클과 db를 연결해줌
						"jdbc:mysql://localhost:3306/sampleDB",
						"kingsmile","mysql");	//사용할 DB정보
				
			}else if(dsn.contentEquals("oracle")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection( //ojdbc6.jar 가 오라클과 db를 연결해줌
						"jdbc:oracle:thin:@localhost:1521:xe",
						"kingsmile","oracle");
			}//if end
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
	} //end getConnection()
	
	public static Connection getConnection(String dsn, String user, String pwd) {
		Connection conn = null;
		
		try {
			
			if(dsn.equals("mysql")) {
				Class.forName("con.mysql.jdbc.Driver");
				conn = DriverManager.getConnection( //ojdbc6.jar 가 오라클과 db를 연결해줌
						"jdbc:mysql://localhost:3306/sampleDB",
						user,pwd);	//사용할 DB정보
				
			}else if(dsn.contentEquals("oracle")) {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection( //ojdbc6.jar 가 오라클과 db를 연결해줌
						"jdbc:oracle:thin:@localhost:1521:xe",
						user,pwd);
			}//if end
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return conn;
		}
	} //end getConnection()
	

} //end ConnectionHelper class
//*/






/*
public class ConnectionHelper {
	
	public static void main(String[] args){
	
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Drive load
			System.out.println("load success!!");
			
			
			
			Connection conn = DriverManager.getConnection( //ojdbc6.jar 가 오라클과 db를 연결해줌
					"jdbc:oracle:thin:@localhost:1521:xe",
					"kingsmile","oracle");
			System.out.println("connection success!!");
			
		}catch (ClassNotFoundException e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//			System.out.println("드라이브 로드 실패"); //사용자 메세지
		} catch(SQLException e){
			System.out.println(e.getStackTrace());
//			System.out.println(e.getMessage());
//			System.out.println("SQL 연결 실패"); 
//			e.printStackTrace();
		}
//		catch(Exception e) {
//			System.out.println("오 류");
////			e.printStackTrace();
//		}
		
		
		
	
	
	}
}*/
