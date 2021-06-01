n = int(input())

allSub = list()



pointSet = {'A+':4.3,'A0':4.0,'A-':3.7,
            'B+':3.3,'B0':3.0,'B-':2.7,
            'C+':2.3,'C0':2.0,'C-':1.7,
            'D+':1.3,'D0':1.0,'D-':0.7,
            'F':0.0}
#print(pointSet)
 



for _ in range(n):
    sub=dict()
    point = list(map(str,input().split(' ')))
    sub['sub']=point[0]
    sub['lv']=point[1]
    sub['point']=point[2]
    allSub.append(sub)

avgSum = 0
totalLv = 0
for p in allSub:
    avgSum += (int(p['lv']) * pointSet[p['point']])
    totalLv += int(p['lv'])

print(avgSum)
print(totalLv)
print(round(avgSum/totalLv,2))
