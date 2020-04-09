package mathAlgorithm;

import java.util.Stack;

public class Combination {

	public static void main(String[] args) {
		String[] s = {"a","b","c"};
		
		MyCombination cm = new MyCombination(s);
		cm.doCombination(s.length, 2, 0);
		
	}
	

}

class MyCombination{
	private String[] arr; // 기준 배열.
	private Stack<String> st; // 조합을 저장할 스택.
	
		
	

	public MyCombination(String[] arr) {
		this.arr = arr;				// 배열을 받아 객체에 주입.
		st = new Stack<String>();	// 스택에 메모리를 할당한다.
	}
	
	// stack 을 출력하기 위한 매서드
	public void showStack() {
		for(int i = 0 ; i < st.size() ; i++) {
			System.out.println(st.get(i)+" ");
		}
		System.out.println(""); // 개행
	}
	
	public void doCombination(int n, int r, int index) {
		// n : 전체 원소의 개수.
		// r : 뽑을 원소의 개수.
		// index : 배열을 다루기 위한 숫자.
		if(r==0) // 더이상 뽑을 것이 없다는 의미이다. 스택을 출력시킨다.
		{
			showStack();
			return;
		}else if(n==r) { // nCn : n개중 n 개를 뽑는의미는 모든것을 다 뽑는다는 의미이다.
			for(int i = 0 ; i <n ; i++) {
				st.add(arr[index+i]); // stack을 채워넣음
			}
			for(int i = 0 ; i<n; i++) {
				st.pop(); // stack 을 비워줌.
			}
		}else {
			// 위에 두 경우에 걸리지 않는경우 점화식대로 진행한다.
			
			// index 를 포함하는 경우.
			st.add(arr[index]);
			// index를 stack에 넣은상태로 다음 점화식 진행
			doCombination(n-1, r-1, index+1); 
			
			//index를 포함하지 않는 경우
			st.pop(); // index 경우를 지운 상태에서
			doCombination(n-1,r,index+1);
			
			
		}
		
		
		
	}
}
