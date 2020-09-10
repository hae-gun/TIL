#10227
import itertools

r,c,h,w = map(int,input().split())

quality_map = [[0] * r for _ in range(c)]

max_middle_quality =10000


for j in range(c):
    quality_map[j] = list(map(int,input().split()))



for x in range(h):
    
    
    for j in range(w):
        ran = []
        for y in range(w):
            line = quality_map[y+j]
            ran.append(line[x:x+h])
        tmp = list(itertools.chain(*ran))
        tmp.sort()
        middle = tmp[h*w//2]
        #print('tmp-',tmp)
        #print('middle: ',middle)
        max_middle_quality = min(max_middle_quality,middle)
        #print(ran)


print(max_middle_quality)

        

    
