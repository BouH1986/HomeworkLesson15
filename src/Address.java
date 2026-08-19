import java.util.Objects;

class Address {
    private final String country;
    private final String city;

    public Address(String country, String city) {
        this.country = country;
        this.city = city;
    }

    //переопределяем метод equals, чтобы можно было сравнивать два объекта Address по обоим полям
    @Override
    public boolean equals(Object obj) {
        //не много ИИ
        // проверка на то что это одна ячейка памяти
        if (this == obj) return true;
        //проверка не передали ли null и проверка на соответствие классов
        if (obj == null || getClass() != obj.getClass()) return false;
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
