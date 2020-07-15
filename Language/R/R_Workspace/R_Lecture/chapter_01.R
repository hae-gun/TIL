# R의 주석은 #을 이용하세요!!
# 여러줄 주석 설정은 ctrl + shift + c
# 홍길동
# a=100
# 최길동
# case-sensitive(대소문자 구분)
# 여러 단어 사용시 camel-case notation 사용.
# 변수 선언과 사칙연산
# "=", "->"를 이용해서 assignment를 수행.

# R은 index가 0이 아닌 1부터 시작
# 변수의 값을 출력하려면 해당 변수를 그래도 실행하면 된다.
# print() 를 이용하여 출력이 가능하다.
# - file에 출력하려면 catr을 이용하여 file option을 이용
# 만약 file 출력에서 파일안에 내용을 추가하려면 append=TRUE를 이용.
myVar <- 100
result = myVar + 200
result
print(result,myVar)
cat(result,myVar)
cat("\n결과값은: \n",result,myVar,file="C:/R_Workspace/R_Lecture/test.txt",append=TRUE)
###############################################################

# 연산자 : 기본적인 연산자는 다른 언어와 상당히 유사하다.
# 
var1 <- 100
var2 <- 3

result <- var1 / var2
result #33.33333(총 7개의 digit로 표현 : default)
options(digits = 5)
result
# c와 java처럼 format을 이용한 출력도 가능.
sprintf("%.8f",result)
# 몫을 구하고 나머지를 구해보자.

result = var1 %/% var2
result
result = var1 %% var2
result

################################################################

#비교연산 => 다른언어와 똑같다.
var1 <- 100
var2 <- 200
var1 == var2
var1 != var2

#################################################################

#논리연산 => 약간 주의를 해야 한다.
# & , && 의미는 같다. ( And 연산 )
# | , || 의미는 같다.( Or 연산 )

TRUE && FALSE

# combine 함수를 이용해서 vector를 생성 => c()
#1개 백터화 연산 (같은 위치끼리 연산을 수행)
c(TRUE,FALSE) & c(TRUE,TRUE)
c(TRUE,FALSE) & c(TRUE,TRUE,FALSE)
#2개 첫자리만 비교
c(TRUE,FALSE) && c(TRUE,TRUE)
c(TRUE,FALSE) && c(TRUE,TRUE,FALSE)

#################################################################

# 기본적으로 사용하는 함수들.
abs(-3) # 절대값 출력
sqrt(5) # 제곱근 출력
factorial(3) # 펙토리얼

#################################################################

# R의 데이터 타입!

# 1. numeric(수치형) : 정수와 실수를 구분하지 않는다.
#     100, 100.3, 10 : 실수 10L : 정수(영문자L)
# 2. character(문자열) : 모든 글자는 싹다 문자열 '' "" 혼용가능. JS와 동일
var='홍길동'
# 3. logical(논리형) : TRUE(T), FALSE(F)
# 4. complex(복소수) : 4-3i

# 특수 데이터 타입.
# 1. NULL (java의 null과 유사한 의미) : 존재하지 않는 객체를 지칭할때 사용.
# 2. NA ( Not Available ) : 유효하지 않는 값. 일반적으로 결측치(측정을 못함)를 표현할떄 사용(missing value)
# 3. NAN ( Not A Number ) : 수치값이지만 숫자로 표현이 안되는 값.

sqrt(-3)

# 4. Inf (Infinite) : 양의 무한대
3/0

#################################################################
#################################################################

# 데이터 타입의 우선순위
# character > complex > numeric >logical
# 기본적으로 사용되는 자료구조가 vector
# vector 안에 다른 데이터 타입을 넣을때.. 높은 우선순위로 데이터 타입이 맞춰짐.
# 
myVar = c(10,20,30,40)
myVar

myVar = c(10,20,30,TRUE)
myVar

myVar = c(10,'홍길동',30,TRUE)
myVar

myVar = "100"
mode(myVar)
mode(as.numeric(myVar))

#데이터 타입에 대한 이야기.
#################################################################

# R package

# R의 package는 처리할 Data + 기능(함수,알고리즘)
# R의 package 시스템은 
# 1. base System
#   - base package
#   - recommended package
# 2. other package

