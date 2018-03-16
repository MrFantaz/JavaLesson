package com.example.library.main.modul;


import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private LocalDate releaseDate;
    private String isbn;
    private String coverImage ;
    private String decprition;
    private long id;

    public Book(String title,String author, LocalDate releaseDate){
        this.author=author;
        this.title=title;
        this.releaseDate=releaseDate;

    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public String getDecprition() {
        return decprition;
    }

    public void setDecprition(String decprition) {
        this.decprition = decprition;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
