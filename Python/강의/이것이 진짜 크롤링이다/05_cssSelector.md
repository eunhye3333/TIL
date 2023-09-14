# 크롤링에서 가장 중요한 CSS 선택자
## CSS
+ 웹 사이트의 디자인을 적용하기 위한 언어
+ 글자 색 변경, 폰트 크기, 가로 세로 길이 변경

## CSS 선택자
+ 디자인을 변경할 HTML 태그를 선택하는 것 
+ HTML 태그를 선택한다는 점에서 크롤링에서도 사용 가능

## CSS 선택자의 종류
+ 태그 선택자 : 태그의 이름으로 선택  
  ```
  ex.
  <h1>제목</h1>
  선택자 : h1
  ```
+ id 선택자 : id(웹 사이트의 한 개의 태그에 별명을 줄 때 사용) 값으로 선택 (#)
  ```
  ex. 
  <div id="articleBody">본문</div>
  선택자 : #articleBody
  ```
+ class 선택자 : class(웹사이트 내 태그의 그룹에 별명을 줄 때 사용) 값으로 선택 (.)
  ```
  ex.
  <div class="info_group">뉴스 목록</div>
  선택자 : .info_group
  ```
+ 자식 선택자 : 보통 내가 원하는 태그에 별명이 없을 때 사용하며 바로 아래 있는 태그를 선택 (>)
  ```
  ex.
  <div class="logo_sports">
    <span>스포츠</span>
  </div>
  선택자 : .logo_sports > span
  ```

