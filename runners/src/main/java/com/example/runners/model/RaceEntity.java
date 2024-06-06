package com.example.runners.model;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Set;

@Entity
public class RaceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long raceId;
    private String raceName;

    private double raceDistance;

    @OneToMany(mappedBy = "race")
    private Set<ResultEntity> results;

    public long getRaceId() {
        return raceId;
    }

    public void setRaceId(long raceId) {
        this.raceId = raceId;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public double getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(double raceDistance) {
        this.raceDistance = raceDistance;
    }

    public Set<ResultEntity> getResults() {
        return results;
    }

    public void setResults(Set<ResultEntity> results) {
        this.results = results;
    }
}
