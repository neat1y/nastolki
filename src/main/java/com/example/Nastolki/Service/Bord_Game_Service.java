package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Bord_game;
import com.example.Nastolki.Repositories.BordRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Bord_Game_Service {
    private final BordRepositories bordRepositories;
    @Autowired
    public Bord_Game_Service(BordRepositories bordRepositories) {
        this.bordRepositories = bordRepositories;
    }
    public List<Bord_game> allByTitle_Id(String title){
        return bordRepositories.findAllByTitleIsLike(title);
    }

    public Integer save(Bord_game bord_game) {
            Bord_game bord_game1= bordRepositories.save(bord_game);
            return bord_game1.getGame_id();
    }

    public Bord_game findbyId(int i) {
           return bordRepositories.findById(i).get();

    }
}
