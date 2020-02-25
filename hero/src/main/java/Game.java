import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    //fields
    private Screen screen;
    //public interface
    Game()
    {
        try
        {
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException
    {

        screen.clear();
        screen.setCharacter(10, 10, new TextCharacter('X'));
        screen.refresh();
    }

    public void run()
    {
        try
        {
            draw();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
