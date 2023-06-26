package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MissionTests {
    @ParameterizedTest(name = "create rover from string")
    @CsvSource({
        "2 2 N, 2, 2, N",
        "5 5 E, 5, 5, E",
        "0 0 S, 0, 0, S",
        "0 5 W, 0, 5, W",
    })
    void placeRoverFromStringTest(String roverString, int expectedX, int expectedY, char expectedDir) {
        Mission testMission = new Mission(5, 5);

        testMission.placeFirstRoverFromString(roverString);
        assertEquals(expectedX, testMission.rover1.posX);
        assertEquals(expectedY, testMission.rover1.posY);
        assertEquals(expectedDir, testMission.rover1.currentDir);
    }

    @ParameterizedTest(name = "create rover from string")
    @CsvSource({
        "7 2 N, 5, 2, N",
        "-2 5 E, 0, 5, E",
        "0 9 S, 0, 5, S",
        "-6 5 W, 0, 5, W",
    })
    void placeRoverFromStringTestClamped(String roverString, int expectedX, int expectedY, char expectedDir) {
        Mission testMission = new Mission(5, 5);

        testMission.placeFirstRoverFromString(roverString);
        assertEquals(expectedX, testMission.rover1.posX);
        assertEquals(expectedY, testMission.rover1.posY);
        assertEquals(expectedDir, testMission.rover1.currentDir);
    }

    @ParameterizedTest(name = "move rover from command string")
    @CsvSource({
        "1 2 N, 1, 3, N, LMLMLMLMM",
        "3 3 E, 5, 1, E, MMRMMRMRRM"
    })
    void moveRoverFromStringTest(String roverString, int expectedX, int expectedY, char expectedDir, String commandsString) {
        Mission testMission = new Mission(5, 5);
        testMission.rover1 = testMission.placeRoverFromString(roverString);

        testMission.moveRoverFromString(commandsString, testMission.rover1);
        assertEquals(expectedX, testMission.rover1.posX);
        assertEquals(expectedY, testMission.rover1.posY);
        assertEquals(expectedDir, testMission.rover1.currentDir);
    }
}