package com.example.runners.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long resultId;
    public long contestantId;

    private long racesId;
    private double raceTime;
}


