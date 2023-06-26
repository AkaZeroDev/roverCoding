package com.example.project;

public class Mission {
    private Plateau plateau;
    public Rover rover1;
    public Rover rover2;

    public Mission(int maxX, int maxY) {
        this.plateau = new Plateau(maxX, maxY);
    }

    private Rover placeRover(int x, int y, char dir) {
        return new Rover(x, y, dir);
    }

    private Rover placeRoverFromString(String roverString) {
        String[] roverStringSplit = roverString.split(" ");

        return placeRover(
            Integer.parseInt(roverStringSplit[0]),
            Integer.parseInt(roverStringSplit[1]),
            roverStringSplit[2].charAt(0)
        );
    }

    public void placeFirstRoverFromString(String roverString) {
        this.rover1 = placeRoverFromString(roverString);
    }

    public void placeSecondRoverFromString(String roverString) {
        this.rover2 = placeRoverFromString(roverString);
    }
}