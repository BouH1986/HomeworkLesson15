import java.util.*;

public class Main {
    public static void main(String[] args) {

        //set - для получения списка стран доставок
        Set<String> set = new HashSet<>();

        //map - для адресов и цен
        Map<Address, Integer> costPerAddress = new HashMap<>();

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
            //у 'end' вызываем метод equals, а не у введенного значения,
            // для избежания возможных ошибок с null
            if ("end".equals(country)) {
                break;
            }
            System.out.print("Введите город: ");
            String city = sc.nextLine();
            if ("end".equals(city)) {
                break;
            }
            System.out.print("Введите вес (кг): ");
            String weightStr = sc.nextLine();
            if ("end".equals(weightStr)) {
                break;
            }

            try {
                int weight = Integer.parseInt(weightStr);
                //создаем объект с введенными пользователем данными
                Address userAddress = new Address(country, city);
                //если объект содержится в ключе мапы
                if (costPerAddress.containsKey(userAddress)) {
                    //метод get возвращает значение по ключу
                    int price = costPerAddress.get(userAddress) * weight;
                    System.out.println("Стоимость доставки составит: " + price + " руб.");
                    priceAll += price;
                    System.out.println("Общая стоимость всех доставок: " + priceAll + " руб.");
                    set.add(country);
                } else {
                    System.out.println("Доставки по этому адресу нет");
                }
            } catch (NumberFormatException e) {
                System.out.println("!!!Вы ввели не число!!!");
            }

            System.out.println();
        }
        System.out.println("Количество различных стран доставки: " + set.size());
        System.out.println("Программа завершена");
    }
}
