package com.example.runners.model;
import jakarta.persistence.*;
import jakarta.persistence.Entity;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
public class ResultEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long resultId;
    @ManyToOne
    @JoinColumn(name = "runner_id", nullable = false)
    private RunnerEntity runner;
    @ManyToOne
    @JoinColumn(name = "race_id", nullable = false)
    private RaceEntity race;
    private double raceTime;

    public long getResultId() {
        return resultId;
    }

    public void setResultId(long resultId) {
        this.resultId = resultId;
    }

    public RunnerEntity getRunner() {
        return runner;
    }

    public void setRunner(RunnerEntity runner) {
        this.runner = runner;
    }

    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }

    public double getRaceTime() {
        return raceTime;
    }

    public void setRaceTime(double raceTime) {
        this.raceTime = raceTime;
    }
}

