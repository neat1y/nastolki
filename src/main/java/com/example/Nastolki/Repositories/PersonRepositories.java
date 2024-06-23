package com.example.Nastolki.Repositories;

import com.example.Nastolki.Entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepositories extends JpaRepository<Person,Integer> {
    Optional<Person> findByName(String name);
}
