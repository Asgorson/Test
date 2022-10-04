import java.util.*;

public class TreeSet_Class {                    //представляет структуру данных в виде дерева, в котором все объекты 
                                                //хранятся в отсортированном виде по возрастанию. 
                                                //Наследует класс AbstractSet и реализует интерфейс NavigableSet,
                                                //а, следовательно, интерфейс SortedSet. 
    public static void main(String[] args){
        
        TreeSet<Integer> TempData = new TreeSet<Integer>(); 

        TempData.add(100); 
        TempData.add(122); 
        TempData.add(13);
        TempData.add(123);
        TempData.add(1234);

        System.out.println("Tree contains: " + TempData.size() + " elements.");
        System.out.println("Last lement is: " + TempData.last() + "\tFirst element is: " + TempData.first());

        System.out.println("Наименьший элемент, который больше указанного (>=): " + TempData.ceiling(100));//условие >=, следовательно может вернуть тот же элемент.
        System.out.println("Наибольший элемент, кторый меньше указанного (<=): " + TempData.floor(100)); //условие <=, следовательно может вернуть тот же элемент. 
        System.out.println("Наименьший элемент, который больше указанного (>): " + TempData.higher(100));
        System.out.println("Наибольший элемент, который меньше указанного (<): " + TempData.lower(100));

        for (Integer j: TempData){
            System.out.println(j);
        }
        System.out.println(TempData);

        SortedSet<Integer> set = TempData.subSet(13,122);
        System.out.println(set);
        NavigableSet<Integer> navSet = TempData.descendingSet();
        SortedSet<Integer> SetFromLower = TempData.tailSet(13); 
        SortedSet<Integer> SetFromHead = TempData.headSet(1234, true);
        System.out.println("Nav Set: " + navSet);
        System.out.println("SetFromLower: " + SetFromLower);
        System.out.println("SetFromHead: " + SetFromHead);
    }
}
/*
методы SortedSet:
E first():                                  возвращает первый элемент набора

E last():                                   возвращает последний элемент набора

SortedSet<E> headSet(E end):                возвращает объект SortedSet, который содержит все элементы первичного набора до элемента end

SortedSet<E> subSet(E start, E end):        возвращает объект SortedSet, который содержит все элементы первичного набора между 
                                            элементами start и end

                                            SortedSet<E> tailSet(E start):              возвращает объект SortedSet, который содержит все элементы первичного набора, начиная с элемента start

Методы NavigableSet: 
E ceiling(E obj):   ищет в наборе наименьший элемент e, который больше obj (e >=obj). Если такой элемент найден, то он возвращается в 
                    качестве результата. Иначе возвращается null.

E floor(E obj):     ищет в наборе наибольший элемент e, который меньше элемента obj (e <=obj). Если такой элемент найден, то он возвращается 
                    в качестве результата. Иначе возвращается null.

E higher(E obj):    ищет в наборе наименьший элемент e, который больше элемента obj (e >obj). Если такой элемент найден, то он возвращается 
                    в качестве результата. Иначе возвращается null.

E lower(E obj):     ищет в наборе наибольший элемент e, который меньше элемента obj (e <obj). Если такой элемент найден, то он возвращается 
                    в качестве результата. Иначе возвращается null.

E pollFirst():      возвращает первый элемент и удаляет его из набора

E pollLast():       возвращает последний элемент и удаляет его из набора

NavigableSet<E> descendingSet():                        возвращает объект NavigableSet, который содержит все элементы первичного набора 
                                                        NavigableSet в обратном порядке

NavigableSet<E> headSet(E upperBound, boolean incl):    возвращает объект NavigableSet, который содержит все элементы первичного набора 
                                                        NavigableSet до upperBound. Параметр incl при значении true, позволяет включить в 
                                                        выходной набор элемент upperBound

NavigableSet<E> tailSet(E lowerBound, boolean incl):    возвращает объект NavigableSet, который содержит все элементы первичного набора 
                                                        NavigableSet, начиная с lowerBound. Параметр incl при значении true, позволяет 
                                                        включить в выходной набор элемент lowerBound

NavigableSet<E> subSet(E lowerBound, boolean lowerIncl, E upperBound, boolean highIncl): возвращает объект NavigableSet, который содержит 
                                                                                         все элементы первичного набора NavigableSet от 
                                                                                         lowerBound до upperBound.
*/