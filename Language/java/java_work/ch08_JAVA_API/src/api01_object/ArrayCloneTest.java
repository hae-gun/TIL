package api01_object;

public class ArrayCloneTest {

	public static void main(String[] args) {

		int[] arr1 = {1,2,3,4,5};
		int[] arr2;
		int[] arr3;
		
		arr2 = arr1.clone();// 복사본 만들어서 저장. 깊은 복제
		arr3 = arr1; // 얕은 복제. 둘은 같은값. 참조 변수만 다르고 주소는 같음
		System.out.print("복사된 arr2 배열 :");
		for(int num : arr2){
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("복사된 arr3 배열 :");
		for(int num : arr3){
			System.out.print(num + " ");
		}
		System.out.println();
		arr1[3] = 0; // arr2 요소 값 변경
		System.out.print("변경 후 arr1 배열 :");
		for(int num : arr1){
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("변경 후 arr2 배열 :");
		for(int num : arr2){
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.print("변경 후 arr3 배열 :");
		for(int num : arr3){
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("arr1:HashCode-" + arr1.hashCode());
		System.out.println("arr2:HashCode-" + arr2.hashCode());
		System.out.println("arr3:HashCode-" + arr3.hashCode());
	}
}
