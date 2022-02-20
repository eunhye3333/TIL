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
