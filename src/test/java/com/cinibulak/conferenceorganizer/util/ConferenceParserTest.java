package com.cinibulak.conferenceorganizer.util;

import com.cinibulak.conferenceorganizer.model.Event;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class ConferenceParserTest {

    private ConferenceParser conferenceParser;

    @BeforeEach
    void setUp() {
        conferenceParser = new ConferenceParser();
    }

    @Test
    void parse() {
        // Given
        String body = "Architecting Your Codebase 60min\n" +
                "Overdoing it in Python 45min\n" +
                "Flavors of Concurrency in Java 30min\n" +
                "Ruby Errors from Mismatched Gem Versions 45min\n" +
                "JUnit 5 - Shaping the Future of Testing on the JVM 45min\n" +
                "Cloud Native Java lightning\n" +
                "Communicating Over Distance 60min\n" +
                "AWS Technical Essentials 45min\n" +
                "Continuous Delivery 30min\n" +
                "Monitoring Reactive Applications 30min\n" +
                "Pair Programming vs Noise 45min\n" +
                "Rails Magic 60min\n" +
                "Microservices \"Just Right\" 60min\n" +
                "Clojure Ate Scala (on my project) 45min\n" +
                "Perfect Scalability 30min\n" +
                "Apache Spark 30min\n" +
                "Async Testing on JVM 60min\n" +
                "A World Without HackerNews 30min\n" +
                "User Interface CSS in Apps 30min";

        // When
        List<Event> eventList = conferenceParser.parse(body);

        // Then
        Assert.assertEquals(19, eventList.size());
    }
}