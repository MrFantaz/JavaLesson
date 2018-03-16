package com.example.library.main.modul;

public class Author {
    private long id;
    private String fullName;
    private String alias;
    private long birthDate;
 private static long idCounter=0;
    public Author(String fullName) {
        this.fullName = fullName;
        id=idCounter++;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
