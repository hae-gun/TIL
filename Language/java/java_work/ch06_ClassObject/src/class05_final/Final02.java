package class05_final;

public class Final02 {
	// instance 변수
	int a;
	
	// static final : 상수 (constant); 수정 불가능, 선언과 동시에 초기화 or static block 에서 초기화한다
	static final double EARTH_RADIUS = 6400;
	static final double EARTH_SURFACE_AREA;
	
//	아래같이 불가능
//	Final02(){
//		EARTH_SURFACE_AREA = 1.0;
//	}
	
	static {
		//인스턴스 변수는 static에서 사용 불가능
		//a=10;
		EARTH_SURFACE_AREA = EARTH_RADIUS * EARTH_RADIUS * Math.PI * 4; 
	}
	
	public static void main(String[] args) {
		System.out.println("지구 반지름: "+EARTH_RADIUS + "km");
		System.out.println("지구 표면적: "+EARTH_SURFACE_AREA + "km^2");
	}
}

