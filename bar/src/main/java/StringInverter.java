public class StringInverter implements StringTransformer {
    @Override
    public void execute(StringDrink drink)
    {
        String oldString = drink.getText();
        StringBuffer buffer = new StringBuffer(oldString);
        buffer.reverse();
        drink.setText(buffer.toString());
    }
}
