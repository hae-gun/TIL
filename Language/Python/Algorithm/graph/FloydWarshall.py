#Floyd-warshall

INF = int(1e9)

# n: node
n = int(input())

# m: 경로의 갯수 
m = int(input())

graph = [[INF] * (n+1) for _ in range(n+1)]

# 자기자신에게 가는 경로는 0
for a in range(1,n+1):
    for b in range(1,n+1):
        if a==b:
            graph[a][b] = 0

# 간선정보 입력받기
for _ in range(m):
    a,b,c = map(int,input().split())
    graph[a][b] = c


# Floyd-warshall 수행
for k in range(1,n+1):
    for a in range(1,n+1):
        for b in range(1,n+1):
            graph[a][b] = min(graph[a][b],graph[a][k]+graph[k][b])


for a in range(1,n+1):
    for b in range(1,n+1):
        if graph[a][b] == INF:
            print("INFINITY",end=" ")
        else:
            print(graph[a][b],end=" ")
    print()
