package marco.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "libri")
public class Books extends CatalogElement {
    private String author;
    private String genre;


    public Books(long isbn, String title, int published, int pages, String author, String genre) {
        super(isbn, title, published, pages);
        this.author = author;
        this.genre = genre;
    }

    public Books() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Books{" +
                "author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
