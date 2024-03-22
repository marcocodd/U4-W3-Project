package marco;

import marco.dao.CatalogElementsDao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Application {

    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecapersistence");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogElementsDao catalogdao = new CatalogElementsDao(em);
        System.out.println("Hello World!");

//        Book libro1 = new Book(123456, "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy");
//        Book libro2 = new Book(654321, "1984", 1949, 328, "George Orwell", "Distopia");
//        Book libro3 = new Book(252525, "Il nome della rosa", 1980, 536, "Umberto Eco", "Mistero");
//
//        catalogdao.save(libro1);
//        catalogdao.save(libro2);
//        catalogdao.save(libro3);
//
//        Magazine rivista1 = new Magazine(123456789, "National Geographic", 1888, 150, MagazinePeriodicity.Monthly);
//        Magazine rivista2 = new Magazine(789012345, "Time", 1923, 100, MagazinePeriodicity.WEEKLY);
//        Magazine rivista3 = new Magazine(987654321, "Multiplayer", 1993, 80, MagazinePeriodicity.SEMIANNUAL);
//
//        catalogdao.save(rivista1);
//        catalogdao.save(rivista2);
//        catalogdao.save(rivista3);

//        CatalogElement elementoTrovato = catalogdao.searchByIsbn(123456);
//        System.out.println("Elemento trovato tramite isbn:");
//        System.out.println(elementoTrovato);
//
//        catalogdao.deleteElementByIsbn(252525);

    }
}
