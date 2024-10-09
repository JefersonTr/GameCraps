package org.example.crapsgame.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import org.example.crapsgame.model.Dice;
import org.example.crapsgame.model.Game;

import java.util.ArrayList;

public class GameController {

    @FXML
    private Label pointLabel, shootLabel;

    @FXML
    private Label pointLabel1, shotLabel1;

    @FXML
    private ImageView dice1ImageView, dice2ImageView;





    Dice dice1, dice2;
    Game game;
    ArrayList<Game> games = new ArrayList<Game>();

    public GameController() {
        this.dice1 = new Dice();
        this.dice2 = new Dice();
        this.game = new Game(); //Se crea un objeto de la clase Game


    }

    @FXML
    public void onHandleButtonRollTheDice(ActionEvent event) {
        this.dice1.rollDice();
        this.dice2.rollDice();
        this.dice1ImageView.setImage(this.dice1.getDiceImage());
        this.dice2ImageView.setImage(this.dice2.getDiceImage());

        //Variable resultado para mandar los valores y hacer uso de objeto Game
        int resultado = this.game.rollDices(this.dice1.getValue(), this.dice2.getValue());
        shootLabel.setText(String.valueOf(resultado)); // interfaz con valor del tiro

        if (game.getShootCount() == 1) { //Cuando el tiro sea 1 (el primero)
            Primer_tiro(resultado);  //(Se usa función para gestionar el primer tiro)
        } else {
            Resto_tiros(resultado); //Función para el resto de los tiros.
        }

        // Actualizar las veces ganadas y perdidas
        Puntos_Win_Lose();
    }

    // Función que gestiona el primer tiro, dado si es tiro ganador o tiro perdedor o si debe mantener el punto
    private void Primer_tiro(int resultado) {
        if (resultado == 7 || resultado == 11) {
            System.out.println("Ganaste.");
            game.isWin();
            game.resetGame();
        } else if (resultado == 2 || resultado == 3 || resultado == 12) {
            System.out.println("Perdiste.");
            game.isLose();
            game.resetGame();
        } else {
            System.out.println("punto:" + resultado);
            pointLabel.setText(String.valueOf(resultado)); //Manda el punto al label de point
        }
    }

    //Función para el resto de tiros, es decir, cuando se establece el punto
    private void Resto_tiros(int resultado) {
        if (resultado == Integer.parseInt(pointLabel.getText())) {
            System.out.println("Ganaste haciendo el punto.");
            game.isWin();
            game.resetGame();
        } else if (resultado == 7) {
            System.out.println("Perdiste por sacar 7.");
            game.isLose();
            game.resetGame();
        }
    }
    // Establece los valores para los labels de juegos  ganados y perdidos
    private void Puntos_Win_Lose() {
        shotLabel1.setText(String.valueOf(game.getPointWin()));
        pointLabel1.setText(String.valueOf(game.getPointLose()));
    }
}