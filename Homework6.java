package Course_Java;

import java.util.HashMap;
import java.util.Iterator;

// Задание:  Напишите программу, которая имитирует HashSet (не используя Set's). В программе создать:
//           1) метод add, добавляющий элемент в коллекцию;
//           2) метод toString, возвращающий строку с элементами множества;
//          *1) метод, позволяющий читать элементы по индексу;
//              *) реализовать все методы из семинара:
//          *2) метод remove (удаление элемента и возвр.true если удаление выполнено);
//          *3) метод size (возврат к-ва элементов множества);
//          *4) метод isEmpty (вернуть true если пустой);
//          *5) получение данных из множества.
// Формат данных Integer.
public class Homework6 {
    public static void main(String[] args) {
        Course_Java.Set<Integer> set1 = new Course_Java.Set();

        System.out.println("method 1 (addElem): " + set1.addElem(111));   // method 1
        System.out.println("method 1 (повторн. добавление того же эл.) -> " + set1.addElem(111));
        System.out.println("----------------------");
        set1.addElem(888);
        set1.addElem(999);
        System.out.println("method 2 (toString): " + set1.toString());  // method 2
        System.out.println("----------------------");
        System.out.println("method *1: ");
        System.out.println(set1.getElemForIndex());                    // method *1
        System.out.println("----------------------");
        System.out.println("method *2: добавили элемент -> " + set1.addElem(222));
        System.out.println("method *2 (removeElem): " + set1.removeElem(222));   // method *2
        System.out.println("method *2 (повторное удаление этого же элемента) -> " + set1.removeElem(222));
        System.out.println("----------------------");
        System.out.println("method *3 (size) первичное к-во эл.: " + set1.sizeElem());
        System.out.println("method *3: (добавили элемент): " + set1.addElem(333));
        System.out.println("method *3 (size) (после добавления элемента) -> " + set1.sizeElem());   // method *3
        System.out.println("----------------------");
        System.out.println("method *4(isEmpty): " + set1.isEmptyElem());   //    method *4 (isEmpty)
        System.out.println("----------------------");
        Iterator<Integer> itr = set1.iteratorSet();                      // method *5 (Iterator)
        System.out.println("method *5(вывод данных из Set): ");
        while (itr.hasNext()) System.out.println(itr.next());
    }

    class Set<E> {
        private HashMap<E, Object> many = new HashMap<>();
        private static final Object VAL = new Object();

        public boolean addElem(E number) {                  // method 1 :
            return many.put(number, VAL) == null;}
        public boolean removeElem(E num){                  // method *2 :
            return many.remove(num) == VAL;}
        public Integer sizeElem(){    // Method *3 :
            return many.size();
        }  // method *3
        public boolean isEmptyElem(){  // Method *4 :
            return many.isEmpty();
        } // method *4
        public Iterator<E> iteratorSet(){ // для method *5 возвращаем keySet
            return  many.keySet().iterator();
        }   // for method *5
        public String toString() {                           //  method 2
            StringBuilder setAsString = new StringBuilder("{");
            for (E key: many.keySet()) {
                setAsString.append(key);}
            return many.toString();
        }
        public Integer getElemForIndex(){                    // method *1
            for (Object i: many.keySet().toArray()){
                System.out.println("Вывод элемента по индексу: " + i);
            }
        return null;
        }
    }
}
