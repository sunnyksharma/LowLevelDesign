package com.lld.entity;


public class Player {
    private Integer id;
    private Integer value;
    private Game game;


    public Player(int id){
        this.id = id;
        //this.value = value;
    }
    public void setValue(int value){
        this.value = value;
    }
    public Game startAGameWithPlayer(Player player){
        this.value = 1;
        player.setValue(-1);
        Game newGame = new Game(this, player, 3);
        this.game = newGame;
        player.game = newGame;
        return this.game;
    }

    public Integer getId(){
        return this.id;
    }



    public boolean makeAMove(int r, int c){
        return this.game.nextMove(r,c,this.value);
    }
}
