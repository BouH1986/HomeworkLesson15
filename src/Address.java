import java.util.Objects;

public class Address {
    private String country;
    private String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    //переопределяем метод hashCode, чтобы хеш объекта Address
    // считался и по полю страны и по полю города
    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }

    //переопределяем метод equals чтобы можно было сравнивать два объекта Address,
    // не расписывая в условном операторе равенство обоих полей
    @Override
    public boolean equals(Object obj) {
        Address adr = (Address) obj;
        return country.equals(adr.country) && city.equals(adr.city);
    }
}
