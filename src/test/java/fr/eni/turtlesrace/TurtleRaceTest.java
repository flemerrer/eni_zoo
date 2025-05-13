package fr.eni.turtlesrace;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleRaceTest {

    private static Turtle bob;
    private static Turtle patrick;
    private static Turtle sandy;

    @BeforeAll
    static void init() {
        bob = new Turtle(1, "Bob", 15.00);
        patrick = new Turtle(2, "Patrick", 30.00);
        sandy = new Turtle(3, "Sandy", 10.00);
    }

    @Test
    void testTurtleRace() {
        ArrayList<Turtle> turtles = new ArrayList<>();
        turtles.add(bob);
        turtles.add(patrick);
        turtles.add(sandy);
        Collections.sort(turtles);
        assertEquals(sandy.getName(), turtles.getFirst().getName());
    }

}
