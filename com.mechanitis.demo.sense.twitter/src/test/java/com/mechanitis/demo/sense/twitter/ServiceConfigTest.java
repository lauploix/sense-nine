package com.mechanitis.demo.sense.twitter;

import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class ServiceConfigTest {
    @Test
    void testConfigLoading() {
        InputStream stream = this.getClass().getResourceAsStream("/serviceconfig.json");
        assertNotNull(stream, "Config file not found!");
    }
}
