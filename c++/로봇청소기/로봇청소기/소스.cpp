#include<stdio.h>
#include<queue>
using namespace std;

struct ROBOT {
	int y, x, dir;
};

int n, m;
int map[50][50];

ROBOT robot;

const int dy[] = { -1,0,+1,0 };
const int dx[] = { 0,+1,0,-1 };

int main() {

	scanf("%d %d", &n, &m);


	scanf("%d %d %d", &robot.y, &robot.x, &robot.dir);
	for (int y = 0; y < n; ++y) {
		for (int x = 0; x < m; ++x) {
			scanf("%d", &map[y][x]);
		}
	}
	queue < ROBOT> q;
	q.push(robot);

	int ret = 0;
	while (!q.empty()) {
		ROBOT cur = q.front(); q.pop();
		if (map[cur.y][cur.x] == 0) {
			map[cur.y][cur.x] = 2;
			++ret;
		}

		for (int dir = 0; dir < 4; ++dir) {
			ROBOT next;
			next.dir = (cur.dir + 3 - dir) % 4;
			next.y = cur.y + dy[next.dir];
			next.x = cur.x + dx[next.dir];
			// 지도 밖인 부분.
			if (next.y < 0 || next.y >= n || next.x < 0 || next.x >= m || map[next.y][next.x]!=0) {
				continue;
			}
			// 한방향만 넣기 때문에 바로 break로 나감
			// break 를 하지 않으면 로봇이 여러개 생기게 된다.
			q.push(next);
			break;

		}

		if (q.empty()) {
			ROBOT next;
			next.dir = cur.dir;
			// 반대 방향으로 움직임.
			next.y = cur.y + dy[(next.dir+2)%4];
			next.x = cur.x + dx[(next.dir+2)%4];
			if (next.y < 0 || next.y >= n || next.x < 0 || next.x >= m || map[next.y][next.x] == 1) {
				break;
			}
			q.push(next);
		}



	}

	printf("%d\n", ret);

	return 0;
}