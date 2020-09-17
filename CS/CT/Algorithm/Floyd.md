# Floyd-Warshall Allgorithm

* 그래프에서 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우에 사용할 수 있는 알고리즘.
* 다익스트라와 달리 현재 노드를 거쳐가는 모든 경로를 고려한다.
* DP 개념이 포함되는 경로탐색 알고리즘이다. (다익스트라는 그리디 알고리즘 이용)



## 점화식

D~ab~ = min( D~ab~, D~ak~ + D~kb~ )

* 각 노드에 대하여 해당 노드를 거처 다음 노드로 가는 숫자들을 계속 더하여 2차원 배열을 완성시켜줌.
* 2차원 배열의 의미 : D\[a\]\[b\] -> a 번 노드에서 출발하여 b 노드로 가는 최단경로
* 점화식의 의미: 직접 b 노드로 접근하거나 k노드를 거처 가는 경로 둘 중 최단경로