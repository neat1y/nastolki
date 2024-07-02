package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Bord_Game_Img_Video;
import com.example.Nastolki.Repositories.BordGameImgRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BordGameImgService {
    private final BordGameImgRepositories bordGameImgRepositories;
    @Autowired
    public BordGameImgService(BordGameImgRepositories bordGameImgRepositories) {
        this.bordGameImgRepositories = bordGameImgRepositories;
    }

    public void save(Bord_Game_Img_Video bord_game_img_video) {
        bordGameImgRepositories.save(bord_game_img_video);
    }
}
