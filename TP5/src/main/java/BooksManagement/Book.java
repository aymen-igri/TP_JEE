package BooksManagement;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String author;
    @Column
    private Double price;
    @Column
    private Integer discountPrice;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "book_categories",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories = new ArrayList<>();

    public Book (){}

    public Book (String name, String author, Double price, Integer discountPrice){
        this.name = name;
        this.author = author;
        this.price = price;
        this.discountPrice = discountPrice;
    }

    public Publisher getPublisher() {
        return this.publisher;
    }

    public List<Category> getCategories() {
        return this.categories;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public String getName() {
        return this.name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
