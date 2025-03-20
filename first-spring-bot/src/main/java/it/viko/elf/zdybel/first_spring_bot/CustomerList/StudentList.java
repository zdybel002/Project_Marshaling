package it.viko.elf.zdybel.first_spring_bot.CustomerList;

import it.viko.elf.zdybel.first_spring_bot.models.Student;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
public class CustomerList {

    private List<Student> students;

    @XmlElement(name = "customer")
    public List<Student> getCustomers() {
        return students;
    }

    public void setCustomers(List<Student> customers) {
        this.students = students;
    }
}
