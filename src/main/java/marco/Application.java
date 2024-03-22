package marco;

import marco.dao.BookDao;
import marco.dao.CatalogElementsDao;
import marco.entities.Book;
import marco.entities.CatalogElement;
import marco.entities.Magazine;
import marco.entities.MagazinePeriodicity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecapersistence");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogElementsDao catalogDao = new CatalogElementsDao(em);
        BookDao bookDao = new BookDao(em);
        System.out.println("Hello World!");

        Book libro1 = new Book(123456, "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy");
        Book libro2 = new Book(654321, "1984", 1949, 328, "George Orwell", "Distopia");
        Book libro3 = new Book(252525, "Il nome della rosa", 1980, 536, "Umberto Eco", "Mistero");
        Book libro4 = new Book(555555, "Java odio e amore", 2005, 1000, "Umberto Eco", "Commedia");


        catalogDao.save(libro1);
        catalogDao.save(libro2);
        catalogDao.save(libro3);
        catalogDao.save(libro4);

        Magazine rivista1 = new Magazine(123456789, "National Geographic", 1888, 150, MagazinePeriodicity.Monthly);
        Magazine rivista2 = new Magazine(789012345, "Time", 1923, 100, MagazinePeriodicity.WEEKLY);
        Magazine rivista3 = new Magazine(987654321, "Multiplayer", 1993, 80, MagazinePeriodicity.SEMIANNUAL);
        Magazine rivista4 = new Magazine(5555555, "Geografia", 1993, 80, MagazinePeriodicity.WEEKLY);
        catalogDao.save(rivista1);
        catalogDao.save(rivista2);
        catalogDao.save(rivista3);
        catalogDao.save(rivista4);

        CatalogElement elementoTrovato = catalogDao.searchByIsbn(123456);
        System.out.println("Elemento trovato tramite isbn:");
        System.out.println(elementoTrovato);

        //catalogdao.deleteElementByIsbn(252525); 
        System.out.println("Elementi trovati per anno: ");
        catalogDao.searchByYear(1993).forEach(System.out::println);

        System.out.println("Libri trovati per autore: ");
        bookDao.searchByAuthor("Umberto Eco").forEach(System.out::println);


    }
}
