package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point = 0;
    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        return this.shootCount;
    }

    public int getPoint() {
        return this.point;
    }

    public boolean isWin() {
        return this.win;
    }

    public boolean isLose() {
        return this.lose;
    }

    public int rollDices() {
        return this.shoot;
    }

}
