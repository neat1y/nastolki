package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Bord_game;
import com.example.Nastolki.Repositories.BordRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BordService {
    private final BordRepositories bordRepositories;
    @Autowired
    public BordService(BordRepositories bordRepositories) {
        this.bordRepositories = bordRepositories;
    }
    public List<Bord_game> all(){
       return bordRepositories.findAll();
    }
    public void save(Bord_game bordGame){

    }
}
