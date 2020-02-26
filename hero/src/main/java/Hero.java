import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;
import javafx.geometry.Pos;

public class Hero {
    //fields
    private Position position;
    //functions
    Hero(int x,int y)
    {
        this.position.setX(x);
        this.position.setY(y);
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

    public void draw(Screen screen)
    {
        screen.setCharacter(position.getX(),position.getY(), new TextCharacter('X'));
    }
}
