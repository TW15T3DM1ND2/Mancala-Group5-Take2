package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ArcadeMultiPlayer implements Initializable  {

    //field
    private Stage stage;
    private Scene scene;
    private Parent root;

    private Board gameBoard;

    public boolean firstRound;
    public int stones;

    //Declaration of player variables
    private static User player1;
    private static User player2;

    public boolean halfHandTri;
    public boolean reverseTurnTri;
    public boolean switchSideTri;




    private int frequencyOfPowerUpsAndSpecialStone;




//    public boolean player1ContinueTurn;
//    public boolean player2ContinueTurn;
//    public boolean player1DoublePoint;
//    public boolean player2DoublePoint;
//
//    private boolean player2PowerUps;
//    private boolean moveAntiClockwise;
//    private int stoneTriggerProb;


    //constructor
    public ArcadeMultiPlayer() {

        this.frequencyOfPowerUpsAndSpecialStone = 0;
        gameBoard = new Board();
//        playerNumber1 = 1;
//        playerNumber2 = 2;

        //Initializing Player Objects
        player1 = new User();
        player2 = new User();
    }

    public ArcadeMultiPlayer(int stones) {
        gameBoard = new Board(stones);
//        playerNumber1 = 1;
//        playerNumber2 = 2;

        //Initializing Player Objects
        player1 = new User();
        player2 = new User();
    }

    public ArcadeMultiPlayer(int stones, User player1) {
        gameBoard = new Board(stones);
        this.player1 = player1;
        player2 = new User();
    }
    public void resetBoard() {

        gameBoard.getPlayer1Side().getPit(0).setPitValue(4);
        gameBoard.getPlayer1Side().getPit(1).setPitValue(4);
        gameBoard.getPlayer1Side().getPit(2).setPitValue(4);
        gameBoard.getPlayer1Side().getPit(3).setPitValue(4);
        gameBoard.getPlayer1Side().getPit(4).setPitValue(4);
        gameBoard.getPlayer1Side().getPit(5).setPitValue(4);
        gameBoard.getPlayer1Store().setPitValue(0);
        gameBoard.getPlayer2Side().getPit(0).setPitValue(4);
        gameBoard.getPlayer2Side().getPit(1).setPitValue(4);
        gameBoard.getPlayer2Side().getPit(2).setPitValue(4);
        gameBoard.getPlayer2Side().getPit(3).setPitValue(4);
        gameBoard.getPlayer2Side().getPit(4).setPitValue(4);
        gameBoard.getPlayer2Side().getPit(5).setPitValue(4);
        gameBoard.getPlayer2Store().setPitValue(0);

        displayBoard();

        System.out.println("You have Reset the Board");
        System.out.println(player1);


    }

    @FXML
    public Label labelpit0, labelpit1, labelpit2, labelpit3, labelpit4, labelpit5, labelpit6, labelpit7, labelpit8, labelpit9, labelpit10, labelpit11, labelpit12, labelpit13;

    public void displayBoard() {
        labelpit0.setText(String.valueOf(gameBoard.getPlayer1Side().getPit(0).getPitValue()));
        labelpit1.setText(String.valueOf(gameBoard.getPlayer1Side().getPit(1).getPitValue()));
        labelpit2.setText(String.valueOf(gameBoard.getPlayer1Side().getPit(2).getPitValue()));
        labelpit3.setText(String.valueOf(gameBoard.getPlayer1Side().getPit(3).getPitValue()));
        labelpit4.setText(String.valueOf(gameBoard.getPlayer1Side().getPit(4).getPitValue()));
        labelpit5.setText(String.valueOf(gameBoard.getPlayer1Side().getPit(5).getPitValue()));
        labelpit6.setText(String.valueOf(gameBoard.getPlayer1Store().getPitValue()));
        labelpit7.setText(String.valueOf(gameBoard.getPlayer2Side().getPit(0).getPitValue()));
        labelpit8.setText(String.valueOf(gameBoard.getPlayer2Side().getPit(1).getPitValue()));
        labelpit9.setText(String.valueOf(gameBoard.getPlayer2Side().getPit(2).getPitValue()));
        labelpit10.setText(String.valueOf(gameBoard.getPlayer2Side().getPit(3).getPitValue()));
        labelpit11.setText(String.valueOf(gameBoard.getPlayer2Side().getPit(4).getPitValue()));
        labelpit12.setText(String.valueOf(gameBoard.getPlayer2Side().getPit(5).getPitValue()));
        labelpit13.setText(String.valueOf(gameBoard.getPlayer2Store().getPitValue()));
        System.out.println("You have displayed a new Board");

        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }
    }

    @FXML
    public Button buttonpit0, buttonpit1,buttonpit2,buttonpit3,buttonpit4,buttonpit5,buttonpit7,buttonpit8,buttonpit9,buttonpit10,buttonpit11,buttonpit12;
    public Label store;

    public void buttonpit0() {
        validMove(gameBoard, true, 0);
    }
    public void buttonpit1() {
        validMove(gameBoard, true, 1);
    }
    public void buttonpit2() {
        validMove(gameBoard, true, 2);
    }
    public void buttonpit3() {
        validMove(gameBoard, true, 3);
    }
    public void buttonpit4() {
        validMove(gameBoard, true, 4);
    }
    public void buttonpit5() {
        validMove(gameBoard, true, 5);
    }
    public void buttonpit7() {
        validMove(gameBoard, false, 0);
    }
    public void buttonpit8() {
        validMove(gameBoard, false, 1 );
    }
    public void buttonpit9() {
        validMove(gameBoard, false, 2);
    }
    public void buttonpit10() {
        validMove(gameBoard, false, 3);
    }
    public void buttonpit11() {
        validMove(gameBoard, false, 4);
    }
    public void buttonpit12() {
        validMove(gameBoard, false, 5);
    }

    public void checkGameOver(Board gameBoard){

        if (gameBoard.player1sideEmpty() | gameBoard.player2sideEmpty()){
            System.out.println("Game Over");
            for (int i = 0; i <= 5 ; i++) {
                int store1 = gameBoard.Player1Store.getPitValue();
                int store2 = gameBoard.Player2Store.getPitValue();
                int value1 = gameBoard.getPitValue(true, i);
                int value2 = gameBoard.getPitValue(false, i);

                gameBoard.setPitValue(true, i, 0);
                gameBoard.setPitValue(false, i, 0);
                gameBoard.Player1Store.setPitValue(store1 + value1);
                gameBoard.Player2Store.setPitValue(store2 + value2);

            }
        }
    }


    //assets
    @FXML
    Label turnMessage;
    @FXML
    Label invalidTurnMessage;
    @FXML
    Label SpecialStoneMessage;
    Label PowerUpsMessage;


    //methods



    public void validMove(Board gameBoard, boolean player1Side, int pitPressed) {

        if (player1.isCurrentTurn) {
            if (player1Side && pitPressed <= 5 && Math.random() > 0.1) {
                if(gameBoard.getPitValue(true,pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                }
                else{
                    makeMove(gameBoard, true, pitPressed);
                    invalidTurnMessage.setText("processing");
                }
            }

            else if (player1Side && pitPressed <= 5 && Math.random() <= 0.033) {
                if(gameBoard.getPitValue(true,pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                }
                else{
                    halfHand(gameBoard, true, pitPressed);
                    invalidTurnMessage.setText("A Half hand special stone has been triggered.");
                }
            }

            else if (player1Side && pitPressed <= 5 &&  Math.random() > 0.033 && Math.random() <= 0.066) {
                if (gameBoard.getPitValue(true, pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                }
                else {
                    reverseTurn(gameBoard, true, pitPressed);
                    invalidTurnMessage.setText("A reverse turn special stone has been triggered.");
                }
            }

            else if (player1Side && pitPressed <= 5 && Math.random() >0.66 && Math.random() <= 0.1) {
                if (gameBoard.getPitValue(true, pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                } else {
                    switchSides(gameBoard, true, pitPressed);
                    invalidTurnMessage.setText("A switch sides special stone has been triggered.");
                }
            }
            else {
                System.out.println("Pit is invalid. Please choose a pit on your side.");
                invalidTurnMessage.setText("Pit is invalid. Please choose a pit on your side.");
            }

        }
        else {
            if (!player1Side && pitPressed <= 5 && Math.random() >= 0.1) {
                if(gameBoard.getPitValue(false,pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                }
                else{
                    makeMove(gameBoard, false, pitPressed);
                    invalidTurnMessage.setText("processing");
                }
            }
            else if (!player1Side && pitPressed <= 5 && Math.random() <= 0.033) {
                if(gameBoard.getPitValue(false,pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                }
                else{
                    halfHand(gameBoard, false, pitPressed);
                    invalidTurnMessage.setText("A Half hand special stone has been triggered.");
                }
            }
            else if (!player1Side && pitPressed <= 5 && Math.random() > 0.033 && Math.random() <= 0.066) {
                if (gameBoard.getPitValue(false, pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                }
                else {
                    reverseTurn(gameBoard, false, pitPressed);
                    invalidTurnMessage.setText("A reverse turn special stone has been triggered.");
                }
            }
            else if (!player1Side && pitPressed <= 5 && Math.random() >0.066 && Math.random() <= 0.099) {
                if (gameBoard.getPitValue(false, pitPressed) == 0) {
                    invalidTurnMessage.setText("Please pick a pit with stones in!");
                } else {
                    switchSides(gameBoard, false, pitPressed);
                    invalidTurnMessage.setText("A switch sides special stone has been triggered.");
                }
            }
            else {
                System.out.println("Pit is invalid. Please choose a pit on your side.");
                invalidTurnMessage.setText("Pit is invalid. Please choose a pit on your side.");
            }

        }
    }

    public void firstPlayer(){
        if(Math.random()>0.5){
            player1.isCurrentTurn = true;
            turnMessage.setText("It is " + player1.getFirstName() +"'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else{
            player1.isCurrentTurn = false;
            turnMessage.setText("It is " + player2.getFirstName() +"'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");

            //MAKE MOVE TODO
        }

    }
    public void makeMove(Board gameBoard, Boolean player1Side, int pitPressed) {

        firstRound = true;
        stones = gameBoard.getPitValue(player1Side, pitPressed);
        gameBoard.setPitValue(player1Side, pitPressed, 0);


        while(stones>0) {

            if (!firstRound) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i)== 1) {
                            System.out.println("FLAG A");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                            System.out.println("FLAG B");
                        }
                    }
                }
            }

            else if (player1.isCurrentTurn && firstRound) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    System.out.println(i);
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    System.out.println("Stones in hand = " + stones);

                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i) == 1) {
                            System.out.println("FLAG C");
                            break;
                        } else {
                            System.out.println("FLAG D");
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && player1.isCurrentTurn) {
                if(doublePointsButton1) {
                    gameBoard.getPlayer1Store().incrementPitValue();
                    gameBoard.getPlayer1Store().incrementPitValue();
                    doublePointsButton1 = false;
                    doublePointsOn1.setStyle("-fx-border-color: red");
                }
                else{
                    gameBoard.getPlayer1Store().incrementPitValue();
                }
                    stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag E");
                    return;
                }
            }

            if (!firstRound && stones>0) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag F");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag G");
                        }
                    }
                }
            }

            else if (!player1.isCurrentTurn && firstRound && stones>0) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && !player1.isCurrentTurn) {
                if(doublePointsButton2) {
                    gameBoard.getPlayer2Store().incrementPitValue();
                    gameBoard.getPlayer2Store().incrementPitValue();
                    doublePointsButton2 = false;
                    doublePointsOn2.setStyle("-fx-border-color: red");
                }
                else{
                    gameBoard.getPlayer2Store().incrementPitValue();
                }
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag J");
                    return;
                }
            }
        }

        if(continueTurnButton1 && player1.isCurrentTurn){
            checkGameOver(gameBoard);
            displayBoard();
            invalidTurnMessage.setText("A continue turn power-ups has been used.");
            continueTurnButton1 = false;
            continueTurnOn1.setStyle("-fx-border-color: red");

            return;
        }
        if(continueTurnButton2 && !player1.isCurrentTurn){
            checkGameOver(gameBoard);
            displayBoard();
            invalidTurnMessage.setText("A continue turn power-ups has been used.");
            continueTurnButton2 = false;
            continueTurnOn2.setStyle("-fx-border-color: red");
            return;
        }

        System.out.println("Flag K");
        player1.isCurrentTurn = !player1.isCurrentTurn;



        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }
        return;
    }


    // POWER-UPS

