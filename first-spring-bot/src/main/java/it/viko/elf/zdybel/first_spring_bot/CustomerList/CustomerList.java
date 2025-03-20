package it.viko.elf.zdybel.first_spring_bot.CustomerList;
import it.viko.elf.zdybel.first_spring_bot.models.Customer;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CustomerList {

    private List<Customer> customers;

    @XmlElement(name = "customer")
    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
