package com.example.Nastolki.DTO;

import jakarta.persistence.Column;

import java.util.List;

public class BordCountDTO {
    private Integer count;
    private String video;
    private List<byte[]> Imgs;
    private String description;
    private String title;

    public List<byte[]> getImgs() {
        return Imgs;
    }

    public void setImgs(List<byte[]> imgs) {
        Imgs = imgs;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private Integer min_price;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public List<byte[]> getImg() {
        return Imgs;
    }

    public void setImg(List<byte[]> Imgs) {
        this.Imgs = Imgs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMin_price() {
        return min_price;
    }

    public void setMin_price(Integer min_price) {
        this.min_price = min_price;
    }
}
