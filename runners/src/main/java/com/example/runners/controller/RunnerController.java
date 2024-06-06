package com.example.runners.controller;

import com.example.runners.model.RunnerEntity;
import com.example.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runners")
public class RunnerController {

    @Autowired
    RunnerRepository runnerRepository;

    @GetMapping("/getAllRunners")
    public List<RunnerEntity>getAllRunners(){return runnerRepository.findAll();}

    @PostMapping("/addRunner")
    public RunnerEntity addRunner(@RequestBody RunnerEntity runner) {
        runnerRepository.save(runner);
        return runner;
    }

}
