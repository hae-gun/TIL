# Combination

* java로 조합(Combination) 구현하기.



* 조합의 점화식

  ![image-20200409162703694](C:%5CUsers%5Cstudent%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200409162703694.png)

  * n 개중 r 개를 뽑는 경우의 수는 다음과 같다.

    1. 어떤 특정한 원소를 포함하고 뽑았을 때.

       * 1개가 뽑혔으니 이제 나머지  n-1 개중 r-1개를 뽑으면 되는 경우이다. 

         ![image-20200409163425353](C:%5CUsers%5Cstudent%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200409163425353.png)

         

    2. 어떤 특정한 원소를 포함하지 않고 뽑았을 때.

       * 특정 원소를 포함하지 않으니 n-1 개중 r개를 뽑으면 되는 경우이다.

         ![image-20200409163457299](C:%5CUsers%5Cstudent%5CAppData%5CRoaming%5CTypora%5Ctypora-user-images%5Cimage-20200409163457299.png)

* 해당 알고리즘을 `Stack` 과 `재귀함수` 를 이용하여 구현한다.



