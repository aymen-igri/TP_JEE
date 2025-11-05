package BooksManagement;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String country;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();

    public Publisher (){}

    public  Publisher (String name, String country){
        this.name = name;
        this.country = country;
    }

    public List<Book> getBooks(){
        return this.books;
    }

    public String getName() {
        return this.name;
    }
}
