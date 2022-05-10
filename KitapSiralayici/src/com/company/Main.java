package com.company;

import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        // write your code here
        TreeSet<Book> sortByName = new TreeSet<>(new NameComparator());
        TreeSet<Book> sortByPage = new TreeSet<>(new PageComparator());

        sortByName.add(new Book("Yaşamak", 250));
        sortByName.add(new Book("Iletişim Donanımları", 190));
        sortByName.add(new Book("Kürk Mantolu Madonna", 180));
        sortByName.add(new Book("Ateşten Gömlek", 200));

        for (Book book : sortByName){
            System.out.println(book.getName());
        }

        sortByPage.add(new Book("Yaşamak", 250));
        sortByPage.add(new Book("Iletişim Donanımları", 190));
        sortByPage.add(new Book("Kürk Mantolu Madonna", 180));
        sortByPage.add(new Book("Ateşten Gömlek", 200));

        for(Book book: sortByPage){
            System.out.println(book.getNumberOfPage() + " ->" + book.getName());
        }
    }
}
