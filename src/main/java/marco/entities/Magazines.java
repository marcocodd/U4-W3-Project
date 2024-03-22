package marco.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Magazines extends CatalogElement {
    private MagazinePeriodicity periodicity;

    public Magazines(long isbn, String title, int published, int pages, MagazinePeriodicity periodicity) {
        super(isbn, title, published, pages);
        this.periodicity = periodicity;
    }

    public Magazines() {
    }
}