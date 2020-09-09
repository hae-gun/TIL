# 퀵 정렬 : 파이썬 장점 살려서 만들기

def quick_sort(array):

    if len(array)<=1:
        return array

    pivot = array[0] # 첫번째 자리 pivot 지정
    tail = array[1:] # pivot 을 제외한 나머지 리스트

    left_side = [x for x in tail if x <= pivot]
    right_side = [x for x in tail if x > pivot]
    print('left: ',left_side,' right: ',right_side)

    return quick_sort(left_side) + [pivot] + quick_sort(right_side)

array = list(map(int,input().split()))

quick_sort(array)


print(array)

    
