import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Monster extends Element {
    //functions
    public Monster(int x, int y)
    {
        super(x,y);
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#00ff00"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.putString(new TerminalPosition(position.getX(), position.getY()), "M");
    }

    public Position move() // doesn't check collision with walls because it can't access the information about their positions
    {
        Position result;
        Random random = new Random();

        int currentX = position.getX();
        int currentY = position.getY();

        List<Position> adjacentPositions = new ArrayList<>();

        for (int i = (currentX-1);i <= (currentX+1);i++)
        {
            for (int i2 = (currentY-1);i2 <= (currentY+1);i2++)
            {
                if (i == currentX && i2 == currentY) continue;
                else adjacentPositions.add(new Position(i,i2));
            }
        }

        result = adjacentPositions.get(random.nextInt(adjacentPositions.size()));

        return result;
    }
}
