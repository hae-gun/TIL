# 큰수의 법칙 다르게 풀어보기

# 반복되는 수열 큰수 * k , 그다음큰수 * 1

# 반복되는 수열의 길이 = k+1

# 반복되는 수열의 갯수 = m / (k + 1)

# m이 k+1로 나누어 떨어지지 않을 때 큰수가 나머지 숫자만큼 반복됨.
# 즉 큰수가 나오는 횟수는 아래와 같음
# ( m/(k+1) ) * k + m %(k+1) 개.
# 두번주 수의 반복 횟수는 반복된 수열의 갯수만큼. 즉 m / (k+1)

# 따라서 결과는 다음과 같은 식으로 정의됨.

# 큰수 * ( (m/(k+1)) * k + m % (k+1)) + 두번째 큰수 * (m / (k +1) )

n,m,k = map(int,input().split())

array = list(map(int,input().split()))

array.sort()

first = array[n-1]
second = array[n-2]

# 반복되는 수열 갯수 : count
count = m / (k+1)

# 나머지
res = m % (k+1)

firstCount = count*k + res
# result = (int)(first * ( (m/(k+1)) * k + m%(k+1)) + second * (m / (k+1)))

result = (int)(first * firstCount + second * count)
print(result)
