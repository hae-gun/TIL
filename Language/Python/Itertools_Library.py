# itertools

# 1. permutations

from itertools import permutations


data =['A','B','C']

result_permutations = list(permutations(data,3))

print('permutations: ',result_permutations)

from itertools import combinations


result_combinations = list(combinations(data,2))

print('\ncombinations: ',result_combinations)

from itertools import product


result_product = list(product(data,repeat=2))

print("\nproduct: ",result_product)



from itertools import combinations_with_replacement

result_cwr = list(combinations_with_replacement(data,2))

print('\ncwr: ',result_cwr)
