package marco.dao;

import marco.entities.Book;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookDao {
    private final EntityManager em;

    public BookDao(EntityManager em) {
        this.em = em;
    }

    public List<Book> searchByAuthor(String author) {
        TypedQuery<Book> query = em.createNamedQuery("searchByAuthor", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }
}
