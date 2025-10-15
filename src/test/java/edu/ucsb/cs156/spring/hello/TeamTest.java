package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assertEquals("test-team", team.getName());
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
   
    @Test
    public void equals_returns_correct_result() {
        assertTrue(team.equals(team));
        Team team2 = new Team("test-team");
        assertTrue(team.equals(team2));
        Team team3 = new Team("different-team");
        assertTrue(!team.equals(team3));
        assertTrue(!team.equals(null));
    }

    @Test
    public void hashCode_returns_correct_result() {
        Team team2 = new Team("test-team");
        assertEquals(team.hashCode(), team2.hashCode());
        Team team3 = new Team("test-team");
        team2.addMember("Bob");
        team3.addMember("Bob");
        assertEquals(team2.hashCode(), team3.hashCode());
    
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);



    }


}
