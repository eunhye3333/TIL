# HTML을 파이썬으로 가져오자 : requests
## requests
+ HTTP 통신을 위한 파이썬 라이브러리

## 라이브러리
+ 프로그램 개발을 쉽게 하기 위한 도구
+ 라이브러리를 사용하면 개발이 쉬워짐

## HTTP 통신
+ 인터넷에 접속할 때 발생하는 대화 
+ 서버와 내가 소통하는 과정
+ GET 요청과 POST 요청이 있음
  + GET : 특정 페이지를 요청하는 것
  + POST : 특정 정보들과 함께 페이지를 요청하는 것

## requests 설치
```
pip install requests
```

## requests 사용법
원하는 사이트의 html 코드 가져오기
```
import requests

response = requests.get("원하는 사이트 주소")
html = response.text
print(html)
```
