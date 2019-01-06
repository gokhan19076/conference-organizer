package com.cinibulak.conferenceorganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private int duration;
    private boolean isLightning;
    private LocalTime startTime;

    public Event(String name, int duration, boolean isLightning) {
        this.name = name;
        this.duration = duration;
        this.isLightning = isLightning;
    }

    public LocalTime getEndTime() {
        return startTime.plusMinutes(duration);
    }
}
