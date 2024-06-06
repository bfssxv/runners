package com.example.runners.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Set;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long runnerId;
    private String runnerName;
    private int runnerAge;
    private String runnerGender;

    @OneToMany(mappedBy = "runner")
    private Set<ResultEntity> results;

    public long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(long runnerId) {
        this.runnerId = runnerId;
    }

    public String getRunnerName() {
        return runnerName;
    }

    public void setRunnerName(String runnerName) {
        this.runnerName = runnerName;
    }

    public int getRunnerAge() {
        return runnerAge;
    }

    public void setRunnerAge(int runnerAge) {
        this.runnerAge = runnerAge;
    }

    public String getRunnerGender() {
        return runnerGender;
    }

    public void setRunnerGender(String runnerGender) {
        this.runnerGender = runnerGender;
    }

    public Set<ResultEntity> getResults() {
        return results;
    }

    public void setResults(Set<ResultEntity> results) {
        this.results = results;
    }
}