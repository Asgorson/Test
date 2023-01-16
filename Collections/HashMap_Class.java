import java.util.*;

/*
 * Интерфейс Map<k,v> представляет отображение или иначе говоря словарь, где каждый элемент представляет пару "ключ-значение". При этом
 * все ключи уникальные в рамках объекта Map. Такие коллекции облегчают поиск элемента, если нам известен ключ - уникальный идентификатор 
 * объекта. 
 * Данный интерфейс НЕ расширяет интерфейс Collection.
 */
public class HashMap_Class {
    public static void main(String[] args){

        Map<String, String> States_ = new HashMap<String, String>();
        States_.put("id111", "Germany");
        States_.put("id011", "Italy");
        States_.put("id001", "Russia");
        
        //Вывод элемента по ключу
        System.out.println("Element (1): " + States_.get("id001"));

        //получить весь набор ключей
        Set<String> keys = States_.keySet();
        for(String o: keys){
            System.out.printf("%s\t",o);
        }
        System.out.println();
        //получить весь набор значений 
        Collection<String> values = States_.values();
        for(String s: values){
            System.out.printf("%s\t",s);
        }
        System.out.println();

        //замена элемента 
        States_.replace("id111", "Rome");
        
        //удаление элемента 
        States_.remove("id011");

        //Вывод всех ключенй и значений 
        for(Map.Entry<String, String> item: States_.entrySet()){
            System.out.printf("Key: %s\t Value: %s\n", item.getKey(), item.getValue());
        }

        Map<Integer, Figures> figures = new HashMap<Integer, Figures>();
        figures.put(123342, new Figures("Равнобедренный треугольник", 3));
        figures.put(1234, new Figures("Прямоугольный треугольник", 3));
        figures.put(1, new Figures("Квадрат", 4));

        for(Map.Entry<Integer, Figures> item: figures.entrySet()){
            System.out.printf("\nKey: %s\tValue: \n", item.getKey());
            item.getValue().showInfo();
        }
    }
}

class Figures{

    private String name; 
    private int sideAmount; 

    Figures(String name, int sideAmount){
        this.name = name;
        this.sideAmount = sideAmount;
    }

    public void showInfo(){
        System.out.printf("Name: %s \tSide amount: %d", name, sideAmount);
    }
}
/*  Методы интерфейса Map

void clear():                               очищает коллекцию
boolean containsKey(Object k):              возвращает true, если коллекция содержит ключ k
boolean containsValue(Object v):            возвращает true, если коллекция содержит значение v
Set<Map.Entry<K, V>> entrySet():            возвращает набор элементов коллекции. Все элементы представляют объект Map.Entry
boolean equals(Object obj):                 возвращает true, если коллекция идентична коллекции, передаваемой через параметр obj
boolean isEmpty:                            возвращает true, если коллекция пуста
V get(Object k):                            возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, 
                                            то возвращается значение null
V getOrDefault(Object k, V defaultValue):   возвращает значение объекта, ключ которого равен k. Если такого элемента не окажется, 
                                            то возвращается значение defaultVlue
V put(K k, V v):                            помещает в коллекцию новый объект с ключом k и значением v. Если в коллекции уже есть 
                                            объект с подобным ключом, то он перезаписывается. После добавления возвращает предыдущее 
                                            значение для ключа k, если он уже был в коллекции. Если же ключа еще не было в коллекции, 
                                            то возвращается значение null
V putIfAbsent(K k, V v):                    помещает в коллекцию новый объект с ключом k и значением v, если в коллекции еще нет элемента 
                                            с подобным ключом.
Set<K> keySet():                            возвращает набор всех ключей отображения
Collection<V> values():                     возвращает набор всех значений отображения

void putAll(Map<? extends K, ? extends V> map): добавляет в коллекцию все объекты из отображения map
V remove(Object k):                             удаляет объект с ключом k
int size():                                     возвращает количество элементов коллекции
*/
 