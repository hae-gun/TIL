# 퀵 정렬 : O(NlogN)
def quick_sort(array,start,end):

    if start >= end: # 원소가 1개인 경우
        return
    pivot = start
    left = start + 1
    right = end
    print('start: ',start,', end: ',end)
    while left <= right:

        # 피벗보다 큰 데이터를 찾을 때까지 반복
        while left <= end and array[left] <= array[pivot]:
            left += 1

        # 피버소다 작은 데이터를 찾을 때까지 반복        
        while right > start and array[right] >=array[pivot]:
                right -= 1

        if left > right: # 두 포인터가 엇갈린경우 right위치 값과 피벗을 교환
            array[pivot],array[right] = array[right],array[pivot]
            print(array)
        else: # 엇갈리지 않은경우 두 수를 교체
            array[left],array[right] = array[right],array[left]
            print(array)
    # 분할 이후 왼쪽 부분과 오른쪽 부분에서 각자 정렬 수행
    quick_sort(array,start,right-1)
    quick_sort(array,right+1,end)

array = list(map(int,input().split()))

quick_sort(array,0,len(array)-1)
print(array)
            
        
        

            
    
