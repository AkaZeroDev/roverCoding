package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RoverTests {
    @ParameterizedTest(name = "turn left from direction {0}")
    @CsvSource({
        "N,    W",
        "W,    S",
        "S,    E",
        "E,    N",
    })
    void turnLeftTest(char dirBeforeTurn, char dirAfterTurn) {
        Rover testRover = new Rover(2, 2, dirBeforeTurn);
        testRover.turnLeft();
        assertEquals(dirAfterTurn, testRover.currentDir);
        assertEquals(2 + " " + 2 + " " + dirAfterTurn   , testRover.toString());
    }

    @ParameterizedTest(name = "turn right from direction {0}")
    @CsvSource({
        "N,    E",
        "W,    N",
        "S,    W",
        "E,    S",
    })
    void turnRightTest(char dirBeforeTurn, char dirAfterTurn) {
        Rover testRover = new Rover(2, 2, dirBeforeTurn);
        testRover.turnRight();
        assertEquals(dirAfterTurn, testRover.currentDir);
    }

    @ParameterizedTest(name = "move in direction {0}")
    @CsvSource({
        "N, 2, 3",
        "W, 1, 2",
        "S, 2, 1",
        "E, 3, 2",
    })
    void moveTest(char dir, int posXAfter, int posYAfter) {
        Rover testRover = new Rover(2, 2, dir);
        testRover.move();
        assertEquals(posXAfter, testRover.posX);
        assertEquals(posYAfter, testRover.posY);
    }
}