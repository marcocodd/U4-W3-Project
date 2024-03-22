package marco.dao;

import marco.entities.CatalogElement;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class CatalogElementsDao {

    private final EntityManager em;

    public CatalogElementsDao(EntityManager em) {
        this.em = em;
    }

    public void save(CatalogElement element) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(element);
        transaction.commit();
        System.out.println("Elemento " + element.getTitle() + " è stato salvato correttamente");

    }

    public CatalogElement searchByIsbn(long isbn) {
        CatalogElement element = em.find(CatalogElement.class, isbn);
        return element;

    }

    public void deleteElementByIsbn(long isbn) {
        CatalogElement element = this.searchByIsbn(isbn);
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.remove(element);
        transaction.commit();
        System.out.println("Elemento con isbn: " + element.getIsbn() + " è stato eliminato");
    }

    public List<CatalogElement> searchByYear(int year) {
        TypedQuery<CatalogElement> query = em.createNamedQuery("searchByYear", CatalogElement.class);
        query.setParameter("year", year);
        return query.getResultList();
    }


}
