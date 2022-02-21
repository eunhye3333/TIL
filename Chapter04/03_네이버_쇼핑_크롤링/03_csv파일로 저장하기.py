from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time
import csv

# 브라우저 생성
browser = webdriver.Chrome(r'E:\develop\startcoding\Chapter04\chromedriver.exe')

# 웹사이트 열기
browser.get('https://www.naver.com')
browser.implicitly_wait(10) 

# 쇼핑 메뉴 클릭
browser.find_element_by_css_selector('a.nav.shop').click()
time.sleep(2)

# 검색창 클릭
search = browser.find_element_by_css_selector('input.co_srh_input._input')
search.click()

# 검색어 입력
search.send_keys('아이폰 13')
search.send_keys(Keys.ENTER) # 엔터 치기

# 스크롤 전 높이
before_h = browser.execute_script("return window.scrollY")

# 무한 스크롤 : 반복문
while True:
    browser.find_element_by_css_selector("body").send_keys(Keys.END)
    time.sleep(2)
    after_h = browser.execute_script("return window.scrollY")

    if after_h == before_h:
        break
    before_h = after_h

# 파일 생성
f = open(r"E:\develop\startcoding\Chapter04\03_네이버_쇼핑_크롤링\data.csv", 'w', encoding='CP949', newline='') # 경로, 쓰기 모드, 인코딩, 줄바꿈 문자 제거(윈도우)
csvWriter = csv.writer(f)

items = browser.find_elements_by_css_selector(".basicList_info_area__17Xyo")

for item in items:
    name = item.find_element_by_css_selector(".basicList_title__3P9Q7").text
    try:
        price = item.find_element_by_css_selector(".price_num__2WUXn").text
    except:
        price = "판매 중단" 

    link = item.find_element_by_css_selector(".basicList_title__3P9Q7 > a").get_attribute('href')

    print(name, price, link)
    
    # 데이터 쓰기
    csvWriter.writerow([name, price, link]) # 한 행 추가

# 파일 닫기
f.close()