//    //option for player to choose select power up
//    public boolean playerPowerUps() {
//
//        return false;
//    }


    public void continueTurn(Board gameBoard, boolean player1Side, int pitPressed) {

        firstRound = true;
        stones = gameBoard.getPitValue(player1Side, pitPressed);
        gameBoard.setPitValue(player1Side, pitPressed, 0);


        while(stones>0) {

            if (player1.isCurrentTurn && firstRound) {

                firstRound = true;
                stones = gameBoard.getPitValue(player1Side, pitPressed);
                gameBoard.setPitValue(player1Side, pitPressed, 0);


                while(stones>0) {

                    if (!firstRound) {

                        for (int i = 0; i <= 5; i++) {
                            gameBoard.incrementPitValue(true, i);
                            stones--;
                            if (stones == 0) {
                                if (gameBoard.getPitValue(true, i)== 1) {
                                    System.out.println("FLAG A");
                                    break;

                                } else {
                                    stones = gameBoard.getPitValue(true, i);
                                    gameBoard.setPitValue(true, i, 0);
                                    System.out.println("FLAG B");
                                }
                            }
                        }
                    }

                    else if (player1.isCurrentTurn && firstRound) {

                        for (int i = pitPressed + 1; i <= 5; i++) {
                            System.out.println(i);
                            gameBoard.incrementPitValue(true, i);
                            stones--;
                            System.out.println("Stones in hand = " + stones);

                            if (stones == 0) {
                                if (gameBoard.getPitValue(true, i) == 1) {
                                    System.out.println("FLAG C");
                                    break;
                                } else {
                                    System.out.println("FLAG D");
                                    stones = gameBoard.getPitValue(true, i);
                                    gameBoard.setPitValue(true, i, 0);
                                }
                            }
                        }
                        firstRound = !firstRound;
                    }

                    if (stones > 0 && player1.isCurrentTurn) {
                        gameBoard.getPlayer1Store().incrementPitValue();
                        stones--;
                        if (stones == 0) {
                            checkGameOver(gameBoard);
                            displayBoard();
                            System.out.println("Flag E");
                            return;
                        }
                    }

                    if (!firstRound && stones>0) {

                        for (int i = 0; i <= 5; i++) {
                            gameBoard.incrementPitValue(false, i);
                            stones--;
                            if (stones == 0) {
                                if (gameBoard.getPitValue(false, i) == 1) {
                                    System.out.println("Flag F");
                                    break;
                                } else {
                                    stones = gameBoard.getPitValue(false, i);
                                    gameBoard.setPitValue(false, i, 0);
                                    System.out.println("Flag G");
                                }
                            }
                        }
                    }

                    else if (!player1.isCurrentTurn && firstRound && stones>0) {

                        for (int i = pitPressed + 1; i <= 5; i++) {
                            gameBoard.incrementPitValue(false, i);
                            stones--;
                            if (stones == 0) {
                                if (gameBoard.getPitValue(false, i) == 1) {
                                    System.out.println("Flag H");
                                    break;
                                } else {
                                    stones = gameBoard.getPitValue(false, i);
                                    gameBoard.setPitValue(false, i, 0);
                                    System.out.println("Flag I");
                                }
                            }
                        }
                        firstRound = !firstRound;
                    }

                    if (stones > 0 && !player1.isCurrentTurn) {
                        gameBoard.getPlayer2Store().incrementPitValue();
                        stones--;
                        if (stones == 0) {
                            checkGameOver(gameBoard);
                            displayBoard();
                            System.out.println("Flag J");
                            return;
                        }
                    }
                }

                System.out.println("Flag K");
                player1.isCurrentTurn = !player1.isCurrentTurn;
                checkGameOver(gameBoard);
                System.out.println(player1Side);
                displayBoard();


                if(player1.isCurrentTurn){
                    turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
                    buttonpit0.setStyle("-fx-border-color: green");
                    buttonpit1.setStyle("-fx-border-color: green");
                    buttonpit2.setStyle("-fx-border-color: green");
                    buttonpit3.setStyle("-fx-border-color: green");
                    buttonpit4.setStyle("-fx-border-color: green");
                    buttonpit5.setStyle("-fx-border-color: green");
                    labelpit6.setStyle("-fx-border-color: green");
                    buttonpit7.setStyle("-fx-border-color: red");
                    buttonpit8.setStyle("-fx-border-color: red");
                    buttonpit9.setStyle("-fx-border-color: red");
                    buttonpit10.setStyle("-fx-border-color: red");
                    buttonpit11.setStyle("-fx-border-color: red");
                    buttonpit12.setStyle("-fx-border-color: red");
                    labelpit13.setStyle("-fx-border-color: red");
                }
                else {
                    turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
                    buttonpit0.setStyle("-fx-border-color: red");
                    buttonpit1.setStyle("-fx-border-color: red");
                    buttonpit2.setStyle("-fx-border-color: red");
                    buttonpit3.setStyle("-fx-border-color: red");
                    buttonpit4.setStyle("-fx-border-color: red");
                    buttonpit5.setStyle("-fx-border-color: red");
                    labelpit6.setStyle("-fx-border-color: red");
                    buttonpit7.setStyle("-fx-border-color: green");
                    buttonpit8.setStyle("-fx-border-color: green");
                    buttonpit9.setStyle("-fx-border-color: green");
                    buttonpit10.setStyle("-fx-border-color: green");
                    buttonpit11.setStyle("-fx-border-color: green");
                    buttonpit12.setStyle("-fx-border-color: green");
                    labelpit13.setStyle("-fx-border-color: green");
                }
                return;
            }

            if (stones > 0 && player1.isCurrentTurn) {
                gameBoard.getPlayer1Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag E");
                    return;
                }
            }

            if (!player1.isCurrentTurn && firstRound && stones>0) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                for (int i = pitPressed + 1; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && !player1.isCurrentTurn) {
                gameBoard.getPlayer2Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag J");
                    return;
                }
            }
        }
