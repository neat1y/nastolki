package com.example.Nastolki.Controllers;

import ch.qos.logback.core.joran.sanity.Pair;
import com.example.Nastolki.DTO.BordCountDTO;
import com.example.Nastolki.DTO.BordGameDTO;
import com.example.Nastolki.Entities.Bord_Count_Img;
import com.example.Nastolki.Entities.Bord_count;
import com.example.Nastolki.Mappers.BordGameMappers;
import com.example.Nastolki.Service.BordCountImgService;
import com.example.Nastolki.Service.BordCountService;
import com.example.Nastolki.Service.BordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bord")
public class BordController {
    private final BordService bordService;
    private final BordCountService bordCountService;
    private final BordGameMappers bordGameMappers;
    private final BordCountImgService bordCountImgService;
    @Autowired
    public BordController(BordService bordService, BordCountService bordCountService, BordGameMappers bordGameMappers, BordCountImgService bordCountImgService) {
        this.bordService = bordService;
        this.bordCountService = bordCountService;
        this.bordGameMappers = bordGameMappers;
        this.bordCountImgService = bordCountImgService;
    }

    @GetMapping("/all")
    public ResponseEntity<Resource> all(){
        List<Resource>    resources=new ArrayList<>();
        List<Bord_Count_Img> bordCountImgs=bordCountImgService.all();
        Map<Object, List<Bord_Count_Img>> first= bordCountImgs.stream().collect(
                Collectors.groupingBy(bordCountImg ->
                {return bordCountImg.getBordCount().getTitle_id();}));
        return  null;
    }
    @PostMapping("/add/new_id")
    public void add(@RequestBody BordGameDTO bordGameDTO){
        bordService.save(bordGameMappers.BordGameDTO_To_BordGame(bordGameDTO));

    }

    @PostMapping("/add/new_game")
    public void add(BordCountDTO bordCountDTO){
        Bord_count bordCount=new Bord_count();
        BordCountService.save(bordCount);

    }
}
