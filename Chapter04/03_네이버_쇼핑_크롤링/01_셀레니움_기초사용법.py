from selenium import webdriver
from selenium.webdriver.common.keys import Keys
import time

# 브라우저 생성
browser = webdriver.Chrome(r'E:\develop\startcoding\Chapter04\chromedriver.exe')
# mac의 경우 exe 안 붙여도 됨

# 웹사이트 열기
browser.get('https://www.naver.com')
browser.implicitly_wait(10) # 로딩이 끝날 때까지 10초까지는 기다려 줌

# 쇼핑 메뉴 클릭
browser.find_element_by_css_selector('a.nav.shop').click() # a.nav.shop a 태그 안의 nav, shop 클래스를 가진 것
# find_element_by_css_selector : css 선택자로 태그를 선택하는 명령어 
# click() : 클릭을 실행하는 명령어

# 페이지 이동이 되기 전 검색창을 클릭하면 오류가 날 수 있기 때문에 기다려줌
time.sleep(2)

# 검색창 클릭
search = browser.find_element_by_css_selector('input.co_srh_input._input')
search.click()

# 검색어 입력
search.send_keys('아이폰 13')
search.send_keys(Keys.ENTER) # 엔터 치기

