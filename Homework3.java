package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Задание:  Дан произвольный список из 100 целых чисел:
//     1) нужно удалить из него чётные числа;
//     2) найти минимальное значение;
//     3) найти максимальное значение;
//     4) найти среднее значение.
public class Homework3 {

    public static void main(String[] args) {
        ArrayList<Integer> listA = new ArrayList<>();
        for (int i = 0; i < 110; i++) {
            listA.add(new Random().nextInt(1, 21));
        }
        System.out.println("Произвольный список: " + listA);

        deleteOddNumbers(listA);
        getMaxMinAvgList(listA);
//        getMaxMinAvgList(listB);  // НЕ РАЗОБРАЛСЯ почему listB не возвращается из метода deleteOddNumbers
    }

    public static ArrayList<Integer> deleteOddNumbers(ArrayList<Integer> list) {
        ArrayList<Integer> listB = new ArrayList<>();
        for (Integer i : list) {
            if (i % 2 != 0) listB.add(i);
        }
        System.out.println("Cписок нечетных чисел: " + listB);
        return listB;
    }

    public static void getMaxMinAvgList(ArrayList<Integer> list) {
        Collections.sort(list);
        System.out.println("Минимальное значение после метода сортировки: " + list.get(0));
        System.out.println("Максимальное значение после метода сортировки: " + list.get(list.size() - 1));
        int min = list.get(0);
        int sum = 0;
        int avg = 0;
        for (Integer i : list) {
            if (i < min) min = i;
            sum += i;
            avg = sum / list.size();
        }
        System.out.println("Максимальное значение с исп. Collections: " + Collections.max(list));
        System.out.println("Минимальное значение: " + min);
        System.out.println("Среднеарифметическое: " + avg);
    }
}

