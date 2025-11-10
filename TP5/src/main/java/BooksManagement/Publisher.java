package BooksManagement;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
public class Publisher extends Personne{
    @Column
    private String country;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private List<Book> books = new ArrayList<>();

    public Publisher (){}

    public  Publisher (String name, String country){
        super(name);
        this.country = country;
    }

    public List<Book> getBooks(){
        return this.books;
    }

    public String getName() {
        return this.getName();
    }
}
