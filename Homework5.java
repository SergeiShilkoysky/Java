package Course_Java;

import java.util.*;

// Задание: Создать структуру телефонной книги используя HashMap.
//    Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
//    их необходимо считать, как одного человека с разными телефонами.
//    Вывод должен быть отсортирован по убыванию числа телефонов.
public class Homework5 {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> dataBase = new HashMap<>();  // String для ArrayList т.к. формат тлф. может содержать + () и др. символы

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите фамилию имя телефон или s(сортировка) или q(выход)");

        while (true){
            String data = scanner.nextLine();
            System.out.println(data);
            if (data.equalsIgnoreCase("s")) sortPhone(dataBase);
            else if(data.equalsIgnoreCase("q")) System.exit(0);
            String[] dataArr = data.split(" ");
            String key = dataArr[0] + " " + dataArr[1];         // Фамилия имя = ключ
            Integer value = Integer.valueOf(dataArr[2]);        // номер = значение
            addInBook(key, value, dataBase);
        }
    }
    private static void addInBook(String key, Integer value, HashMap<String, ArrayList<String>> dataBase) {
        ArrayList list = new ArrayList<>();
        dataBase.putIfAbsent(key, list);                 // добавляем если ключ впервые (отсутствует в базе)
        dataBase.get(key).add(String.valueOf(value));
//        System.out.println(dataBase);
    }
    public static void sortPhone(HashMap<String, ArrayList<String>> dataBase){
        ArrayList list = new ArrayList<>();
        for(String string: dataBase.keySet()){
            list.add(string);
        }
//        System.out.println(dataBase.keySet()); // список ключей(фамилия+имя) до сортировки
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dataBase.get(o2).size() - dataBase.get(o1).size();
            }
        });
//        System.out.println(lst);   // список ключей(фамилия+имя) после сортировки
        list.forEach(n -> System.out.println(n + " = " + dataBase.get(n)));
    }
}














// // Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//
//public class task1{
//
//       // Метод, который добавляет номера в книгу
//    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
//        if (map.containsKey(key)) {
//            map.get(key).add(value);
//        } else {
//            ArrayList<Integer> list = new ArrayList<>();
//            list.add(value);
//            map.put(key, list);
//        }
//
//    }
//    // Метод, который печатает список контактов
//    public static void printBook(Map<String, ArrayList<Integer>> map){
//        for (var item : map.entrySet()) {
//            String phones = "";
//            for(int el: item.getValue()){
//                phones = phones + el + ", ";
//            }
//            System.out.printf("%s: %s \n", item.getKey(), phones);
//        }
//    }
//    public static void main(String[] args) {
//        Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
//        addNumber("Ivanov", 123, bookPhone);
//        addNumber("Ivanov", 1234, bookPhone);
//        addNumber("Petrov", 546585, bookPhone);
//        addNumber("Sidorov", 8956477, bookPhone);
//        addNumber("Ivanov", 12356233, bookPhone);
//        addNumber("Petrov", 787897, bookPhone);
//        printBook(bookPhone);
//       }
//}