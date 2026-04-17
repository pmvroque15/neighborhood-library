package com.pluralsight;

public class Book {
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOUtTo;

    static void main() {
    }

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOUtTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOUtTo = checkedOUtTo;
    }

    static void checkOut(String name) {

    }
    static void checkIn() {

    }

    }

