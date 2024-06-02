package com.example.runners.controller;
import com.example.runners.model.RaceEntity;
import com.example.runners.model.ResultEntity;
import com.example.runners.repository.RaceRepository;
import com.example.runners.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/getAll")
    public List<ResultEntity>getAllResults(){return resultRepository.findAll();}

    @PostMapping("/addResult")
    public ResultEntity createResult(@RequestBody ResultEntity result) {
        resultRepository.save(result);
        return result;
    }

}
