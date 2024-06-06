package com.example.runners.controller;

import com.example.runners.model.RaceEntity;
import com.example.runners.repository.RaceRepository;
import com.example.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class RaceWebController {

    @Autowired
    RaceRepository raceRepository;

    @GetMapping("/getAllRaces")
    public String listRunnerEntity(Model model) {
        model.addAttribute("runners", raceRepository.findAll());
        model.addAttribute("runner", new RaceEntity());
        return "runners";
    }
    @GetMapping("/addRace")
    public String showAddRunnerForm() {
        return "addRaceForm";
    }

    @PostMapping("/races/add")
    public String addRace(@ModelAttribute RaceEntity race) {
        raceRepository.save(race);
        return "redirect:/races";

    }

}
