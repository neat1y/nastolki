package com.example.Nastolki.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "achievement_person")
public class Person_Achievement {
    @EmbeddedId
    private     Person_Achievement_Id id;
    @ManyToOne
    @MapsId("person_id")
    @JoinColumn(name = "person_id")
    private Person person;
    @ManyToOne
    @MapsId("achievement_id")
    @JoinColumn(name = "achievement_id")
    private Achievement achievement;

    public Person_Achievement() {
    }

    public Person_Achievement_Id getId() {
        return id;
    }

    public void setId(Person_Achievement_Id id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Achievement getAchievement() {
        return achievement;
    }

    public void setAchievement(Achievement achievement_id) {
        this.achievement = achievement_id;
    }
}
