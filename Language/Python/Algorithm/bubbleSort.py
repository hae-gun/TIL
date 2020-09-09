# 버블정렬 : O(N^2)
def bubleSort(arr):
    for i in range(len(arr),0,-1):
        for j in range(i-1):
            if arr[j] > arr[j+1]:
                arr[j],arr[j+1] = arr[j+1],arr[j]
        print(arr)
    return arr

a = list(map(int,input().split()))
a = bubleSort(a)
print(a)
