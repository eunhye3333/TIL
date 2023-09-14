# 실전 프로젝트 3) 상품 정보 데이터 수집하기
## requests의 한계
+ 로그인이 필요한 사이트인 경우 크롤링이 어려움 (세션 처리가 어려움)
+ 동적으로 HTML을 만드는 경우 사용하기 어려움  
  동적으로 바뀐다 : 서버에서 정보를 변경할 때 웹사이트 전체 정보가 바뀌는 것이 아니라 필요한 정보만 바뀌는 것
  
## 동적으로 HTML을 만드는 경우
+ 스크롤하거나 클릭하면 데이터가 생성되는 경우
+ URL 주소가 변경되지 않았는데 데이터가 변하는 경우
+ 표, 테이블 형태의 데이터인 경우가 많음

## 셀레니움이란?
+ 웹 어플리케이션 테스트를 위한 도구
+ 브라우저를 실제로 띄워서 사람처럼 동작하도록 만들 수 있음

## 셀레니움 기초 사용법
+ 크롬 드라이버 다운로드  
  https://chromedriver.chromium.org/downloads  
  웹브라우저 버전에 맞는 드라이버 다운로드  
  웹브라우저 버전 확인 (설정 → 크롬 정보)  
  ![setting](https://user-images.githubusercontent.com/77559262/154940888-4c7af02d-9aef-4539-98f0-ebfad181cf2d.png)
  ![info](https://user-images.githubusercontent.com/77559262/154940928-ef55133c-1eec-4e29-ab37-9dcd7a71ce88.png)

+ 라이브러리 설치  
  ```
  pip install selenium
  ```
  
## 무한 스크롤 처리 방법
+ 현재 스크롤된 높이를 알 수 있는 자바스크립트 명령어를 이용한다
+ window.scrollY

## 웹사이트 자동화 종류
+ 크롤링
+ 로그인
+ 업로드
+ 웹사이트에서 위처럼 반복적인 작업을 자동화 가능

## 셀레니움 4
1. 최신 업데이트된 방식 사용
2. 크롬 드라이버 또는 다른 웹드라이버 자동 업데이트 코드
   ```
   pip install webdriver_manager
   ```
3. 브라우저 꺼짐 방지 코드
4. 불필요한 에러 메시지 제거

## 셀레니움 4 업데이트
```
pip list # 현재 설치된 라이브러리의 버전 확인 가능, 확인 후 업데이트

pip install --upgrade pip
pip install --upgrade selenium
```
