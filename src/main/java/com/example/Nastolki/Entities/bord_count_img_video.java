package com.example.Nastolki.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bord_count_img_video")
public class bord_count_img_video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="ref")
    private String ref;
    @ManyToOne
    @JoinColumn(name = "title_id")
    private Bord_count bordCount;


    public bord_count_img_video() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
