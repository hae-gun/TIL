# 팰린드롬
s = input()


stack = []

stack.append(s)
count =0
while len(stack) !=0:
    tmps = stack.pop()
    #print(tmps)
    for i in range(len(tmps)-1,-1,-1):
        tmp = tmps[:i+1]
        if tmp == tmp[::-1]:
            stack.append(tmps[i+1:])
            count+=1
            break

print(count)


