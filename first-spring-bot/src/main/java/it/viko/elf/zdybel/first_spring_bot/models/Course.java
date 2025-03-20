package it.viko.elf.zdybel.first_spring_bot.models;

import jakarta.persistence.*;

@Entity
@Table(name="course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    private String courseName;
    private Float courseFee;

    public Course() {
    }

    // Getter and Setter for ID
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for Course Name
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    // Getter and Setter for Course Fee
    public Float getCourseFee() {
        return courseFee;
    }

    public void setCourseFee(Float courseFee) {
        this.courseFee = courseFee;
    }

    @Override
    public String toString() {
        return "Course:" +
                "\n\tid=" + id +
                "\n\tcourseName=" + courseName +
                "\n\tcourseFee=" + courseFee;
    }
}
