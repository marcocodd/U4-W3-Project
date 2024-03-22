package marco.dao;

import marco.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserDao {
    private final EntityManager em;

    public UserDao(EntityManager em) {
        this.em = em;
    }

    public void save(User user) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(user);
        transaction.commit();
        System.out.println("Utente " + user.getName() + " è stato salvato correttamente");

    }
}
