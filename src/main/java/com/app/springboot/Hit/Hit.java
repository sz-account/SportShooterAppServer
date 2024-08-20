package com.app.springboot.Hit;

import com.app.springboot.Training.Training;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "hit")
public class Hit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="training_id", nullable=false)
    public Training training;

    public Long time;
}
