package com.example.runners.controller;

import com.example.runners.model.RaceEntity;
import com.example.runners.model.RunnerEntity;
import com.example.runners.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/races")
public class RaceController {
    @Autowired
    RaceRepository raceRepository;

    @GetMapping("/getAll")
    public List<RaceEntity> getAllRaces() {
        return raceRepository.findAll();
    }

    @PostMapping("/addRace")
    public RaceEntity createRace(@RequestBody RaceEntity race) {
        raceRepository.save(race);
        return race;
    }
}


