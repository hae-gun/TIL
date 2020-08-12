# N, M, K
n,m,k = map(int,input().split())

# List values
data = list(map(int,input().split()))

data.sort()
first = data[n-1] # 가장큰수
second = data[n-2] # 두번째 큰수

result = 0


while True:
    for i in range(k):
        if m == 0:
            break
        result += first
        m -= 1
    if m == 0:
        break
    result += second
    m -= 1


print(result)
