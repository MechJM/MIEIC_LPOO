import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;



public class Coin extends Element {
    //functions
    public Coin(int x,int y)
    {
        super(x,y);
    }

    public void draw(TextGraphics graphics)
    {

        graphics.setForegroundColor(TextColor.Factory.fromString("#ffa500"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "o");

    }


}
