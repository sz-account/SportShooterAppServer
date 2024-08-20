package com.app.springboot.Training;

import com.app.springboot.Hit.Hit;
import com.app.springboot.Hit.HitService;
import com.app.springboot.Training.TrainingController.NewTrainingRequest;
import com.app.springboot.User.AppUser;
import com.app.springboot.User.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

@Service
@AllArgsConstructor
public class TrainingService {

    private final TrainingRepository trainingRepository;
    private final HitService hitService;
    private final AppUserService appUserService;
    public List<Training> findAll()
    {
        return trainingRepository.findAll();
    }

    public void insertAll(@RequestBody List<NewTrainingRequest> requests)
    {
        List<Training> trainingList = new LinkedList<>();
        List<Hit> hitList = new LinkedList<>();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        AppUser appUser = appUserService.getUser();

        for (NewTrainingRequest request: requests)
        {
            Training training = new Training();
            training.appUser = appUser;
            training.setDate(request.date());
            training.setDistance(request.distance());
            training.setTargetSize(request.targetSize());
            training.setTargets(request.targets());
            training.setTimeStamp(timestamp.getTime());
            training.setTrainingMode(request.gameMode());

            for (Hit v: request.hits()) {

                Hit hit = new Hit();
                hit.training = training;
                hit.time = v.time;
                hitList.add(hit);
            }

            trainingList.add(training);
        }

        trainingRepository.saveAllAndFlush(trainingList);
        hitService.saveAllAndFlush(hitList);
    }

    public List<Training> findAllWithTimestampGreaterThan(long time)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return trainingRepository.findAllWithTimestampGreaterThan(time, auth.getName());
    }
}
