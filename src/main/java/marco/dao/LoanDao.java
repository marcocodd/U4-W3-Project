package marco.dao;

import marco.entities.Loan;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoanDao {
    private final EntityManager em;

    public LoanDao(EntityManager em) {
        this.em = em;
    }

    public void save(Loan loan) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(loan);
        transaction.commit();
        System.out.println("Il prestito di: " + loan.getUser().getName() + "con id: " + loan.getId() + " è stato salvato correttamente");

    }

    public List<Loan> searchLoansByUserCardNumber(long cardNumber) {
        TypedQuery<Loan> query = em.createQuery("SELECT l FROM Loan l WHERE l.user.cardNumber = :cardNumber", Loan.class);
        query.setParameter("cardNumber", cardNumber);
        return query.getResultList();

    }
}
