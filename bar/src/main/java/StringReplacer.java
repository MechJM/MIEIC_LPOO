public class StringReplacer implements StringTransformer {
    private char older,newer;

    public StringReplacer(char older, char newer) {
        this.older = older;
        this.newer = newer;
    }

    @Override
    public void execute(StringDrink drink) {
        String string = drink.getText();
        for (int i = 0; i < string.length(); i++)
        {
            if (string.charAt(i) == older) string = string.replace(older,newer);
        }
        drink.setText(string);
    }

    public char getOlder() {
        return older;
    }

    public void setOlder(char older) {
        this.older = older;
    }

    public char getNewer() {
        return newer;
    }

    public void setNewer(char newer) {
        this.newer = newer;
    }
}
