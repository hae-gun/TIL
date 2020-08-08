from bisect import bisect_left,bisect_right

a = [1,2,4,4,6]

x = 4

print('list: ',a)

print('4 left index: ',bisect_left(a,x))

print('4 right index: ',bisect_right(a,x))

