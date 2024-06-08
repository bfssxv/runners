package com.example.runners.repository;

import org.springframework.transaction.annotation.Transactional;
import com.example.runners.model.RaceEntity;
import com.example.runners.model.ResultEntity;
import com.example.runners.model.RunnerEntity;
import com.example.runners.repository.RaceRepository;
import com.example.runners.repository.ResultRepository;
import com.example.runners.repository.RunnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private RunnerRepository runnerRepository;

    @Autowired
    private RaceRepository raceRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Override
    @Transactional
    public void run(String... args) {
        // create default runner entity
        RunnerEntity runnerEntity1 = new RunnerEntity();
        runnerEntity1.setRunnerName("Nagy Viola");
        runnerEntity1.setRunnerAge(29);
        runnerEntity1.setRunnerGender("Female");
        runnerRepository.save(runnerEntity1);


        RunnerEntity runnerEntity2 = new RunnerEntity();
        runnerEntity2.setRunnerName("Bárdos Balázs");
        runnerEntity2.setRunnerAge(26);
        runnerEntity2.setRunnerGender("Male");
        runnerRepository.save(runnerEntity2);


        RunnerEntity runnerEntity3 = new RunnerEntity();
        runnerEntity3.setRunnerName("Bérczi Bella");
        runnerEntity3.setRunnerAge(36);
        runnerEntity3.setRunnerGender("Female");
        runnerRepository.save(runnerEntity3);

        RunnerEntity runnerEntity4 = new RunnerEntity();
        runnerEntity4.setRunnerName("Molnár Marcell");
        runnerEntity4.setRunnerAge(39);
        runnerEntity4.setRunnerGender("Male");
        runnerRepository.save(runnerEntity4);


        RunnerEntity runnerEntity5 = new RunnerEntity();
        runnerEntity5.setRunnerName("Kovács Zénó");
        runnerEntity5.setRunnerAge(23);
        runnerEntity5.setRunnerGender("Male");
        runnerRepository.save(runnerEntity5);


        RaceEntity raceEntity1 = new RaceEntity();
        raceEntity1.setRaceName("SUHANJ! Futam");
        raceEntity1.setRaceDistance(0.94);
        raceRepository.save(raceEntity1);

        RaceEntity raceEntity2 = new RaceEntity();
        raceEntity2.setRaceName("Midicittá 7 km");
        raceEntity2.setRaceDistance(7);
        raceRepository.save(raceEntity2);

        RaceEntity raceEntity3 = new RaceEntity();
        raceEntity3.setRaceName("Vivicittá 10 km");
        raceEntity3.setRaceDistance(10);
        raceRepository.save(raceEntity3);

        RaceEntity raceEntity4 = new RaceEntity();
        raceEntity4.setRaceName("Vivicittá Félmaraton");
        raceEntity4.setRaceDistance(21);
        raceRepository.save(raceEntity4 );

        Map<String, Double> raceTimes = new HashMap<>();
        raceTimes.put("Nagy Viola:SUHANJ! Futam", 12.18);
        raceTimes.put("Bárdos Balázs:Vivicittá 10 km", 35.32);
        raceTimes.put("Bárdos Balázs:Vivicittá Félmaraton", 78.33);
        raceTimes.put("Bérczi Bella:Vivicittá 10 km", 39.40);
        raceTimes.put("Bérczi Bella:Vivicittá Félmaraton", 82.41);
        raceTimes.put("Molnár Marcell:Midicittá 7 km", 27.04);
        raceTimes.put("Kovács Zénó:Midicittá 7 km", 25.24);


        // Populate results
        List<RunnerEntity> runners = runnerRepository.findAll();
        List<RaceEntity> races = raceRepository.findAll();


        for (RunnerEntity runner : runners) {
            for (RaceEntity race : races) {
                String key = runner.getRunnerName() + ":" + race.getRaceName();
                if (raceTimes.containsKey(key)) {
                    ResultEntity result = new ResultEntity();
                    result.setRunner(runner);
                    result.setRace(race);
                    result.setRaceTime(raceTimes.get(key));
                    resultRepository.save(result);

                }
                }


            }


        }
    }
