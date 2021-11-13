from json2xml import json2xml
import codecs
p = codecs.open("lab4.json", "r", "utf_8_sig")
o = codecs.open("lab4_2.xml", "w", "utf_8_sig")
o.write(json2xml.Json2xml(p).to_xml())