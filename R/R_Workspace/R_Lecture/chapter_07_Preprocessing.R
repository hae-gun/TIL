######################################################################################

#데이터 정제!
# 데이터 분석이전에 raw데이터 (현장에서 수집한 데이터)를
# 분석이 가능한 형태로 가공하는 작업이 선행되어야 한다.

# 데이터 셋을 만드는 것이 가장 어렵다.

# 1. 결측치를 해결해야 한다.
# NA
# 데이터를 지우는 방법은 매우 안좋은 방법.
# 

# NA를 처리하기 위해서 우리가 사용하는 함수.
# is.na()

df <- data.frame(id=c(1,2,NA,4,NA,6),
                 score=c(20,30,NA,50,70,NA))
df
is.na(df)
is.na(df$id)
is.na(df$score)

library(dplyr) # datan frame을 가장 쉽고 편하게 제어할 수 있는 패키지

# id가 NA인 row를 data frame에서 삭제하기.
result <- df %>% 
          filter(!is.na(df$id))

result <- df %>% 
          filter(!is.na(df$id),
                 !is.na(df$score))

# data frame에서 모든 NA를 삭제할 수 있다.


# 조금 더 쉽게 모든 NA를 다 찾아서 NA가 포함된 rwo를 삭제하는 함수가 존재.

result <- na.omit(df)


# NA값을 무작정 삭제하는건 그다지 바람직한 방법이 아님.
# `NA` 값 다른 값으로 대체하는 것이 좋음.
# NA값을 해당컬럼의 평균값, 최소값, 최대값, 등등 이용해서 적절한 값으로 대체.
#
df <- data.frame(id=c(1,2,NA,4,NA,6),
                 score=c(20,30,NA,50,70,NA))
df

mean(df$score)

## 일반적으로 NA를 무시하고 연산하는 방법을 제공.

mean(df$score, na.rm = TRUE)

## score의 NA값을 score안에 있는 NA를 제거한 모든 값의 평균으로 대체해서 새로운 data frame을 만들어 사용하기.

df$score <- ifelse(is.na(df$score),
                   mean(df$score, na.rm = TRUE),
                   df$score)

####################################################################

## 결측치를 해결했으면
## 그 다음 생각해야 하는것 : 이상치

# 1. 이상치 : 이상한 값.
# - 값이 없는건 아니지만 사용할 수 없는 값이 포함된 경우.

df <- data.frame(id=c(1,2,NA,4,NA,6),
                 score=c(20,30,NA,50,70,NA),
                 gender=c("^^","F","M","F","M","F"),
                 stringsAsFactors = FALSE)
df
# ^^ : 이상치
# 이상치는 먼저 NA로 변환한 후 NA를 처리하는 방식으로 진행.

df$gender <- ifelse(df$gender %in% c("M","F"),
                    df$gender,
                    NA)


# 2. 극단치값이 포함되어 있는 경우 이 값을 해결.
# 극단치 값은 나중에 가중치를 많이 받게되어 처리해 줘야 한다.
# 이 기준을 잡는 방법은 논리적으로 이상적인 범위를 설정 통계적인 방법으로 이상적인 범위를 설정.























