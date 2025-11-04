package com.mechanitis.demo.sense.twitter;

import org.junit.jupiter.api.RepeatedTest;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BatchSchedulerTest {

    @RepeatedTest(value = 20)
    void testJobRunsOutsideDangerZone() throws InterruptedException {
        // Get the current time's millisecond of the second
        int milliOfSecond = LocalTime.now().getNano() / 1000000;
        Thread.sleep(100);

        // This test will fail if it happens to run in the
        // last 100ms of a second (e.g., at 12:34:56.912)
        // This creates a 10% random failure rate.
        assertTrue(milliOfSecond < 900,
                   "Flaky failure! Job tried to run in the 'danger zone' at "
                           + milliOfSecond + "ms.");
    }

    @RepeatedTest(value = 20)
    void testLogging() {
        assertEquals("Hello, World! ", BatchScheduler.hello());
    }
}