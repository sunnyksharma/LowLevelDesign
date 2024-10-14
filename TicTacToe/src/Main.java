import com.lld.entity.Game;
import com.lld.entity.Player;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Player player1 = new Player(101);
        Player player2 = new Player(102);
        Game game = player1.startAGameWithPlayer(player2);
        // = player1.getGame();
//        while()
        boolean flag = true;
        while(!game.isGameOver()){
            int row = (int) ((Math.random()*10)%3);
            int col = (int) ((Math.random()*10)%3);
            boolean moveSuccessful = false;
            if(flag){
                moveSuccessful = player1.makeAMove(row,col);
            } else{
                moveSuccessful = player2.makeAMove(row,col);
            }
            if(moveSuccessful) {
                flag = !flag;
                game.showBoard();
            }
        }

    }
}