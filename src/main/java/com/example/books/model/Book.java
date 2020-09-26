package com.example.books.model;

public class Book {
    private String title;
    private String descriprion;
    private String Category;
    private Author[] authors;
    private int imageResourceId;

    public Book(String title, String descriprion, String category, Author[] authors, int imageResourceId) {
        this.title = title;
        this.descriprion = descriprion;
        Category = category;
        this.authors = authors;
        this.imageResourceId = imageResourceId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public String getCategory() {
        return Category;
    }

    public Author[] getAuthors() {
        return authors;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public String toString() {
        return title;
    }
}
