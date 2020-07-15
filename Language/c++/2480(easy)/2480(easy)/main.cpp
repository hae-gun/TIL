#include<stdio.h>

int n,ret;

struct Board {
	int map[20][20];

	// 배열 회전 함수.
	void rotate() {
		int temp[20][20];
		// 해당 배열을 90도 회전
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				temp[y][x] = map[n - x - 1][y];
			}
		}
		// 회전한 배열을 다시 저장.
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				map[y][x] = temp[y][x];
			}
		}
	}

	// 해당 배열에서 가장 큰수를 가져오는 함수.
	int get_max() {
		// 결과값 초기화.
		int ret = 0;
		// 완전탐색.
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				// 탐색한 값이 ret값 보다 크면 
				if (ret < map[y][x]) {
					// 탐색값을 ret에 저장.
					ret = map[y][x];
				}
			}
		}
		return ret;
	}

	// 숫자를 올려 같은값이 있으면 2배해줌.
	void up() {
		int temp[20][20];

		for (int x = 0; x < n; ++x) {
			// flag 인자를 통해 합친적이 있으면 flag를 1로 변경
			int flag = 0, target = -1;
			for (int y = 0; y < n; ++y) {
				if (map[y][x] == 0) {
					continue;
				}// 
				if (flag == 1 && map[y][x] == temp[target][x]) {
					temp[target][x] *= 2, flag = 0;
				}// temp 배열에 현재위치의 값을 저장하고 flag를 1로만듬-> 바꿀게 없다.
				else {
					temp[++target][x] = map[y][x], flag = 1;
				}
			}// 위에 for문이 끝나면 target은 모두 다 끌어 올린후 마지막 칸의 index를 가르킴.
			// 아래의 for문은 target index 뒤 숫자자리의 칸을 모두 0으로 만들어줌.
			for (++target; target < n; ++target) {
				temp[target][x] = 0;
			}
		}
		// up 을 진행한 temp 배열을 Board클래스의 map에 저장시킴.
		for (int y = 0; y < n; ++y) {
			for (int x = 0; x < n; ++x) {
				map[y][x] = temp[y][x];
			}
		}
		
	}

};


void dfs(Board cur, int count) {
	if (count == 5) {
		int candi = cur.get_max();
		if (ret < candi) {
			ret = candi;
		}
		return;
	}

	for (int dir = 0; dir < 4; ++dir) {
		Board next = cur;
		next.up();
		dfs(next, count + 1);
		cur.rotate();
	}
}


int main() {

	Board board;
	scanf("%d", &n);

	for (int y = 0; y < n; ++y) {
		for (int x = 0; x < n; ++x) {
			scanf("%d", &board.map[y][x]);
		}
	}
	ret = 0;
	dfs(board,0);
	printf("%d\n", ret);

	return 0;
}