import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements OrderingStrategy {
    List<StringDrink> drinksWanted;
    List<StringRecipe> recipesWanted;

    public SmartStrategy()
    {
        drinksWanted = new ArrayList<StringDrink>();
        recipesWanted = new ArrayList<StringRecipe>();
    }

    @Override
    public void wants(StringDrink drink, StringRecipe recipe, StringBar bar) {
        drinksWanted.add(drink);
        recipesWanted.add(recipe);
        if (bar.isHappyHour()) this.happyHourStarted(bar);
    }

    @Override
    public void happyHourStarted(StringBar bar) {
        for (int i = 0; i < drinksWanted.size(); i++)
        {
            bar.order(drinksWanted.get(i),recipesWanted.get(i));
        }
    }

    @Override
    public void happyHourEnded(StringBar bar) {
        drinksWanted.clear();
        recipesWanted.clear();
    }
}
