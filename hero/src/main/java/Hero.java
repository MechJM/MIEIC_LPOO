import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;


public class Hero extends Element {
    //fields
    private int energy;
    public boolean isDead = false;
    //functions

    public Hero(int x,int y)
    {
        super(x,y);
        energy = 5;
    }

    /*
    public Position getPosition()
    {
        return position;
    }
    */

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

    /*
    public void setPosition(Position position)
    {
        this.position=position;
    }
     */

    public void lowerEnergy()
    {
        energy--;
        if (energy == 0) isDead = true;
    }

    public void draw(TextGraphics graphics)
    {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "X");
    }
}
