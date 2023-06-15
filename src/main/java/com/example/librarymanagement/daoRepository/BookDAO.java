package com.example.librarymanagement.daoRepository;

import com.example.librarymanagement.model.book.Book;
import com.example.librarymanagement.model.book.Publisher;
import com.example.librarymanagement.model.book.Subject;
import com.example.librarymanagement.model.book.Writer;
import com.example.librarymanagement.util.Enum.BookStatus;
import com.example.librarymanagement.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class BookDAO {

    private static BookDAO bookDAO;
    private EntityManager entity;

    private BookDAO() {
    }

    public static BookDAO getInstance() {
        if (Objects.isNull(bookDAO)) {
            bookDAO = new BookDAO();
        }
        return bookDAO;
    }


    //------------------------------ Book -------------------------//

    public List<Book> getAllBook() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select book from Book book", Book.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBookById(Long bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Book.class, bookId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Book getBookByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select book from Book book where Book.name like: name", Book.class).setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> getAllBookBySubject(Long subjectId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select book from Book book where Book.subject =: subject", Book.class).setParameter("subject", entity.find(Subject.class , subjectId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> getAllBookByWriter(Long writerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select book from Book book where Book.writer =: writer", Book.class).setParameter("writer", entity.find(Writer.class , writerId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> getAllBookByPublisher(Long publisherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select book from Book book where Book.publisher =: publisher", Book.class).setParameter("publisher", entity.find(Publisher.class , publisherId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Book> getAllBookByStatus(BookStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select book from Book book where Book.status =: status", Book.class).setParameter("status", status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Publisher -------------------------//

    public List<Publisher> getAllPublisher() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select publisher from Publisher publisher", Publisher.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Publisher getPublisherById(Long publisherId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Publisher.class, publisherId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Publisher getPublisherByName(String name) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select publisher from Publisher publisher where publisher.name like: name", Publisher.class).setParameter("name", name).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Publisher getPublisherByPublisherCode(Long publisherCode) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select publisher from Publisher publisher where publisher.publisherCode =: publisherCode", Publisher.class).setParameter("publisherCode", publisherCode).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Publisher> getAllPublisherByCountry(String country) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select publisher from Publisher publisher where publisher.country like: country", Publisher.class).setParameter("country", country).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Writer -------------------------//

    public List<Writer> getAllWriter() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select writer from Writer writer", Writer.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Writer getWriterById(Long writerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Writer.class, writerId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Writer> getAllWriterByFirstName(String firstName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select writer from Writer writer where writer.firstName like:firstName", Writer.class).setParameter("firstName", firstName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Writer> getAllWriterByLastName(String lastName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select writer from Writer writer where writer.lastName like:lastName", Writer.class).setParameter("lastName", lastName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Writer> getAllWriterByFirstNameAndLastName(String firstName, String lastName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select writer from Writer writer where writer.firstName like: firstName and writer.lastName like:lastName", Writer.class).setParameter("firstName", firstName).setParameter("lastName", lastName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Writer> getAllWriterByDegree(String degree) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select writer from Writer writer where writer.degree like:degree", Writer.class).setParameter("degree", degree).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Subject -------------------------//

    public List<Subject> getAllSubject() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select subject from Subject subject", Subject.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Subject getSubjectById(Long subjectId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Subject.class, subjectId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Subject getSubjectBySubject(String subject) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select subject from Subject subject where subject.subject=: subject", Subject.class).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
