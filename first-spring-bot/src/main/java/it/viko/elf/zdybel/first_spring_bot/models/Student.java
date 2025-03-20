package it.viko.elf.zdybel.first_spring_bot.models;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@Entity
@Table(name="student")
@XmlType(propOrder = {"firstName", "lastName", "email", "courses"})
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="Student_Course",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;

    public Student() {
    }

    // Getter and Setter for ID
    // Find out about XmlTransient ----------------------
    @XmlTransient
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for First Name
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter and Setter for Last Name
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter and Setter for Email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter for Courses
    public List<Course> getCourses() {
        return courses;
    }

    @XmlElementWrapper(name="courses")
    @XmlElement(name="course")
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student:" +
                "\n\tid=" + id +
                "\n\tfirstName=" + firstName  +
                "\n\tlastName=" + lastName  +
                "\n\temail=" + email  +
                "\n\tcourses=\n\t" + courses ;
    }
}
