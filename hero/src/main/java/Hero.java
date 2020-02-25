import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    //fields
    private int x;
    private int y;
    //public interface
    Hero(int x,int y)
    {
        this.x=x;
        this.y=y;
    }

    //getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    //hero movement
    public void moveUp()
    {
        y--; //lower y means it's closer to the top
    }
    public void moveDown()
    {
        y++; //higher y means it's closer to the bottom
    }
    public void moveRight()
    {
        x++;
    }
    public void moveLeft()
    {
        x--;
    }

    public void draw(Screen screen)
    {
        screen.setCharacter(x,y, new TextCharacter('X'));
    }
}
