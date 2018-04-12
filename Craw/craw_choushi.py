import requests
from bs4 import BeautifulSoup
url = 'https://www.qiushibaike.com/text/'
header = 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57.0'
headers = {"User-Agent": header}
q = requests.get(url, headers=headers)
print('\r\n')
soup = BeautifulSoup(q.text,"html.parser")
kk = soup.select('div.col1 > div')
print(type(kk))
for i in kk:
    text = i.select(' a > div > span ')[0].text
    print(text)
