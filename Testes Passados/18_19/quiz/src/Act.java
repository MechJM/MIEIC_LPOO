public abstract class Act {
    protected String country,name;

    Act(String name,String country)
    {
        this.name = name;
        this.country = country;
    }

    public  String getName()
    {
        return name;
    }

    public  String getCountry()
    {
        return country;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o == null) return false;
        if (this == o) return true;
        if (o.getClass() != this.getClass()) return false;

        Act a = (Act) o;

        return a.name.equals(this.name) && a.country.equals(this.country);
    }
}
