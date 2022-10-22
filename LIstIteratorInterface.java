import java.util.*;

//Данный метод используется калссами, реализующими интерфейс List, то есть классами LinkedList, ArrayList и др.

public class LIstIteratorInterface {
    public static void main(String[] args){
        
        ArrayList<String> Mass_1 = new ArrayList<String>(); 

        Mass_1.add("Winter");
        Mass_1.add("Spring");
        Mass_1.add("Summer");
        Mass_1.add("Autumn");
        ListIterator<String> ListIter = Mass_1.listIterator();
        while (ListIter.hasNext()){
            System.out.printf("Index: %s \tValue: %s \n", ListIter.nextIndex(), ListIter.next());
            //ListIter.remove(); //Удаляет элемент из списка
        }
        // после вывода, текущим элементом является значения поля Autumn
        // Заменим его на Space
        System.out.println();
        ListIter.set("Space");
        while (ListIter.hasPrevious()){
            System.out.printf("Index: %s \tValue: %s \n",ListIter.previousIndex(), ListIter.previous());
        }
    }
}


/*

void add(E obj):            вставляет объект obj перед элементом, который должен быть возвращен следующим вызовом next()
boolean hasNext():          возвращает true, если в коллекции имеется следующий элемент, иначе возвращает false
boolean hasPrevious():      возвращает true, если в коллекции имеется предыдущий элемент, иначе возвращает false
E next():                   возвращает текущий элемент и переходит к следующему, если такого нет, то генерируется исключение 
                            NoSuchElementException
E previous():               возвращает текущий элемент и переходит к предыдущему, если такого нет, то генерируется исключение 
                            NoSuchElementException
int nextIndex():            возвращает индекс следующего элемента. Если такого нет, то возвращается размер списка
int previousIndex():        возвращает индекс предыдущего элемента. Если такого нет, то возвращается число -1
void remove():              удаляет текущий элемент из списка. Таким образом, этот метод должен быть вызван после методов next() или 
                            previous(), иначе будет сгенерировано исключение IlligalStateException
void set(E obj):            присваивает текущему элементу, выбранному вызовом методов next() или previous(), ссылку на объект obj

 */