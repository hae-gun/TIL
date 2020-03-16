## 데이터분석을 이용하려면
## 웹 데이터 분석이 가장 많지 않을까 생각됨.
## 의사결정에 반영하는 방식으로 이용. -> 마케팅목적으로 많이 이용.
## 추천시스템


## Graph에 대해서 알아보기.
## 2차원 그래프를 그리는 방법에 대해서 알아보기.
## ggplot2 라는 package를 이용.

## 1. 산점도(scatter plot)
## 2차원 평면(x축,y축)에 점으로 표현한 그래프

## ggplot2 package의 그래프 그리는 방식.
##  1. 배경설정 (x축과 y축 설정)
##  2. 실제 그래프를 추가 (선, 막대, 점)
##  3. 축범위, 색과 같은 설정을 추가.

library(ggplot2)


df <- as.data.frame(mpg)    # table 형식의 데이터를 data frame으로 변환.

## 1. scatter 그리기
##    - 배기량과 고속도로 연비의 관계를 알기위해서 산점도를 그려보기.

## 1)축설정
ggplot(data = df, #사용할 데이터 프레임
        aes(x=displ, y=hwy)) # x,y축 지정

## 2)그릴 그래프 설정.
## + ggplot2에서 이어간다는 의미.
ggplot(data = df, 
        aes(x=displ, y=hwy)) + 
  geom_point()   # 산점도 그리는 함수.


## 3) 그래프 설정

ggplot(data = df, 
        aes(x=displ, y=hwy)) + 
  geom_point() + 
  xlim(3,6) + 
  ylim(20,40) # 그래프 범위 정해서 보기.

#########################################################################
## 막대그래프를 그려보기.
## 일반적으로 두 집단간의 차이를 볼때.
## 우리가 갖고 있는 자동차 데이터를 이용해서 구동방식별 고속도로 연비차이 비교

## 전륜구동, 후륜구동, 4륜구동


## 모든 차량 데이터를 구동방식별로 grouping.
result <- df %>%
        group_by(drv) %>%
        summarise(mean_hwy = mean(hwy))


ggplot(data = result,
       aes(x=drv,y=mean_hwy))+
  geom_col()

## boxplot을 알아보기.

ggplot(data=df,
       aes(x=drv,y=hwy)) +
  geom_boxplot()



# 사분위 개념.
data <- c(1,2,3,4,5,6,7,8,9,10,11,12,50)
mean(data)
# 2사분위 : 데이터의 중간에 있는 값. 중위수.

#############################################################################

## 문자열 처리 (워드클라우드)
## 한글 형태소 분석

## 영화댓글사이트에서 특정 영화에 대한 댓글을 모아서 형태소를 분석한 후 해당 내용을 이용해서 워드 크라우드를 만들기.

## 한글 형태소를 분석하기 위해서는 특수한 package가 필요.
## KoNLP(Korean Natural Language Process)

# 패키지 설치
install.packages("KoNLP")
## 현재 CRAN에서 설치가 안되고 있다.
## 폴더를 복사하는 형식으로 사용한다.
## 2개의 폴더를 library 폴더에 복사.
.libPaths()



install.packages("Sejong")
install.packages("hash")
install.packages("tau")
install.packages("RSQLite")
install.packages("devtools")

library(KoNLP)

# 사용할 수 있는 한글 사전은 3가지 종류
# 시스템, 세종, NIADIC
useNIADic()


tmp <- "이것은 소리없는 아우성"

extractNoun(tmp)

library(stringr) # package 로딩

tmp <- readLines(file.choose(),encoding = "UTF-8")
tmp


words <- extractNoun(tmp)


result <- unlist(words)


# 글자 빈도수 구하기.

# table() <- 빈도 구하는 함수.

wordcount <- table(result)


wordcount_df <- as.data.frame(wordcount,
                              stringsAsFactors = FALSE)

wordcount_df

## 워드클라우드 작성.

word_df <- wordcount_df %>%
           filter(nchar(result) >= 2) %>%# nchar 글자수 출력함수.
           arrange(desc(Freq)) %>%       # 내림차순으로 정렬
           head(20)                      # 상위 20개 출력

