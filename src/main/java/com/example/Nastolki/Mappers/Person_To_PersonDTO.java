package com.example.Nastolki.Mappers;

import com.example.Nastolki.DTO.PersonDTO;
import com.example.Nastolki.DTO.RegDTO;
import com.example.Nastolki.Entities.Person;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

@Component
public class Person_To_PersonDTO {
    public PersonDTO map_to_personDTO(Person person){
        PersonDTO personDTO=new PersonDTO();
        personDTO.setBlock(person.getBlock());
        personDTO.setName(person.getName());
        personDTO.setPerson_role(person.getPerson_role());
        personDTO.setPassword(person.getPassword());
        personDTO.setPoints(person.getPoints());
        personDTO.setExperience(person.getExperience());
        personDTO.setPerson_id(person.getPerson_id());
        return personDTO;
    }
    public Person map_to_Person(RegDTO regDTO){
        Person person = new Person();
        person.setName(regDTO.getName());
        person.setPassword(regDTO.getPassword());
        person.setTelephone(regDTO.getTelephone());
        person.setBlock(false);
        person.setExperience(0);
        person.setPoints(0);
        return person;
    }
}
