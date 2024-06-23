package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Placement;
import com.example.Nastolki.Repositories.PlacementRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlacementService {
    private final PlacementRepositories placementRepositories;
    @Autowired
    public PlacementService(PlacementRepositories placementRepositories) {
        this.placementRepositories = placementRepositories;
    }

    public Optional<Placement> findByName(String address){
        return placementRepositories.findByAddress(address);
    }

    public void save(String placement) {
        Placement placement1=new Placement();
        placement1.setAddress(placement);
        placementRepositories.save(placement1);
    }
}
