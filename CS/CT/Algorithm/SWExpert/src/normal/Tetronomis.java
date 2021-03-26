package normal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Tetronomis {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N,M;
		String[] nm = br.readLine().split(" ");
		
		N = Integer.valueOf(nm[0]);
		M = Integer.valueOf(nm[1]);
		int[][] map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String[] numbers = br.readLine().split(" ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.valueOf(numbers[j]);
			}
		}
		int max = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				for(int shape = 1;shape < 10; shape++) {
					Block block = new Block(shape,i,j);
					for(int turn=0; turn <4; turn ++) {
						int sum = 0;
						switch (turn) {
							case 0:
								break;
							case 1:
								block = block.leftRight(block);
								break;
							case 2:
								block = block.topBottom(block);
								break;
							case 3:
								block = block.leftRight(block);
								break;
						}
						List<Point> list = block.list;
						boolean chk = false;
						System.out.println();
						for(Point point : list) {
							int x = point.x;
							int y = point.y;
							if( x < 0 || x >= N || y < 0 || y >= M) {
								chk = true;
								break;
							}
							sum += map[x][y];
						}
						System.out.println();
						if(chk) {
							continue;
						}
						System.out.println(block.list + ">>" + sum);
						max = Math.max(sum, max);
					}
				}
				
			}
		}
		System.out.println(max);
	}

}


class Block{
	int shape;
	Point center;
	int x;
	int y;
	ArrayList<Point> list;
	private Block(int x, int y) {
		center = new Point(x,y);
		this.x = x;
		this.y = y;
	}
	
	public Block(int shape,int x,int y) {
		this.shape = shape;
		center = new Point(x,y);
		this.x = x;
		this.y = y;
		makePosition();
	}
	
	public void makePosition(){
		
		this.list = new ArrayList<Point>();
		
		switch (this.shape) {
		case 1: // ㅁ 
			list.add(center);
			list.add(new Point(x+1,y));
			list.add(new Point(x,y+1));
			list.add(new Point(x+1,y+1));
			break;
		case 2: // ㅗ 
			list.add(center);
			list.add(new Point(x,y+1));
			list.add(new Point(x,y+2));
			list.add(new Point(x+1,y+1));		
			break;
		case 3: // ㅏ 
			list.add(center);
			list.add(new Point(x+1,y));
			list.add(new Point(x+1,y+1));
			list.add(new Point(x+2,y));		
			break;
		case 4: // ㅡ 
			list.add(center);
			list.add(new Point(x+1,y));
			list.add(new Point(x+2,y));
			list.add(new Point(x+3,y));
			break;
		case 5: // l 
			list.add(center);
			list.add(new Point(x,y+1));
			list.add(new Point(x,y+2));
			list.add(new Point(x,y+3));
			break;
		case 6: // ㄴ 
			list.add(center);
			list.add(new Point(x+1,y));
			list.add(new Point(x+2,y));
			list.add(new Point(x+2,y+1));
			break;
		case 7: // ㄱ 
			list.add(center);
			list.add(new Point(x+1,y));
			list.add(new Point(x+2,y));
			list.add(new Point(x+2,y-1));	
			break;
		case 8: // 번개 
			list.add(center);
			list.add(new Point(x+1,y));
			list.add(new Point(x+1,y+1));
			list.add(new Point(x+2,y+1));
			break;
		case 9:// 누워있는 번개 
			list.add(center);
			list.add(new Point(x,y+1));
			list.add(new Point(x+1,y+1));
			list.add(new Point(x,y+2));
			break;
			
		default:
			break;
		}
		
	}
	public Block leftRight(Block preBlock){
		Block result= new Block(preBlock.x,preBlock.y);
		
		
		List<Point> list = preBlock.list;
		result.list = new ArrayList<Point>();
		result.list.add(preBlock.center);
		
		for(Point p : list) {
			if(!preBlock.center.equals(p)) {
					result.list.add(new Point(p.x, preBlock.center.y-(p.y)));
			}
		}
//		System.out.println(result.list);
		return result;
	}
	public Block topBottom(Block preBlock){
		Block result= new Block(preBlock.x,preBlock.y);
		
		List<Point> list = preBlock.list;
		result.list = new ArrayList<Point>();
		result.list.add(preBlock.center);
//		System.out.println(preBlock.center);
		for(Point p : list) {
			if(!preBlock.center.equals(p)) {
					result.list.add(new Point(preBlock.center.y-(p.x), p.y));
			}
		}
		
//		System.out.println(result.list);
		return result;
	}
	
}

class Point{
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Point other = (Point) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}
	
	
	
}
