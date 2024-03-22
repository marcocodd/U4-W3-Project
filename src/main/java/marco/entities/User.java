package marco.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "utente")
public class User {
    @Id
    @GeneratedValue
    @JoinColumn(name = "numero_tessera")
    private long cardNumber;
    @JoinColumn(name = "nome")
    private String name;
    @JoinColumn(name = "cognome")
    private String surname;
    @JoinColumn(name = "data_nascita")
    private LocalDate birthdate;
    @OneToMany(mappedBy = "user")
    private List<Loan> loansList;

    public User(String name, String surname, LocalDate birthdate) {

        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public long getCardNumber() {
        return cardNumber;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "User{" +
                "cardNumber=" + cardNumber +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
