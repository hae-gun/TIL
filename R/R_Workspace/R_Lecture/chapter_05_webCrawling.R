# install.packages("rvest") web scrapping을 위한 package 설치.
library("rvest")
library("stringr")
#path를 통한 scraping 처리

# 네이버 영화 commnet 페이지에서 영화제목, 평점, 리뷰가져오기.

url <- "https://movie.naver.com/movie/point/af/list.nhn?&page="

#추후 crawling 작업을 생각해서 request_url 작성.
request_url <- str_c(url,1)

page_html <- read_html(request_url,encoding = "CP949")

# 영화제목부분을 추출하기.
nodes <- html_nodes(page_html,"td.title > a.movie")
titles = html_text(nodes)
# 여기까지는 selector 이용.
#########################################################################

#xpath 이용.

movie_title = vector(mode="character", length = 10) # 영화제목을 저장할 빈 vector 생성.

for(i in 1:10){
  myPath = str_c('//*[@id="old_content"]/table/tbody/tr[',i,']/td[2]/a[1]/text()')
  nodes <- html_nodes(page_html,xpath = myPath)
  movie_title[i] <- html_text(nodes)
  }
  movie_title

movie_comments = vector(mode = "character", length = 10)
for(i in 1:10){
  myPath = str_c( '//*[@id="old_content"]/table/tbody/tr[',i,']/td[2]/text()')
  nodes <- html_nodes(page_html, xpath = myPath)
  movie_comments[i] <- html_text(nodes)
}



# 수행평가 문제
# 로튼토마토 사이트에가서 2019년에 가장 인기있었던 영화 top100
# 영화제목 사용자평점 장르 가져오기.
# data frame으로 생성한 후 파일로 저장!
 
url <- "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
page_html <- read_html(url,encoding = "UTF-8")
nodes <- html_nodes(page_html,"#top_movies_main > div > table > tbody > tr > td > a")

install.packages("pracma")
library("rvest")
library("stringr")
library(dplyr)
library(pracma)

url <- "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
mainUrl <- "https://www.rottentomatoes.com"
url_page <- vector(mode = "character",length = 100)
html <- read_html(url,encodin="UTF-8")
nodes <- html_nodes(html,"td > a.articleLink")
url_link<- html_attr(nodes,"href")

full_url <- str_c(mainUrl,url_link)

title_set = vector(mode = "character",length = 100)
point_set = vector(mode = "character",length = 100)
genre_set = vector(mode = "character",length = 100)

data <- data.frame()
i <- 79
for(i in 1:100){
  page_html <- read_html(full_url[i],"UTF-8")
  nodes <- html_nodes(page_html,"h1.mop-ratings-wrap__title.mop-ratings-wrap__title--top")
  title <- html_text(nodes)
  nodes <- html_nodes(page_html,"#topSection > div.col-sm-17.col-xs-24.score-panel-wrap > div.mop-ratings-wrap.score_panel.js-mop-ratings-wrap > section > section > div.mop-ratings-wrap__half.audience-score > h2 > a > span.mop-ratings-wrap__percentage")
  
  point <- html_text(nodes)
  point <- str_remove_all(point,"[\n ]")
  if(isempty(point))point <- "comming soon"
  nodes <- html_nodes(page_html,'div.media-body > div.panel-body > ul.info > li.meta-row > div.meta-value > a')
  genre <- html_text(nodes)[1]
  
  
  a <- data.frame(title=title,
                  point=point,
                  genre=genre)
  data <- bind_rows(data,a)
}

data


View(data)

a<-read_html("https://www.rottentomatoes.com/m/the_heiresses")




page_html <- read_html("https://www.rottentomatoes.com/m/the_heiresses",encoding = "UTF-8")
nodes <- html_nodes(page_html,"#topSection > div.col-sm-17.col-xs-24.score-panel-wrap > div.mop-ratings-wrap.score_panel.js-mop-ratings-wrap > section > section > div.mop-ratings-wrap__half.audience-score > h2 > a > span.mop-ratings-wrap__percentage")
point <- html_text(nodes)
point <- str_remove_all(point,"[\n ]")
nodes <- html_nodes(page_html,'div.media-body > div.panel-body > ul.info > li.meta-row > div.meta-value > a')
genre <- html_text(nodes)[1]
point
genre


write.table(nodes,file="C:/Users/student/Desktop/TIL/R")