//
//        System.out.println("Flag K,continue");                    for continue turn no need to switch
//        player1.isCurrentTurn = !player1.isCurrentTurn;
//        checkGameOver(gameBoard);
//        System.out.println(player1Side);
//        displayBoard();


        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn again");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn again");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }


        return;
    }

    //double all point for one single turn
    public void doublePoints(Board gameBoard, boolean player1Side, int pitPressed) {

        firstRound = true;
        stones = gameBoard.getPitValue(player1Side, pitPressed);
        gameBoard.setPitValue(player1Side, pitPressed, 0);


        while(stones>0) {

            if (!firstRound) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i)== 1) {
                            System.out.println("FLAG A");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                            System.out.println("FLAG B");
                        }
                    }
                }
            }

            else if (player1.isCurrentTurn && firstRound) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    System.out.println(i);
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    System.out.println("Stones in hand = " + stones);

                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i) == 1) {
                            System.out.println("FLAG C");
                            break;
                        } else {
                            System.out.println("FLAG D");
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && player1.isCurrentTurn) {
                gameBoard.getPlayer1Store().incrementPitValue2();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag E");
                    return;
                }
            }

            if (!firstRound && stones>0) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag F");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag G");
                        }
                    }
                }
            }

            else if (!player1.isCurrentTurn && firstRound && stones>0) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && !player1.isCurrentTurn) {
                gameBoard.getPlayer2Store().incrementPitValue2();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag J");
                    return;
                }
            }
        }

        System.out.println("Flag K");
        player1.isCurrentTurn = !player1.isCurrentTurn;
        checkGameOver(gameBoard);
        System.out.println(player1Side);
        displayBoard();


        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }

