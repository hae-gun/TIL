# 1
import re

def solution(new_id):
    answer = ''

    answer = new_id.lower()

    temp = re.sub('[^a-z0-9-_.]','',answer)
                   
    #print(temp)
    while '..' in temp:
        temp = temp.replace("..",".")

    #print(temp)

    
    if temp[0] == '.':
        temp = temp[1:]
    if len(temp) != 0:
        if temp[-1]=='.':
            temp = temp[:-1]
    #print(temp)
    
    if len(temp) == 0:
        temp+='a'
    #print('1',temp)
    if len(temp) >= 16:
        temp = temp[:15]
    #print('2',temp)
    if temp[-1]=='.':
        temp = temp[:-1]

    
    
    while len(temp) <3:
        temp = temp + temp[-1]
    
    #print(temp)
    
    #if answer[0] =='.':
    #    del answer[0]
   # if answer[len(answer)-1] =='.':
   #     del anser[len(answer)-1]
    
    
    
    answer = temp
    return answer

#new_id = "...!@BaT#*..y.abcdefghijklm."
#new_id = "z-+.^."
#new_id = "=.="
#new_id = "123_.def"
new_id = "abcdefghijklmn.p"
print(solution(new_id))
