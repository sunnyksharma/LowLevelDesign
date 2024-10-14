package com.lld.entity;

public class Board {
    Integer size;
    int[][] state;
    int[] row;
    int[] col;
    int leftDiagonal;
    int rightDiagonal;
    int availability;

    public Board(int size){
        this.size = size;
        this.state = new int[size][size];
        row = new int[size];
        col = new int[size];
        leftDiagonal = 0;
        rightDiagonal = 0;
        this.availability = (this.size * this.size);
    }

    public boolean nextMove(int r, int c, int v){
        if(this.state[r][c] != 0){
            System.out.println("The cell is occupied, Try other cells");
            return false;
            //throw new Exception("")
        }

        this.state[r][c] = v;
        row[r]+=v;
        col[c] +=v;
        if(r==c) leftDiagonal+=v;
        if(r+c == size) rightDiagonal+=v;
        this.availability--;
        return true;
    }

    public boolean checkIfVictory(int r, int c){
        return (Math.abs(row[r] )== this.size || Math.abs(col[c])==this.size || (r==c && Math.abs(leftDiagonal) == this.size) || (r+c == this.size && Math.abs(rightDiagonal)== this.size));
    }

    public boolean checkIfDraw(int count){
        if(this.availability<=1){
            System.out.println("Only available");
        }
        return this.availability<=0;
    }

    public void printBoardStatus(){
        for(int i =0; i<this.size; i++){
            for(int j=0; j< this.size; j++){
                int val = this.state[i][j];

                System.out.print(val == 0? " ": val==-1?0:val);
                System.out.print(" |");

            }
            System.out.println();
        }
        System.out.println("-----------------");
    }


}
