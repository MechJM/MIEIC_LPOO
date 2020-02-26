import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.io.IOException;

public class Arena {
    //fields
    private int width;
    private int height;
    Hero hero;
    //functions


    public Arena(int width, int height,int x,int y) {
        hero = new Hero(x,y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void processKey(KeyStroke key)
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

    public void draw(Screen screen) throws IOException
    {
        hero.draw(screen);
    }

    public void moveHero(Position position)
    {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position)
    {
        if (position.getY()<height && position.getX()<width) return true;
        else return false;
    }
}
