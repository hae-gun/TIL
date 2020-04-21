import java.io.IOException;
import java.util.Scanner;

public class SnakeProblem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		int n, k, m;
		int snake_y[] = new int[10101];
		int snake_x[] = new int[10101];
		int[][] map = new int[101][101];
		String[] cmd = new String[10001];
		
		int dy[] = { 0, +1, 0, -1 };
		int dx[] = { +1, 0, -1, 0 };

		Scanner scan = new Scanner(System.in);

		n = scan.nextInt();
		k = scan.nextInt();


		int x = 0;
		int y = 0;

		for (int i = 0; i < k; i++) {
			y = scan.nextInt();
			x = scan.nextInt();
			map[y][x] = 1;
		}

		int time;
		String c;

		m = scan.nextInt();

		for (int i = 0; i < m; i++) {
			time = scan.nextInt();
			c = scan.next();
			cmd[time] = c;
		}

		int dir = 0;
		time = 0;

		int head_y = 1;
		int head_x = 1;
		int tail_index = time;
		
		snake_y[time] = head_y;
		snake_x[time] = head_x;
		
		map[head_y][head_x] = -1;

//		for(int i=1 ; i<=n;i++) {
//			for(int j=1 ; j<=n;j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//		for(int i=0;i<cmd.length;i++) {
//			if(cmd[i]!=null) {
//				System.out.print(i+":"+cmd[i]+" ");
//			}
//				
//		}
//		int t = 13;
		System.out.println();
		while (true) {
			++time;

			head_y += dy[dir];
			head_x += dx[dir];
//			if(time==t)
//			System.out.println("head:"+map[head_y][head_x]);
			if (head_y < 1 || head_y > n || head_x < 1 || head_x > n || map[head_y][head_x] == -1) {
				break;
			}
			snake_y[time] = head_y;
			snake_x[time] = head_x;
			if (map[head_y][head_x] == 0) {
				int tail_y = snake_y[tail_index];
				int tail_x = snake_x[tail_index];
				map[tail_y][tail_x] = 0;
				++tail_index;
			}
			
			
			map[head_y][head_x] = -1;
			
//			if(time==t) {
//				
//				for(int i=1 ; i<=n;i++) {
//					for(int j=1 ; j<=n;j++) {
//						System.out.print(map[i][j]);
//					}
//					System.out.println();
//				}}
			
			if (cmd[time] != null) {
				if (cmd[time].equals("D")) {
					dir = (dir + 1) % 4;
				} else if (cmd[time].equals("L")) {
					dir = (dir + 3) % 4;
				}
			}

		}

		System.out.println(time);

	}

}
