package com.cinibulak.conferenceorganizer.util;

import com.cinibulak.conferenceorganizer.model.Event;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ConferenceParser {

    public List<Event> parse(String body) {
        String[] lines = body.split("\n");

        List<Event> eventList = new ArrayList<>();

        for (String line : lines) {
            int indexOfLastSpace = line.lastIndexOf(StringUtils.SPACE);
            String name = line.substring(0, indexOfLastSpace);
            String durationAsString = line.substring(indexOfLastSpace + 1);

            int duration;
            boolean isLightning = false;
            if (durationAsString.equals("lightning")) {
                isLightning = true;
                duration = 5;
            } else {
                int indexOfMinute = durationAsString.lastIndexOf("min");
                duration = Integer.parseInt(durationAsString.substring(0, indexOfMinute));
            }

            Event event = new Event(name, duration, isLightning);
            eventList.add(event);
        }

        return eventList;
    }
}
