package com.example.Nastolki.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "bord_game_img_and_video")
public class Bord_Game_Img_Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="ref")
    private String ref;
    @ManyToOne
    @JoinColumn(name = "game_id")
    private Bord_game bordGame;
    @Column(name = "is_pict")
    private  Boolean is_pict;

    public Bord_Game_Img_Video() {
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

    public Bord_game getBordGame() {
        return bordGame;
    }

    public void setBordGame(Bord_game bordGame) {
        this.bordGame = bordGame;
    }

    public Boolean getIs_pict() {
        return is_pict;
    }

    public void setIs_pict(Boolean is_pict) {
        this.is_pict = is_pict;
    }
}
