# find component

N = int(input())
store = list(map(int,input().split()))


M = int(input())
customer = list(map(int,input().split()))



def binary_search(array,target,start,end):
    if start > end:
        return None
    mid = (start+end) //2
    if array[mid] == target:
        return mid
    elif array[mid] > target:
        return binary_search(array,target,start,mid-1)
    else:
        return binary_search(array,target,mid+1,end)
    

store.sort()
customer.sort()



for num in customer:
    if binary_search(store,num,0,len(store)-1) is None:
        print('no')
    else:
        print('yes')







