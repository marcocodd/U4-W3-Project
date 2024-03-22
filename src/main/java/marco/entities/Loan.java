package marco.entities;

import javax.persistence.*;

@Entity
@Table(name = "prestiti")
public class Loan {
    @Id
    @JoinColumn(name = "prestito_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @ManyToOne
    @JoinColumn(name = "utente_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "catalog_element_isbn")
    private CatalogElement catalogElementPrestato;

    public Loan(long id, User user, CatalogElement catalogElementPrestato) {
        this.id = id;
        this.user = user;
        this.catalogElementPrestato = catalogElementPrestato;
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

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", user=" + user +
                ", catalogElementPrestato=" + catalogElementPrestato +
                '}';
    }
}
