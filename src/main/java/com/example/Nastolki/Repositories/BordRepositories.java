package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.Bord_game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BordRepositories extends JpaRepository<Bord_game,Integer> {
        public List<Bord_game> findAllByTitleIsLike(String s);

}
