package BooksManagement;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author extends Personne{

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author", orphanRemoval = true)
    private List<Book> books = new ArrayList<>();

    @Column
    private  String email;

    public List<Book> getBooks(){
        return this.books;
    }

    public Author(){}
    public Author(String name, String email){
        super(name);
        this.email = email;
    }


}
