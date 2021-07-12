package com.nevette.bookstore.dtos;

public class BookDTO {

    private Long isbn;
    private String title;
    private String author;
    private Integer releaseYear;
    private Float price;

    public BookDTO(Long isbn, String title, String author, Integer releaseYear, Float price){
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.price = price;
    }

    public Long getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle() {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public Float getPrice() {
        return price;
    }
}
