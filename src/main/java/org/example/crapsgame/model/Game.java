package org.example.crapsgame.model;

public class Game {
    private int shootCount;
    private int shoot;
    private int point_win;
    private int point_lose;
    private boolean win;
    private boolean lose;
    Dice dice1, dice2;

    public Game() {
        this.shootCount = 0;
        this.shoot = 0;
        this.point_win = 0;
        this.point_lose = 0;
        this.win = false;
        this.lose = false;

    }

    public int getShoot() {
        return this.shoot;
    }

    public int getShootCount() {
        //System.out.println(shootCount);
        return this.shootCount;
    }

    public int getPointWin() {
        //System.out.println(point);
        return this.point_win;
    }

    public int getPointLose() {
        return this.point_lose;
    }
    public boolean isWin() {
        this.point_win++;
        return this.win == true;
    }

    public boolean isLose() {
        this.point_lose++;
        return this.lose == true;
    }

    public void resetGame() {
        this.shootCount = 0;
        this.shoot = 0;
        this.win = false;
        this.lose = false;
    }

    public int rollDices(int dice1Value, int dice2Value) {
        shoot = dice1Value + dice2Value; //Se obtiene el valor de dados
        //System.out.println(shoot);
        this.shootCount++; //Se incrementa contador de tiros
        return this.shoot;
    }


}
