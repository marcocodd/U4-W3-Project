package marco;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class CatalogElement {
    @Id //per ora non lo genero automaticamente per le verifiche successive dei metodi
    protected long isbn;
    protected String Title;
    protected int published;
    protected int pages;

    public CatalogElement(long isbn, String title, int published, int pages) {
        this.isbn = isbn;
        Title = title;
        this.published = published;
        this.pages = pages;
    }

    public CatalogElement() {
    }

    public long getIsbn() {
        return isbn;
    }


    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
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
                ", Title='" + Title + '\'' +
                ", published=" + published +
                ", pages=" + pages +
                '}';
    }
}
