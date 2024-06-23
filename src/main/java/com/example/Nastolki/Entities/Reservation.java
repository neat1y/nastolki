package com.example.Nastolki.Entities;

import jakarta.persistence.*;

import java.sql.Date;
import java.sql.Timestamp;
@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_id")
    private Integer reservation_id;
    @Column(name = "how_long")
    private Timestamp how_long;
    @Column(name = "date_reservation")
    private Date date_reservation;
    @ManyToOne
    @JoinColumn(name = "person_id",foreignKey = @ForeignKey(name = "reservation_person_id_fkey"))
    private Person person;
    @ManyToOne
    @JoinColumn(name = "game_id",foreignKey = @ForeignKey(name = "reservation_game_id_fkey"))
    private Bord_game bordGame;

    public Reservation() {
    }

    public Integer getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(Integer reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Timestamp getHow_long() {
        return how_long;
    }

    public void setHow_long(Timestamp how_long) {
        this.how_long = how_long;
    }

    public Date getDate_reservation() {
        return date_reservation;
    }

    public void setDate_reservation(Date date_reservation) {
        this.date_reservation = date_reservation;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Bord_game getBordGame() {
        return bordGame;
    }

    public void setBordGame(Bord_game bordGame) {
        this.bordGame = bordGame;
    }
}
