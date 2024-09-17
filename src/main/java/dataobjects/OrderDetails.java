package dataobjects;

public class OrderDetails {
    private String Name;
    private String Country;
    private String City;
    private String Creditcard;
    private String Month;
    private String Year;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCreditcard() {
        return Creditcard;
    }

    public void setCreditcard(String creditcard) {
        Creditcard = creditcard;
    }

    public String getMonth() {
        return Month;
    }

    public void setMonth(String month) {
        Month = month;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }
}
