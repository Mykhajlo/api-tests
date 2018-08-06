package com.adyax.api.automation;

public class Book {
    private   String isbn;
    private  String title;
    private   String subtitle;
    private   String author;
    private String published;
    private String publisher;
    private  String pages;
    private String description;
    private String website;

    @Override
    public String toString() {
        return "Book [isbn =" + isbn + ", title = " + title + ",subtitle ="+ subtitle + ", author = " + author +  ", published = " + published + ", publisher = " + publisher + ", pages = " + pages + ", description = " + description + ", website = " + website +",  ]";
    }

}
