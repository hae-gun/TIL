package array;

public class Arr02 {
	public static void main(String[] args) {
		// 배열 생성 및 초기화
		int[] arr1 = new int[3];
		// 배열에 값 입력
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		// 배열에서 값 추출하여 출력
		System.out.println(arr1[0]);
		System.out.println(arr1[1]);
		System.out.println(arr1[2]);
		System.out.println("------------------");
		// 배열 생성 및 초기화, 값 입력
		int[] arr2 = { 10, 20, 30 };
		System.out.println(arr2[0]);
		System.out.println(arr2[1]);
		System.out.println(arr2[2]);
		System.out.println("------------------");
		// 10칸짜리 정수 배열 선언, 생성
		int[] arr3 = new int[10];
		// 배열의 길이(칸수): 배열이름.length로 확인 - last index + 1
		System.out.println(arr3.length);
		System.out.println("------------------");
		// arr3[0]=100; arr3[1]=200;
		// 배열에 for문으로 규칙적으로 반복되는 값 입력
		for (int i = 0; i < arr3.length; i++) {
			arr3[i] = (i + 1) * 100;
		}
		// 배열 값 출력하기
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("arr3[" + i + "] = " + arr3[i]);
		}
		System.out.println("------------------");
		// char 배열 26칸을 만들고 alphabet(A: 65)을 넣으시오.
		// 배열을 출력하시오
		char[] alphabet = new char[26];
		for (int i = 0; i < alphabet.length; i++) {
			alphabet[i] = (char) (i + 65);
			System.out.println("alphabet[" + i + "] = " + alphabet[i]);
		}
		
		for(char k : alphabet) {
			System.out.print(k + ",");
		}

	}
}
