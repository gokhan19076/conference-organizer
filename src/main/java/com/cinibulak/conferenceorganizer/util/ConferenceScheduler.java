package com.cinibulak.conferenceorganizer.util;

import com.cinibulak.conferenceorganizer.model.ConferenceSchedule;
import com.cinibulak.conferenceorganizer.model.Event;
import com.cinibulak.conferenceorganizer.model.Track;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
public class ConferenceScheduler {

    public ConferenceSchedule createConferenceSchedule(List<Event> eventList) {
        eventList.sort(Comparator.comparing(Event::getDuration, Comparator.reverseOrder()));

        List<Track> trackList = new ArrayList<>();
        for (Event event : eventList) {
            boolean isEventScheduled = false;

            for (Track track : trackList) {
                if (track.addEvent(event)) {
                    isEventScheduled = true;
                    break;
                }
            }

            if (!isEventScheduled) {
                Track track = new Track();
                track.addEvent(event);
                trackList.add(track);
            }
        }

        for (Track track : trackList) {
            track.addNetworkingEvent();
        }

        return new ConferenceSchedule(trackList);
    }
}
