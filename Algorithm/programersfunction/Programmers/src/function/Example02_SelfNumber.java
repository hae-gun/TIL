package function;

public class Example02_SelfNumber {

	public static void main(String[] args) {

		int result = PlusNumber(9999);

		// PlusNumber 를 통해 결과가 나온값은 셀프숫자가 아님.
		int checkNum[] = new int[10001];

		// 숫자 배열을 통해 PlusNumber 결과가 나왔을 때 해당 수에 해당하는 인덱스의 수를 1씩 증가.
		// 숫자배열을 검색하여 배열의 값이 0인 index의 숫자는 샐프 숫자를 의미함.

		// for문을 통해 시작 숫자를 증가시키며 해당 수를 PlusNumber를 계속 진행시키며
		// 결과가 10000보다 작은수 일때까지 루프를 진행
		for (int i = 1; i <= 10000; i++) {
			int startNum = i;
			do {
				if (PlusNumber(startNum) < 10000)
					checkNum[PlusNumber(startNum)]++;
				startNum = PlusNumber(startNum);
			} while (startNum < 10000);
		}

		for (int i = 1; i < checkNum.length; i++) {
			if (checkNum[i] == 0) {
				System.out.println(i);
			}
		}

	}

	public static int PlusNumber(int Number) {
		int result = Number;
		// 자신과 각 자릿수를 더하기.
		while (Number != 0) {
			result += (Number % 10);
			Number /= 10;
		}
		return result;
	}

	// 10000보다 작거나 같은 샐프숫자 찾기.

	// 샐프 숫자 : 1~10000 까지 각각 자신과 각 자리숫자를 더하여 나온 숫자가 단 하나의 숫자로만 나오는 수.

	/*
	 * 예) 시작수 1 -> 1 + 1 = 2 2 + 2 = 4 4 + 4 = 8 8 + 8 = 16 16 + 1 + 6 = 23 ....
	 * 
	 * 1 은 2 의 생성자. 2 는 4 의 생성자. ...
	 * 
	 * 성자가 없는 수 = 셀프숫자. 예) 3은 생성자가 없다. 3 + 3 = 6 3은 6의 생성자. 6 + 6 = 12
	 * 
	 */

	// 먼저 자기 자신과 각 자리수를 더하는 로직 생성.

}
