package tech.ada.onlinelibrary.dto;

import tech.ada.onlinelibrary.domain.enums.Genre;

import java.time.Year;
import java.util.Objects;

public class BookPostRequest {

    private String title;
    private String author;
    private Genre genre;
    private String publisher;
    private Year publicationYear;

    public BookPostRequest(String title, String author, Genre genre, String publisher, Year publicationYear) {
        this.title = Objects.requireNonNull(title);
        this.author = Objects.requireNonNull(author);
        this.genre = Objects.requireNonNull(genre);
        this.publisher = Objects.requireNonNull(publisher);
        this.publicationYear = Objects.requireNonNull(publicationYear);
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

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Year getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(Year publicationYear) {
        this.publicationYear = publicationYear;
    }
}