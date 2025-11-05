package BooksManagement;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String comment;

    @ManyToOne
    @JoinColumn(name= "book_id")
    private Book book;

    public Review(){}

    public Review(String comment){
        this.comment = comment;
    }

    public Book getBook() {
        return this.book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
