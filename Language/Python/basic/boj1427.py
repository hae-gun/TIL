# bubble sort

a = str(input())
b = list(a)
for i in range(0,len(b)):
    for j in range(0,len(b)-i-1):
        if int(b[j]) < int(b[j+1]):
            b[j],b[j+1] = b[j+1],b[j]

print(''.join(b))
    
