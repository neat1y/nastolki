package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.Bord_count;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BordCountRepositories extends JpaRepository<Bord_count, String> {

}
