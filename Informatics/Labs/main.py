from urllib.request import urlopen
filedata = urlopen('https://itmo.ru/ru/schedule/0/P3113/schedule.htm')
datatowrite = filedata.read()
with open("D:\ITMO\Course_1\Informatics\Labs\cum.htm", 'wb') as f:
    f.write(datatowrite)
