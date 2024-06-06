package com.example.runners.repository;

import com.example.runners.model.RaceEntity;
import com.example.runners.model.RunnerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class DataLoader implements CommandLineRunner {

    private final RunnerRepository runnerRepository;
    private final RaceRepository raceRepository;
    @Autowired
    public DataLoader(RunnerRepository runnerRepository, RaceRepository raceRepository) {
        this.runnerRepository = runnerRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public void run(String... args) {
        // create default runner entity
        RunnerEntity runnerEntity1 = new RunnerEntity();
        runnerEntity1.setRunnerName("Nagy Viola");
        runnerEntity1.setRunnerAge(29);
        runnerEntity1.setRunnerGender("Female");


        RunnerEntity runnerEntity2 = new RunnerEntity();
        runnerEntity2.setRunnerName("Bárdos Balázs");
        runnerEntity2.setRunnerAge(26);
        runnerEntity2.setRunnerGender("Male");


        RunnerEntity runnerEntity3 = new RunnerEntity();
        runnerEntity3.setRunnerName("Bérczi Bella");
        runnerEntity3.setRunnerAge(36);
        runnerEntity3.setRunnerGender("Female");


        RunnerEntity runnerEntity4 = new RunnerEntity();
        runnerEntity4.setRunnerName("Molnár Marcell");
        runnerEntity4.setRunnerAge(39);
        runnerEntity4.setRunnerGender("Male");


        RunnerEntity runnerEntity5 = new RunnerEntity();
        runnerEntity5.setRunnerName("Kovács Zénó");
        runnerEntity5.setRunnerAge(23);
        runnerEntity5.setRunnerGender("Male");


        RaceEntity raceEntity1 = new RaceEntity();
        raceEntity1.setRaceName("SUHANJ! Futam");
        raceEntity1.setRaceDistance(0.94);

        RaceEntity raceEntity2 = new RaceEntity();
        raceEntity2.setRaceName("Midicittá 7 km");
        raceEntity2.setRaceDistance(7);

        RaceEntity raceEntity3 = new RaceEntity();
        raceEntity3.setRaceName("Vivicittá 10 km");
        raceEntity3.setRaceDistance(10);

        RaceEntity raceEntity4 = new RaceEntity();
        raceEntity4.setRaceName("Vivicittá Félmaraton");
        raceEntity4.setRaceDistance(21);

        runnerRepository.save(runnerEntity1);
        runnerRepository.save(runnerEntity2);
        runnerRepository.save(runnerEntity3);
        runnerRepository.save(runnerEntity4);
        runnerRepository.save(runnerEntity5);

        raceRepository.save(raceEntity1);
        raceRepository.save(raceEntity2);
        raceRepository.save(raceEntity3);
        raceRepository.save(raceEntity4);







        }



}