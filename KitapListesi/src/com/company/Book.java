package com.company;

import java.util.Date;

public class Book {
    private int id;
    private String nameOfBook;
    private int pageNumber;
    private String authorName;
    private int dateOfRelease;

    public Book() {
    }

    public Book(int id, String nameOfBook, int pageNumber, String authorName, int dateOfRelease) {
        this.id = id;
        this.nameOfBook = nameOfBook;
        this.pageNumber = pageNumber;
        this.authorName = authorName;
        this.dateOfRelease = dateOfRelease;
    }

    public static Book[] books(){
        Book[] books = new Book[]{
                new Book(0, "ilk kitap", 250, "ilk yazar", 2013),
        new Book(1, "ikinci kitap", 124, "ikinci yazar", 2016),
        new Book(2, "üçüncü kitap", 654, "üçüncü yazar", 2003),
        new Book(3, "dördüncü kitap", 167, "dördüncü yazar", 204),
        new Book(4, "beşinci kitap", 320, "beşinci yazar", 2012),
        new Book(5, "altıncı kitap", 367, "altıncı yazar", 2015),
        new Book(6, "yedinci kitap", 836, "yedinci yazar", 2000),
        new Book(7, "sekinci kitap", 256, "sekinci yazar", 2001),
        new Book(8, "dokuzuncu kitap", 357, "dokuzuncu yazar", 2002),
        new Book(9, "onuncu kitap", 289, "onuncu yazar", 2007)
        };
        return books;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfBook() {
        return nameOfBook;
    }

    public void setNameOfBook(String nameOfBook) {
        this.nameOfBook = nameOfBook;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(int dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }
}
