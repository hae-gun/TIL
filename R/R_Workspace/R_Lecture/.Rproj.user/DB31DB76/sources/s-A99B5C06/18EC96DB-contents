############################################################################

## 3/9 정리
## 데이터분석
## R에서 EDA(탐색적 데이터 분석)
## - 주어진 데이터 안에서 내가 알고자하는 데이터를 추출.
## - 데이터 내에 숨겨져 있는 특정한 사실을 유추해내는 작업.
## 통계적 가설 검정
## 머신러닝 -> 딥러닝으로 진행되는게 일반적인 순서.

## R 설치, RStudio 설치
## R Operator(연산자)
## R Data Type
## R Package
## R Data Structure
## - 6개
## homogeneous : vector(1D), matrix(2D), Array(3D) 
## hetrogeneous : list(1D), data frame(2D)!

############################################################################

# matrix : 2차원 구조 (행과 열로 구성되어있다.)

var1 <- matrix(c(1:5))  #5행 1열짜리 2차원 matrix
var1

var1 <- matrix(c(1:10),nrow=2) #norw 행 갯수 지정.
var1
var1 <- matrix(c(1:11),nrow=2) # 2행 6열 recycle rule.
var1

var1 <- matrix(c(1:10), nrow = 2, byrow = TRUE) # 2행 5열, 방향으로 데이터 채우기

############################################################################

#vector를 이용한 matrix 생성.
var1 = 1:4
var2 = 5:8

mat1 = rbind(var1,var2)
mat1

mat1 = cbind(var1,var2)
mat1

############################################################################

var <- matrix(c(1:10),nrow=2, byrow = TRUE) # 일반적인 2차원 indexing 방법과 동일하다.
var
var[1,4]

var[,4]
var[1,]

length(var)

nrow(var)
ncol(var)

############################################################################

var1 <- array(c(1:24), dim = c(3,2,4))
var1

############################################################################

# R factor
# factor는 범주형
# 방의 크기 (대, 중, 소) => level 값과 level을 통시에 표시.
# 명목형과 순서형
# 순서개념 없는것 - 명목형
# 순서개념 있는것 - 순서형.

# factor를 생성할 떄 vector를 이용해서 만든다.

var1 <- c("A","B","AB","O","A","AB")
var1_factor <- factor(var1)
var1_factor

levels(var1_factor)

# 일반적으로 factor를 생성하는 방법.


var1 <- c("A","B","AB","O","A","AB")
var1_factor <- factor(var1,levels = c("A","B","O"))

var1_factor <- factor(var1,levels = c("A","B","O","AB"), ordered = TRUE)

#############################################################################

# list
# 1차원 선형구조.
# 여러형태의 자료형이 같이 저장될 수 있다.
# 각 index 위치에 값이 저장될 때 map 형태로 저장된다. (key 와 value의 쌍의 형태).
# 중첩 자료구조.
# 값을 넣을때 map 형태로 넣어야 함.

var1_scalar = 100

var2_vector = c(10,20,30)

var3_matrix = matrix(c(1:6), nrow = 3)

myList = list(var1_scalar,var2_vector,var3_matrix)
myList

myList[[2]][1]

# 전형적인 방식의 리스트 생성.
myList <- list(name=c("홍길동","김길동"),
               age=c("20","30"),
               gender=c("남자","여자"))
myList

myList$age
myList[[2]]
myList[["age"]]

##########################################################################
# 기본적인 자료구조에 대한 사용법. 익숙해지기.

# Data frame
# R에서 가장 많이 쓰이고 가장 중요한 자료구조.
# 행과 열로 구성된 2차원 형태의 테이블.
# 데이터베이스의 Table과 같은 구조라고 생각하면 됨.
# 컬럼단위로 서로 다른 타입의 데이터 저장이 가능하다.


df = data.frame(NO=c(1,2,3),
                Name=c("홍길동","이순신","강감찬"),
                Age=c(20,30,40),
                stringsAsFactors=FALSE)# 컬럼명 = 값 형태로 저장.


df
View(df) # 표로 확인가능.

#내가 원하는 column만 보기.
df$Age
df$Name

# data frame을 살펴봤다.... data frame중 일부를 추출해서 새로운 data frame을 생성할수 있다.

df <- data.frame(x=c(1:5),
                 y=seq(2,10,2),
                 z=c("a","b","c","d","e"),
                 stringsAsFactors = FALSE)

# x의 값이 3 이상인 행만 추출!

subset1 <- subset(df,x>=3)

# x값이 3이상이고 y값이 8이하인 행만 추출하기

subset2 <- subset(df,x>=3 & y<=8)
subset1
subset2
##################################################################################

# 연습문제.

# 1. 4,5,7,8,10,3 의 숫자를 이용해서 숫자벡터 x를 생성하기.
x <- c(4,5,7,8,10,3)
print(x)

# 2. 연산 결과는?
x1 <- c(3,5,7,9)
x2 <- c(3,5,3)
x1 + x2 # recycle rule 적용되어 계산. 6, 8, 10, 12
        # vector화 연산이 어떻게 수행되는가.

# 3. Data Frame과 subset을 이용해서 다음의 결과를 만들어 보기.

Age <- c(22,25,18,20)
Name <- c("홍","최","박","홍")
Gender <- c("M",'F','M','F')

# 1) 위의 3개의 vector를 이용하여 df 를 만들기.
df <- data.frame(Age=Age,
                 Name=Name,
                 Gender=Gender,
                 stringsAsFactors = FALSE)

# 2) subset을 이용해 다음의 결과를 출력
## Age Nage Gender
## 22   홍   M
## 18   박   M
subset1 <- subset(df,Gender=="M")
subset2 <- subset(df,Gender!="F")
df
subset1
subset2


# 4. 다음의 R코드를 실행시킨 결과는? (Boolean indexing)
x <- c(2,4,6,8)
y <- c(TRUE,FALSE,TRUE,FALSE)

# logical 백터를 다른백터의 index로 지정할수 있다.

x[y]
# 전제조건 : size 같아야함.
# 해당위치의 TRUE만 남기고 버림.


x[c(1,2,4)]
# Fancy Indexing


sum(x[y]) #sum(), min(), max(), min() 기본함수

# 5. 아래의 계산결과는?
#    
x <- c(1:4)
(x+2)[(!is.na(x))& x>2] -> k
k

# 6. 결측치 (missing value) => NA
x <- c(10,20,30,NA,40,50,60,NA,NA,100)
# vector 안에있는 NA 갯수 출력
sum(is.na(x)) # FALSE는 0, TRUE는 1이기 때문에 NA의 갯수를 확인할 수 있다.





