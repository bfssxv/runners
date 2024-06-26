package com.example.runners.controller;

import com.example.runners.model.RunnerEntity;
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
public class RunnerWebController {

    @Autowired
    RunnerRepository runnerRepository;

    @GetMapping("/runners")
    public String listRunnerEntity(Model model) {
        model.addAttribute("runners", runnerRepository.findAll());
        model.addAttribute("runner", new RunnerEntity());
        return "runners";
    }
    @GetMapping("/addRunnerForm")
    public String showAddRunnerForm() {
        return "addRunnerForm";
    }

    @PostMapping("/runners/add")
        public String addRunner(@ModelAttribute RunnerEntity runner) {
            runnerRepository.save(runner);
            return "redirect:/runners";

    }

}
