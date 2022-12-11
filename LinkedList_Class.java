import java.util.LinkedList;
public class LinkedList_Class {     //представляет структуру данных в виде двусвязного списка.
                                    //Соединяет в себе функции классов ArrayList, ArrayDeque
                                    //Его отличие от класса ArraList в том, что там фактически используется массив. 
                                    //Он пересоздается при добавлении нового элемента. Класс LinkedList в тоже время работает с 
                                    //указателями, которые связывают отдельные объекты. 
                                    //реализует интерфейсы Dequeue и Queue
    public static void main(String[] args){

        LinkedList<String> StaffNames = new LinkedList<String>(); 
        StaffNames.add("Leon");
        StaffNames.addFirst("Jemma");
        StaffNames.addLast("Jhon");

        ///////////////////////////////////////////
        // Вывод можно организовывать по разному //
        ///////////////////////////////////////////
        if(StaffNames.offerFirst("Moana")){
            System.out.println("\nName (" + StaffNames.getFirst() + ") is added.");
        }else {
            System.out.println("There is a problem!");
        }
        StaffNames.push("Jess"); 
        for (String s: StaffNames){
            System.out.println(s);
        }
        System.out.println("Size is: " + StaffNames.size()); 
        System.out.println(StaffNames.get(0));
        


    }
}
