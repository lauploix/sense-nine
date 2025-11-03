
package com.mechanitis.demo.sense.twitter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ApiKeyTest {
    @Test
    void testPremiumFeatureIntegration() {
        // This variable is set by the CI runner via secrets
        String apiKey = System.getenv("SENSE_NINE_API_KEY");

        // The test fails locally because apiKey is null
        assertNotNull(apiKey, "Environment variable 'SENSE_NINE_API_KEY' is not set!");

        // Example test logic
        assertTrue(apiKey.startsWith("prod_"), "API key format is incorrect.");
    }
}