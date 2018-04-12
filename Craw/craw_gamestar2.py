#!/usr/bin/env python3
# -*- coding: utf-8 -*-

import  requests, bs4, os

print('gamersky...')

for page in range(1, 40):
    if page == 1:
        signin_url = 'http://www.gamersky.com/ent/201706/913251.shtml'
    else:
        signin_url = 'http://www.gamersky.com/ent/201706/913251_' + str(page) + '.shtml'

    user_agent = 'Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.98 Safari/537.36'

    headers = {"User-Agent": user_agent}

    signin_req = requests.post(signin_url,
                               headers=headers,
                               )
    soup = bs4.BeautifulSoup(signin_req.text)

    imgList = soup.select('img[src]')

    for i in imgList:
        print(i.get('src'))

    if imgList == []:
        print('Could not find comic image')
    else:
        for i in range(len(imgList)):
            imgUrl = imgList[i].get('src')
            # Download the image
            print('Downloading iamge %s...' % (imgUrl))
            imgRes = requests.get(imgUrl)
            print(imgRes.raise_for_status())

            imageFile = open(os.path.join('gamersky', os.path.basename(imgUrl)), 'wb')

            for chunk in imgRes.iter_content(10000000):
                imageFile.write(chunk)

            imageFile.close()

