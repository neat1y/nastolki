package com.example.Nastolki.Entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "bord_count")
public class Bord_count {
    @Id
    @Column(name = "title_id")
    private String title_id;
    @Column(name = "count")
    private Integer count;
    @Column(name = "video")
    private String video;
    @OneToMany(mappedBy = "bordCount")
    private Set<bord_count_img_video> imgs;
    @Column(name = "description")
    private String description;

    @Column(name = "min_price")
    private Integer min_price;

    public Bord_count() {
    }

    public Bord_count(String title_id, Integer count, String video, Set<bord_count_img_video> img, String description, Integer min_price) {
        this.title_id = title_id;
        this.count = count;
        this.video = video;
        this.imgs = img;
        this.description = description;
        this.min_price = min_price;
    }

    public String getTitle_id() {
        return title_id;
    }

    public void setTitle_id(String title_id) {
        this.title_id = title_id;
    }

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

    public Set<bord_count_img_video> getImg() {
        return imgs;
    }

    public void setImg(Set<bord_count_img_video> img) {
        this.imgs = img;
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
