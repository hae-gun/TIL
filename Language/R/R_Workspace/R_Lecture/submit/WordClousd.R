library(dplyr)
library(rvest)
library(stringr)

url <- "https://movie.naver.com/movie/point/af/list.nhn?st=mcode&sword=52515&target=&page="


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

tmp <- readLines("C:/R_Workspace/R_Lecture/data/words.csv",encoding = "UTF-8")
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
  filter(word_df$result!="영화") %>% 
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
          random.order = F,       # 고빈도 단어 중앙위치.(T이면 랜덤)
          rot.per = .1,            # 글자 살작 회전해여 만듬
          colors = pal) 

