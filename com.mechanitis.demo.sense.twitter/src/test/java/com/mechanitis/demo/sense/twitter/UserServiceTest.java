package com.mechanitis.demo.sense.twitter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {
    @Test
    void testItemCountIncludesBonus() {
        UserService service = new UserService();
        assertEquals(6, service.getAccessibleItemCount(5),
                     "User should get 5 base items + 1 bonus item");
    }
}