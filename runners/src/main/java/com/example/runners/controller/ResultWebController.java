package com.example.runners.controller;

import com.example.runners.model.RaceEntity;
import com.example.runners.model.ResultEntity;
import com.example.runners.model.RunnerEntity;
import com.example.runners.repository.RaceRepository;
import com.example.runners.repository.RunnerRepository;
import com.example.runners.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/web")
public class ResultWebController {
    @Autowired
    private RunnerRepository runnerRepository;
    @Autowired
    private RaceRepository raceRepository;
    @Autowired
    private ResultRepository resultRepository;
    @GetMapping("/runners")
    public String getRunners(Model model) {
        List<RunnerEntity> runners = runnerRepository.findAll();
        model.addAttribute("runners", runners);
        return "runnerList";
    }

    @GetMapping("/runner/{id}/results")
    public String getResults(@PathVariable Long id, Model model) {
        RunnerEntity runner = runnerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Runner not found with ID: " + id));
        model.addAttribute("runner", runner);
        model.addAttribute("results", runner.getResults());
        return "runnerResults";

    }

    @GetMapping("/addRunner")
    public String showAddRunnerForm(Model model) {
        model.addAttribute("runner", new RunnerEntity());
        return "addRunner";
    }

    @PostMapping("/addRunner")
    public String addRunner(@ModelAttribute RunnerEntity runner) {
        runnerRepository.save(runner);
        return "redirect:/web/runners";
    }

    @GetMapping("/addResult")
    public String showAddResultForm(Model model) {
        model.addAttribute("result", new ResultEntity());
        model.addAttribute("runners", runnerRepository.findAll());
        model.addAttribute("races", raceRepository.findAll());
        return "addResult";  // This will render addResult.html
    }

    @PostMapping("/addResult")
    public String addResult(@ModelAttribute ResultEntity result) {
        resultRepository.save(result);
        return "redirect:/web/runners";
    }

}

