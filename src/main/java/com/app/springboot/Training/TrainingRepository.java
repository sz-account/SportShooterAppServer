package com.app.springboot.Training;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training, Long> {

    @Transactional
    @Query("SELECT t FROM training t WHERE t.timeStamp > :timestamp and t.appUser.googleId = :userId")
    List<Training> findAllWithTimestampGreaterThan(long timestamp, String userId);
}
