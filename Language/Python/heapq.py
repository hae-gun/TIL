# heapq


import heapq

def heapsort(iterable):
    h = []
    result = []

    # 모든 원소를 차례대로 힙에 삽입
    for value in iterable:
        heapq.heappush(h,value)

    # 힙에 삽입된 모든 원소를 차례대로 꺼내어 담기
    for i in range(len(h)):
        result.append(heapq.heappop(h))

    return result


# 최대 힙 구현시에는 원소의 부호를 바꾸어 넣은후 꺼낼때 다시 바꾼다.

def maxHeapsort(iterable):
    h=[]
    result=[]

    for value in iterable:
        heapq.heappush(h,-value)

    for i in range(len(h)):
        result.append(-heapq.heappop(h))

    return result


myList = [1,3,5,7,9,2,4,6,8,0]

result = heapsort(myList)
print(result)

result = maxHeapsort(myList)
print(result)
