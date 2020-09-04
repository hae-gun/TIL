point = [[0]*4 for _ in range(4)]

count = int(input())

for i in range(count):
    temp = list(map(int,input().split()))
    point[1][temp[0]] +=1
    point[2][temp[1]] +=1
    point[3][temp[2]] +=1

#print(point)

tempMax = -1
maxCount =0 # 최댓값인 것 갯수
check = 0 # 동점자 체크
numb = -1 # 최댓값가진 후보 번호

for i in range(1,4):
    sumTemp = point[i][1] + point[i][2]*2 + point[i][3]*3

    if sumTemp > tempMax:
        tempMax = sumTemp
        maxCount += 1
        numb = i
    elif sumTemp == tempMax:
        if point[numb][3] < point[i][3]:
            numb = i
            check =0
        elif point[numb][3] == point[i][3] and point[numb][2] < point[i][2]:
            numb=i
            check=0
        elif point[numb][3] == point[i][3] and point[numb][2] == point[i][2]:
            check = 1

if check==1:
    numb=0

print(numb,tempMax)
