package com.example.runners.controller;

import com.example.runners.model.RunnerEntity;
import com.example.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    @Autowired
    RunnerRepository runnerRepository;

    @GetMapping("/getAll")
    public String getAllRunners(Model model) {
        List<RunnerEntity> runners = runnerRepository.findAll();
        model.addAttribute("runners", runners);
        return "runners";
    }
}
