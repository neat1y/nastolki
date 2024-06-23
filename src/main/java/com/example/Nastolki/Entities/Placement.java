package com.example.Nastolki.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "placement")
public class Placement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placement_id")
    private Integer placement_id;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "placement")
    private Set<Bord_game> bordGameSet;

    public Placement(Integer placement_id, String address, Set<Bord_game> bordGameSet) {
        this.placement_id = placement_id;
        this.address = address;
        this.bordGameSet = bordGameSet;
    }

    public Placement() {
    }

    public Integer getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(Integer placement_id) {
        this.placement_id = placement_id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Bord_game> getBordGameSet() {
        return bordGameSet;
    }

    public void setBordGameSet(Set<Bord_game> bordGameSet) {
        this.bordGameSet = bordGameSet;
    }
}
