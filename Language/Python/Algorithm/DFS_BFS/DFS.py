from collections import deque

stack=[1,2,3,4]

stack.append(123)
a = stack.pop()

queue = deque([1,2,3])

b = queue.popleft()

print(a,'',b)
