import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;


import java.io.IOException;

public class Game {
    //fields
    private Screen screen;
    private Hero hero;
    //functions
    Game()
    {
        try
        {
            hero = new Hero(10,10);
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();     // resize screen if necessary
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException
    {
        screen.clear();
        hero.draw(screen);
        screen.refresh();
    }

    public void run() throws IOException
    {

        while (true) {
            draw();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
            if (key.getKeyType() == KeyType.EOF) break;
            processKey(key);
        }
    }

    private void processKey(KeyStroke key)
    {
        System.out.println(key);

        switch (key.getKeyType())
        {
            case ArrowUp:
            {
                moveHero(hero.moveUp());
                break;
            }
            case ArrowDown:
            {
                moveHero(hero.moveDown());
                break;
            }
            case ArrowRight:
            {
                moveHero(hero.moveRight());
                break;
            }
            case ArrowLeft:
            {
                moveHero(hero.moveLeft());
                break;
            }
            default:break;
        }
    }

    private void moveHero(Position position)
    {
        hero.setPosition(position);
    }
}
