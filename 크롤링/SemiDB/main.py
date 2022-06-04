import dload
import time
import os
from openpyxl import Workbook
from bs4 import BeautifulSoup
from selenium import webdriver
from selenium.common.exceptions import NoSuchElementException

driver = webdriver.Chrome(executable_path='C:/dev/chromedriver.exe')

catNums = ["01", "13", "15", "05", "19", "33", "11", "42", "27"]

# file = open('title.txt', 'a')
num = 100

os.mkdir("image")

wb = Workbook()
ws1 = wb.active
ws1.title = "book"
ws1.append(["BOOK_TITLE", "CATEGORY_NO", "AUTHOR", "PUBLISHER", "CONTENT", "RELEASE_DATE", "IMG"])

for catNum in catNums:
    driver.get("http://www.kyobobook.co.kr/categoryRenewal/categoryMain.laf?perPage=20&mallGb=KOR&linkClass="+catNum+"&menuCode=002")
    # time.sleep(5)

    req = driver.page_source
    soup = BeautifulSoup(req, 'html.parser')

    thumbnails = soup.select('#prd_list_type1 > li > div > div.info_area > div.cover_wrap > div > a > span > img')
    # names = soup.select('#category_layout > ul > li > div > div.goods_info > div.goods_name > a')
    names = soup.select('#prd_list_type1 > li.id_detailli')


    # file.write(str(num) + "=")
    n = 1
    for i in range(len(thumbnails)):
        time.sleep(2)
        try:
            img = thumbnails[i]['src']
            # print(img)

            title = names[i].select_one('div > div.info_area > div.detail > div.title > a > strong').text
            author = names[i].select_one('div > div.info_area > div.detail > div.pub_info > span.author').text
            pub = names[i].select_one('div > div.info_area > div.detail > div.pub_info > span:nth-child(2)').text
            relDate = names[i].select_one('div > div.info_area > div.detail > div.pub_info > span:nth-child(3)').text
            relDate2 = relDate.replace('"', '').strip()[0:10]
            imgName = title.replace('.', '').replace(':', '').replace('?', '').replace('/', '').replace('*', '').replace('<', '').replace('>', '')
            imgName2 = str(num) + "_" + str(i) + "_" + imgName + ".jpg"
            print(title, author, pub)
            # print(author)
            # print(pub)
            # if i == 0:
            #     file.write(title)
            # else:
            #     file.write("/" + title)
            dload.save(img, f'image/{num}_{i}_{imgName}.jpg')
            # imgSrc = "image/" + str(num) + "_" + str(i) + "_" + imgName + ".jpg"


            driver.find_element_by_xpath("//*[@id='prd_list_type1']/li[" + str(n) + "]/div/div[1]/div[2]/div[1]/a").click()
            # time.sleep(5)
            try:
                content = driver.find_element_by_xpath('//*[@id="container"]/div[5]/div[1]/div[3]/div[4]').text
                # print(content)
            except NoSuchElementException:
                content = driver.find_element_by_xpath('//*[@id="container"]/div[5]/div[1]/div[2]/div[4]').text
            driver.back()
            # print(n)
            ws1.append([title, num, author, pub, content, relDate2, imgName2])
            n += 2
        except AttributeError as e:
            print("error")

    # file.write("\n")
    num += 100


driver.quit()
wb.save(filename='book.xlsx')
# file.close()
