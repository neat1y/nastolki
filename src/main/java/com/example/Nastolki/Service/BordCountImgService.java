package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Bord_Count_Img;
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
    public List<Bord_Count_Img> all(){
        return bordCountImgRepositories.findAll();
    }
}
