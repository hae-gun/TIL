n = int(input())
vote = list()

for i in range(n):
    vote.append(int(input()))
    
m = 0
for i in range(len(vote)):
    m = max(m,vote[i])
tmp=0
while m != 0:
    vote[0] += 1
    vote[m] -= 1
    for i in range(len(vote)):
        m = max(
    
    



print(vote)
