import java.util.ArrayDeque;        //класс реализующий обобщенную двунаправленную очередь 
                                    //по умолчанию емкость очереди - 16.
                                    //это фактическая реалилзация стека 

public class ArrayQueue_Deque_Class {
    public static void main(String[] args){
        
        ArrayDeque<String> countries = new ArrayDeque<String>();

        countries.addFirst("Russia");
        countries.addLast("Finland");
        System.out.println("First country: " + countries.getFirst());//получение первого элемента без удаления
        System.out.println("Last country: " + countries.getLast());//получение последнего элемента без удаления 

        countries.push("Japan"); //добавление элемента в начало 
        System.out.println("Refreshed qeue(first element): " + countries.getFirst());

        System.out.println("Size of Qeue: " + countries.size());//получение размера очереди
        System.out.println("\nCountries: \n");
        System.out.println("Показывает и удаляет объект из начала очереди: " + countries.pop());
        /*
        while(countries.peek()!=null){           //возвращает элемент без удаления из начала очереди peek(). Если очередь пуста возваращает null.
            System.out.println(countries.pop()); //получение элемента из начала очереди с удалением. Вместо pop() можно использовать poll().
                                                 //однако если очередь пуста pop() генерирует исключение, а poll() ничего не делает.
        }*/

        ArrayDeque<Warrior> WarArray = new ArrayDeque<Warrior>();
        WarArray.addFirst(new Warrior("Obi-Van"));
        WarArray.add(new Warrior("Yoda"));
        WarArray.addLast(new Warrior("Annekin"));
        System.out.println("\nWarriors: \n");
        for (Warrior p: WarArray){
            System.out.println(p.getName());
        }
        
        if(WarArray.offerFirst(new Warrior("Darth Veider"))){ //добавляет в начало очереди элемент, если удачно возвращает true  
            System.out.println("\nAddition succeed!\n");         //иначе возвраещает false
                                                                    //также есть offerLast()
        }

        for (Warrior p: WarArray){
            System.out.println(p.getName());
        }
    }
    
}

class Warrior{

    private String name; 

    public Warrior(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }
}
/*
E element():                возвращает, но не удаляет, элемент из начала очереди. Если очередь пуста, генерирует исключение 
                            NoSuchElementException
boolean offer(E obj):       добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
E peek():                   возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
E poll():                   возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
E remove():                 возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
void addFirst(E obj):       добавляет элемент в начало очереди
void addLast(E obj):        добавляет элемент obj в конец очереди
E getFirst():               возвращает без удаления элемент из головы очереди. Если очередь пуста, генерирует исключение NoSuchElementException
E getLast():                возвращает без удаления последний элемент очереди. Если очередь пуста, генерирует исключение NoSuchElementException
boolean offerFirst(E obj):  добавляет элемент obj в самое начало очереди. Если элемент удачно добавлен, возвращает true, иначе - false
boolean offerLast(E obj):   добавляет элемент obj в конец очереди. Если элемент удачно добавлен, возвращает true, иначе - false
E peekFirst():              возвращает без удаления элемент из начала очереди. Если очередь пуста, возвращает значение null
E peekLast():               возвращает без удаления последний элемент очереди. Если очередь пуста, возвращает значение null
E pollFirst():              возвращает с удалением элемент из начала очереди. Если очередь пуста, возвращает значение null
E pollLast():               возвращает с удалением последний элемент очереди. Если очередь пуста, возвращает значение null
E pop():                    возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
void push(E element):       добавляет элемент в самое начало очереди
E removeFirst():            возвращает с удалением элемент из начала очереди. Если очередь пуста, генерирует исключение NoSuchElementException
E removeLast():             возвращает с удалением элемент из конца очереди. Если очередь пуста, генерирует исключение NoSuchElementException
boolean removeFirstOccurrence(Object obj): удаляет первый встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.
boolean removeLastOccurrence(Object obj): удаляет последний встреченный элемент obj из очереди. Если удаление произшло, то возвращает true, иначе возвращает false.
*/