package it.viko.elf.zdybel.first_spring_bot.models;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@Entity
@Table(name="customer")
@XmlType(propOrder = {"firstName","lastName","email","accounts"})
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="Customer_Account",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "account_id")
    )
    private List<Account> accounts;

    public Customer() {
    }

//Getter Setter ID
//Find out about XmlTransient----------------------
    @XmlTransient
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

//Getter Setter FirstName
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//Getter and Setter LastName
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

//Getter and Setter Email
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @XmlElementWrapper(name="accounts")
    @XmlElement(name="accounts")
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Customer:" +
                "\n\tid=" + id +
                "\n\tfirstName=" + firstName  +
                "\n\tlastName=" + lastName  +
                "\n\temail=" + email  +
                "\n\taccounts=\n\t" + accounts ;
    }
}
