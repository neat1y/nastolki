package com.example.Nastolki.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="Achievement")
public class Achievement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "achievement_id")
    private Integer achievement_id;
    @Column(name = "title")
    private String title;
    @Column(name = "description")
    private String description;
    @Column(name = "img")
    private String img;
    @OneToMany(mappedBy = "achievement")
    private Set<Person_Achievement> personAchievementSet;

    public Achievement(Integer achievement_id, String title, String description, String img, Set<Person_Achievement> personAchievementSet) {
        this.achievement_id = achievement_id;
        this.title = title;
        this.description = description;
        this.img = img;
        this.personAchievementSet = personAchievementSet;
    }

    public Achievement() {
    }

    public Integer getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(Integer achievement_id) {
        this.achievement_id = achievement_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Set<Person_Achievement> getPersonAchievementSet() {
        return personAchievementSet;
    }

    public void setPersonAchievementSet(Set<Person_Achievement> personAchievementSet) {
        this.personAchievementSet = personAchievementSet;
    }
}
