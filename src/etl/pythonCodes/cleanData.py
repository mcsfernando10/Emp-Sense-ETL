# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import petl as etl
import sys
import json
from collections import OrderedDict

filePath = sys.argv[1]
dataTable = etl.fromcsv(filePath)

#read JSON file
with open('src/etl/outputs/attributes.json') as data_file:    
    data = json.load(data_file)

mappings = OrderedDict()
#length of attribtues map
length = len(data['attibutes'])
#map Attributes and clean them
for x in range(length):
    attr = data['attibutes'][x]['attrName']
    matchingField = data['attibutes'][x]['matchingField']
    mappings[attr] = matchingField
    
mappedTable = etl.fieldmap(dataTable, mappings)

cleansedTable = mappedTable
#add rules to clean the table
for x in range(length):
    attr = data['attibutes'][x]['attrName']
    rules = data['attibutes'][x]['rules']
    rulesListSize = len(rules)
    for y in range(rulesListSize):
        if rules[y] == "Remove Null Value Rows":
            cleansedTable = etl.select(cleansedTable, attr, lambda v: v != '')

etl.tocsv(cleansedTable,'src/etl/outputs/cleansed.csv')