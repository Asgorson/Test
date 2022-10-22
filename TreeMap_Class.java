import java.util.*;

public class TreeMap_Class {
    /*
     * Данный класс наследует интерфейсы Sorted Map и Navigable Map. 
     * Класс TreeMap<K,V> представляет отображение в виде дерева. В отличие от коллекции HashMap, тут все объекты автоматически 
     * сортируются по возрастанию ключей. 
     * Имеет следующие конструкторы: 
        TreeMap():                                   создает пустое отображение в виде дерева
        TreeMap(Map<? extends K,​? extends V> map):   создает дерево, в которое добавляет все элементы из отображения map
        TreeMap(SortedMap<K, ? extends V> smap):     создает дерево, в которое добавляет все элементы из отображения smap
        TreeMap(Comparator<? super K> comparator):   создает пустое дерево, где все добавляемые элементы впоследствии будут 
                                                     отсортированы компаратором.
     */
public static void main(String[] args){

        TreeMap<String, String> Voc_1 = new TreeMap<String, String>(); 
        Voc_1.put("id1023", "Sam");
        Voc_1.put("id1024", "Jane");
        Voc_1.put("id1025", "William");
        Voc_1.put("id1026", "Tom");

        System.out.println("First key: " + Voc_1.firstKey());
        System.out.println("Last key: " + Voc_1.lastKey());
        System.out.println("Object by key(id1024): " + Voc_1.get("id1024") + "\n");

        for (Map.Entry<String, String> item: Voc_1.entrySet()){
            System.out.println("Key: " + item.getKey() + "\tValue: " + item.getValue());
        }
        //Получение объектов которые стоят после объекта с ключом id1025
        Map<String, String> SoMap = Voc_1.headMap("id1025");

        System.out.println("\nВывод данных до ключа id1025.\n");
        for (Map.Entry<String, String> item: SoMap.entrySet()){
            System.out.println("Key: " + item.getKey() + "\tValue: " + item.getValue());
        }

        //Получим набор всех ключей
        Set<String> someKeySet = Voc_1.keySet();
        System.out.println("\nSet of keys: ");
        for (String item: someKeySet){
            System.out.println(item);
        }

        //Получим набор всех значений 
        Collection<String> someValueCollection = Voc_1.values();
        System.out.println("\nCollection of values: ");
        for (String item: someValueCollection){
            System.out.println(item);
        }

        //Получим последний элемент дерева
        Map.Entry<String, String> lastItem = Voc_1.lastEntry();
        System.out.printf("\nLast item has key: %s \tValue: %s\n\n", lastItem.getKey(), lastItem.getValue());

        //Создаем словарь содержащий объекты 
        Map<String, Engine> MapOfEngines = new TreeMap<String, Engine>();
        MapOfEngines.put("id0000", new Engine("DieselOne", 1200));
        MapOfEngines.put("id0002", new Engine("HondaEngine", 2300));
        MapOfEngines.put("id0001", new Engine("HondaMotor", 1300));
        

        for (Map.Entry<String, Engine> item: MapOfEngines.entrySet()){
            System.out.printf("Engine name:  %s \tEngine mass: %d \tID: %s\n", item.getValue().getName(), item.getValue().getMass(), item.getKey());
        }
    }
}



class Engine{
    private String name; 
    private int mass; 

    Engine(String name, int mass){
        this.name = name;
        this.mass = mass;
    }

    String getName(){
        return name; 
    }

    int getMass(){
        return mass;
    }
}
/*
 * Методы интерфейса SortedMap: 
 
    K.firstKey():                           возвращает ключ первого элемента отображения
    K.lastKey():                            возвращает ключ последнего элемента отображения
    SortedMap<K, V> headMap(K end):         возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap 
                                            вплоть до элемента с ключом end
    SortedMap<K, V> tailMap(K start):       возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap, 
                                            начиная с элемента с ключом start
    SortedMap<K, V> subMap(K start, K end): возвращает отображение SortedMap, которые содержит все элементы оригинального SortedMap 
                                            вплоть от элемента с ключом start до элемента с ключом end

*Методы интерфейса NavigableMap:
    Map.Entry<K, V> ceilingEntry(K obj):возвращает элемент с наименьшим ключом k, который больше или равен ключу obj (k >=obj). 
                                        Если такого ключа нет, то возвращается null.
    Map.Entry<K, V> floorEntry(K obj):  возвращает элемент с наибольшим ключом k, который меньше или равен ключу obj (k <=obj). 
                                        Если такого ключа нет, то возвращается null.
    Map.Entry<K, V> higherEntry(K obj): возвращает элемент с наименьшим ключом k, который больше ключа obj (k >obj). 
                                        Если такого ключа нет, то возвращается null.
    Map.Entry<K, V> lowerEntry(K obj):  возвращает элемент с наибольшим ключом k, который меньше ключа obj (k <obj). 
                                        Если такого ключа нет, то возвращается null.
    Map.Entry<K, V> firstEntry():       возвращает первый элемент отображения
    Map.Entry<K, V> lastEntry():        возвращает последний элемент отображения
    Map.Entry<K, V> pollFirstEntry():   возвращает и одновременно удаляет первый элемент из отображения
    Map.Entry<K, V> pollLastEntry():    возвращает и одновременно удаляет последний элемент из отображения
    K ceilingKey(K obj):                возвращает наименьший ключ k, который больше или равен ключу obj (k >=obj). 
                                        Если такого ключа нет, то возвращается null.
    K floorKey(K obj):                  возвращает наибольший ключ k, который меньше или равен ключу obj (k <=obj). 
                                        Если такого ключа нет, то возвращается null.
    K lowerKey(K obj):                  возвращает наибольший ключ k, который меньше ключа obj (k <obj). 
                                        Если такого ключа нет, то возвращается null.
    K higherKey(K obj):                 возвращает наименьший ключ k, который больше ключа obj (k >obj). 
                                        Если такого ключа нет, то возвращается null.
    NavigableSet<K> descendingKeySet(): возвращает объект NavigableSet, который содержит все ключи отображения в обратном порядке
    NavigableMap<K, V> descendingMap(): возвращает отображение NavigableMap, которое содержит все элементы в обратном порядке
    NavigableSet<K> navigableKeySet():  возвращает объект NavigableSet, который содержит все ключи отображения

    NavigableMap<K, V> headMap(K upperBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы 
                                                            оригинального NavigableMap вплоть от элемента с ключом upperBound. 
                                                            Параметр incl при значении true указывает, что элемент с ключом upperBound 
                                                            также включается в выходной набор.
    NavigableMap<K, V> tailMap(K lowerBound, boolean incl): возвращает отображение NavigableMap, которое содержит все элементы 
                                                            оригинального NavigableMap, начиная с элемента с ключом lowerBound. 
                                                            Параметр incl при значении true указывает, что элемент с ключом lowerBound 
                                                            также включается в выходной набор.

    NavigableMap<K, V> subMap(K lowerBound, boolean lowIncl, K upperBound, boolean highIncl):   возвращает отображение NavigableMap, 
                                                                                                которое содержит все элементы оригинального 
                                                                                                NavigableMap от элемента с ключом lowerBound 
                                                                                                до элемента с ключом upperBound. Параметры 
                                                                                                lowIncl и highIncl при значении true включают
                                                                                                в выходной набор элементы с ключами 
                                                                                                lowerBound и upperBound соответственно.
 */