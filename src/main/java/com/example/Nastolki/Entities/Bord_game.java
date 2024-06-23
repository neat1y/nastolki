package com.example.Nastolki.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "bord_game")
public class Bord_game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Integer game_id;
    @Column(name = "title")
    private String title;
    @OneToMany(mappedBy = "bordGame")
    private Set<Bord_Game_Img_Video> img;
    @Column(name = "price")
    private Double price;
    @Column(name = "is_use")
    private Boolean is_use;
    @ManyToOne
    @JoinColumn(name = "placement_id")
    private Placement placement;

    @OneToMany(mappedBy = "bordGame")
    private Set<Operations> operationsSet;
    @OneToMany(mappedBy = "bordGame")
    private Set<Reservation> reservations;
    public Bord_game() {
    }

    public Set<Operations> getOperationsSet() {
        return operationsSet;
    }

    public void setOperationsSet(Set<Operations> operationsSet) {
        this.operationsSet = operationsSet;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Bord_game(Integer game_id, String title, Set<Bord_Game_Img_Video> img, Double price, Boolean is_use, Placement placement) {
        this.game_id = game_id;
        this.title = title;
        this.img = img;
        this.price = price;
        this.is_use = is_use;
        this.placement = placement;
    }

    public Integer getGame_id() {
        return game_id;
    }

    public void setGame_id(Integer game_id) {
        this.game_id = game_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Bord_Game_Img_Video> getImg() {
        return img;
    }

    public void setImg(Set<Bord_Game_Img_Video> img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIs_use() {
        return is_use;
    }

    public void setIs_use(Boolean is_use) {
        this.is_use = is_use;
    }

    public Placement getPlacement() {
        return placement;
    }

    public void setPlacement(Placement placement) {
        this.placement = placement;
    }
}
