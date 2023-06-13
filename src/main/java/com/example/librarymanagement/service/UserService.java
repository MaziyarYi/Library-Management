package com.example.librarymanagement.service;

import com.example.librarymanagement.model.user.Member;
import com.example.librarymanagement.model.user.Staff;
import com.example.librarymanagement.model.user.User;
import com.example.librarymanagement.model.user.UserAccount;
import com.example.librarymanagement.util.Enum.Gender;
import com.example.librarymanagement.util.Enum.Role;
import com.example.librarymanagement.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.Objects;

public class UserService {

    private static UserService userService;
    private EntityManager entity;

    private UserService(){
    }

    public static UserService getInstance() {
        if (Objects.isNull(userService)) {
            userService = new UserService();
        }
        return userService;
    }

    //------------------------------ Member -------------------------//

    public Boolean createMember(String firstName , String lastName , String nationalId , String memberId , int age , Gender gender , String phoneNumber , String address) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Member member = new Member();
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setNationalId(nationalId);
            member.setMemberId(memberId);
            member.setAge(age);
            member.setGender(gender);
            member.setPhoneNumber(phoneNumber);
            member.setAddress(address);
            entity.persist(member);
            entity.flush();
            entity.getTransaction().commit();
            createUserAccount(member.getId() , memberId , nationalId , Role.Customer);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateMember(Long id , String firstName , String lastName , String nationalId , String memberId , int age , Gender gender , String phoneNumber , String address){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Member member = entity.find(Member.class , id);
            member.setFirstName(firstName);
            member.setLastName(lastName);
            member.setNationalId(nationalId);
            member.setMemberId(memberId);
            member.setAge(age);
            member.setGender(gender);
            member.setPhoneNumber(phoneNumber);
            member.setAddress(address);
            entity.persist(member);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteMember(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Member.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------ Staff -------------------------//

    public Boolean createStaff(String firstName , String lastName , String nationalId , String staffId , Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Staff staff = new Staff();
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setNationalId(nationalId);
            staff.setStaffId(staffId);
            entity.persist(staff);
            entity.flush();
            entity.getTransaction().commit();
            createUserAccount(staff.getId() , staffId , nationalId , role);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateStaff(Long id , String firstName , String lastName , String nationalId , String staffId){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            Staff staff = entity.find(Staff.class , id);
            staff.setFirstName(firstName);
            staff.setLastName(lastName);
            staff.setNationalId(nationalId);
            staff.setStaffId(staffId);
            entity.persist(staff);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteStaff(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(Staff.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    //------------------------------ User Account -------------------------//

    public Boolean createUserAccount(Long userId ,String username , String password , Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            UserAccount account = new UserAccount();
            account.setUsername(username);
            account.setPassword(password);
            account.setRole(role);
            account.setCreateDate(new Date());
            entity.persist(account);
            entity.flush();
            User user = entity.find(User.class , userId);
            user.setUserAccount(account);
            entity.persist(user);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean updateUserAccount(Long id , String username , String password , Role role){
        try (Session session = HibernateUtil.getSessionFactory().openSession()){
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            UserAccount account = entity.find(UserAccount.class , id);
            account.setUsername(username);
            account.setPassword(password);
            account.setRole(role);
            entity.persist(account);
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean deleteUserAccount(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            entity.remove(entity.find(UserAccount.class, id));
            entity.flush();
            entity.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
