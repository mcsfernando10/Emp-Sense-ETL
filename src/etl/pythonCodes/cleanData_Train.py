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
rawDataTable = cleansedTable

mappings = OrderedDict()
#mapping attributes
mappings['Employee ID'] = 'Employee ID'
mappings['Employee Name'] = 'Employee Name'
mappings['Age'] = 'Age'
mappings['Gender'] = 'Gender', {'Male': 0, 'Female': 1}
mappings['Marital Status'] = 'Marital Status', {'Single': 0, 'Married': 1}
mappings['Having Degree'] = 'Having Degree', {'No': 0, 'Yes': 1}
mappings['Job Role'] = 'Job Role', {'': 0, 'IT': 1,'IT Trainee': 2, 'Software Engineering Intern': 3,
    'IT Officer - Intern': 4, 'Developer Intern': 5, 'System Admin': 6,'Software Architecturer': 7,
    'Tech Lead': 8,'System Analyst': 9, 'QA Mananger': 10,'Software Engineer': 11,'IT Manager': 12,
    'IT App Man': 13,'IT Project Leader': 14,'HR Manager':15,
    'Finance Manager':16,'Accountant':17,'Assistant Accountant':18}
mappings['Department'] = 'Department', {'IT': 0, 'QA': 1,'Planning': 2, 'HR': 3,
    'Financial': 4}
mappings['Work From'] = 'Work From'
mappings['Work To'] = 'Work To'
mappings['Tenure'] = 'Tenure'
mappings['Salary'] = 'Salary'
mappings['No of Leaves'] = 'No of Leaves'
mappings['Distance'] = 'Distance'
mappings['No of Dependents'] = 'No of Dependents'
mappings['Reason to Leave'] = 'Reason to Leave', {'Due to distance': 0, 'Due to salary problems': 1,
    'Health Problem': 2, 'Due to Higher Education': 3, 'Left the country': 4,
    'Personal reason':5}
mappings['Churn'] = 'Churn'

mappedRawDataTable = etl.fieldmap(rawDataTable, mappings)

etl.tocsv(mappedRawDataTable,'src/etl/outputs/rawData.csv')