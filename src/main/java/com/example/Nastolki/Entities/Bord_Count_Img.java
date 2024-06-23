package com.example.Nastolki.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Bord_Count_Img")
public class Bord_Count_Img {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="ref")
    private String ref;
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Bord_count bordCount;


    public Bord_Count_Img() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Bord_count getBordCount() {
        return bordCount;
    }

    public void setBordCount(Bord_count bordCount) {
        this.bordCount = bordCount;
    }
}
