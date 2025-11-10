package DBOperation;

import BooksManagement.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.ArrayList;
import java.util.List;

public class Creation {

    static EntityManagerFactory factory;
    static EntityManager entityManager;

    public static void main(String[] args){
        begin();
        create();
        end();
    }

    public static void create(){
        Publisher publisher = new Publisher("Ahmed", "Morocco");
        System.out.println("Publisher created: " + publisher);

        Author author = new Author("amine", "amine@bookmail.com");
        System.out.println("Author created: " + author);

        Book book = new Book("Java Programming", 29.99, 25);
        System.out.println("Book created: " + book);

        Category category1 = new Category("Programming");
        Category category2 = new Category("Learning");
        System.out.println("Categories created: " + category1 + ", " + category2);

        Review review1 = new Review("Great book for beginners!");
        Review review2 = new Review("Well explained concepts.");
        System.out.println("Reviews created: " + review1 + ", " + review2);
        review1.setBook(book);
        review2.setBook(book);

        book.setPublisher(publisher);

        book.setAuthor(author);

        book.getCategories().add(category1);
        book.getCategories().add(category2);

        entityManager.persist(publisher);
        entityManager.persist(author);
        entityManager.persist(book);
        entityManager.persist(category1);
        entityManager.persist(category2);
        entityManager.persist(review1);
        entityManager.persist(review2);
    }

    public static void begin(){
        factory = Persistence.createEntityManagerFactory("BookUnit");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public static void end(){
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }
}
