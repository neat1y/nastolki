package com.example.Nastolki.Service;

import com.example.Nastolki.Entities.Bord_Count_Img;
import com.example.Nastolki.Entities.Bord_count;
import com.example.Nastolki.Repositories.BordCountRepositories;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BordCountService {
    private final BordCountRepositories bordCountRepositories;
    @Autowired
    public BordCountService(BordCountRepositories bordCountRepositories) {
        this.bordCountRepositories = bordCountRepositories;
    }

    public static void save(Bord_count bordCount) {

    }

}
