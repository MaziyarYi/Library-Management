package com.example.librarymanagement.daoRepository;

import com.example.librarymanagement.model.user.Member;
import com.example.librarymanagement.model.user.Staff;
import com.example.librarymanagement.model.user.User;
import com.example.librarymanagement.model.user.UserAccount;
import com.example.librarymanagement.util.Enum.Gender;
import com.example.librarymanagement.util.Enum.Role;
import com.example.librarymanagement.util.HibernateUtil;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Objects;

public class UserDAO {

    private static UserDAO userDAO;
    private EntityManager entity;

    private UserDAO() {
    }

    public static UserDAO getInstance() {
        if (Objects.isNull(userDAO)) {
            userDAO = new UserDAO();
        }
        return userDAO;
    }

    //------------------------------ UserAccount -------------------------//

    public List<UserAccount> getAllUserAccount() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();

            return entity.createQuery("select user from UserAccount user", UserAccount.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserAccount getUserAccountById(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(UserAccount.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<UserAccount> getAllUserAccountByRole(Role role) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();

            return entity.createQuery("select user from UserAccount user where user.role =: role", UserAccount.class).setParameter("role", role).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public UserAccount getUserAccountByUserName(String username) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from UserAccount user where user.username like:username", UserAccount.class).setParameter("username", username).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    //------------------------------ User -------------------------//

    public List<User> getAllUser() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from User user", User.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserById(Long userId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUserByFirstName(String firstName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from User user where user.firstName like:firstName", User.class).setParameter("firstName", firstName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUserByLastName(String lastName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from User user where user.lastName like:lastName", User.class).setParameter("lastName", lastName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<User> getAllUserByFirstNameAndLastName(String firstName, String lastName) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from User user where user.firstName like: firstName and user.lastName like:lastName", User.class).setParameter("firstName", firstName).setParameter("lastName", lastName).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByNationalId(String nationalId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from User user where user.nationalId=:nationalId", User.class).setParameter("nationalId", nationalId).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public User getUserByUserAccount(Long accountId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select user from User user where user.userAccount=:account", User.class).setParameter("account", entity.find(UserAccount.class, accountId)).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //------------------------------ Member -------------------------//

    public List<Member> getAllMember() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();

            return entity.createQuery("select m from Member m", Member.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Member getMemberById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Member.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Member getMemberByMemberId(Long memberId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select m from Member m where m.memberId=:memberId", Member.class).setParameter("memberId", memberId).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Member> getAllMemberByAge(int age) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select m from Member m where m.age=:age", Member.class).setParameter("age", age).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Member> getAllMemberByGender(Gender gender) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select m from Member m where m.gender=:gender", Member.class).setParameter("gender", gender).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<Member> getAllMemberByGenderAndAge(Gender gender, int age) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select m from Member m where m.gender=:gender and m.age=:age", Member.class).setParameter("gender", gender).setParameter("age", age).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //------------------------------ Staff -------------------------//

    public List<Staff> getAllStaff() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select s from Staff s", Staff.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Staff getStaffById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.find(Staff.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Member getStaffByStaffId(Long staffId) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            entity = session.getEntityManagerFactory().createEntityManager();
            entity.getTransaction().begin();
            return entity.createQuery("select s from Staff s where s.staffId=:staffId", Member.class).setParameter("staffId", staffId).getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
