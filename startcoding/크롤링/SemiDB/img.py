import dload
from selenium import webdriver
driver = webdriver.Chrome('chromedriver')

# driver.get("http://www.naver.com")

from bs4 import BeautifulSoup
from selenium import webdriver
import time

driver = webdriver.Chrome('chromedriver') # 웹드라이버 파일의 경로
driver.get("http://www.yes24.com/24/Category/Display/001001019001")
time.sleep(5) # 5초 동안 페이지 로딩 기다리기

req = driver.page_source
# HTML을 BeautifulSoup이라는 라이브러리를 활용해 검색하기 용이한 상태로 만듦
# soup이라는 변수에 "파싱 용이해진 html"이 담긴 상태가 됨
# 이제 코딩을 통해 필요한 부분을 추출하면 된다.
soup = BeautifulSoup(req, 'html.parser')

# thumbnails = soup.select_one('#imgList > div:nth-child(1) > a > img') # 1개
# 필요한 것 : src 값, 이미지 주소
# thumbnails = soup.select_one('#imgList > div:nth-child(1) > a > img')['src']
# print(thumbnails)

# 여러 개 가지고 오기
# nth-child(1) 부분만 다름
thumbnails = soup.select('#category_layout > ul > li:nth-child(1) > div > p > span > span > a > img')
i = 1
for thumbnail in thumbnails:
    img = thumbnail['src']
    # print(img)
    dload.save(img, f'image/{i}.jpg')
    i += 1

# print(soup)

driver.quit() # 끝나면 닫아주기