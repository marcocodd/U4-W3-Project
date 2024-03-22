package marco.entities;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CatalogElement {
    @Id //per ora non lo genero automaticamente per le verifiche successive dei metodi
    protected long isbn;
    protected String title;
    protected int published;
    protected int pages;

    public CatalogElement(long isbn, String title, int published, int pages) {
        this.isbn = isbn;
        this.title = title;
        this.published = published;
        this.pages = pages;
    }

    public CatalogElement() {
    }

    public long getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        title = title;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public String toString() {
        return "CatalogElement{" +
                "isbn=" + isbn +
                ", Title='" + title + '\'' +
                ", published=" + published +
                ", pages=" + pages +
                '}';
    }
}
