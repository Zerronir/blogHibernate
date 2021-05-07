package com.blog.entities;

import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "person")
public class Person {
    // Generamos la id de la persona
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String firstName;
    String lastName;
    String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    LocalDate birthDay;

    @ManyToOne(optional = true)
    @JoinColumn(name = "job_id", nullable = true)
    @Nullable
    Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s %s %s %s", id, firstName, lastName, birthDay, job);
    }

}
