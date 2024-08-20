package com.app.springboot.Training;

import com.app.springboot.Hit.Hit;
import com.app.springboot.User.AppUser;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity(name = "training")
public class Training {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public Date date;
    public int targetSize;
    public int distance;
    public int targets;
    public int trainingMode;

    @OneToMany(mappedBy="training")
    public List<Hit> hits;

    @ManyToOne
    @JoinColumn(name="appUser_id", nullable=false)
    public AppUser appUser;

    public long timeStamp;
}
