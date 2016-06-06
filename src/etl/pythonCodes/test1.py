'''from numpy import genfromtxt
my_data = genfromtxt('/home/suren/Desktop/data.csv', delimiter=',')
print my_data[:,0]
for i, val in enumerate(my_data):
    print i, val
#for (x,y), value in numpy.ndenumerate(my_data):
#    print x,y'''
'''from xml.dom import minidom
xmldoc = minidom.parse('/home/suren/Desktop/data.xml')
itemlist = xmldoc.getElementsByTagName('Table1')
print(itemlist[0].tagName)'''
import numpy as num
test = num.array([["Great", 2], [3, 4], [5, 6]])
print test[:,0]
