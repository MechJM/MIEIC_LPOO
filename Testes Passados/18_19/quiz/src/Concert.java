import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Concert {
    private String date,country,city;
    private List<Act> acts;
    int lastTicketNum;

    Concert(String city,String country,String date)
    {
        this.date = date;
        this.city = city;
        this.country = country;
        acts = new ArrayList<>();
        lastTicketNum = 1;
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

    @Override
    public int hashCode()
    {
        return Objects.hash(city,country,acts,date);
    }

    public boolean isValid(Ticket ticket) throws InvalidTicket
    {
        if (ticket.getConcert().equals(this)) return true;
        else return false;
    }

    public boolean participates(Artist artist)
    {
        for (Act act: acts)
        {
            if (act instanceof Artist && ((Artist) act).equals(artist)) return true;
            if (act instanceof Band && ((Band) act).containsArtist(artist)) return true;
        }
        return false;
    }

    public void incrementTicketNum() {lastTicketNum++;}
}
