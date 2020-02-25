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
    private int x = 10;
    private int y = 10;
    //public interface
    Game()
    {
        try
        {
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
        screen.setCharacter(x, y, new TextCharacter('X'));
        screen.refresh();
    }

    public void run()
    {
        try
        {
            while(true)
            {
                draw();
                KeyStroke key = screen.readInput();
                if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') screen.close();
                if (key.getKeyType() == KeyType.EOF) break;
                processKey(key);
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void processKey(KeyStroke key)
    {
        System.out.println(key);

        switch (key.getKeyType())
        {
            case ArrowUp:
            {
                y--; //lower y means it's closer to the top
                break;
            }
            case ArrowDown:
            {
                y++; //higher y means it's closer to the bottom
                break;
            }
            case ArrowRight:
            {
                x++;
                break;
            }
            case ArrowLeft:
            {
                x--;
                break;
            }
            default:break;
        }
    }
}
