package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Person;
import com.example.Nastolki.Mappers.Person_To_PersonDTO;
import com.example.Nastolki.Repositories.PersonRepositories;
import com.example.Nastolki.Util.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailService implements UserDetailsService {
    private final PersonRepositories personRepositories;
    private final Person_To_PersonDTO person_to_personDTO;

    @Autowired
    public PersonDetailService(PersonRepositories personRepositories, Person_To_PersonDTO personToPersonDTO) {
        this.personRepositories = personRepositories;
        person_to_personDTO = personToPersonDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> person=personRepositories.findByName(username);
        if(person.isEmpty()){
            throw new UsernameNotFoundException("User not found");
        }

        return new PersonDetails(person_to_personDTO.map_to_personDTO(person.get()));
    }
}
