package com.example.Nastolki.Controllers;

import com.example.Nastolki.Entities.Placement;
import com.example.Nastolki.Service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/placement")
public class PlacementControlelrs {
    private final PlacementService placementService;
    @Autowired
    public PlacementControlelrs(PlacementService placementService) {
        this.placementService = placementService;
    }
    @PostMapping("/add")
    public ResponseEntity<?> addnewPlacement(@RequestParam("address") String address){

        placementService.save(address);
        return ResponseEntity.ok("fine");
    }
}
