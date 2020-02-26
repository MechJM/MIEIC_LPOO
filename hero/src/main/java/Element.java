import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    //fields
    protected Position position;
    //functions
    public Element(int x,int y)
    {
        position = new Position(x,y);
    }

    public void setPosition(Position position)
    {
        this.position=position;
    }

    public Position getPosition()
    {
        return position;
    }

    public abstract void draw(TextGraphics graphics);
}
