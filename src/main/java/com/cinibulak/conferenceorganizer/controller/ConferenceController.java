package com.cinibulak.conferenceorganizer.controller;

import com.cinibulak.conferenceorganizer.model.ConferenceSchedule;
import com.cinibulak.conferenceorganizer.service.ConferenceOrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ConferenceController {

    private final ConferenceOrganizerService conferenceOrganizerService;

    @PostMapping(value = "/conferences", consumes = MediaType.TEXT_PLAIN_VALUE)
    public ResponseEntity<Void> createConference(@RequestBody String requestBody) {
        conferenceOrganizerService.createConference(requestBody);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(value = "/conferences")
    public ResponseEntity<ConferenceSchedule> getConference() {
        ConferenceSchedule conference = conferenceOrganizerService.getConference();
        return ResponseEntity.status(HttpStatus.OK).body(conference);
    }
}
