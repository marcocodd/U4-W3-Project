package marco.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prestiti")
public class Loan {
    @Id
    @JoinColumn(name = "prestito_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "cardNumber")
    private User user;
    @OneToOne
    @JoinColumn(name = "catalog_element_isbn", referencedColumnName = "isbn")
    private CatalogElement catalogElementPrestato;

    @JoinColumn(name = "data_inizio_prestito")
    private LocalDate loanDate;
    @JoinColumn(name = "data_prevista_fine_prestito")
    private LocalDate returnLoanDate;

    @JoinColumn(name = "data_restituzione")
    private LocalDate endLoanDate;


    public Loan() {
    }

    public Loan(User user, CatalogElement catalogElementPrestato, LocalDate loanDate, LocalDate endLoanDate) {
        this.user = user;
        this.catalogElementPrestato = catalogElementPrestato;
        this.loanDate = loanDate;
        this.returnLoanDate = loanDate.plusDays(30);
        this.endLoanDate = endLoanDate;
    }

    public long getId() {
        return id;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CatalogElement getCatalogElementPrestato() {
        return catalogElementPrestato;
    }

    public void setCatalogElementPrestato(CatalogElement catalogElementPrestato) {
        this.catalogElementPrestato = catalogElementPrestato;
    }


    public LocalDate getLoanDate() {
        return loanDate;
    }


    public LocalDate getReturnLoanDate() {
        return returnLoanDate;
    }


    public LocalDate getEndLoanDate() {
        return endLoanDate;
    }

    public void setEndLoanDate(LocalDate endLoanDate) {
        this.endLoanDate = endLoanDate;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", catalogElementPrestato=" + catalogElementPrestato +
                ", loanDate=" + loanDate +
                ", returnLoanDate=" + returnLoanDate +
                ", endLoanDate=" + endLoanDate +
                '}';
    }
}
