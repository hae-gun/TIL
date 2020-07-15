package myFunc;
import java.util.Arrays;
public class Combination {

	
	public static void main(String[] args) {
		int[] arr = {1,2,3};
		int n = arr.length;
		int r = 2;
		int[] combArr = new int[n];
//		doCombination(combArr,n,r,0,0,arr);
		
		for(int i=0; i<3 ;i++) {
			
		} 
		
	}
	
	public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr) {
		if(r==0) {
			System.out.println(Arrays.toString(combArr));
			for(int i=0; i<index; i++) {
				System.out.print(arr[combArr[i]]+" ");
			}
			System.out.println();
		}else if(target == n) {
			return;
		}else {
			combArr[index] = target;
			doCombination(combArr,n,r-1,index+1,target+1,arr);
			doCombination(combArr, n, r, index, target+1, arr);
		}
	}

	
	
}


