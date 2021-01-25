package hello.hellospring;
// (기본적으론) 해당 하위 패키지에서만 컴포넌트 스캔이 진행된다. 설정가능.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HelloSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringApplication.class, args);
	}

}
