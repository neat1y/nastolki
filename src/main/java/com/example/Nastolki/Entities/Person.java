package com.example.Nastolki.Entities;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

import java.util.Set;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "person_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer person_id;
    @Column(name = "img")
    private String img;
    @Column(name = "telephone")
    private String telephone;
    @Column(name = "password")
    private String password;
    @Column(name = "block")
    private Boolean block;
    @Column(name = "name")
    private String name;
    @Column(name = "person_role")
    private String person_role;
    //Опыт
    @Column(name = "experience")
    private Integer experience;
    @Column(name = "points")
    private Integer points;
    @OneToMany(mappedBy = "person")
    private Set<Person_Achievement> personAchievementSet;
    @OneToMany(mappedBy = "person")
    private Set<Operations> operations_person;
    @OneToMany(mappedBy = "operator")
    private Set<Operations> operations_operator;
    @OneToMany(mappedBy = "person")
    private Set<Reservation> reservations;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Operations> getOperations_person() {
        return operations_person;
    }

    public void setOperations_person(Set<Operations> operations_person) {
        this.operations_person = operations_person;
    }

    public Set<Operations> getOperations_operator() {
        return operations_operator;
    }

    public void setOperations_operator(Set<Operations> operations_operator) {
        this.operations_operator = operations_operator;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Person(Integer person_id, String img, String telephone, String password, Boolean block, String person_role, Integer experience, Integer points, Set<Person_Achievement> personAchievementSet) {
        this.person_id = person_id;
        this.img = img;
        this.telephone = telephone;
        this.password = password;
        this.block = block;
        this.person_role = person_role;
        this.experience = experience;
        this.points = points;
        this.personAchievementSet = personAchievementSet;
    }

    public Integer getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Integer person_id) {
        this.person_id = person_id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }

    public String getPerson_role() {
        return person_role;
    }

    public void setPerson_role(String person_role) {
        this.person_role = person_role;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<Person_Achievement> getPersonAchievementSet() {
        return personAchievementSet;
    }

    public void setPersonAchievementSet(Set<Person_Achievement> personAchievementSet) {
        this.personAchievementSet = personAchievementSet;
    }
}
