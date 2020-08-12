# 숫자 카드 게임

# 고른 행에서 가장 작은 수를 뽑음.

# 각 행에서 뽑은 가장 작은수중 가장 큰수는?


n , m = map(int,input().split())

result = 0

for i in range(n):
    data = list(map(int,input().split()))
    min_in_data = min(data)
# min(data) 함수를 아래처럼 구현가능
#    for a in data:
#        min_value = min(min_value,a)
    result = max(result,min_in_data)


print(result)

