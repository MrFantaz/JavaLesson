package com.example.library.main.modul;


import java.time.LocalDate;

public class Author {
    private long id;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;
    private String alias;
    private LocalDate birthDay;
    private LocalDate dateGone;
    private static long idCounter;

    public Author(String fullName) {
        this.fullName = fullName;
        id=idCounter++;
    }
    public  Author(String fullName,String occupation,LocalDate birthDay,LocalDate dateGone ){
        this.fullName = fullName;
        this.alias = occupation;
        this.birthDay=birthDay;
        this.dateGone = dateGone;
    }
    public Author(long id,String firstName,String middleName,String lastName,String alias,LocalDate birthDay,LocalDate dateGone){
        this.id=id;
        this.firstName=firstName;
        this.middleName=middleName;
        this.lastName=lastName;
        this.alias=alias;
        this.birthDay=birthDay;
        this.dateGone=dateGone;
    }

    @Override
    public String toString(){
        return fullName;
    }
    public String getFullName() {
        return fullName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAlias() {
        return alias;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public LocalDate getDateGone() {
        return dateGone;
    }

    public static long getIdCounter() {
        return idCounter;
    }
}
