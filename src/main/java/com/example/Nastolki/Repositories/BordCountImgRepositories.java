package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.bord_count_img_video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BordCountImgRepositories extends JpaRepository<bord_count_img_video,Integer> {

}
