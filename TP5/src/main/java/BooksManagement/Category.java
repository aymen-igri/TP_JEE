package BooksManagement;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return this.books;
    }

    public Category(){}

    public Category(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
