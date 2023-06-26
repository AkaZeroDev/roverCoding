package com.example.project;

public class Mission {
    public Plateau plateau;
    public Rover rover1;
    public Rover rover2;

    public Mission(int maxX, int maxY) {
        this.plateau = new Plateau(maxX, maxY);
    }

    public Mission(String input) {
        String[] inputSplit = input.split("\n");

        if (inputSplit.length != 5) {
            this.plateau = new Plateau(0, 0);
            this.rover1 = placeRover(0, 0, 'S');
            this.rover2 = placeRover(0, 0, 'S');
            return;
        }

        String[] dimensionSplit = inputSplit[0].split((" "));
        this.plateau = new Plateau(Integer.parseInt(dimensionSplit[0]), Integer.parseInt(dimensionSplit[1]));

        this.rover1 = placeRoverFromString(inputSplit[1]);
        moveRoverFromString(inputSplit[2], this.rover1);

        this.rover2 = placeRoverFromString(inputSplit[3]);
        moveRoverFromString(inputSplit[4], this.rover2);
    }

    private Rover placeRover(int x, int y, char dir) {
        return new Rover(x, y, dir);
    }

    // Ensures the val parameter is between min and max
    // overflow are clamped
    private int clamp(int min, int max, int val) {
        if (val < min) {
            return min;
        } else if (val > max) {
            return max;
        }
        return val;
    }

    public Rover placeRoverFromString(String roverString) {
        String[] roverStringSplit = roverString.split(" ");

        if (roverStringSplit.length != 3) {
            return placeRover(0, 0, 'W');
        }

        // Direction only considers the first char
        return placeRover(
            clamp(0 ,this.plateau.maxX ,Integer.parseInt(roverStringSplit[0])),
            clamp(0 ,this.plateau.maxY ,Integer.parseInt(roverStringSplit[1])),
            roverStringSplit[2].charAt(0)
        );
    }

    public void moveRoverFromString(String commandsString, Rover r) {
        // Possible commands are L (turn left), R (turn right) and M (move forward)
        // Any other commande retrieved is ignored
        for (char cmd:commandsString.toCharArray()) {
            switch (cmd) {
                case 'L':
                    r.turnLeft();
                    break;
                case 'R':
                    r.turnRight();
                    break;
                case 'M':
                    r.move();
                    break;
                default:
                    break;
            }
        }
    }

    public String toString() {
        return this.rover1.toString() + "\n" + this.rover2.toString();
    }
}