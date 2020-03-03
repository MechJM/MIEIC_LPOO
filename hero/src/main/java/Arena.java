import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    //fields
    private int width;
    private int height;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private int score;
    private Hero hero;
    //functions


    public Arena(int width, int height,int x,int y) {
        hero = new Hero(x,y);
        this.width = width;
        this.height = height;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
        score = 0;
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
        moveMonsters();
        System.out.println(key);

        if (key.getKeyType() == KeyType.Character && key.getCharacter() == 'q') Game.shouldContinue = false;

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
        for (Coin coin : coins) coin.draw(graphics);
        for (Monster monster : monsters) monster.draw(graphics);
    }

    public void moveHero(Position position)
    {
        if (canMove(position))
            hero.setPosition(position);
        retrieveCoins();
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

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(hero.getPosition());
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Coin new_coin = null;
            while (new_coin == null)
            {
                new_coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                for (Position pos : positions)
                {
                    if (pos.equals(new_coin.getPosition())) new_coin = null;
                }
            }
            coins.add(new_coin);
            positions.add(new_coin.getPosition());
        }
        return coins;
    }

    public void retrieveCoins()
    {
        for (Coin coin : coins)
        {
            if (coin.getPosition().equals(hero.getPosition()))
            {
                coins.remove(coin);
                score++;
                if (coins.isEmpty())
                {
                    System.out.println("YOU WON!");
                    System.out.print("Score: ");
                    System.out.println(score);
                    Game.shouldContinue = false;
                }
                break;
            }
        }
    }

    public List<Monster> createMonsters()
    {
        Random random = new Random();
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(hero.getPosition());
        for (Coin coin : coins) positions.add(coin.getPosition());
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Monster newMonster = null;
            while (newMonster == null)
            {
                newMonster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
                for (Position pos : positions)
                {
                    if (pos.equals(newMonster.getPosition())) newMonster = null;
                }
            }
            monsters.add(newMonster);
            positions.add(newMonster.getPosition());
        }
        return monsters;
    }

    public void moveMonsters()
    {
        verifyMonsterCollisions();
        for (Monster monster : monsters) {
            Position newMonsterPosition = monster.move();
            if (canMove(newMonsterPosition)) monster.setPosition(newMonsterPosition);
        }
        verifyMonsterCollisions();
    }

    public boolean canMove(Position position)
    {
        for (Wall wall : walls) if (wall.getPosition().equals(position)) return false;
        return true;
    }

    public void verifyMonsterCollisions()
    {
        for (Monster monster : monsters) if (monster.getPosition().equals(hero.getPosition())) hero.lowerEnergy();

        if (hero.isDead)
        {
            System.out.println("GAME OVER");
            System.out.print("Score: ");
            System.out.println(score);
            Game.shouldContinue = false;
            Game.lost = true;
        }
    }

}
