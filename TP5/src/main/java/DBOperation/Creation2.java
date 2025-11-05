package DBOperation;

import BooksManagement.Category;
import BooksManagement.Publisher;
import BooksManagement.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Creation2 {

    static EntityManagerFactory factory;
    static EntityManager entityManager;

    public static void main(String[] args){
        begin();
        //findBooksByCat(1L);
        //findBookByPublisher(1L);
        //deleteBook(1L);
        //updateBookPrice(2L, 39.99);
        testFetchTypes(2L);
        end();
    }

    public static void findBooksByCat(Long catId){
        Category category = entityManager.find(Category.class, catId);
        System.out.println("Books in category" + category.getName() + ":");
        category.getBooks().forEach(b ->
            System.out.println("-" + b.getName())
        );
    }

    public static void findBookByPublisher(Long publisherId){
        Publisher publisher = entityManager.find(Publisher.class, publisherId);

        System.out.println("Books published by '" + publisher.getName() + "':");
        publisher.getBooks().forEach(book ->
                System.out.println("- " + book.getName())
        );
    }

    public static void deleteBook(Long bookId){
        Book book = entityManager.find(Book.class, bookId);

        if(book != null){
            System.out.println("Deleting book: " + book.getName());
            System.out.println("This book has " + book.getReviews().size() + " reviews");

            entityManager.remove(book);

            System.out.println("Book deleted successfully");
        }
    }

    public static void updateBookPrice(Long bookId, double newPrice) {
        Book book = entityManager.find(Book.class, bookId);

        if (book != null) {
            System.out.println("Old price: " + book.getPrice());
            book.setPrice(newPrice);
            System.out.println("New price: " + book.getPrice());
        }
    }

    public static void testFetchTypes(Long bookId){
        System.out.println("\n=== Testing EAGER Loading ===");
        entityManager.clear();

        Book book = entityManager.find(Book.class, bookId);
        System.out.println("Book loaded: " + book.getName());
        System.out.println("Publisher (EAGER): " + book.getPublisher().getName());

        System.out.println("\n=== Testing LAZY Loading ===");
        entityManager.clear();

        Book book2 = entityManager.find(Book.class, bookId);
        System.out.println("Book loaded");
        System.out.println("Accessing reviews now...");
        System.out.println("Number of reviews (LAZY): " + book2.getReviews().size());
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
