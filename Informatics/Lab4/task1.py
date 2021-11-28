import codecs
p = codecs.open("lab4.json", "r", "utf_8_sig")
o = codecs.open("lab4.xml", "w", "utf_8_sig")
o.write("<DAY>")
endScp = 1
arrKeys = []
countKeys = -1
specialKey = ""
startArr = False
startArrScp = False
for line in p:
    line_xml = line
    check_quotes = 0
    first_key = []
    key = ""
    param = ""
    for i in range (len(line)):
        check = i + 1
        if line[i] == "\"":
            if check_quotes == 4:
                check_quotes = 0
            else:
                check_quotes += 1
        if line[i] == "\"" and check_quotes == 1:
            while line[check] != "\"":
                key += line[check]
                check += 1
            specialKey = key
            line_xml = line_xml.replace("\"" + key + "\"", "<" + key + ">")
        elif line[i] == "\"" and check_quotes == 3:
            while line[check] != "\"":
                param += line[check]
                check += 1
            line_xml = line_xml.replace(" : \"" + param + "\",", param + "</" + key + ">")
            line_xml = line_xml.replace(" : \"" + param + "\"", param + "</" + key + ">")
            key = ""
            param = ""

    if endScp == 1 and line_xml.count("{"):
        line_xml = line_xml.replace("{", "", 1)
        endScp -= 1
    if line.count("["):
        startArr = True
        arrKeys.append(specialKey)
        countKeys += 1
        line_xml = line_xml.replace("<" + specialKey + ">", "", 1)
    if startArr:

        line_xml = line_xml.replace("{", "<"+arrKeys[countKeys]+">",1)
        line_xml = line_xml.replace("}", "</" + arrKeys[countKeys] + ">", 1)

        if line.count("]"):
            startArr = False
            countKeys -= 1
            print(arrKeys)
            startArrScp = False
    elif line_xml.count("{") and (not startArr):
        line_xml = line_xml.replace("{", "", 1)
        arrKeys.append(specialKey)
        countKeys += 1
    elif line_xml.count("}"):
        try:
            line_xml = line_xml.replace("}", "</"+arrKeys[countKeys]+">",1)
        except:
            pass
        countKeys -= 1
    if countKeys == -1:
        arrKeys = []
    line_xml = line_xml.replace(">,", ">")
    line_xml = line_xml.replace(">: [", ">")
    line_xml = line_xml.replace(">[", ">")
    line_xml = line_xml.replace(">:[", ">")
    line_xml = line_xml.replace(">:", ">")
    line_xml = line_xml.replace(">]", ">")
    line_xml = line_xml.replace("}", "")
    line_xml = line_xml.replace(":[", "", 1)
    o.write(line_xml)

o.write("</DAY>")
o.close()


