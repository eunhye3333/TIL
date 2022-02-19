# 내가 원하는 태그를 선택하자 : beautifulsoup
## beautifulsoup
+ HTML 분석을 위한 파이썬 라이브러리

## beautifulsoup 설치
```
pip install beautifulsoup4
```

## beautifulsoup 사용법
```
import requests
from bs4 import Beatuifulsoup

response = requests.get("원하는 사이트 주소")
html = response.text

soup = Beautifulsoup(html 코드, html 번역 선생님)
word = soup.select_one(선택할 부분)
print(word.text)
```
