package it.viko.elf.zdybel.first_spring_bot.models;

import jakarta.persistence.*;

import java.math.BigInteger;

@Entity
@Table(name="account")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private BigInteger accountNumber;
    private Float amount;

    public Account() {

    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public BigInteger getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(BigInteger accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Float getAmount() {
        return amount;
    }
    public void setAmount(Float amount) {
        this.amount = amount;
    }


    @Override
    public String toString() {
        return "Account:" +
                "\n\tid=" + id +
                "\n\taccountNumber=" + accountNumber +
                "\n\tamount=" + amount ;
    }


}

