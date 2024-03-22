package marco;

import marco.dao.BookDao;
import marco.dao.CatalogElementsDao;
import marco.dao.LoanDao;
import marco.dao.UserDao;
import marco.entities.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;


public class Application {
    //reminder
    // LocalDateof.of (anno mese giorno)
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("bibliotecapersistence");


    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();
        CatalogElementsDao catalogDao = new CatalogElementsDao(em);
        BookDao bookDao = new BookDao(em);
        UserDao userDao = new UserDao(em);
        LoanDao loanDao = new LoanDao(em);
        System.out.println("Hello World!");

//        aggiunto qualche libro, riviste, utenti, prestiti

        Book signoreDegliAnelli = new Book(123456, "Il Signore degli Anelli", 1954, 1170, "J.R.R. Tolkien", "Fantasy");
        Book libroAcaso = new Book(654321, "Libro a caso", 1949, 328, "George Orwell", "Distopia");
        Book ilNomeDellaRosa = new Book(252525, "Il nome della rosa", 1980, 536, "Umberto Eco", "Mistero");
        Book javaOdioEamore = new Book(555555, "Java odio e amore", 2005, 1000, "Umberto Eco", "Commedia");
        Book javaOdioEamore2 = new Book(6666, "Java odio e amore", 2005, 1000, "Fantozzi", "Commedia");


        catalogDao.save(signoreDegliAnelli);
        catalogDao.save(libroAcaso);
        catalogDao.save(ilNomeDellaRosa);
        catalogDao.save(javaOdioEamore);
        catalogDao.save(javaOdioEamore2);

        Magazine nationalGeographic = new Magazine(123456789, "National Geographic", 1888, 150, MagazinePeriodicity.Monthly);
        Magazine time = new Magazine(789012345, "Time", 1923, 100, MagazinePeriodicity.WEEKLY);
        Magazine multiplayer = new Magazine(987654321, "Multiplayer", 1993, 80, MagazinePeriodicity.SEMIANNUAL);
        Magazine geografia = new Magazine(54321, "Geografia", 1993, 80, MagazinePeriodicity.WEEKLY);
        Magazine javaOdioEamore3 = new Magazine(666666, "Java odio e amore", 1993, 80, MagazinePeriodicity.WEEKLY);

        catalogDao.save(nationalGeographic);
        catalogDao.save(time);
        catalogDao.save(multiplayer);
        catalogDao.save(geografia);
        catalogDao.save(javaOdioEamore3);

        User marco = new User("Marco", "Rossi", LocalDate.of(1995, 3, 15));
        User gino = new User("Gino", "Bianchi", LocalDate.of(1980, 5, 20));


        userDao.save(marco);
        userDao.save(gino);

        //inserire così utente e il libro magazine immagino non sia corretto, potrei assegnare ad una variabile l'oggetto tramite findId... ho velocizzato
        //devo rivedere tutta questa settimana.

        Loan prestitoMarco = new Loan(marco, signoreDegliAnelli, LocalDate.of(2024, 3, 22), LocalDate.of(2024, 3, 31));
        Loan prestitoMarco2 = new Loan(marco, libroAcaso, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 4, 10));
        Loan prestitoMarco3 = new Loan(marco, multiplayer, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 3, 15));


        Loan prestitoGino = new Loan(gino, javaOdioEamore, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 4, 10));
        Loan prestitoGino2 = new Loan(gino, geografia, LocalDate.of(2024, 3, 10), LocalDate.of(2024, 5, 22));


        loanDao.save(prestitoMarco);
        loanDao.save(prestitoMarco2);
        loanDao.save(prestitoMarco3);
        loanDao.save(prestitoGino);
        loanDao.save(prestitoGino2);


        CatalogElement elementoTrovato = catalogDao.searchByIsbn(123456);
        System.out.println("Elemento trovato tramite isbn:");
        System.out.println(elementoTrovato);
        System.out.println(" ");

        catalogDao.deleteElementByIsbn(252525);

        System.out.println("Elementi trovati per anno: ");
        catalogDao.searchByYear(1993).forEach(System.out::println);
        System.out.println(" ");
        System.out.println("Libri trovati per autore: ");
        bookDao.searchByAuthor("Umberto Eco").forEach(System.out::println);
        System.out.println(" ");
        System.out.println("Elementi trovati per titolo o titolo parziale");
        catalogDao.searchByPartialTitleOrTitle("java").forEach(System.out::println);
        System.out.println(" ");
        System.out.println("ricerca elementi catalogo prestati per cardNumber");
        loanDao.searchLoansByUserCardNumber(18).forEach(System.out::println);
        loanDao.searchLoansByUserCardNumber(19).forEach(System.out::println);
        System.out.println(" ");
        System.out.println("Prestiti scaduti:");
        loanDao.searchNoReturnedLoansByDate().forEach(System.out::println);

    }
}
