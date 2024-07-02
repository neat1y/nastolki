package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.Bord_Game_Img_Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BordGameImgRepositories extends JpaRepository<Bord_Game_Img_Video,Integer> {

}
