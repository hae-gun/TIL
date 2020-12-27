package coupang;

public class Ocean {
	public static void main(String[] args) {
		
	int[] dx = {1,0,-1,0};
	int[] dy = {0,1,0,-1};
	
	boolean[][] visit = new boolean[5][4];
	
	int[][] ocean = { 
			{1,1,1,0,0},
			{0,0,1,0,0},
			{0,0,1,0,0},
			{0,0,0,0,0},
			{1,1,0,0,1}
			};
		
		for(int i=0; i<ocean.length; i++) {
			for(int j=0; j<ocean[i].length; j++) {
				
				if(ocean[i][j] == 1 && !visit[i][j]) {
					
				}
				
				
			}
			
			
			
		}
	
	
		
	}
}
