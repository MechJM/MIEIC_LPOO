import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;


public class Hero {
    //fields
    private Position position;
    //functions
    public Hero(int x,int y)
    {
        position = new Position(x,y);
    }

    //getters and setters
    public int getX() {
        return position.getX();
    }

    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(int y) {
        this.position.setY(y);
    }

    //hero movement
    public Position moveUp()
    {
        return new Position(position.getX(),position.getY()-1);
    }
    public Position moveDown()
    {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveRight()
    {
        return new Position(position.getX()+1,position.getY());
    }
    public Position moveLeft()
    {
        return new Position(position.getX()-1,position.getY());
    }

    public void setPosition(Position position)
    {
        this.position=position;
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
