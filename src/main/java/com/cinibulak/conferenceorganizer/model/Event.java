package com.cinibulak.conferenceorganizer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private long id;
    private String name;
    private int duration;
    private boolean isLightning;
    @JsonFormat(pattern = "KK:mm a")
    private LocalTime startTime;

    public Event(String name, int duration, boolean isLightning) {
        this.name = name;
        this.duration = duration;
        this.isLightning = isLightning;
    }

    @JsonIgnore
    public LocalTime getEndTime() {
        return startTime.plusMinutes(duration);
    }
}
