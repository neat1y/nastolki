package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.bord_count_img_video;
import com.example.Nastolki.Repositories.BordCountImgRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BordCountImgService {
    private final BordCountImgRepositories bordCountImgRepositories;
    @Autowired
    public BordCountImgService(BordCountImgRepositories bordCountImgRepositories) {
        this.bordCountImgRepositories = bordCountImgRepositories;
    }
    public List<bord_count_img_video> all(){
        return bordCountImgRepositories.findAll();
    }

    public void save(bord_count_img_video bordCountImg) {
        bordCountImgRepositories.save(bordCountImg);
    }
}
