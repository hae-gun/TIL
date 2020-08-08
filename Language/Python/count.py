from bisect import bisect_left, bisect_right

def count_by_range(List, left_value, right_value):

    # left right 값을 실수로 반대로 넣었을 때 바꿔주는 로직
    if(left_value > right_value):
        temp = left_value
        left_value = right_value
        right_value = temp
    
    right_index = bisect_right(List, right_value)
    left_index = bisect_left(List, left_value)
    return right_index - left_index

a = [1,2,3,3,3,4,4,8,9]

print(count_by_range(a,2,4))
print(count_by_range(a,4,2))
