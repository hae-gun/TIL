package basic;

public class test {

	public static void main(String[] args) {
		int[][] s = { { 1, 2 }, { 3, 4 } };

		int n = s.length;
		int m = s[0].length;
		
		int[][] b = new int[n][m];
		
		for(int y=0; y<n; y++) {
			for(int x=0; x<m; x++) {
				b[y][x] = s[y][x];
				
			}
		}
		
		s[0][1] = 3;
		
		for(int[] a : b) {
			for(int c : a) {
				System.out.print(c+" ");
			}
			System.out.println();
		}
		
		
	}

}
