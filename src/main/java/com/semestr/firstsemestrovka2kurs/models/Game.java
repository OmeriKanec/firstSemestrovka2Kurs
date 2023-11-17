package com.semestr.firstsemestrovka2kurs.models;

import java.time.LocalDate;

public class Game {
    private long id;
    private String name;
    private String genre;
    private LocalDate dateOfRelise;
    private String developer;
    private String publisher;
    private long creatorid;

    public Game(long id, String name, String genre, LocalDate dateOfRelise, String developer, String publisher, long creatorid) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.dateOfRelise = dateOfRelise;
        this.developer = developer;
        this.publisher = publisher;
        this.creatorid = creatorid;
    }

    public Game(String name, String genre, LocalDate dateOfRelise, String developer, String publisher, long creatorid) {
        this.name = name;
        this.genre = genre;
        this.dateOfRelise = dateOfRelise;
        this.developer = developer;
        this.publisher = publisher;
        this.creatorid = creatorid;
    }

    public Game(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfRelise() {
        return dateOfRelise;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public long getCreatorid() {
        return creatorid;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfRelise(LocalDate dateOfRelise) {
        this.dateOfRelise = dateOfRelise;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setCreatorid(long creatorid) {
        this.creatorid = creatorid;
    }
}
