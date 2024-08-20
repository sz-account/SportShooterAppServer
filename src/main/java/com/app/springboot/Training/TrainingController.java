package com.app.springboot.Training;

import com.app.springboot.Hit.Hit;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping(path = "/training")
public class TrainingController {

    private final TrainingService trainingService;

    @GetMapping
    public List<Training> findAll()
    {
        return trainingService.findAll();
    }

    record NewTrainingRequest(Date date, int targetSize, int distance, int targets, int gameMode, List<Hit> hits){}

    @PostMapping
    public void insertAll(@RequestBody List<NewTrainingRequest> requests)
    {
        trainingService.insertAll(requests);
    }

    @PostMapping("/ts")
    public List<Training> findAllWithTimestampGreaterThan(@RequestParam long time)
    {
        return trainingService.findAllWithTimestampGreaterThan(time);
    }
}
