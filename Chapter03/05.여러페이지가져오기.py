from urllib import response
import requests
from bs4 import BeautifulSoup
import pyautogui

keyword = pyautogui.prompt("검색어를 입력하세요") 

# 몇 페이지까지 크롤링할지 입력받기
lastPage = pyautogui.prompt("마지막 페이지 번호를 입력해 주세요") # 해당 데이터는 문자열 형태이기 때문에 int로 바꿔 줘야 함
pageNum = 1
# 1~3 페이지 크롤링
for i in range(1, int(lastPage) * 10, 10):
    print(f"{pageNum}페이지입니다.============") # 페이지 확인
    response = requests.get(f"https://search.naver.com/search.naver?where=news&sm=tab_jum&query={keyword}&start={i}") 
    html = response.text 

    soup = BeautifulSoup(html, 'html.parser')
    links = soup.select(".news_tit") 

    for link in links:
        title = link.text 
        url = link.attrs['href'] 
        print(title, url)
    pageNum = pageNum + 1