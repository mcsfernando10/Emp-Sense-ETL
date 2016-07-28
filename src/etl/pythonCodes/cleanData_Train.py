# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import petl as etl
import sys
import json
from collections import OrderedDict

#filePath = sys.argv[1]
#dataTable = etl.fromcsv(filePath)

#read JSON file
with open('src/etl/outputs/attributes.json') as data_file:    
    data = json.load(data_file)

filePath = data['filePath']
dataTable = etl.fromcsv(filePath)

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
#add rules to clean the table - reversed for give the priority for top attributes
for x in reversed(range(length)):
    attr = data['attibutes'][x]['attrName']
    rules = data['attibutes'][x]['rules']
    rulesListSize = len(rules)
    for y in range(rulesListSize):
        if rules[y] == "Remove Null Value Rows":
            cleansedTable = etl.select(cleansedTable, attr, lambda v: v != '')
        if rules[y] == "Remove Duplicates":
            cleansedTable = etl.aggregate(cleansedTable, attr)
        if rules[y] == "Sort":
            cleansedTable = etl.mergesort(cleansedTable, key=attr)
        if rules[y] == "Number Validation":
            cleansedTable = etl.select(cleansedTable, attr)
        if rules[y] == "Fill Missing Values":
            cleansedTable = etl.filldown(cleansedTable, attr)

etl.tocsv(cleansedTable,'src/etl/outputs/cleansed.csv')

#Create rawData Table
dataTable = cleansedTable
rawDataTable = cleansedTable

mappings = OrderedDict()

#mapping attributes
# go through each column (c = table)
for i in range(length):
    #get unique values for each column
    uniqueValues = etl.aggregate(dataTable,dataTable[0][i])
    #create unique value for each column
    uniqueValArr = []
    k = 0
    for iterating_var in uniqueValues:
        if (k != 0):
            uniqueValArr.append(iterating_var[0])
        k += 1
    #create unique value map (assign value for each unique value)
    uniqueValMap = {}
    for n in range(len(uniqueValArr)):
        uniqueValMap[uniqueValArr[n]] = n
    mappings[dataTable[0][i]] = dataTable[0][i],uniqueValMap

reasonUniqueValues = etl.aggregate(dataTable,dataTable[0][15])

reasonUniqueArr = []
for i in range(len(reasonUniqueValues)):
	if ( i!= 0 ):
            reasonUniqueArr.append([i-1,reasonUniqueValues[i][0]])

etl.tocsv(reasonUniqueArr,'src/etl/outputs/reasons.csv')

mappedRawDataTable = etl.fieldmap(rawDataTable, mappings)

etl.tocsv(mappedRawDataTable,'src/etl/outputs/rawData.csv')