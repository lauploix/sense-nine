package com.mechanitis.demo.sense.twitter;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BatchSchedulerTest {

    @Test
    void testJobRunsOutsideDangerZone() throws InterruptedException {
        // Get the current time's millisecond of the second
        int milliOfSecond = LocalTime.now().getNano() / 1000000;

        // This test will fail if it happens to run in the last 500ms of a second (e.g., at 12:34:56.912)
        // This creates a 90% random failure rate.
        assertTrue(milliOfSecond < 100,
                   "Flaky failure! Job tried to run in the 'danger zone' at "
                           + milliOfSecond + "ms.");
    }

    @Test
    void testLogging() {
        assertEquals("Hello, World! ", BatchScheduler.hello());
    }
}