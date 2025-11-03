package com.mechanitis.demo.sense.twitter;

import org.junit.jupiter.api.Test;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;

import static org.junit.jupiter.api.Assertions.fail;

public class ExternalApiServiceTest {


    @Test
    void testExternalServiceConnection() {
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("localhost", 9876), 100);
            socket.close();
            // If it *does* connect (unlikely), force a failure
            fail("Test server was unexpectedly running on port 9876");

        } catch (SocketTimeoutException e) {
            // This is our simulated "flaky network timeout"
            fail("Failed to connect to external service: " + e.getMessage());
        } catch (Exception e) {
            // This will likely be a "Connection refused" error, also good!
            fail("Failed to connect to external service: " + e.getMessage());
        }
    }
}
