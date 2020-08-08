# 파이썬 유용한 라이브러리

## itertools

### permutations

* 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우(순열) 를 계산해 준다.

* permutations는 클래스이므로 객체 초기화 이후에는 리스트 자료형으로 변환하여 사용한다.

* 문법 : `permutations (iterable객체, 뽑을 갯수)`

  ```python
  from itertools import permutations
  
  data = ['A','B','C']
  
  # 3개중 3개를 일렬로 나열하는 모든 경우의 수
  result = list(permutations(data,3)) 
  
  print(result)
  
  # 3개중 2개를 일렬로 나열하는 모든 경우의 수
  result = list(permutations(data,2))
  
  print(result)
  
  ```

  ![image-20200808155754807](무제.assets/image-20200808155754807.png)



### combinations

* 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우 (조합)를 계산한다.

* permutations 와 마찬가지로 list에 넣어 서 사용한다.

* 문법 : `combinations(iterable객체, 뽑을 갯수)`

  ```python
  from itertools import combinations
  
  data = ['A','B','C']
  result = list(combinations(data,2))
  
  print(result)
  ```

  ![image-20200808163104253](무제.assets/image-20200808163104253.png)

### product

* permutations 와 같이 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 일렬로 나열하는 모든 경우 (순열)를 계산한다.

* 다만 원소를 중복하여 추출함.

* product객체 사용시 `repeat` 속성으로 뽑고자 하는 갯수를 설정한다.

* 문법 : `product(iterable객체, repeat=뽑을 갯수)`

  ```python
  from itertools import product
  
  data = ['A','B','C']
  result = list(product(data,repeat=2))
  
  print(result)
  ```

  ![image-20200808164223418](무제.assets/image-20200808164223418.png)

### combinations_with_replacement

* combinations 와 같이 리스트와 같은 iterable 객체에서 r개의 데이터를 뽑아 순서를 고려하지 않고 나열하는 모든 경우(조합) 을 계산한다.

* 다만 product와 같이 원소를 중복하여 추출한다

* 문법 : `combinations_with_replacement(data,2)`

  ```python
  from itertools import combinations_with_replacement
  
  data = ['A','B','C']
  result = list(combinations_with_replacement(data,2))
  
  print(result)
  ```

  ![image-20200808164726928](무제.assets/image-20200808164726928.png)

