import java.util.*;

public class Main {
    public static void main(String[] args) throws RuntimeException {

        //map - для адресов и цен
        Map<Address, Integer> costPerAddress = new HashMap<>();

        //set - для получения списка стран доставок
        Set<String> set = new HashSet<>();

        costPerAddress.put(new Address("Россия", "Самара"), 1000);
        costPerAddress.put(new Address("Россия", "Москва"), 2000);
        costPerAddress.put(new Address("Россия", "Казань"), 1500);
        costPerAddress.put(new Address("Англия", "Лондон"), 3500);
        costPerAddress.put(new Address("Англия", "Ливерпуль"), 3000);
        costPerAddress.put(new Address("США", "Вашингтон"), 6000);
        costPerAddress.put(new Address("США", "Калифорния"), 5000);

        Scanner sc = new Scanner(System.in);
        int priceAll = 0;
        while (true) {
            System.out.println("Заполнение нового заказа");
            System.out.println("Для выхода введите 'end'");
            System.out.print("Введите страну: ");
            String country = sc.nextLine();
            if (country.equals("end")) {
                break;
            }
            System.out.print("Введите город: ");
            String city = sc.nextLine();
            if (city.equals("end")) {
                break;
            }
            try {
                int weight;
                System.out.print("Введите вес (кг): ");
                String weightStr = sc.nextLine();
                if (weightStr.equals("end")) {
                    break;
                } else {
                    weight = Integer.parseInt(weightStr);
                }
                int price = 0;
                Address userAddress = new Address(country, city);
                for (Map.Entry<Address, Integer> deliveryAddress : costPerAddress.entrySet()) {
                    //if (deliveryAddress.getKey().getCountry().equals(country) &&
                    // deliveryAddress.getKey().getCity().equals(city)) { //первый вариант решения
                    if (userAddress.equals(deliveryAddress)) {
                        price = weight * deliveryAddress.getValue();
                        priceAll += price;
                        set.add(deliveryAddress.getKey().getCountry());
                    }
                }
                if (price != 0) {
                    System.out.println("Стоимость доставки составит: " + price);
                    System.out.println("Общая стоимость всех доставок: " + priceAll);
                } else {
                    System.out.println("Доставки по этому адресу нет");
                }
            } catch (RuntimeException e) {
                System.out.println("!!!Вы ввели не число!!!");
            }
        }
        System.out.println("Количество различных стран доставки: " + set.size());
        System.out.println("Программа завершена");
    }
}
