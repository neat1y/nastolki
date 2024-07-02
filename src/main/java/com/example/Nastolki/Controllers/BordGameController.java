package com.example.Nastolki.Controllers;

import com.example.Nastolki.DTO.BordGamePostDTO;
import com.example.Nastolki.Entities.Bord_Game_Img_Video;
import com.example.Nastolki.Entities.Bord_game;
import com.example.Nastolki.Service.BordGameImgService;
import com.example.Nastolki.Service.Bord_Game_Service;
import com.example.Nastolki.Service.PlacementService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bordgame")
public class BordGameController {
    @Value("${upload.directory}")
    private String uploadDirectory;
    private final Bord_Game_Service bord_game_service;
    private final PlacementService placementService;
    private final BordGameImgService bordGameImgService;
    @Autowired
    public BordGameController(Bord_Game_Service bord_game_service, PlacementService placementService, BordGameImgService bordGameImgService) {
        this.bord_game_service = bord_game_service;
        this.placementService = placementService;
        this.bordGameImgService = bordGameImgService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> allbyid(@PathVariable("id") String id) throws IOException {
            List<Bord_game> bord_gameList=bord_game_service.allByTitle_Id(id);
            List<byte[]> files_photo=new ArrayList<>();
//          List<byte[]> files_video=new ArrayList<>();
            Map<String,Object> response=new HashMap<>();
            for(Bord_game bord_game:bord_gameList){
                for(Bord_Game_Img_Video bord_game_img_video:bord_game.getImg()){
                    Path path= Paths.get(bord_game_img_video.getRef());
                    String contenttype=Files.probeContentType(path);
                    if(contenttype.equals("video/mp4")){
                        response.put("video",Files.readAllBytes(path));
                    }
                    else {
                        files_photo.add(Files.readAllBytes(path));
                    }
                }
                Map<String,Object> one_game=new HashMap<>();
                one_game.put("photos",files_photo);
                one_game.put("title",bord_game.getTitle());
                one_game.put("price",bord_game.getPrice());
                one_game.put("is_use",bord_game.getIs_use());
                one_game.put("place",bord_game.getPlacement());
                response.put(bord_game.getGame_id().toString(),one_game);
            }
            return ResponseEntity.ok(response);
    }
    @PostMapping("/add/once")
    public ResponseEntity<?> addall(HttpServletRequest request){
        try {
            List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("files");
            String dataJson = request.getParameter("data");
            ObjectMapper objectMapper = new ObjectMapper();
            BordGamePostDTO bordGamePostDTO = objectMapper.readValue(dataJson, BordGamePostDTO.class);
            Bord_game bord_game=new Bord_game();
            bord_game.setIs_use(false);
            bord_game.setPlacement(placementService.findByName(bordGamePostDTO.getAddress()).get());
            bord_game.setPrice(bordGamePostDTO.getPrice());
            bord_game.setTitle(bordGamePostDTO.getTitle());
             int i=bord_game_service.save(bord_game);
            Path path = Paths.get(uploadDirectory + "/bord_game" + "/Photo");
            // Создание директории, если она не существует

            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }
            Bord_Game_Img_Video bord_game_img_video=new Bord_Game_Img_Video();
            // Сохранение каждого файла в созданной директории
            for (MultipartFile file : multipartFiles) {
                Path filePath = path.resolve(file.getOriginalFilename());
                Files.write(filePath, file.getBytes());
                bord_game_img_video.setRef(filePath.toString());
                bord_game_img_video.setBordGame(bord_game_service.findbyId(i));
                bord_game_img_video.setIs_pict(!Files.probeContentType(filePath).equals("video/mp4"));
                bordGameImgService.save(bord_game_img_video);
                bord_game_img_video=new Bord_Game_Img_Video();
            }

            return ResponseEntity.ok("Game added successfully");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error processing request");
        }
    }
}
