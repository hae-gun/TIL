# 결과로 얻은 JSON -> Data Frame으로 변환하기
# 외부 package를 이용.

install.packages("jsonlite")
install.packages("curl") #dependancy 걸려있는 패키지.
require(jsonlite) # JSON 처리를 위해서 loading
require(curl) 
require(stringr) # 문자열 처리를 위해서 loading

url <- "http://localhost:8080/bookSearch/search?keyword="

request_url <- str_c(url,scan(what=character()))#실제 호출할 URL

request_url

df <- fromJSON(request_url)

View(df)

# nrow(df) : row의 갯수
for (i in 1:nrow(df)) {
  print(df$title[i])
}

## 외부 API 이용.

# package 설치는 이미 진행함 (jsonlite, curl)
# 사용할 package loading(require, library) : 이미 수행함.

url <- "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=2b28381965c8d739d439fad98c6ebe85&targetDt=20200310"

df <- fromJSON(url)
View(df)

df[[1]]
df[["boxOfficeResult"]]
df$boxOfficeResult$dailyBoxOfficeList$movieNm

for (i in 1:nrow(df$boxOfficeResult$dailyBoxOfficeList)) {
  print(df$boxOfficeResult$dailyBoxOfficeList$movieNm[i])
}


