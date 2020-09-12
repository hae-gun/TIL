# 2


def solution(orders, course):
    answer = []

    
    alphabet = dict()

    for i in orders:
        for word in i:
            if word in alphabet:
                alphabet[word] += 1
            else:
                alphabet[word] = 1
    


    print(alphabet)
    

    return answer
    
    



orders = ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]
course = [2,3,4]


solution(orders, course)
