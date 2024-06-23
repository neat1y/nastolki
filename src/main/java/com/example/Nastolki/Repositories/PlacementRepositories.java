package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.Placement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlacementRepositories extends JpaRepository<Placement,Integer> {
    public Optional<Placement> findByAddress(String address);
}
