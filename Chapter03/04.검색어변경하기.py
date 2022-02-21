from urllib import response
import requests
from bs4 import BeautifulSoup
import pyautogui

# keyword = input("검색어를 입력하세요 >>> ") # 파이썬 기본 내장 함수 input 사용
keyword = pyautogui.prompt("검색어를 입력하세요") # pyautogui 사용

# response = requests.get("https://search.naver.com/search.naver?where=news&sm=tab_jum&query=" + keyword) 

# f-string 문자열 포맷팅 사용 : 변수와 문자열이 자연스럽게 이어짐
response = requests.get(f"https://search.naver.com/search.naver?where=news&sm=tab_jum&query={keyword}") 
html = response.text 

soup = BeautifulSoup(html, 'html.parser')
links = soup.select(".news_tit") 

for link in links:
    title = link.text 
    url = link.attrs['href'] 
    print(title, url)