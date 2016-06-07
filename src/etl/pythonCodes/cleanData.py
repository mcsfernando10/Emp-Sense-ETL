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
for x in xrange(0, length-1):
    attr = data['attibutes'][x]['attrName']
    matchingField = data['attibutes'][x]['matchingField']
    mappings[attr] = matchingField
    
table2 = etl.fieldmap(dataTable, mappings)


etl.tocsv(table2,'src/etl/outputs/cleansed.csv')