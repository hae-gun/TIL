num = int(input())

print(num,'의 펙토리얼 구하기')

def factorial(num):
    if num ==1:
        return 1
    return num * factorial(num-1)


a = factorial(num)

print(a)






