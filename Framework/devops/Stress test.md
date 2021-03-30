# API 성능측정



* Artillery 를 사용한 부하 테스트 (Stress Test)
* Node.js 이용

```cmd
npm install -g artillery@1.6 # 설치
```





* yml 파일 작성

```yml
config:
  target: "http:// xxx.xxx.xxx.xx" # ContextRoot 정보 입력
  phases:
    - duration: 60
      arrivalRate: 5
      name: Warm up

scenarios:
  # We define one scenario:
  - name: "Search and buy"
    flow:
      - get:
          url: "/product/{{ id }}/details" # url 정보

```



* 실행

```cmd
sudo artillery run --output report.json ./cpu-test.yaml
```

* 생성된 json 파일 웹으로 보기

```cmd
artillery report ./report.json 
```

