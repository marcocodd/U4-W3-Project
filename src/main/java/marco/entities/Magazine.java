package marco.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "riviste")
public class Magazine extends CatalogElement {
    private MagazinePeriodicity periodicity;

    public Magazine(long isbn, String title, int published, int pages, MagazinePeriodicity periodicity) {
        super(isbn, title, published, pages);
        this.periodicity = periodicity;
    }

    public Magazine() {
    }

    public MagazinePeriodicity getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(MagazinePeriodicity periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "periodicity=" + periodicity +
                ", isbn=" + isbn +
                ", title='" + title + '\'' +
                '}';
    }
}
