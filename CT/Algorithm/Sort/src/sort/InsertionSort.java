package sort;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arraySet =  { 10, 5, 6, 4, 8, 2, 1, 3, 7, 9 };
		int index,temp;
		for(int i =0 ; i < 9; i++) {
			index = i;
			
			while(arraySet[index]>arraySet[index+1]) {
				temp = arraySet[index];
				arraySet[index] = arraySet[index+1];
				arraySet[index+1] = temp;
				if(index>0)
				index--;
			}
		}
		for(int i : arraySet) {
			System.out.printf("%2d ",i);
		}
	}

}
