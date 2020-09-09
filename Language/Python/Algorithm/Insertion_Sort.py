# 삽입정렬 : O(N^2)
def insertionSort(arr):
    for i in range(1,len(arr)):
        for j in range(i,0,-1):
            if arr[j] < arr[j-1]:
                arr[j],arr[j-1] = arr[j-1],arr[j]
            else:
                break
        print(arr)
    return arr

arr = list(map(int,input().split()))

arr = insertionSort(arr)
print(arr)

