package net.codejava.booksmanager;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {
    private Integer bookId;
    private String title;
    private String author;
    private float price;

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getBookId(){
        return this.bookId;
    }

    public void setBookId(Integer bookId){
        this.bookId = bookId;
    }

    @Column(name = "author")
    public String getAuthor(){
        return this.author;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    @Column(name = "title")
    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    @Column(name = "price")
    public float getPrice(){
        return this.price;
    }

    public void setPrice(float price){
        this.price = price;
    }
}
