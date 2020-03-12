
install.packages("pracma")
library("rvest")
library("stringr")
library(dplyr)
library(pracma)

url <- "https://www.rottentomatoes.com/top/bestofrt/?year=2019"
mainUrl <- "https://www.rottentomatoes.com"
#url_page <- vector(mode = "character",length = 100)
html <- read_html(url,encodin="UTF-8")
nodes <- html_nodes(html,"td > a.articleLink")
url_link<- html_attr(nodes,"href")

full_url <- str_c(mainUrl,url_link)

title_set = vector(mode = "character",length = 100)
point_set = vector(mode = "character",length = 100)
genre_set = vector(mode = "character",length = 100)

data <- data.frame()

for(i in 1:100){
  page_html <- read_html(full_url[i],"UTF-8")
  nodes <- html_nodes(page_html,"h1.mop-ratings-wrap__title.mop-ratings-wrap__title--top")
  title <- html_text(nodes)
  nodes <- html_nodes(page_html,"#topSection > div.col-sm-17.col-xs-24.score-panel-wrap > div.mop-ratings-wrap.score_panel.js-mop-ratings-wrap > section > section > div.mop-ratings-wrap__half.audience-score > h2 > a > span.mop-ratings-wrap__percentage")
  
  point <- html_text(nodes)
  point <- str_remove_all(point,"[\n ]")
  if(isempty(point))point <- "comming soon"
  nodes <- html_nodes(page_html,'div.media-body > div.panel-body > ul.info > li.meta-row > div.meta-value > a')
  genre <- html_text(nodes)
  
  
  a <- data.frame(title=title,
                  point=point,
                  genre=genre)
  data <- bind_rows(data,a)
}

data

write.table(data,
            file="C:/Users/student/Desktop/TIL/R/result.csv",
            fileEncoding = "UTF-8",
            quote=F)

View(data)
