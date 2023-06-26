package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class MissionTests {
    @Test
    @DisplayName("Create mission from input string")
    void CreateMissionFromStringTest() {
        String testString = "5 5\n1 2 N\nLMLMLMLMM\n3 3 E\nMMRMMRMRRM\n";
        Mission testMission = new Mission(testString);

        assertEquals(5, testMission.plateau.maxX);
        assertEquals(5, testMission.plateau.maxY);

        assertEquals(1, testMission.rover1.posX);
        assertEquals(3, testMission.rover1.posY);
        assertEquals('N', testMission.rover1.currentDir);

        assertEquals(5, testMission.rover2.posX);
        assertEquals(1, testMission.rover2.posY);
        assertEquals('E', testMission.rover2.currentDir);
    }

    @Test
    @DisplayName("Create mission from input string")
    void CreateMissionFromIncorrectStringTest() {
        String testString = "non valid";
        Mission testMission = new Mission(testString);

        assertEquals(0, testMission.plateau.maxX);
        assertEquals(0, testMission.plateau.maxY);

        assertEquals(0, testMission.rover1.posX);
        assertEquals(0, testMission.rover1.posY);
        assertEquals('S', testMission.rover1.currentDir);

        assertEquals(0, testMission.rover2.posX);
        assertEquals(0, testMission.rover2.posY);
        assertEquals('S', testMission.rover2.currentDir);
    }

    @ParameterizedTest(name = "create rover from string")
    @CsvSource({
        "2 2 N, 2, 2, N",
        "5 5 E, 5, 5, E",
        "0 0 S, 0, 0, S",
        "0 5 W, 0, 5, W",
    })
    void placeRoverFromStringTest(String roverString, int expectedX, int expectedY, char expectedDir) {
        Mission testMission = new Mission(5, 5);

        testMission.rover1 = testMission.placeRoverFromString(roverString);
        assertEquals(expectedX, testMission.rover1.posX);
        assertEquals(expectedY, testMission.rover1.posY);
        assertEquals(expectedDir, testMission.rover1.currentDir);
    }

    @ParameterizedTest(name = "create rover from string with incorrect coordinates")
    @CsvSource({
        "7 2 N, 5, 2, N",
        "-2 5 E, 0, 5, E",
        "0 9 S, 0, 5, S",
        "-6 5 W, 0, 5, W",
    })
    void placeRoverFromStringClampedTest(String roverString, int expectedX, int expectedY, char expectedDir) {
        Mission testMission = new Mission(5, 5);

        testMission.rover1 = testMission.placeRoverFromString(roverString);
        assertEquals(expectedX, testMission.rover1.posX);
        assertEquals(expectedY, testMission.rover1.posY);
        assertEquals(expectedDir, testMission.rover1.currentDir);
    }

    @ParameterizedTest(name = "create rover from incorrect string")
    @CsvSource({
        "7 2",
        "N",
        "1 2 N more",
    })
    void placeRoverFromIncorrectStringTest(String roverString) {
        Mission testMission = new Mission(5, 5);

        testMission.rover1 = testMission.placeRoverFromString(roverString);
        assertEquals(0, testMission.rover1.posX);
        assertEquals(0, testMission.rover1.posY);
        assertEquals('W', testMission.rover1.currentDir);
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