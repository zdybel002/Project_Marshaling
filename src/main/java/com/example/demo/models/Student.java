package com.example.demo.models;

import jakarta.persistence.*;

import java.util.List;

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private String firstName;

    private String lastName;

    private String email;

    private int major;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name="student",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id")
    )
    private List<Subject> subjects;
}
