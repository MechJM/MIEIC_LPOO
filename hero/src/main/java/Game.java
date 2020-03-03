import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
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
    private Arena arena;
    private TextGraphics graphics;
    public static boolean shouldContinue = true;
    public static boolean lost = false;
    //functions
    public Game()
    {
        try
        {
            arena = new Arena(50,24,5,5); //alturas acima de 24 fazem com que a parede de baixo nao apareca(?)
            Terminal terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.setCursorPosition(null);   // we don't need a cursor
            screen.startScreen();             // screens must be started
            screen.doResizeIfNecessary();   // resize screen if necessary
            graphics = screen.newTextGraphics();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private void draw() throws IOException
    {
        screen.clear();
        arena.draw(graphics);
        screen.refresh();
    }

    public boolean run() throws IOException
    {
        while (true) {
            draw();
            if (!shouldContinue && lost) if (endGameScreen()) return true;
            else if (!shouldContinue && !lost) screen.close();
            KeyStroke key = screen.readInput();
            if (key.getKeyType() == KeyType.EOF) break;
            processKey(key);
        }
        return false;
    }

    private void processKey(KeyStroke key)
    {
        arena.processKey(key);
    }

    private boolean endGameScreen() throws IOException
    {
        screen.clear();
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(50, 50), "Do you want to restart(s/n):");
        screen.refresh();

        KeyStroke answer = screen.readInput();
        while (true)
        {
            if (answer.getKeyType() == KeyType.Character && answer.getCharacter() == 's') {screen.close();return true;}
            if (answer.getKeyType() == KeyType.Character && answer.getCharacter() == 'n') {screen.close(); return false;}
            answer = screen.readInput();
        }
    }
}
