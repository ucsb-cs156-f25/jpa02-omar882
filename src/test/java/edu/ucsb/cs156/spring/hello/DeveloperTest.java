package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Omar A.", Developer.getName());
    }

    @Test
    public void getGithubId_returns_correct_githubId() {
        assertEquals("omar882", Developer.getGithubId());
    }

    @Test
    public void getTeam_returns_team_with_correct_name() {
        Team  t = Developer.getTeam();
        assertEquals("f25-16", t.getName());
        assertTrue(t.getMembers().contains("OMAR AHMED"),"Team should contain OMAR AHMED");
        assertTrue(t.getMembers().contains("MIHIR"),"Team should contain MIHIR");
        assertTrue(t.getMembers().contains("ALEX "), "Team should contain ALEX");
        assertTrue(t.getMembers().contains("QUINN THEODORE ROGER"), "Team should contain QUINN THEODORE ROGER");
        assertTrue(t.getMembers().contains("SAQIF AYAAN"), "Team should contain SAQIF AYAAN");
        assertTrue(t.getMembers().contains("WILLIAM PAUL"), "Team should contain WILLIAM PAUL");
    }

}