//        doublePointsOn = false;

    }


    // SPECIAL STONES

//    //notify and activate special stone by 3.33% each
//    public int stoneTriggerProb(){
//
//        if (Math.random() <= 0.033){
//            halfHandTri = true;
//            SpecialStoneMessage.setText("A Half hand special stone had been triggered.");
//        } else if (Math.random() > 0.033 && Math.random() <=0.066 ){
//            reverseTurnTri = true;
//            SpecialStoneMessage.setText("A reverse turn special stone had been triggered.");
//        }else if (Math.random() > 0.066 && Math.random() <=0.99 ){
//            switchSideTri = true;
//            SpecialStoneMessage.setText("A switch sides special stone had been triggered.");
//
//        }
//
//        return stoneTriggerProb() ;
//    }

    //reduce pick up point by half and round up if odd number
    public void halfHand(Board gameBoard, boolean player1Side, int pitPressed) {

        firstRound = true;
        stones = gameBoard.getPitValue(player1Side, pitPressed) / 2;
        gameBoard.setPitValue(player1Side, pitPressed, 0);


        while(stones>0) {

            if (!firstRound) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i)== 1) {
                            System.out.println("FLAG A");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                            System.out.println("FLAG B");
                        }
                    }
                }
            }

            else if (player1.isCurrentTurn && firstRound) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    System.out.println(i);
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    System.out.println("Stones in hand = " + stones);

                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i) == 1) {
                            System.out.println("FLAG C");
                            break;
                        } else {
                            System.out.println("FLAG D");
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && player1.isCurrentTurn) {
                gameBoard.getPlayer1Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag E");
                    return;
                }
            }

            if (!firstRound && stones>0) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag F");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag G");
                        }
                    }
                }
            }

            else if (!player1.isCurrentTurn && firstRound && stones>0) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && !player1.isCurrentTurn) {
                gameBoard.getPlayer2Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag J");
                    return;
                }
            }
        }

        System.out.println("Flag K");
        player1.isCurrentTurn = !player1.isCurrentTurn;
        checkGameOver(gameBoard);
        System.out.println(player1Side);
        displayBoard();


        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }
        return;
    }



    //player next move change to clockwise position
    public void reverseTurn(Board gameBoard, boolean player1Side, int pitPressed) {

        firstRound = true;
        stones = gameBoard.getPitValue(player1Side, pitPressed);
        gameBoard.setPitValue(player1Side, pitPressed, 0);


        while(stones>0) {

            if (!firstRound) {

                for (int i = 5; i >=0; i--) {
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i)== 1) {
                            System.out.println("FLAG A");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                            System.out.println("FLAG B");
                        }
                    }
                }
            }

            else if (player1.isCurrentTurn && firstRound) {

                for (int i = 5; i <= pitPressed + 1; i--) {
                    System.out.println(i);
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    System.out.println("Stones in hand = " + stones);

                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i) == 1) {
                            System.out.println("FLAG C");
                            break;
                        } else {
                            System.out.println("FLAG D");
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && player1.isCurrentTurn) {
                gameBoard.getPlayer1Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag E");
                    return;
                }
            }

            if (!firstRound && stones>0) {

                for (int i = 5; i >= 0 ; i--) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag F");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag G");
                        }
                    }
                }
            }

            else if (!player1.isCurrentTurn && firstRound && stones>0) {

                for (int i = 5 ; i >= pitPressed + 1; i--) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && !player1.isCurrentTurn) {
                gameBoard.getPlayer2Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag J");
                    return;
                }
            }
        }

        System.out.println("Flag K");
        player1.isCurrentTurn = !player1.isCurrentTurn;
        checkGameOver(gameBoard);
        System.out.println(player1Side);
        displayBoard();


        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }
        return;
    }

    //player return all current stone to the pit and take the opposite pit/position
    public void switchSides(Board gameBoard, boolean player1Side, int pitPressed) {

        firstRound = true;
        stones = gameBoard.getPitValue(player1Side, pitPressed);
        gameBoard.setPitValue(player1Side, pitPressed, 0);


        while(stones>0) {

            if (!firstRound) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i)== 1) {
                            System.out.println("FLAG A");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                            System.out.println("FLAG B");
                        }
                    }
                }
            }

            else if (player1.isCurrentTurn && firstRound) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    System.out.println(i);
                    gameBoard.incrementPitValue(false, i);
                    stones--;
                    System.out.println("Stones in hand = " + stones);

                    if (stones == 0) {
                        if (gameBoard.getPitValue(false, i) == 1) {
                            System.out.println("FLAG C");
                            break;
                        } else {
                            System.out.println("FLAG D");
                            stones = gameBoard.getPitValue(false, i);
                            gameBoard.setPitValue(false, i, 0);
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && player1.isCurrentTurn) {
                gameBoard.getPlayer1Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag E");
                    return;
                }
            }

            if (!firstRound && stones>0) {

                for (int i = 0; i <= 5; i++) {
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i) == 1) {
                            System.out.println("Flag F");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                            System.out.println("Flag G");
                        }
                    }
                }
            }

            else if (!player1.isCurrentTurn && firstRound && stones>0) {

                for (int i = pitPressed + 1; i <= 5; i++) {
                    gameBoard.incrementPitValue(true, i);
                    stones--;
                    if (stones == 0) {
                        if (gameBoard.getPitValue(true, i) == 1) {
                            System.out.println("Flag H");
                            break;
                        } else {
                            stones = gameBoard.getPitValue(true, i);
                            gameBoard.setPitValue(true, i, 0);
                            System.out.println("Flag I");
                        }
                    }
                }
                firstRound = !firstRound;
            }

            if (stones > 0 && !player1.isCurrentTurn) {
                gameBoard.getPlayer2Store().incrementPitValue();
                stones--;
                if (stones == 0) {
                    checkGameOver(gameBoard);
                    displayBoard();
                    System.out.println("Flag J");
                    return;
                }
            }
        }

        System.out.println("Flag K");
        player1.isCurrentTurn = !player1.isCurrentTurn;
        checkGameOver(gameBoard);
        System.out.println(player1Side);
        displayBoard();


        if(player1.isCurrentTurn){
            turnMessage.setText("It is " + player1.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: green");
            buttonpit1.setStyle("-fx-border-color: green");
            buttonpit2.setStyle("-fx-border-color: green");
            buttonpit3.setStyle("-fx-border-color: green");
            buttonpit4.setStyle("-fx-border-color: green");
            buttonpit5.setStyle("-fx-border-color: green");
            labelpit6.setStyle("-fx-border-color: green");
            buttonpit7.setStyle("-fx-border-color: red");
            buttonpit8.setStyle("-fx-border-color: red");
            buttonpit9.setStyle("-fx-border-color: red");
            buttonpit10.setStyle("-fx-border-color: red");
            buttonpit11.setStyle("-fx-border-color: red");
            buttonpit12.setStyle("-fx-border-color: red");
            labelpit13.setStyle("-fx-border-color: red");
        }
        else {
            turnMessage.setText("It is " + player2.getFirstName() + "'s turn");
            buttonpit0.setStyle("-fx-border-color: red");
            buttonpit1.setStyle("-fx-border-color: red");
            buttonpit2.setStyle("-fx-border-color: red");
            buttonpit3.setStyle("-fx-border-color: red");
            buttonpit4.setStyle("-fx-border-color: red");
            buttonpit5.setStyle("-fx-border-color: red");
            labelpit6.setStyle("-fx-border-color: red");
            buttonpit7.setStyle("-fx-border-color: green");
            buttonpit8.setStyle("-fx-border-color: green");
            buttonpit9.setStyle("-fx-border-color: green");
            buttonpit10.setStyle("-fx-border-color: green");
            buttonpit11.setStyle("-fx-border-color: green");
            buttonpit12.setStyle("-fx-border-color: green");
            labelpit13.setStyle("-fx-border-color: green");
        }
        return;
    }


    //method return frequency of power-ups and special stones used in arcade
    public void incrementFrequencyValue(){
        this.frequencyOfPowerUpsAndSpecialStone += 1;
    }
    @FXML
    ImageView imageview1;

    @FXML
    ImageView imageview2;

    @FXML
    Label username1;

    @FXML
    Label username2;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        User player1 = LoginControllerT2.getLoggedInPlayer(1);
        User player2 = LoginControllerT2.getLoggedInPlayer(2);
        ArcadeMultiPlayer ArcadeMultiPlayer = new ArcadeMultiPlayer(4, player1);
        resetBoard();
        displayBoard();

        Image profilepic1 = new Image(getClass().getResourceAsStream("/" + player1.getUserName() + ".jpg"),150,150,false,false);
        imageview1.setImage(profilepic1);

        Image profilepic2 = new Image(getClass().getResourceAsStream("/" + player2.getUserName() + ".jpg"),150,150,false,false);
        imageview2.setImage(profilepic2);

        username1.setText(player1.getFirstName());
        username2.setText(player2.getFirstName());




        this.player1 = player1;
        this.player2 = player2;

        firstPlayer();

        invalidTurnMessage.setText("");
    }
    @FXML
    Button continueTurnOn1;
    @FXML
    Button continueTurnOn2;

    @FXML
    Button doublePointsOn1;
    @FXML
    Button doublePointsOn2;

    public void switchToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
        stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setWidth(720);
        stage.setHeight(720);
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
        System.out.println("You are now viewing the Menu");
    }


    //continue && double buttons
    public boolean continueTurnButton1 = false;
    public boolean doublePointsButton1= false;
    public boolean continueTurnButton2 = false;
    public boolean doublePointsButton2 = false;


    @FXML
    public void continueTurnOn1(ActionEvent e) throws IOException {
        continueTurnButton1 = true;
        continueTurnOn1.setStyle("-fx-border-color: red");

    }

    public void continueTurnOn2(ActionEvent e) throws IOException {
        continueTurnButton2 = true;
        continueTurnOn2.setStyle("-fx-border-color: red");

    }


    public void doublePointsOn1(ActionEvent e) throws IOException{
        doublePointsButton1 = true;
        doublePointsOn1.setStyle("-fx-border-color: red");

    }

    public void doublePointsOn2(ActionEvent e) throws IOException{
        doublePointsButton2 = true;
        doublePointsOn2.setStyle("-fx-border-color: red");

    }










}
