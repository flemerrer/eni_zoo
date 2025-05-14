package fr.eni.turtlesrace;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

public class TurtleRaceTest {

    private static Turtle michelangelo;
    private static Turtle donatello;
    private static Turtle leonardo;

    @BeforeAll
    static void init() {
        michelangelo = new Turtle(1, "Michelangelo", 15.00);
        donatello = new Turtle(2, "Donatello", 30.00);
        leonardo = new Turtle(3, "Leonardo", 10.00);
    }

    @Test
    void testTurtleRace() {
        ArrayList<Turtle> turtles = new ArrayList<>();
        turtles.add(michelangelo);
        turtles.add(donatello);
        turtles.add(leonardo);
        Collections.sort(turtles);
        assertEquals(leonardo.getName(), turtles.getFirst().getName());
    }

}
