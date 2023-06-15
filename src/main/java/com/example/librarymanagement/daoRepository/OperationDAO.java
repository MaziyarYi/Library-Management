package com.example.librarymanagement.daoRepository;

import com.example.librarymanagement.model.book.Book;
import com.example.librarymanagement.model.book.Subject;
import com.example.librarymanagement.model.operation.BorrowRequest;
import com.example.librarymanagement.model.operation.DonationRequest;
import com.example.librarymanagement.model.operation.Order;
import com.example.librarymanagement.model.operation.Payment;
import com.example.librarymanagement.model.user.Member;
import com.example.librarymanagement.util.Enum.PaymentStatus;
import com.example.librarymanagement.util.Enum.RequestStatus;
import com.example.librarymanagement.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class OperationDAO {

    private static OperationDAO operationDAO;
    private EntityManager entity;

    private OperationDAO() {
    }

    public static OperationDAO getInstance() {
        if (Objects.isNull(operationDAO)) {
            operationDAO = new OperationDAO();
        }
        return operationDAO;
    }

    //------------------------------ Borrow Request -------------------------//

    public List<BorrowRequest> getAllBorrowRequest() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from BorrowRequest request", BorrowRequest.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public BorrowRequest getBorrowRequestById(Long requestId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(BorrowRequest.class, requestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BorrowRequest> getAllBorrowRequestByBorrower(Long borrowerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from BorrowRequest request where request.borrower =: borrower", BorrowRequest.class).setParameter("borrower", entity.find(Member.class , borrowerId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BorrowRequest> getAllBorrowRequestByBook(Long bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from BorrowRequest request where request.book =: book", BorrowRequest.class).setParameter("book", entity.find(Book.class , bookId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<BorrowRequest> getAllBorrowRequestByStatus(RequestStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from BorrowRequest request where request.status =: status", BorrowRequest.class).setParameter("status", status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Donation Request -------------------------//

    public List<DonationRequest> getAllDonationRequest() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from DonationRequest request", DonationRequest.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public DonationRequest getDonationRequestById(Long requestId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(DonationRequest.class, requestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DonationRequest> getAllDonationRequestByDonator(Long donatorId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from DonationRequest request where request.donator =: donator", DonationRequest.class).setParameter("donator", entity.find(Member.class , donatorId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DonationRequest> getAllDonationRequestByBook(Long bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from DonationRequest request where request.book =: book", DonationRequest.class).setParameter("book", entity.find(Book.class , bookId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<DonationRequest> getAllDonationRequestByStatus(RequestStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from DonationRequest request where request.status =: status", DonationRequest.class).setParameter("status", status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Order -------------------------//

    public List<Order> getAllOrder() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from Order request", Order.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Order getOrderById(Long requestId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Order.class, requestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> getAllOrderByBuyer(Long buyerId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from Order request where request.buyer =: buyer", Order.class).setParameter("buyer", entity.find(Member.class , buyerId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> getAllOrderByBook(Long bookId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from Order request where request.book =: book", Order.class).setParameter("book", entity.find(Book.class , bookId)).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Order> getAllOrderByStatus(RequestStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select request from Order request where request.status =: status", Order.class).setParameter("status", status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Payment -------------------------//

    public List<Payment> getAllPayment() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select payment from Payment payment", Payment.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Payment getPaymentById(Long paymentId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Payment.class, paymentId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Payment getPaymentByOrder(Long orderId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select payment from Payment payment where payment.order =: order", Payment.class).setParameter("order", entity.find(Order.class , orderId)).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Payment> getAllPaymentByStatus(PaymentStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select payment from Payment payment where payment.status =: status", Payment.class).setParameter("status", status).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
