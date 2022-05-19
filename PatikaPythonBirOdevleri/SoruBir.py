"""
1- Bir listeyi düzleştiren (flatten) fonksiyon yazın. Elemanları birden çok katmanlı listelerden ([[3],2] gibi) oluşabileceği gibi, non-scalar verilerden de oluşabilir. Örnek olarak:
input: [[1,'a',['cat'],2],[[[3]],'dog'],4,5]

output: [1,'a','cat',2,3,'dog',4,5]
"""

liste = [[1,'a',['cat'],2],[[[3]],'dog'],4,5]

yeni =[]

def flatten(num):
    for i in num:
        if isinstance(i, list): 
            flatten(i)
        else:
            yeni.append(i)

flatten(liste)
print(yeni)