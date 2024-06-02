package com.example.runners.controller;

import com.example.runners.model.RaceEntity;
import com.example.runners.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    @Autowired
    RaceRepository raceRepository;

    @GetMapping("/getAll")
    public List<RaceEntity>getAllRaces(){return raceRepository.findAll();}
}



