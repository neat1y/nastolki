package com.example.Nastolki.Controllers;

import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/person")
public class PersonControllers {

    @PostMapping("/update_role")
    public void patch(@RequestBody Map<String ,Object> request){
             request.get("name");
    }
}
