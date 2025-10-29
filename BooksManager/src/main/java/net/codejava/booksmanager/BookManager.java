package net.codejava.booksmanager;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;

public class BookManager {
    static EntityManagerFactory factory;
    static EntityManager entityManager;

    public static void main(String[] args) {
        begin();
        //create();
        //update();
        //find();
        //remove();
        //query();
        //addElements();
        addPers();
        end();
    }

    public static void begin(){
        factory = Persistence.createEntityManagerFactory("BookUnit");
        entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();
    }

    public static void create(){
        Book book = new Book();
        book.setTitle("book 1");
        book.setAuthor("author 1");
        book.setPrice(10.9f);
        entityManager.persist(book);
    }

    public static void update(){
        Book book2 = new Book();
        book2.setBookId(1);
        book2.setTitle("book 2");
        book2.setAuthor("author 2");
        book2.setPrice(11.9f);
        entityManager.merge(book2);
    }

    public static void find(){
        Integer bookId = 1;
        Book book = entityManager.find(Book.class, bookId);

        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());
    }

    public static void remove(){
        Integer bookId = 1;
        Book book = entityManager.getReference(Book.class, bookId);
        entityManager.remove(book);
    }

    public static void query(){
        String jpql = "SELECT b FROM Book b WHERE b.price<20";
        Query q = entityManager.createQuery(jpql);
        List<Book> list = q.getResultList();
        for (Book b : list){
            System.out.println(b.getTitle() + " - " + b.getPrice());
        }
    }

    public static void addElements(){
        for (int i=0; i<5; i++){
            Book book = new Book();
            book.setTitle("book " + (i+2));
            book.setAuthor("author " + (i+2));
            book.setPrice(10.0f + (i+50));
            entityManager.persist(book);
        }
    }

    public static void addPers(){
        String jpql = "SELECT b FROM Book b WHERE b.price>=50";
        Query q = entityManager.createQuery(jpql);
        List<Book> list = q.getResultList();
        for (Book b : list){
            b.setPrice(b.getPrice() + (b.getPrice()*0.05f));
            entityManager.merge(b);
        }

    }

    public static void end(){
        entityManager.getTransaction().commit();
        entityManager.close();
        factory.close();
    }

}
