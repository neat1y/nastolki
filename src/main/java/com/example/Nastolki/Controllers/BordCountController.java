package com.example.Nastolki.Controllers;

import com.example.Nastolki.DTO.BordCountDTO;
import com.example.Nastolki.DTO.BordCountPostDTO;
import com.example.Nastolki.Entities.bord_count_img_video;
import com.example.Nastolki.Entities.Bord_count;
import com.example.Nastolki.Mappers.BordGameMappers;
import com.example.Nastolki.Service.BordCountImgService;
import com.example.Nastolki.Service.BordCountService;
import com.example.Nastolki.Service.BordService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/bord")
public class BordCountController {
    @Value("${upload.directory}")
    private String uploadDirectory;
    private final BordService bordService;
    private final BordCountService bordCountService;
    private final BordGameMappers bordGameMappers;
    private final BordCountImgService bordCountImgService;
    @Autowired
    public BordCountController(BordService bordService, BordCountService bordCountService, BordGameMappers bordGameMappers, BordCountImgService bordCountImgService) {
        this.bordService = bordService;
        this.bordCountService = bordCountService;
        this.bordGameMappers = bordGameMappers;
        this.bordCountImgService = bordCountImgService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<BordCountDTO>> all() throws IOException {
        List<bord_count_img_video> bordCountImgs= bordCountImgService.all();
        List<Bord_count> bord_counts=bordCountService.all();
        List<BordCountDTO>  response=new ArrayList<>();
        BordCountDTO bord_countDto=new BordCountDTO();
        for(Bord_count bord_count:bord_counts){
            List<byte[]> images=new ArrayList<>();
            for(bord_count_img_video bordCountImg:bordCountImgs){
                Path path=Paths.get(bordCountImg.getRef());
                images.add(Files.readAllBytes(path));

            }
            bord_countDto.setMin_price(bord_count.getMin_price());
            bord_countDto.setDescription(bord_count.getDescription());
            bord_countDto.setImg(images);
            bord_countDto.setCount(bord_count.getCount());
            bord_countDto.setTitle(bord_count.getTitle_id());
            response.add(bord_countDto);
            bord_countDto=new BordCountDTO();
        }
        return  ResponseEntity.ok(response);
    }
    @PostMapping("/add/new_game")
    public ResponseEntity<?> add(HttpServletRequest request) {
        try {
            // Обработка multipart данных
            List<MultipartFile> multipartFiles = ((MultipartHttpServletRequest) request).getFiles("files");
            String dataJson = request.getParameter("data");

            // Преобразование JSON строки в объект DTO
            ObjectMapper objectMapper = new ObjectMapper();
            BordCountPostDTO bordCountDTO = objectMapper.readValue(dataJson, BordCountPostDTO.class);

            // Создание и сохранение нового объекта Bord_count
            Bord_count bord_count = new Bord_count();
            bord_count.setDescription(bordCountDTO.getDescription());
            bord_count.setTitle_id(bordCountDTO.getTitle());
            bordCountService.save(bord_count);

            Path path = Paths.get(uploadDirectory + "/" + bord_count.getTitle_id() + "/Photo");
            // Создание директории, если она не существует
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            // Сохранение каждого файла в созданной директории
            for (MultipartFile file : multipartFiles) {
                Path filePath = path.resolve(file.getOriginalFilename());
                Files.write(filePath, file.getBytes());

                bord_count_img_video bordCountImg = new bord_count_img_video();
                bordCountImg.setRef(filePath.toString());
                bordCountImg.setBordCount(bordCountService.findbyId(bordCountDTO.getTitle()));
                bord_count.setCount(0);
                bordCountImgService.save(bordCountImg);
            }

            return ResponseEntity.ok("Game added successfully");

        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error processing request");
        }
    }
//    @PostMapping("/add/new_game")
//    public ResponseEntity<?> add(@RequestParam("files")  List<MultipartFile> multipartFiles,@RequestParam("data") BordCountPostDTO bordCountDTO){
//        Bord_count bord_count=new Bord_count();
//        bord_count.setDescription(bordCountDTO.getDescription());
//        bord_count.setTitle_id(bordCountDTO.getTitle());
//        bordCountService.save(bord_count);
//        Path path=Paths.get(uploadDirectory+"/"+bord_count.getTitle_id()+"/Photo");
//        try {
//            // Создание директории, если она не существует
//            if (!Files.exists(path)) {
//                Files.createDirectories(path);
//            }
//            Bord_Count_Img bordCountImg=new Bord_Count_Img();
//
//            // Сохранение каждого файла в созданной директории
//            for (MultipartFile file : multipartFiles) {
//                Path filePath = path.resolve(file.getOriginalFilename());
//                Files.write(filePath, file.getBytes());
//                bordCountImg.setRef(filePath.toString());
//                bordCountImg.setBordCount(bordCountService.findbyId(bordCountDTO.getTitle()));
//                bord_count.setCount(0);
//                bordCountImgService.save(bordCountImg);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//            // Обработка ошибки, например, логирование или выброс исключения
//        }
//        return ResponseEntity.ok("fine");
//    }


}
