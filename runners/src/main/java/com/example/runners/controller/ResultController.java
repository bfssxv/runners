package com.example.runners.controller;
import com.example.runners.model.RaceEntity;
import com.example.runners.model.ResultEntity;
import com.example.runners.model.RunnerEntity;
import com.example.runners.repository.RaceRepository;
import com.example.runners.repository.RunnerRepository;
import com.example.runners.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ResultController {
    @Autowired
    private RunnerRepository runnerRepository;
    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ResultRepository resultRepository;

    @GetMapping("/runners")
    public List<RunnerEntity> getRunners() {
        return runnerRepository.findAll();
    }

    @PostMapping("/addRunner")
    public RunnerEntity addRunner(@RequestBody RunnerEntity runner) {
        return runnerRepository.save(runner);
    }


    @GetMapping("/results/{runnerId}")
    public List<ResultEntity> getResults(@PathVariable Long runnerId) {
        RunnerEntity runner = runnerRepository.findById(runnerId).orElseThrow(() -> new RuntimeException("Runner not found with ID: " + runnerId));
        return runner.getResults();
    }

    @PostMapping("/addResult")
    public ResultEntity addResult(@RequestBody ResultEntity result) {
        return resultRepository.save(result);

    }
}