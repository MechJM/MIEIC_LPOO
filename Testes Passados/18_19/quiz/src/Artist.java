import java.util.ArrayList;
import java.util.List;

public class Artist extends Act {
    Artist(String name,String country)
    {
        super(name,country);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;

        Artist a = (Artist) o;
        return name.equals(((Artist) o).name) && country.equals(((Artist) o).country);
    }
}
