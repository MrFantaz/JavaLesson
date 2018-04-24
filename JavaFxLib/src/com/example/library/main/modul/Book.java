package com.example.library.main.modul;


import java.time.LocalDate;

public class Book {
    private String title;
    private Author author;
    private LocalDate releaseDate;
    private String isbn;
    private String coverImage ;
    private String decprition;
    private long id;

    public Book(String title, Author author, LocalDate releaseDate, String isbn, String coverImage, String decprition, long id) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.isbn = isbn;
        this.coverImage = coverImage;
        this.decprition = decprition;
        this.id = id;
    }

    public Book(String title, Author author, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}
