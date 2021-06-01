tmp = list()
while True:
    try:
        tmp.append(str(input()))
    except EOFError:
        break

    
#print(tmp)
result = [0 for _ in range(len(tmp[-1]))]


for code in tmp:
    for i in range(len(tmp[-1])):
        result[i] += int(code[i])
        result[i] %= 10

ans = ''    
for n in result:
   ans += str(n)
print(int(ans))
