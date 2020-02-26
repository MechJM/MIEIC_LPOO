import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arena {
    //fields
    private int width;
    private int height;
    private List<Wall> walls;
    Hero hero;
    //functions


    public Arena(int width, int height,int x,int y) {
        hero = new Hero(x,y);
        this.width = width;
        this.height = height;
        this.walls=createWalls();
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

    public void draw(TextGraphics graphics) throws IOException
    {
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width, height), ' ');

        hero.draw(graphics);
        for (Wall wall : walls) wall.draw(graphics);
    }

    public void moveHero(Position position)
    {
        if (canHeroMove(position))
            hero.setPosition(position);
    }

    private boolean canHeroMove(Position position)
    {
        for (Wall wall : walls)
        {
            if (wall.getPosition().equals(position)) return false;
        }

        return true;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();

        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }

        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }

        return walls;
    }

}
