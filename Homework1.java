package org.example;
// Семинар 1
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Homework1 {
    public static void main(String[] args) {
//  1.  Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//  1й вариант
        int num = (int) (Math.random() * 2001);
        System.out.println("задание №1. (1-й вариант) случайное число > " + num);
//  2й вариант
        Random random = new Random();
        int i = random.nextInt(0, 2001);
        System.out.println("задание №1. (2-й вариант) случайное число > " + i);
        System.out.println("-------------------------");

//  2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
        String m = Integer.toBinaryString(i);
        //System.out.println(m);

//  1й вариант
        int n = m.length();  // поскольку старший бит - крайний слева > его номер будет равен длине числа в битах
        System.out.println("задание №2.(1й вариант) число <" + m + "> (в десятичной системе <" + i + ">), номер старшего бита: " + n);
//  2й вариант
        int count = 0;
        for (int j = 0; j < m.length(); j++) count++;
        System.out.println("задание №2.(2й вариант) номер старшего значащего бита выпавшего числа: " + count);
        System.out.println("-------------------------");

        Homework1.getArrayM1();
        Homework1.getArrayM2();
    }

// 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1   
    public static void getArrayM1() {
        System.out.println("задание №3: массив чисел кратных <n> в диапазоне i : MAX_VALUE");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число <n> : ");
        int n = scanner.nextShort();
        System.out.print("Введите начальное значение диапазона <i>: ");
        short i = scanner.nextShort();
        ArrayList<Short> arr = new ArrayList<Short>(); // создаем объект класса ArrayList (коллекцию)
        short maxShortValue = Short.MAX_VALUE;  // создаем объект класса Short и инициализируем. с макс. значением
//        System.out.println(maxShortValue);
        while (i != maxShortValue) {     // сортируем в диапазоне от a до Short.MAX_VALUE значения кратные числу n
            i++;
            if (i % n == 0) {
                arr.add(i);
//                System.out.println(a);
            }
        }
//        System.out.println(arr);
        Short[] m1 = arr.toArray(new Short[arr.size()]); //  конвертируем в массив
        System.out.print(Arrays.toString(m1));
        System.out.println("______________________________");
    }


//4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2
  public static void getArrayM2() {
        System.out.println("-------------------------");
        System.out.println("задание №4: массив чисел кратных <n> в диапазоне Short.MIN_VALUE : i");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число: ");
        int n = scanner.nextShort();
        System.out.print("Введите конечное значение диапазона <i>: ");
        short i = scanner.nextShort();
        ArrayList<Short> m2 = new ArrayList<Short>();
        short minShortValue = Short.MIN_VALUE;
        while (i != minShortValue) {     // сортируем в диапазоне от a до Short.MAX_VALUE значения НЕкратные числу n
            i--;
            if(i % n != 0) m2.add(i);
        }
        System.out.println(m2);
    }
}