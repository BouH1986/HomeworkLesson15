import java.util.Objects;

public class Address {
    private final String country;
    private final String city;

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

    //переопределяем метод equals, чтобы можно было сравнивать два объекта Address по обоим полям
    @Override
    public boolean equals(Object obj) {
        Address adr = (Address) obj;
        return country.equals(adr.country) && city.equals(adr.city);
    }

    //при переопределении equals нужно обязательно переопределить метод hashCode,
    // чтобы не было рассогласованности в этих двух методах,
    // так как hashCode может возвращать хеш имени ячейки памяти

    //переопределяем метод hashCode, чтобы хеш объекта Address
    // считался и по полю страны и по полю города
    @Override
    public int hashCode() {
        return Objects.hash(country, city);
    }
}
