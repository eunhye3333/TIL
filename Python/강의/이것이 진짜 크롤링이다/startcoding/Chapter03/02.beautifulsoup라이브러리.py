import requests
from bs4 import BeautifulSoup

# naver 서버에 대화를 시도
response = requests.get("http://www.naver.com")

# naver에서 html을 줌
html = response.text

# html 번역 선생님으로 수프 만듦
soup = BeautifulSoup(html, 'html.parser')

# soup.select : 여러 개의 태그를 선택하고 싶은 경우
# soup.select_one : 하나의 태그를 선택하고 싶은 경우

# id 값이 NM_set_home_btn인 놈 한 개를 찾아냄
word = soup.select_one('#NM_set_home_btn') # id는 앞에 #을 붙여야 함 : css 선택자

# print(word)
print(word.text) # 텍스트만 가지고 오고 싶은 경우
