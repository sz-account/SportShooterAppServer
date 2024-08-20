package com.app.springboot.Hit;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class HitService {

    private final HitRepository hitRepository;

    public void saveAllAndFlush(List<Hit> hitList)
    {
        hitRepository.saveAllAndFlush(hitList);
    }
}
