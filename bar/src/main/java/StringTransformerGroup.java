import java.util.List;

public class StringTransformerGroup implements StringTransformer {
    private List<StringTransformer> group;

    public StringTransformerGroup(List<StringTransformer> group) {
        this.group = group;
    }

    public List<StringTransformer> getGroup() {
        return group;
    }

    public void setGroup(List<StringTransformer> group) {
        this.group = group;
    }

    public void execute(StringDrink drink)
    {
        for (StringTransformer transformer : group)
        {
            transformer.execute(drink);
        }
    }
}
