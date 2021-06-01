n = int(input())

xpoints = list()
ypoints = list()
for _ in range(n):
    tmp = list(map(int,input().split(' ')))
    xpoints.append(int(tmp[0]))
    ypoints.append(int(tmp[1]))


xpoints.sort()
ypoints.sort()
#print(xpoints)
#print(ypoints)

print(2 * (xpoints[-1]-xpoints[0] + ypoints[-1]-ypoints[0]))
