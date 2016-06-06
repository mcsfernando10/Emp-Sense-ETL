# To change this license header, choose License Headers in Project Properties.
# To change this template file, choose Tools | Templates
# and open the template in the editor.
import petl as etl

cols = [[0, 1, 2], ['a', 'b', 'c']]
tbl = etl.fromcolumns(cols)
return tbl

#table1 = etl.fromcsv('/home/suren/Desktop/test.csv')
#headers = etl.head(table1)
#print(table1)
'''
#output =look(table1)

#print(output)
headers = head(table1)
print(header(table1))

# convert table to sepecific data type

Converted=convert(table1,{'Salary': float,
                       'Work_Hours': int,
                       'amountOfAutometedWorkEstimate': int,
                       'amountOfManualWorkEstimate' : int,
                       'Leave_Per_Month': int,
                       'experiance': int,
                       'Age':int
                       });

#data clensing
groupC=select(Converted,lambda rec : rec.jobCategory=="C" and rec.Salary >7500.00 and rec.Salary< 35000.00)
groupB=select(Converted,lambda rec : rec.jobCategory=="B" and rec.Salary >15000.00 and rec.Salary< 50000.00 and (rec.Educational_Level=="Master's Degree" or rec.Educational_Level=="Bsc" or rec.Educational_Level=="Diploma") )
groupA=select(Converted,lambda rec : rec.jobCategory=="A" and rec.Salary >75000.00 and rec.Salary< 100000.00 and (rec.Educational_Level=="Master's Degree" or rec.Educational_Level=="Bsc")  )

tableFinal=cat(groupC,groupB,groupA)

tocsv(tableFinal,'clenced.csv')
out =look(tableFinal)
print(out)
print ("Data Cleansing done....!")'''