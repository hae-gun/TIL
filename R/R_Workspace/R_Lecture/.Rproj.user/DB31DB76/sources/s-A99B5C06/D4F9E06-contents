# 빅데이터 처리에서 문자열처리는 꽤나 빈번하게 발생되는 작업이다.

# 기본적인 R의 base system을 이용해서 문자열을 처리하는건 그다지 좋은 방식은 아니다.

# 문자열처리에 대한 대표적인 package가 있다. 
# stringr

# 1. package 설치
#install.packages("stringr")

# 2. package loading
library(stringr) # require(stringr)

# 3. 문자열(character)하나 준비.
myStr= "Honkgd1051Leess4504YOU25홍길동1004"
# 한글과 영문 모두 1개로 취급한다. 인코딩상관없이.
#길이출력
str_length(myStr)

#위치출력
str_locate(myStr,"Lee")
str_locate(myStr,"0")
str_locate_all(myStr,"0")

# 부분문자열
str_sub(myStr,2,5)

# 대소문자
str_to_upper(myStr)
str_to_lower(myStr)

# 문자열 교체
str_replace(myStr,"홍길동","신사임당")

# 문자열 결합
str_c(myStr,"1234")

#문자열 분리
myStr= "Honkgd105,1Leess4504,YOU25,홍길동1004"
str_split

######################################################################

# R 정규표현식(regular expression)
# 약속된(정해져있는) 기호를 이용해서 의미를 표현.

myStr= "Honkgd105,1Leess4504,YOU25,홍길동1004"

# stringr에 정규식을 이용해서 내가 원하는 형태의 문자열을 추출하는 함수

str_extract_all(myStr,"[a-z]{3}") #대괄호 : [] 안에 나오는 문자중 한개
str_extract_all(myStr,"[a-z]{3,}") # onkgd eess
str_extract_all(myStr,"[a-z]{3,4}") # onkg eess

str_extract_all(myStr,"[가-힣]{3}")

str_extract_all(myStr,"[0-9]{4}")

str_extract_all(myStr,"[^a-z]{3}") # 영문자 소문자 3개 연속이 아닌것.

###########################################################################

# 데이터의 입출력
# 데이터 분석을 하기 위해서는 가장 먼저 데이터를 준비해야 한다.
# 키보드로 부터 데이터를 입력받아 보기.
# scan() edit() 함수를 이용해서 입력을 받아보자.


myNum = scan() # 숫자만 가능함.


myNum

myData = scan(what = character())

myData

# 만약 data frame에 데이터를 집적 입력하고 싶다면..

df = data.frame()
my_df = edit(df)


my_df

# 파일처리.

# 파일에 있는 데이터를 가져오기 위해서 여러가지 형태의 함수를 이용.

##read.table()

df <- read.table("data/student_midterm.txt",
                 sep = ",")
df

## file에 header가 포횜되어 있는 경우


df <- read.table("data/student_midterm.txt",
                 sep = ",",
                 header = TRUE,
                 fileEncoding = "UTF-8")
df

## 파일탐색기를 이용해서 파일을 선택할 경우

df <- read.table(file.choose(),
                 sep = ",",
                 header = TRUE,
                 fileEncoding = "UTF-8")


## 만약 파일에 이상데이터가 있는 경우

df <- read.table(file.choose(),
                 sep = ",",
                 header = TRUE,
                 fileEncoding = "UTF-8",
                 na.strings = "-") #na.strings 를 통해 NA로 처리할 문자지정
df


########################################################################

# 데이터 교환, 전달할때 사용하는 데이터 표준형식

# 1. CSV(Comma Seperated Value) 방식
#    CSV파일을 이용해서 사용.
#    예) 홍길동,20,서울,김길동,40,부산,신사임당,30,인천
#    장점 - 용량이 작다. => 대용량의 데이터 전달에 유리함.
#    단점 - 데이터의 구조화가 힘들다. -> 파서가 필요하게됨.
#         - 유지보수에 문제가 있다.
#
# 2. XML(eXtended Markup Language) 방식
#    예) <name>홍길동</name><age>20</age><address>서울</address>
#    단점 - 데이터 전체의 크기가 너무크게 증가함. 모바일시대로 넘어오면서 데이터크기 = 돈의 개념.
#
#	3. JSON(JavaScript Object Notation)
#     데이터 전송에 대한 표준. 프로그래밍과는 상관이 없음.
#     예) { name : "홍길동", age : "20", address : "서울"}

################################################################################

# R 에서 CSV 파일형식 읽기.
# read.table() 과 거의 유사함.
# `header=TRUE` 가 default로 잡혀있다.
# sep="," dafault
read.csv(file.choose(),
         fileEncoding = "UTF-8")


# excel 파일로 데이터 파일이 되어 있는 경우
# Excel file을 사용하려면 기본기능으로는 안됨. 외부 패키지가 필요함.


install.packages("xlsx")
library(xlsx)

df <- read.xlsx(file.choose(),
                sheetIndex = 1,
                  encoding = "UTF-8")

df

class(df)
# file에 data frame을 저장하려면..

# write.table()

write.table(df,
            file = "data/result.csv",
            row.names = FALSE,
            quote = FALSE)

########################################################################

# R에서 JSON처리
# JSON데이터를 어디서 얻나요??
# 1. 우리가 DB설정, 간단한 Servlet을 이용해서 JSON을
#    받아올꺼예요!!
#
# 2. OPEN API(영화진흥위원회 OPEN API)
#
#
# 도서검색 프로그램을 이용해서 JSON을 이용해 보아요!
# - 데이터베이스 세팅
# - mysql을 이용해서 데이터베이스 설정(standalone)
# - 1. mysql압축을 풀어요
# - 2. bin폴더 안에 있는 mysqld를 실행(daemon)
#      => myslq server가 기동
# - 3. mysql에 console진입(새로운 도스창을 열어서)
#      => mysql -u root
# - 4. 새로운 사용자를 생성
#      => create user rdata identified by "rdata";
#      => create user rdata@localhost identified by "rdata";
# - 5. 데이터베이스 생성
#      => create database library;
# - 6. 데이터베이스 권한 설정
#      => grant all privileges on library.* to rdata;
#      => grant all privileges on library.* to rdata@localhost;
# - 7. flush privileges; 
# - 8. console에서 나가요!! => exit;
# - 9. 제공된 script를 이용하여 database 구축!!
#      mysql -u rdata -p library < _BookTableDump.sql































