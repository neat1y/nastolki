package com.example.Nastolki.Mappers;

import com.example.Nastolki.DTO.BordCountDTO;
import com.example.Nastolki.DTO.BordGameDTO;
import com.example.Nastolki.Entities.Bord_count;
import com.example.Nastolki.Entities.Bord_game;
import com.example.Nastolki.Entities.Placement;
import com.example.Nastolki.Service.PlacementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class BordGameMappers {
    private final PlacementService placementService;
    @Autowired
    public BordGameMappers(PlacementService placementService) {
        this.placementService = placementService;
    }

    public Bord_game BordGameDTO_To_BordGame(BordGameDTO bordGameDTO){
        Bord_game bordGame =new Bord_game();
        bordGame.setImg(bordGame.getImg());
        Optional <Placement> placement=placementService.findByName(bordGameDTO.getPlacement());
        if(!placement.isEmpty()){
            bordGame.setPlacement(placement.get());
        }
        else{
            placementService.save(bordGameDTO.getPlacement());
            placement=placementService.findByName(bordGameDTO.getPlacement());
            bordGame.setPlacement(placement.get());
        }
        bordGame.setPrice(bordGameDTO.getPrice());
        bordGame.setTitle(bordGameDTO.getTitle());
        bordGame.setIs_use(false);
        return bordGame;
    }


    public Bord_count BordCountDTO_to_BordCount(BordCountDTO bordCountDTO){
        Bord_count bordCount =new Bord_count();
        bordCount.setCount(bordCountDTO.getCount());
        bordCount.setDescription(bordCountDTO.getDescription());
        bordCount.setVideo(bordCountDTO.getVideo());
        bordCount.setMin_price(bordCountDTO.getMin_price());
        return bordCount;
    }
}
