public class StringCaseChanger implements StringTransformer {
    @Override
    public void execute(StringDrink drink) {
        String oldStr = drink.getText();
        StringBuffer buffer = new StringBuffer(oldStr);

        for (int i = 0; i < buffer.length(); i++)
        {
            char ch = buffer.charAt(i);
            if (Character.isUpperCase(ch)) buffer.setCharAt(i, Character.toLowerCase(ch));
            else buffer.setCharAt(i, Character.toUpperCase(ch));
        }

        drink.setText(buffer.toString());
    }
}
