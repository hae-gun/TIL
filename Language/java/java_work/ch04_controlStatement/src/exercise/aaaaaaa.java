package exercise;

public class aaaaaaa {
	public static void main(String[] args) {
		int i,j;
		int temp;
		int[] a = {5,2,6,3,7};
		for(i= 1; i<5;i++) {
			j = i-1;
			while((j>=0)&&(a[j]>a[j+1])) {
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
				j--;
			}
		}
		for(i=0; i<3;i++) {
			System.out.println(a[i]+" ");
		}
	}
}
