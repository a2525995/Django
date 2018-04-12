import os
from bs4 import BeautifulSoup
import requests

header = 'Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:57.0) Gecko/20100101 Firefox/57.0'
headers = {"User-Agent":header}
url = 'http://www.gamersky.com/ent/201706/913251.shtml'
signin_req = requests.post(url,
                           headers=headers,
                           )
b = 0
dir_name = '/home/CORPUSERS/xp023799/Downloads/gamesky'
if not os.path.exists(dir_name):
    os.mkdir(dir_name)
os.chdir(dir_name)
for i in range(40):
    if(url=='http://www.gamersky.com/ent/201706/913251.shtml'):
        url='http://www.gamersky.com/ent/201706/913251_'+str(i)+'.shtml'
    for i in soup.find_all('lay-img'):
        src = i['src']
        print('Downloading %s\n' % src)
        with open(str(b), 'wb') as f
        for chunk in requests.get(src).iter_content(chunk_size=1000000000):
            f.write(chunk)
            f.flush()
        b += 1
        f.close()



