package com.cinibulak.conferenceorganizer.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Track {

    @JsonIgnore
    private final int MORNING_SESSION_TOTAL_DURATION = 180;
    @JsonIgnore
    private final int AFTERNOON_SESSION_TOTAL_DURATION = 240;

    private String name;
    private List<Event> morningEventList;
    private List<Event> afternoonEventList;

    public Track(String name) {
        this.name = name;
        this.morningEventList = new ArrayList<>();
        this.afternoonEventList = new ArrayList<>();
    }

    public boolean addEvent(Event event) {
        if (getFreeTimeInMorningSession() >= event.getDuration()) {
            if (morningEventList.size() == 0) {
                event.setStartTime(LocalTime.of(9, 0));
            } else {
                Event lastTalk = morningEventList.get(morningEventList.size() - 1);
                event.setStartTime(lastTalk.getEndTime());
            }
            morningEventList.add(event);
            return true;
        } else if (getFreeTimeInAfternoonSession() >= event.getDuration()) {
            if (afternoonEventList.size() == 0) {
                event.setStartTime(LocalTime.of(13, 0));
            } else {
                Event lastEvent = afternoonEventList.get(afternoonEventList.size() - 1);
                event.setStartTime(lastEvent.getEndTime());
            }
            afternoonEventList.add(event);
            return true;
        } else {
            return false;
        }
    }

    private int getScheduledDuration(List<Event> eventList) {
        if (eventList == null) {
            return 0;
        }

        int scheduledDuration = 0;
        for (Event event : eventList) {
            scheduledDuration += event.getDuration();
        }
        return scheduledDuration;
    }

    private int getFreeTimeInMorningSession() {
        return MORNING_SESSION_TOTAL_DURATION - getScheduledDuration(morningEventList);
    }

    private int getFreeTimeInAfternoonSession() {
        return AFTERNOON_SESSION_TOTAL_DURATION - getScheduledDuration(afternoonEventList);
    }

    public void addNetworkingEvent() {
        Event networkingEvent = new Event("Networking Event", 60, false);
        Event lastEvent = afternoonEventList.get(afternoonEventList.size() - 1);

        LocalTime startTime;
        if (lastEvent.getEndTime().isBefore(LocalTime.of(16, 0))) {
            startTime = LocalTime.of(16, 0);
        } else {
            startTime = lastEvent.getEndTime();
        }

        networkingEvent.setStartTime(startTime);
        afternoonEventList.add(networkingEvent);
    }
}
