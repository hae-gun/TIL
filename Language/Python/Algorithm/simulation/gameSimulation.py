#Game Simulation

n,m = map(int,input().split())

d = [[0]*m for _ in range(n)] # n * m 배열 만들기

x, y, direction = map(int, input().split())
d[x][y] = 1;

array = []
for i in range(n):
    array.append(list(map(int, input().split())))

# 회전방향 북 동 남 서 90도 회전
dx = [-1,0,1,0]
dy = [0,1,0,-1]

# 회전 함수 정의
def turn_left():
    global direction
    direction -=1
    if direction ==-1:
        direction =3


# 시뮬레이션 시작
count =1
turn_time = 0
while True:
    turn_left()
    nx = x + dx[direction]
    ny = y + dy[direction]
    if nx < 0 and nx > n and ny < 0 and ny > m:
        continue
    
    if d[nx][ny] ==0 and array[nx][ny] ==0:
        d[nx][ny]=1
        x=nx
        y=ny
        count +=1
        turn_time =0
    else:
        turn_time +=1
    # 4방향 모두 본 경우
    if turn_time ==4:
        nx = x-dx[direction]
        ny = y-dy[direction]

        if array[nx][ny] == 0:
            x=nx
            y=ny
        else:
            break
        turn_time=0

print(count)
    



