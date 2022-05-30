import requests
from bs4 import BeautifulSoup
import openpyxl
import time
import csv
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By

browser = webdriver.Chrome(r'C:\Users\ABC\Desktop\test\chromedriver.exe')

browser.get('https://www.bigdata-transportation.kr/frn/prdt/search')
browser.implicitly_wait(10)

browser.execute_script("window.scrollTo(0, 900)")
time.sleep(2)
elem = browser.find_element_by_css_selector('#filter-instt-list > li:nth-child(8) > div > label').click()

time.sleep(2)
pages = browser.find_elements(By.CSS_SELECTOR, '#prdt-pagination > ul > li')
print(pages)
f = open(r"C:\Users\ABC\Desktop\test\data.csv", 'w', encoding='CP949', newline='') 
csvWriter = csv.writer(f)

for page in pages:
    browser.execute_script("window.scrollTo(0,document.body.scrollHeight)")
    time.sleep(2)

    page.send_keys(Keys.ENTER)
    time.sleep(2)

    browser.execute_script('window.scrollTo(0,0)')
    time.sleep(1)

    links = browser.find_elements(By.CSS_SELECTOR, '#prdt-list > li')

    print("okokook")
    for link in links:
        gotothe = link.find_element_by_css_selector('a').get_attribute("href")
        browser.execute_script('window.open("https://google.com");')
        time.sleep(1)

        browser.switch_to.window(browser.window_handles[-1])  #새로 연 탭으로 이동
        browser.get(gotothe)
        time.sleep(1)

        title = browser.find_element_by_css_selector('#prdt-summary > div.prd-info > table > tbody > tr:nth-child(1) > td > div > strong').text
        cost = browser.find_element_by_css_selector('#prdt-summary > div.prd-info > table > tbody > tr:nth-child(2) > td > span').text
        category = browser.find_element_by_css_selector('#prdt-summary > div.prd-info > table > tbody > tr:nth-child(3) > td > span').text
        keywords = browser.find_elements(By.CSS_SELECTOR, '#prdt-summary > div.prd-info > table > tbody > tr:nth-child(5) > td > div > span')
        try:
            content = browser.find_element_by_css_selector('#prdt-detail-expl > p:nth-child(1)').text
        except:
            content = browser.find_element_by_css_selector('#prdt-detail-expl').text
        

        k = ""
        for keyword in keywords:
            k += keyword.text + '\n'

        csvWriter.writerow([title, cost, category, k, content])

        browser.close()
        browser.switch_to.window(browser.window_handles[-1])
        time.sleep(1)


# 파일 닫기
f.close()
