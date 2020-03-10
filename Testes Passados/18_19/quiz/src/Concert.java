import java.util.ArrayList;
import java.util.List;

public class Concert {
    private String date,country,city;
    private List<Act> acts;

    Concert(String city,String country,String date)
    {
        this.date = date;
        this.city = city;
        this.country = country;
        acts = new ArrayList<>();
    }

    public void addAct(Act act)
    {
        acts.add(act);
    }

    public List<Act> getActs()
    {
        return acts;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null) return true;
        if (getClass() != o.getClass()) return false;

        Concert concert = (Concert) o;
        return (city.equals(concert.city) && country.equals(concert.country) && date.equals(concert.date) && acts.equals(concert.acts));
    }
}
