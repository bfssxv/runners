package com.example.runners.controller;
import com.example.runners.model.RaceEntity;
import com.example.runners.model.ResultEntity;
import com.example.runners.repository.RaceRepository;
import com.example.runners.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {
    @Autowired
    ResultRepository resultRepository;

    @GetMapping("/getAll")
    public List<ResultEntity>getAllResults(){return resultRepository.findAll();}
}
