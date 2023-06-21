package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Homework4 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<String> allData = new ArrayList<>();        // список полный
        ArrayList<Integer> idData = new ArrayList<>();        // список индексов


//        ArrayList<String> surname = new ArrayList<>();       // только фамилии
//        ArrayList<Integer> age = new ArrayList<>();          // возраст
//        ArrayList<String> gender = new ArrayList<>();        // пол

        inputData(allData, idData);
        printData(allData);
//        System.out.println(idData); // проверка списка индексов
        System.out.println("-----------------------------");

        System.out.println("Введите:\n" +                                // интерфейс для польз.
                "  q - выход,\n" +
                "  s - сортировка по возрасту,\n" +
                "  a - сортировка по возрасту(useIndex),\n" +
                "  g -  сортировка по возрасту и гендерному признаку (useIndex)\n");
        String data = scanner.nextLine();
        if (data.equalsIgnoreCase("q")) System.exit(0);       // выход из программы
        else if (data.equalsIgnoreCase("s")) {
            sortDataAge(allData);
            printData(allData);
        }
        else if (data.equalsIgnoreCase("a")) {
            sortDataAgeIndex(idData);
//            printData(allData);
        }
//        else if (data.equalsIgnoreCase("g")) {
//            sortDataAgeGender();
//        }
    }

    static void inputData(ArrayList<String> arrAllData,
                        ArrayList<Integer> idData){
        System.out.println("Введите: <Фамилию> <Отчество> <Имя> <возраст> <пол> или <q> (выход)");
        while(true) {
            String data = scanner.nextLine();
            if (data.equalsIgnoreCase("q")) {return;} // сравниваем строку с другой, игнорируя регистр
            arrAllData.add(data);     // заполняем данными массив

            idData.add(arrAllData.indexOf(data)); // заполняем массив индексов
//            System.out.println(idData.get(arrAllData.indexOf(data)));    // Значения idData?

//            String[] lst = data.split(" ");
//            arrSurname.add(lst[0]);
//            arrAge.add(Integer.parseInt(lst[3]));
//            arrGender.add(lst[4]);
        }
    }

    static void printData(ArrayList<String> arrayList) {
        for (String i : arrayList) {
            String[] str = i.split(" ");
            System.out.println(str[0] + " " + str[1].toUpperCase().charAt(0)
                    + "." + str[2].toUpperCase().charAt(0) + ". " + str[3] + " " + str[4]);
        }
    }

    private static void sortDataAge(ArrayList<String> arrayList) {
        arrayList.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o1.split(" ")[3]) - Integer.parseInt(o2.split(" ")[3]);
            }
        });
    }

    static void sortDataAgeIndex(ArrayList<Integer> arrayList) {
//        for (int i = 0; i <arrayList.size()-1 ; i++) {         // пузырьковая сортировка
//            for (int j = 0; j < arrayList.size() - i - 1; j++) {
//                if (arrayList.get(j + 1) < arrayList.get(j)) {
//                    int tmp = arrayList.get(j);
//                    arrayList.get(j) = arrayList.get(j + 1);   //??????
//                    arrayList.get(j + 1) = tmp;
//
//                }
//            }
//        }
////        System.out.println(arrayList);
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return arrayList.get(o1) - arrayList.get(o2);
            }
        });
        System.out.println();
    }

    static void sortDataAgeGender(ArrayList<Integer> ArrayList) {
        // ... сортировка по возрасту

        // ... сортировка по генд.признаку

//        ArrayList result = new ArrayList();   // суммарный массив с 2мя отсортированными полями
//        for (String i: result){
//            result.addAll(i);
//        }
    }
}