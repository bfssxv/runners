package com.example.runners.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class RunnerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long runnerId;
    private String runnerName;
    private int runnerAge;
    private String runnerGender;

    @OneToMany(mappedBy = "runner", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ResultEntity> results;

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

    public List<ResultEntity> getResults() {
        return results;
    }

    public void setResults(List<ResultEntity> results) {
        this.results = results;
    }
}