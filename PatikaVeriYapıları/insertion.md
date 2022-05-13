# Proje 1
## **[22,27,16,2,18,6]** -> **Insertion Sort**
Yukarı verilen dizinin sort türüne göre aşamalarını yazınız.
* ***Aşamalar*:**
```
- 1- [22]
- 2- [22,27]
- 3- [16, 22, 27]
- 4- [2, 16, 22, 27]
- 5- [2, 16, 18, 22, 27]
- 6- [2, 6, 16, 18, 22, 27]
```
Big-O gösterimini yazınız.
```
Her adımda bir eleman için yer tahsis ediyorum. İlk eleman için: n kere yer bakıyorum, ikinci eleman için: n- 1,  üçüncü eleman için: n- 2 ...
n.(n-1).(n-2)...(n-(n-1)) formülü = (n.(n-1)/2) olduğundan (n^2 - n)/2  çıkar. Big-O notasyonunda en büyük katsayılı n kabul edildiğinden big-O notasyonu:

O(n^2)
```
***Time Complexity:***

Average case: Aradığımız sayının ortada olması
```
O(n^2) (yukarıdaki durum / best ile worst ortalaması)
```
Worst case: Aradığımız sayının sonda olması
```
O(n^2)
```
Best case: Aradığımız sayının dizinin en - başında olması.
```
O(n) (dizi sıralıdır ve her eleman birer kez kontrol edilir)
```

Dizi sıralandıktan sonra 18 sayısı hangi case kapsamına girer? Yazınız.
```
Average case kapsamına girer
```

## **[7,3,5,8,2,9,4,15,6]** dizisinin **Insertion Sort**'a göre ilk 4 adımını yazınız.
* ***Aşamalar*:**
```
- 1- [7]
- 2- [3, 7]
- 3- [3, 5, 7]
- 4- [3, 5, 7, 8]
- 5- [2, 3, 5, 7, 8]
```