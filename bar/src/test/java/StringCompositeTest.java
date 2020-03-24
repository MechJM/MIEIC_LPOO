import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class StringCompositeTest {
    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        si.execute(drink);
        cc.execute(drink);
        sr.execute(drink);

        sr.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());

        cc.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());

        si.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());
    }

    @Test
    public void transformerComposite() {
        StringDrink drink = new StringDrink("AbCd-aBcD");

        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');

        List<StringTransformer> transformers1 = new ArrayList<>();
        transformers1.add(si);
        transformers1.add(cc);
        StringTransformerGroup tg1 = new StringTransformerGroup(transformers1);

        List<StringTransformer> transformers2 = new ArrayList<>();
        transformers2.add(sr);
        transformers2.add(cc);
        StringTransformerGroup tg2 = new StringTransformerGroup(transformers2);

        List<StringTransformer> transformers3 = new ArrayList<>();
        transformers3.add(tg1);
        transformers3.add(tg2);

        StringRecipe recipe = new StringRecipe(transformers3);
        recipe.mix(drink);

        assertEquals("DcBx-dCbA", drink.getText());
    }

}
