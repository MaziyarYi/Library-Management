package com.example.librarymanagement.service;

import com.example.librarymanagement.model.book.Book;
import com.example.librarymanagement.model.book.Publisher;
import com.example.librarymanagement.model.book.Subject;
import com.example.librarymanagement.model.book.Writer;
import com.example.librarymanagement.util.Enum.BookStatus;
import com.example.librarymanagement.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.Objects;

public class BookService {

    private static BookService bookService;
    private EntityManager entity;

    private BookService(){
    }

    public static BookService getInstance() {
        if (Objects.isNull(bookService)) {
            bookService = new BookService();
        }
        return bookService;
    }

    //---------------------- Subject -----------------------//

    public Boolean createSubject(String subject) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Subject sub = new Subject();
            sub.setSubject(subject);
            entity.persist(sub);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateSubject(Long id , String subject){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Subject sub = entity.find(Subject.class , id);
            sub.setSubject(subject);
            entity.persist(sub);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteSubject(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Subject.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //---------------------- Publisher -----------------------//

    public Boolean createPublisher(String name , String country , Long publisherCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Publisher publisher = new Publisher();
            publisher.setName(name);
            publisher.setCountry(country);
            publisher.setPublisherCode(publisherCode);
            entity.persist(publisher);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updatePublisher(Long id , String name , String country , Long publisherCode){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Publisher publisher = entity.find(Publisher.class , id);
            publisher.setName(name);
            publisher.setCountry(country);
            publisher.setPublisherCode(publisherCode);
            entity.persist(publisher);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deletePublisher(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Publisher.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //---------------------- Writer -----------------------//

    public Boolean createWriter(String firstName , String lastName , String degree) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Writer writer = new Writer();
            writer.setFirstName(firstName);
            writer.setLastName(lastName);
            writer.setDegree(degree);
            entity.persist(writer);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateWriter(Long id , String firstName , String lastName , String degree){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Writer writer = entity.find(Writer.class , id);
            writer.setFirstName(firstName);
            writer.setLastName(lastName);
            writer.setDegree(degree);
            entity.persist(writer);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteWriter(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Writer.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //---------------------- Book -----------------------//

    public Boolean createBook(String name , Long subjectId , Long writerId , Long publisherId , Long price) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Book book = new Book();
            book.setName(name);
            book.setSubject(entity.find(Subject.class , subjectId));
            book.setWriter(entity.find(Writer.class , writerId));
            book.setPublisher(entity.find(Publisher.class , publisherId));
            book.setPrice(price);
            book.setStatus(BookStatus.Available);
            entity.persist(book);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateBook(Long id , String name , Long subjectId , Long writerId , Long publisherId , Long price , BookStatus status){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Book book = entity.find(Book.class , id);
            book.setName(name);
            book.setSubject(entity.find(Subject.class , subjectId));
            book.setWriter(entity.find(Writer.class , writerId));
            book.setPublisher(entity.find(Publisher.class , publisherId));
            book.setPrice(price);
            book.setStatus(status);
            entity.persist(book);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteBook(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Book.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
