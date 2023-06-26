package com.example.project;

import java.util.Arrays;
import java.util.List;

public class Rover {
    public int posX;
    public int posY;
    public char currentDir;

    public int currentDirIndex;

    private char allDir[] = { 'N', 'E', 'S', 'W' };
    private int moveXByDir[] = { 0, 1, 0, -1};
    private int moveYByDir[] = { 1, 0, -1, 0};

    public Rover(int posX, int posY, char dir) {
        this.posX = posX;
        this.posY = posY;
        this.currentDir = dir;

        for (int i = 0; i < allDir.length; i++) {
            if (allDir[i] == dir) {
                this.currentDirIndex = i; 
            }
        }
    }

    public void turnRight() {
        currentDirIndex = (currentDirIndex + 1) % 4;
        currentDir = allDir[currentDirIndex];
    }

    public void turnLeft() {
        currentDirIndex = currentDirIndex - 1 >= 0 ? currentDirIndex - 1 : 3;
        currentDir = allDir[currentDirIndex];
    }

    public void move() {
        this.posX = this.posX + moveXByDir[currentDirIndex];
        this.posY = this.posY + moveYByDir[currentDirIndex];
    }

    public String toString() {
        return posX + " " + posY + " " + currentDir + "\n";
    }
}