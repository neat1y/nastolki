package com.example.Nastolki.Controllers;

import com.example.Nastolki.DTO.LoginDTO;
import com.example.Nastolki.DTO.RegDTO;
import com.example.Nastolki.Entities.Person;
import com.example.Nastolki.Mappers.Person_To_PersonDTO;
import com.example.Nastolki.Repositories.PersonRepositories;
import com.example.Nastolki.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    private final PersonRepositories personRepositories;
    private final Person_To_PersonDTO person_to_personDTO;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(JwtUtil jwtUtil, AuthenticationManager authenticationManager, PersonRepositories personRepositories, Person_To_PersonDTO personToPersonDTO, PasswordEncoder passwordEncoder) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
        this.personRepositories = personRepositories;
        person_to_personDTO = personToPersonDTO;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public Map<String,Object> login(@RequestBody LoginDTO loginDTO){
        UsernamePasswordAuthenticationToken authInputToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getName(),
                        loginDTO.getPassword());

        try {
            authenticationManager.authenticate(authInputToken);
        } catch (BadCredentialsException e) {
            return Map.of("message", "Incorrect credentials!");
        }

        String token = jwtUtil.generateToken(loginDTO.getName());
        return Map.of("jwt-token", token);
    }
    @PostMapping("/reg")
    public Map<String, String> reg(@RequestBody RegDTO regDTO){
           Optional<Person> person= personRepositories.findByName(regDTO.getName());
           Map<String,String> qwe=new HashMap<>();

           if(person.isPresent()){
               qwe.put("error","name has");
               return qwe;
           }
           Person person1=person_to_personDTO.map_to_Person(regDTO);
           person1.setPassword(passwordEncoder.encode(person1.getPassword()));
           person1.setPerson_role("ROLE_USER");
          String jwt= jwtUtil.generateToken(person1.getName());
          personRepositories.save(person1);
          qwe.put("jwt",jwt);
          return qwe;
    }
}
