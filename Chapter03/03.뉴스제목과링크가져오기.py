from urllib import response
import requests
from bs4 import BeautifulSoup

response = requests.get("https://search.naver.com/search.naver?where=news&sm=tab_jum&query=%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90") # 한글 부분은 인코딩되어 표시
html = response.text # 웹사이트 전체의 정보

soup = BeautifulSoup(html, 'html.parser')
links = soup.select(".news_tit") # 결과는 리스트로 저장됨
# print(links)

for link in links:
    title = link.text # 태그 안에 텍스트 요소를 가져옴
    url = link.attrs['href'] # href의 속성 값을 가져온다
    print(title, url)