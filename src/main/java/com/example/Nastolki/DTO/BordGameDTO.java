package com.example.Nastolki.DTO;

import com.example.Nastolki.Entities.Placement;
import jakarta.persistence.*;

public class BordGameDTO {

    private String title;
    private String img;
    private Double price;
    private String placement;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }
}
