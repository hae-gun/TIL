package user_define;


// 자바 9부터 만든객체를 try()안에 바로 사용해도됨.
public class TryWithResource {
	public static void main(String[] args) {
		
		AutoCloseObj obj = new AutoCloseObj();
		// 자바9 부터 아래와 같이 사용 가능
		try(obj){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		//자바 8버전까지는 아래와 같이 이용
		try(AutoCloseObj obj2 = new AutoCloseObj()){
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}

class AutoCloseObj implements AutoCloseable{
	@Override
	public void close() throws Exception {
		System.out.println("asdf");
	}
}
