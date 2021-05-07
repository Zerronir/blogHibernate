package com.blog.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "job")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String job;

    @OneToMany
    @JoinColumn(name = "job_id", nullable = true)
    Set<Person> persons;

    public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return String.format("%s", job);
    }
}
