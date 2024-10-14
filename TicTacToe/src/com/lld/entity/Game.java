package com.lld.entity;

import java.util.Stack;

public class Game {
    Player player1;
    Player player2;
    Stack<Move> previousMoves;
    Boolean isGameOver;
    String winner;

    public Game(Player player1, Player player2, int n) {
        this.player1 = player1;
        this.player2 = player2;
        this.previousMoves = new Stack<>();
        this.board = new Board(n);
        isGameOver = false;
    }

    public boolean isGameOver(){
        return isGameOver;
    }

    Board board;

    public void showBoard(){
        this.board.printBoardStatus();
    }
    public boolean nextMove(int row, int col, int value){
        if(this.isGameOver){
            System.out.println("Game Has Ended, "+ winner);
            return true;
        }

        if(!isMyTurn(value)){
            System.out.println("Please wait for your turn");
            return false;
        }
        boolean moveSuccess = this.board.nextMove(row,col,value);
        if(!moveSuccess){
            return moveSuccess;
        }
        this.isGameOver = this.board.checkIfVictory(row,col);
        if(this.isGameOver){
            this.winner = (value==1?player1.getId():player2.getId()) + " is winner";
            System.out.println("Game Has Ended, "+ winner);
            return moveSuccess;
        }
        if(this.board.checkIfDraw(previousMoves.size())){
            this.winner = "No one is winner. Match Drawn !!!";
            System.out.println(this.winner);
            this.isGameOver = true;
            return moveSuccess;
        }
        Move currentMove = new Move(value==1?player1:player2,row,col);
        previousMoves.add(currentMove);
        return moveSuccess;
    }

    public boolean isMyTurn(int value){
        if(previousMoves.size()%2 == 0){
            return value == 1;
        }
        else{
            return value!=1;
        }
    }



    //public boolean checkMove()

}
