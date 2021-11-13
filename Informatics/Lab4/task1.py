import codecs
p = codecs.open("lab4.json", "r", "utf_8_sig")
o = codecs.open("lab4.xml", "w", "utf_8_sig")
arr_keys = []
main_key = []
count_in = -1
count_out = 0
chek = 1
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
            line_xml = line_xml.replace("\"" + key + "\"", "<" + key + ">")
            first_key.append(key)
        elif line[i] == "\"" and check_quotes == 3:
            while line[check] != "\"":
                param += line[check]
                check += 1
            line_xml = line_xml.replace(" : \"" + param + "\",", param + "</" + key + ">")
            line_xml = line_xml.replace(" : \"" + param + "\"", param + "</" + key + ">")
            key = ""
            param = ""
    if check_quotes == 2 and line.count("["):
        arr_keys.append(first_key[0])
        line_xml = line_xml.replace(": [", "", 1)
        line_xml = line_xml.replace("[", "", 1)
    if line.count("{") and count_out < 2:
        main_key.append(key)
        line_xml = line_xml.replace(": {", "", 1)
        line_xml = line_xml.replace("{", "", 1)
        count_out += 1
    elif line.count("{"):
        arr_keys.append(key)
        line_xml = line_xml.replace(": {", "<" + arr_keys[count_in] + ">", 1)
        line_xml = line_xml.replace("{", "<" + arr_keys[count_in] + ">", 1)
        count_out += 1
        chek += 1
    elif line.count("["):
        line_xml = line_xml.replace(": [", "", 1)
        count_out -= 1
        count_in += 1
    elif line.count("{"):
        line_xml = line_xml.replace(": {", "", 1)
        line_xml = line_xml.replace("{", "", 1)
        chek += 1
    if line.count("]"):
        line_xml = line_xml.replace("]", "", 1)
    if line.count("}") and chek == 1:
        line_xml = line_xml.replace("},", "</" + arr_keys[count_in] + ">", 1)
        line_xml = line_xml.replace("}", "</" + arr_keys[count_in] + ">", 1)
        chek -= 1
    elif line.count("}"):
        line_xml = line_xml.replace("},", "", 1)
        line_xml = line_xml.replace("}", "", 1)
    o.write(line_xml)
o.write("\n" + "\t" + "</" + main_key[1] + ">")
o.close()


