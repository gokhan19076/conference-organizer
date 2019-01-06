package com.cinibulak.conferenceorganizer.service;

import com.cinibulak.conferenceorganizer.model.ConferenceSchedule;
import com.cinibulak.conferenceorganizer.model.Event;
import com.cinibulak.conferenceorganizer.repository.EventRepository;
import com.cinibulak.conferenceorganizer.util.ConferenceParser;
import com.cinibulak.conferenceorganizer.util.ConferenceScheduler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ConferenceOrganizerService {

    private final ConferenceParser conferenceParser;
    private final EventRepository eventRepository;
    private final ConferenceScheduler conferenceScheduler;

    public void createConference(String requestBody) {
        log.info("==> ", requestBody);

        List<Event> eventList = conferenceParser.parse(requestBody);
        log.info("==> Length: {}", eventList.size());

        eventRepository.saveAll(eventList);
    }

    public ConferenceSchedule getConference() {
        List<Event> eventList = eventRepository.findAll();

        log.info("==> Result: ", eventList);
        return conferenceScheduler.createConferenceSchedule(eventList);
    }
}