word_df

install.packages("wordcloud")
library(wordcloud)

# 팔레트 설정. (색상 설정.)

# 단어 색상 목록 설정.
pal <- brewer.pal(8,"Dark2") # Dark2 색상 range 안에서 8개의 색상을 사용.

# wordcloud는 생성할 때 마다 다르게 생성.
# 내부적으로 랜덤하게 만들어짐.
# 만약 같은 형태의 wordcloud를 생성하고 싶으면
# random에 대한 seed값을 설정.

set.seed(1)  # 초기숫자 설정.

wordcloud(words = word_df$result, # 사용할 단어
          freq = word_df$Freq,    # 단어 빈도수
          min.freq = 2,           # 최소 빈도수
          max.words = 200,        # 최대 단어수
          random.color = F,       # 고빈도 단어 중앙위치.(T이면 랜덤)
          rot.per = .1,            # 글자 살작 회전해여 만듬
          colors = pal)           # 색상 

#####################################################################


# R 정리
# 1. 데이터 분석 => R
#    데이터 타입, 데이터 구조(자료구조)
# 2. 데이터 수집 => 파일로부터 데이터를 받아와요!
#                   웹프로그램으로부터 JSON
#                   Open API를 이용해서 JSON
#                   scraping & crawling (selector, xpath)
# 3. 데이터 전처리(NA,이상치 처리)
#
# 4. 데이터 분석 => dplyr을 이용한 data frame처리
#                   EDA(탐색적 데이터 분석) SQL과 유사한 처리.
#                   주어진 데이터안에서 요구되는 데이터를 추출하는 방법을 연습.
#                   공공데이터 (일반적인 raw데이터를 이용해서 의미있는 데이터 추출) 
# 
# R과정 수행평가.
# 3가지 문제를 해결해보아요!
# 1. mpg data set을 이용한 8개 문제 해결. (dplyr)
# 2. 웹 스크래핑(로튼 토마토)
# 3. 네이버 영화댓글 사이트에서 특정 영화에 대한 댓글을 수집하여 wordcloud드 생성
# 

library(dplyr)
library(rvest)
library(stringr)

url <- "https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=52515&target=&page="

i<-1

  data <- data.frame()
  
for(i in 1:10){
 rhtml <- str_c(url,i)
 page_html <- read_html(rhtml,encoding="CP949")

  comentset <- vector(mode = "character",length = 10)
 
 for(j in 1:10){
  nodes <- html_nodes(page_html,xpath = str_c('//*[@id="old_content"]/table/tbody/tr[',j,']/td[2]/text()'))  
  coment <- str_remove_all(html_text(nodes[4]),"[\t\n]")
  a <- data.frame(coments=coment)
  data<-bind_rows(data,a)
  }
}
  
    
  
  
  View(data)


  write.table(data,
              file="C:/R_Workspace/R_Lecture/data/words.csv",
              fileEncoding = "UTF-8",
              quote=F)
 tmp <- readLines(file.choose(),encoding = "UTF-8")
  extractNoun(tmp)

  words <- extractNoun(tmp)
  
  
  result <- unlist(words) # 하나의 벡터안에 모든 값을 저장.
  result

  wordcount <- table(result)
  wordcount

  wordcount_df <- as.data.frame(wordcount,
                                stringsAsFactors = FALSE)
  
  wordcount_df

  word_df <- wordcount_df %>%
    filter(nchar(result) >= 2) %>%# nchar 글자수 출력함수.
    arrange(desc(Freq)) %>%       # 내림차순으로 정렬
    head(20)                      # 상위 20개 출력
  
 View(word_df)

  pal <- brewer.pal(8,"Dark2")
  set.seed(1)  # 초기숫자 설정.
  
  wordcloud(words = word_df$result, # 사용할 단어
            freq = word_df$Freq,    # 단어 빈도수
            min.freq = 2,           # 최소 빈도수
            max.words = 200,        # 최대 단어수
            random.color = F,       # 고빈도 단어 중앙위치.(T이면 랜덤)
            rot.per = .1,            # 글자 살작 회전해여 만듬
            colors = pal) 


