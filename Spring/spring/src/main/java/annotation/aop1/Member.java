package annotation.aop1;

import org.springframework.stereotype.Component;

@Component
public class Member {
	public void login(String id) {
		System.out.println(id + " 회원님이 로그인 하셨습니다.");
	}

	public void logout() {
		System.out.println("회원님이 로그아웃 하셨습니다.");
	}
}
