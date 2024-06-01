package com.example.runners.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long runnerId;
    private String runnerName;
    private int runnerAge;
    private String runnerGender;
}

