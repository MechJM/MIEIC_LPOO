package com.aor.refactoring.example5;

public class Turtle {
    private int row;
    private int column;
    private char direction;

    public Turtle(int row, int column, char direction) {
        this.row = row;
        this.column = column;
        this.direction = direction;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public char getDirection() {
        return direction;
    }

    private void rotateLeft() {
        if (direction == 'N') direction = 'W';
        else if (direction == 'W') direction = 'S';
        else if (direction == 'S') direction = 'E';
        else if (direction == 'E') direction = 'N';
    }

    private void rotateRight() {
        if (direction == 'N') direction = 'E';
        else if (direction == 'E') direction = 'S';
        else if (direction == 'S') direction = 'W';
        else if (direction == 'W') direction = 'N';
    }

    private void moveForward() {
        if (direction == 'N') row--;
        if (direction == 'S') row++;
        if (direction == 'W') column--;
        if (direction == 'E') column++;
    }

    public void execute(char command) {
        final boolean CommandisRotateLeft  = (command == 'L');
        final boolean CommandisRotateRight = (command == 'R');
        final boolean CommandisMoveForward = (command == 'F');

        if (CommandisRotateLeft) {
            rotateLeft();
        } else if (CommandisRotateRight){
            rotateRight();
        } else if (CommandisMoveForward){
            moveForward();
        }
    }
}
