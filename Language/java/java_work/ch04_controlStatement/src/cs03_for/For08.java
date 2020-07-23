package cs03_for;


public class For08 {
	public static void main(String[] args) {
		char ast = '*';
		/*
	     * 
	    ** 
	   *** 
	  **** 
	 ***** 
	 	*/
		for(int i=0; i<5; i++) {
			
			for(int j=0; j<4-i; j++) {
				System.out.print(" ");
			}
			for(int j=0; j<i+1; j++) {
				System.out.print(ast);
			}
			System.out.println();
		}
		/*
		 *
		***
	   *****
	  *******
	 *********
		*/
		for(int i=0; i<5; i++) {
			
			for(int j=4; j>i; j--) {
				System.out.print(" ");
			}
			
			for(int j=0; j<2*i+1; j++) {
				System.out.print(ast);
			}
			System.out.println();
		}
		
	}
}
