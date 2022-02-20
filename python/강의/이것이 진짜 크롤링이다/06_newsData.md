# 뉴스의 제목과 링크를 가지고 오자
## 뉴스 검색
![news](https://user-images.githubusercontent.com/77559262/154834047-f0ab72ae-0811-425f-8724-839811b13b8f.png)  

## 태그 
![tags](https://user-images.githubusercontent.com/77559262/154834078-a60cae1d-ef0f-4033-b5bb-68189cd4e8be.png)  
+ mark : 중요도 표시 태그
+ 제목 : a 태그 안쪽 텍스트
+ href의 속성값 : 뉴스 원본 사이트 주소

## 원하는 태그 선택하기
class를 이용하여 선택  
ctrl + f를 눌러 class 이름 검색 가능  
![class](https://user-images.githubusercontent.com/77559262/154834183-d990021a-7f28-49ef-b647-5a747f095d5f.png)

# 검색어에 따라 다른 결과를 나타내기 : pyautogui
## URL
+ 인터넷 주소 형식
+ Protocol - Domain - Path - Parameter의 4가지 형태로 구분됨
  ```
  ex. https://search.naver.com/search.naver?where=news&query=삼성전자
  Protocol  : //가 나오기 전까지 (https 또는 http)
  Domain    : 프로토콜 이후부터 다음 슬래시가 나오기 전까지 (search.naver.com)
              ip 주소에 이름을 부여한 것
  Path      : 도메인 이후부터 ?가 나오기 전까지 (search.naver)
              서버에서 해당 페이지의 경로
  Parameter : ? 이후 (where=news&query=삼성전자)
              크롤링에서 핵심
              키와 값으로 이루어져 있고, &로 구분됨 (키: where, query, 값: news, 삼성전자)
              서버에 추가적인 정보를 제공하기 위한 부분
              여기에서 query는 검색어에 해당되므로 검색어를 변경하려고 하는 경우 query의 value를 변경해 주면 됨
  ```
  ![url](https://user-images.githubusercontent.com/77559262/154834656-ffae7e67-a069-40eb-bdb3-c73357ac21d5.png)

## pyautogui 라이브러리
+ 마우스, 키보드 매크로 라이브러리
+ 간단한 입력창 띄우기 위해 사용

## pyautogui 설치
```
pip install pyautogui
```

## pyautogui 입력창 띄우기
```
pyautogui.prompt("검색어를 입력하세요")
```

## f-string
파이썬 3.6부터 제공되는 문자열 포멧팅 방식으로 문자열 앞에 f를 붙이고, 문자열 안에 중괄호를 이용하는 방식으로 문자열에 표현식 삽입 가능
```
x = "John"
f"나는 {x}입니다."

결과 : 나는 John입니다.
```
변수 뿐 아니라 함수를 호출한 결과 증 가능한 모든 표현식을 삽입 가능

# 여러 페이지 결과 모두 가져오기 : 반복문
## URL 분석하기
+ 1페이지 → 2페이지 → 3페이지 ... 으로 이동하며 URL이 어떻게 변하는지 살펴봐야 함
  1페이지 : start = 1
  2페이지 : start = 11
  3페이지 : start = 21
  ...
  10페이지 : start = 91

## 반복문 사용하기
```
for i in range(시작, 끝, 단계):
```
