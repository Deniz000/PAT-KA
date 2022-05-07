package src;

import sun.security.util.ArrayUtil;

import java.util.Arrays;

public class MyList<T> {
    private int myArray[];
    private int tempArray[];
    private int newCapacity = 10;
    private static int nwIndex = 0;


    MyList() {
        myArray = new int[10];
        tempArray = new int[10];
    }

    MyList(int capacity){
        int mod = capacity % 10;
        int fark = 10 - mod;
        capacity = capacity + fark;
        newCapacity = capacity;

        myArray = new int[capacity];
    }

    public int size(){return myArray.length;}


    public void add(T data){
        if(nwIndex == newCapacity){
            newCapacity = newCapacity * 2;
            tempArray = new int[newCapacity];
            for (int i = 0; i < myArray.length; i++){
                tempArray[i] = myArray[i];
            }
            myArray = new int[newCapacity];
            for (int i = 0; i < myArray.length / 2; i++){
               myArray[i] = tempArray[i];
            }
        }

        String sayi =  data.toString();
        myArray[nwIndex] =  Integer.parseInt(sayi);
        System.out.println("Eklendi " + nwIndex + " " + myArray[nwIndex] );
        nwIndex++;
    }
    public int getCapacity(){
        return nwIndex;
    }
    public int get(int index){
        if (index < 0 || index > myArray.length) {
            return -1;
        }
        else{
            return myArray[index];
        }
    }
    public String set(int index, T data){

        if (index < 0 || index > myArray.length) {
            return null;
        }else{
            String dta = data.toString();
            myArray[index] = Integer.parseInt(dta);
            System.out.println(myArray[index] + " eklendi");
            return "";
        }

    }
    public void remove(int index){
        int[] tempNewArray = new int[nwIndex-1];
        int j = 0;
        for(int i = 0; i<nwIndex;i++){
            if(i == index){

                continue;
            }
            tempNewArray[j] = myArray[i];
            j++;
        }
        int k = 0;
        for (int i = 0; i < myArray.length; i++){
            myArray[i] = tempNewArray[k];
            k++;
            if (k == tempArray.length){
                break;
            }
            System.out.println(myArray[i]);
        }
    }

    public String toString(){
        String rtValue = "[";
        for(int i = 0; i < myArray.length; i++){
            rtValue += Integer.toString(myArray[i]);
            if(i != myArray.length - 1){
                rtValue += ",";
            }
        }
        return rtValue + "]";
    }

    public int indexOf(T data){
        return 0;
    }


}
