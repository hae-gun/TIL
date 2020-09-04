H,M = map(int,input().split())
time = int(input())

nextTime = M + time

M = nextTime%60
H = H + nextTime//60

if H >24 :
    H -=24

print(H,M)