# 간단하게 package를 하나 설치해 보기.
install.packages("ggplot2")
# 어딘가에 설치가 됨.
# package를 삭제 하려면
# remove.packages("ggplot2")

# 어디에 설치됬는지 확인 해보기.

.libPaths()
# 설치위치를 변경하려면
# .libPaths("C:/myLib")

# 이렇게 package를 설치한 후 사용을 하기 위해서는 메모리에 loading을 반드시 해야함.

library(ggplot2)
require(ggplot2)

myVar = c("남자","여자","여자","여자","여자","남자")

qplot(myVar)
# 함수사용 모를때. help 함수 이용
help(mean)
# 또는 Rdoucumentation.org 사이트 이용하는것 더 좋다.

## 자료구조

# 자료형은 저장된 데이터의 타입을 지칭
# 자료구조는 데이터가 메모리에 어떤 방식으로 저장되어 있는가.

## homogeneous(같은 종류의) 저장된 데이터 타입이 같은것.
#   - 1. Vector : 1차원 선형구조. 순서개념이 존재함. 같은종류의 데이터 타입을 이용함.
#   - 2. Matrix : 2차원구조. Index 사용가능. 같은종류의 데이터
#   - 3. Array : 3차원 이상의 구조. Index 사용가능. 같은종류의 데이터

## heterogeneous(다른 종류의) 자료구조 안에 Data가 각기 다름.
#   - 1. List : 1차원 선형구조. 순서개념이 존재. 실제저장되는 구조는 map구조. 중첩자료구조.
#   - 2. Data Frame : 2차원 테이블 구조.

###########################################################################################

# Vector : 1차원 선형자료구조, 순서의 개념이 있다. index를 이용하여 vector를 사용할수 있다. index시작은 "1". []를 이용하여 각 요소를 access 할 수 있다. 요소가 1개 짜리 `vector`를 `scalar` 라고 칭함.

# myVar = c(100) # myVar <- 100
myVar

# vector를 만드는 방법.
# 1. combine함수 이용. c()
myVar1 = c(10,20,30)
myVar2 = c(3.14,10,100)
result <- c(myVar1,myVar2)

myVar1
myVar2
result

# 2. ":" 을 이용한 방식 
#수치형 Data에서만 사용 가능. 단조 증가, 단조 감소 형태의 vector를 생성할 때 사용.
myVar = 1:10 # (start:end) 양쪽 inclusive 
myVar
myVar = 8.7:2
myVar

# 3. 2번의 일반형
# sequence 함수 이용
myVar = seq(1,10,2) # (시작, 끝, 증가치(감소치))
myVar
# 정식
myVar = seq(from=10,to=3,by=-3)


# 4. 반복적인 값을 이용해서 vector를 생성
#     rep()
myVar = rep(1:3,times=3)
myVar
myVar = rep(1:3,each=3)
myVar

# 많이 사용하는 함수중 하나. vector안의 요소 개수를 알아내는 함수.

length(myVar)

# vector 요소의 사용(indexing 방식) ***** 중요
myVar = c(3.14,100,"Hello",TRUE,300)
myVar[1]

myVar[6]

myVar[length(myVar)]

result = myVar[2:4] #slicing
result

result = myVar[c(2,3,5)] # fancy indexing
result

myVar[-1] # R에서 -의 의미 -N 빼고.
myVar[-(3:4)]
myVar[-c(1,4,5)]


# vector 데이터에 이름을 붙여보아요.
myVar = c(10,20,30,40,50)
myVar
names(myVar)
names(myVar) = c("a","b","c","d","e")
myVar

myVar["a"]


################################################################

# Vector화 연산

myVar1 = 1:3  # 1, 2, 3
myVar2 = 4:6  # 4, 5, 6
result = myVar1 + myVar2 # 5, 7, 9 같은 자리에서 합연산.

myVar3 = 1:6

result = myVar1       +  myVar3
#        1 2 3 1 2 3    1 2 3 4 5 6
# 사이즈 안 맞을때 사이즈를 recycle을 통해 맞춰줌.
result

# vector에 대한 집합연산 (합집합, 교집합, 차집합)
var1 = 1:5
var2 = 3:7

#합집합
union(var1,var2)
intersect(var1,var2)
setdiff(var1,var2)
