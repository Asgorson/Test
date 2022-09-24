import java.util.ArrayDeque;        //класс реализующий обобщенную двунаправленную очередь 
                                    //по умолчанию емкость очереди - 16.
                                    //это фактическая реалилзация стека 

public class ArrayQueue_Deque_Class {
    public static void main(String[] args){
        
        ArrayDeque<String> countries = new ArrayDeque<String>();

        countries.addFirst("Russia");
        countries.addLast("Finland");
        System.out.println("Ffirst country: " + countries.getFirst());//получение первого элемента без удаления
        System.out.println("Last country: " + countries.getLast());//получение последнего элемента без удаления 

        countries.push("Japan"); //добавление элемента в начало 
        System.out.println("Refreshed qeue(first element): " + countries.getFirst());


        
    }
    
}