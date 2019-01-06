package com.cinibulak.conferenceorganizer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConferenceSchedule {

    private List<Track> trackList;
}
