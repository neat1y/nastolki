package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.Bord_Count_Img;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BordCountImgRepositories extends JpaRepository<Bord_Count_Img,Integer> {

}
