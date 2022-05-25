package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here

        List<Book> bookList = new ArrayList<>();
        for (Book book:Book.books()) {
            bookList.add(book);
        }

        bookList.stream().map(book -> book.getNameOfBook() + " KİTABININ YAZARI => "
                        + book.getAuthorName()).forEach(i -> System.out.println(i));

        bookList.stream().filter(book -> book.getPageNumber() > 100)
                .forEach(i -> System.out.println("sayfa sayısı: " + i.getPageNumber()
                + " " + i.getNameOfBook()));

        Comparator<Double> doubleComparator = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return 0;
            }
        }
    }
}
