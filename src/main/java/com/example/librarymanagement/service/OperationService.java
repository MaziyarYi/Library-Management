package com.example.librarymanagement.service;

import com.example.librarymanagement.model.book.Book;
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
import java.util.Date;
import java.util.Objects;

public class OperationService {

    private static OperationService operationService;
    private EntityManager entity;

    private OperationService(){
    }

    public static OperationService getInstance() {
        if (Objects.isNull(operationService)) {
            operationService = new OperationService();
        }
        return operationService;
    }

    //------------------------------ Borrow Request -------------------------//
    public Boolean createBorrowRequest(Long borrowerId , Long bookId , Date fromDate , Date toDate , RequestStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            BorrowRequest request = new BorrowRequest();
            request.setBorrower(entity.find(Member.class , borrowerId));
            request.setBook(entity.find(Book.class , bookId));
            request.setFromDate(fromDate);
            request.setToDate(toDate);
            request.setPeriod(Math.abs(toDate.getTime() - fromDate.getTime()));
            request.setStatus(status);
            entity.persist(request);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateBorrowRequest(Long id , Long bookId , Date fromDate , Date toDate , RequestStatus status){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            BorrowRequest request = entity.find(BorrowRequest.class , id);
            request.setBook(entity.find(Book.class , bookId));
            request.setFromDate(fromDate);
            request.setToDate(toDate);
            request.setPeriod(Math.abs(toDate.getTime() - fromDate.getTime()));
            request.setStatus(status);
            entity.persist(request);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteBorrowRequest(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(BorrowRequest.class , id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------ Donation Request -------------------------//
    public Boolean createDonationRequest(Long donatorId , Long bookId , RequestStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            DonationRequest request = new DonationRequest();
            request.setDonator(entity.find(Member.class , donatorId));
            request.setBook(entity.find(Book.class , bookId));
            request.setDonationDate(new Date());
            request.setStatus(status);
            entity.persist(request);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateDonationRequest(Long id ,  RequestStatus status){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            DonationRequest request = entity.find(DonationRequest.class , id);
            request.setStatus(status);
            entity.persist(request);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteDonationRequest(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(DonationRequest.class , id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------ Order Request -------------------------//

    public Boolean createOrderRequest(Long buyerId , Long bookId , RequestStatus status) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Order request = new Order();
            request.setBuyer(entity.find(Member.class , buyerId));
            request.setBook(entity.find(Book.class , bookId));
            request.setOrderDate(new Date());
            request.setStatus(status);
            entity.persist(request);
            entity.flush();
            entity.getTransaction().commit();
            createPayment(request.getId() , entity.find(Book.class , bookId).getPrice());
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateOrderRequest(Long id , Long bookId ,  RequestStatus status){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Order request = entity.find(Order.class , id);
            request.setBook(entity.find(Book.class , bookId));
            request.setStatus(status);
            entity.persist(request);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteOrderRequest(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Order.class , id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------ Payment -------------------------//

    public Boolean createPayment(Long orderId,Long price) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Payment payment = new Payment();
            payment.setOrder(entity.find(Order.class , orderId));
            payment.setStatus(PaymentStatus.Unpaid);
            payment.setPrice(price);
            payment.setPaymentDate(null);
            entity.persist(payment);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updatePayment(Long id , PaymentStatus status){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Payment payment = entity.find(Payment.class , id);
            payment.setStatus(status);
            payment.setPaymentDate(payment.isPaid() ? new Date() : null);
            entity.persist(payment);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deletePayment(Long id){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Payment.class , id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
