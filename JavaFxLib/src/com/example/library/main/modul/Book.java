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
    private int volume;

    public Book(String title, Author author, LocalDate releaseDate, String isbn, String coverImage, String decprition,int volume, long id) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
        this.isbn = isbn;
        this.coverImage = coverImage;
        this.decprition = decprition;
        this.volume = volume;
        this.id = id;
    }

    public Book(String title, Author author, LocalDate releaseDate) {
        this.title = title;
        this.author = author;
        this.releaseDate = releaseDate;
    }
}
