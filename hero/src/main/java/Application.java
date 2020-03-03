import java.io.IOException;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        try{
           if(game.run()) {game = new Game();game.run();}
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
