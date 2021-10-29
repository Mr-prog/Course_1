
import re
import io
def fSmile(smile, text):
    print(len(re.findall(smile, text)))
def corRep(text):
    code = re.sub(r'\b([^\W\d_]+)(\s+\1)+\b', r'\1', re.sub(r'\W+', ' ', text).strip(), flags=re.I)
    print(code)
def joke_3(text):  
    studs = text.split('\n')
    pattern = r"([А-Я])[а-я]+\s\1\.\1\.\sP339055"
    for i in studs:
        if not re.match(pattern, i):
            print(i)
print("first task:")
pattern = r":<{\|"
test1 = "Привет Привет, как дела? :<{|"
test2 = ":<{| :<{| - this is smiles smiles"
test3 = "Самое долгожданное событие в игровой игровой индустрии - international international 2021"
test4 = ":<{| :<{| rep :<{| :<{| "
test5 = "The best thing thing "
fSmile(pattern, test1)
fSmile(pattern, test2)
fSmile(pattern, test3)
fSmile(pattern, test4)
fSmile(pattern, test5)

print("second task:")
test1 = "Привет Привет, как дела?"
test2 = "Каждый Каждый человек имеет право на ошибку ошибку"
test3 = "Самое долгожданное событие в игровой игровой индустрии - international international 2021"
test4 = "Начинай каждый день правильно правильно"
test5 = "Что такое письма. Письма - это письма"
corRep(test1)
corRep(test2)
corRep(test3)
corRep(test4)
corRep(test5)

print("third task")
test1 = "Иванов А.А. P339055\nСмирнов А.Г. P339055\nНикитин Н.Н. P000000"

test2 = "Рогозин В.В. P332332\nХисматдинов С.Р. P339055\nДавинкин П.В. P339055"
test3 = "Максонов М.М. P339055\nМаринадов М.М. P339055\nПастюшкин П.П. P339055"
test4 = "Дабович Д.Д. P339055\nМаринадов М.М. P3355\nПастюшкин П.П. P3390"
test5 = "Камянецький Н.В. P339055\nОтчиславович О.О. P339055"
joke_3(test1)
joke_3(test2)
joke_3(test3)
joke_3(test4)
joke_3(test5)















