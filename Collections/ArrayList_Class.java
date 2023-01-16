import java.util.ArrayList; //реализация простого однонаправленного списка. Аналогичен безразмерному массиву.
                            //по умолчанию емкость равна 10. 
public class ArrayList_Class {
    public static void main(String[] args){
        ArrayList<String> names = new ArrayList<String>(); 
        names.add("Tom"); //добавлять элементы можно тоже по индексу
        names.add("Jack");

        ////////////////////////////////////
        //  Применение некоторых методов  //
        ////////////////////////////////////
        System.out.println("Names is: ");
        for (String someChar: names){
            System.out.println(someChar);
        }

        System.out.println("Names is: ");
        for(int i=0; i<names.size(); i++){  //получение размера списка name.size()
            System.out.println(names.get(i));//полчеине элемента списка по индексу names.get(i)
        }

        if(names.contains("Tom")){  //поиск элемента в списке по его имени names.contains()
            System.out.println("Name Tom is in list.");
        }else {
            System.out.println("Not found.");
        }
        names.add("Petro");
        names.add("Suarez");
        ShowList(names);
        names.remove("Tom");//тут можно удалять объекты по следующим параметрам: -имени
                               //                                                  -индексу 
        ShowList(names);
        names.set(1,"Ivan"); //можно изменить необходимый элемент
        ShowList(names);   
        String someHuman = names.get(1);
        System.out.println("names.get(1) result: " + someHuman);  

        ArrayList<SomeObject> ArrayOfObjects = new ArrayList<SomeObject>();

        ArrayOfObjects.add(new SomeObject("Grace", 23));//забиваем объекты в список
        ArrayOfObjects.add(new SomeObject("Milly", 22));
        ArrayOfObjects.add(new SomeObject("Triss", 18));
        ShowObjects(ArrayOfObjects);
        SomeObject sob;
        ArrayOfObjects.set(0, new SomeObject("BatMan", 33));
        sob = ArrayOfObjects.get(0);
        sob.ShowData();
        ShowObjects(ArrayOfObjects);
    }

    public static <T> void ShowList(ArrayList<T> obj){
        System.out.println("\nNames is: ");
        for (T someChar: obj){
            System.out.println(someChar);
        }
    }

    public static void ShowObjects(ArrayList<SomeObject> obj){
        System.out.println("\nThere are list of objects: \n");
        for (SomeObject p : obj){
            p.ShowData();
        }

    }
    
}
class SomeObject{
    private String name;
    private int age;

    SomeObject(String name, int age){
        this.name = name; 
        this.age = age;
    }
    public void ShowData(){
        System.out.printf("Name is: %s\n", name);
        System.out.printf("Age is: %d\n", age);
    }
}
/*
void add(E obj):                        добавляет в конец списка объект obj
void add(int index, E obj):             добавляет в список по индексу index объект obj
E get(int index):                       возвращает объект из списка по индексу index
int indexOf(Object obj):                возвращает индекс первого вхождения объекта obj в список. Если объект не найден, то возвращается -1
int lastIndexOf(Object obj):            возвращает индекс последнего вхождения объекта obj в список. Если объект не найден, то возвращается -1
ListIterator<E> listIterator ():        возвращает объект ListIterator для обхода элементов списка
static <E> List<E> of(элементы):        создает из набора элементов объект List
E remove(int index):                    удаляет объект из списка по индексу index, возвращая при этом удаленный объект
E set(int index, E obj):                присваивает значение объекта obj элементу, который находится по индексу index
void sort(Comparator<? super E> comp):  сортирует список с помощью компаратора comp
List<E> subList(int start, int end):    получает набор элементов, которые находятся в списке между индексами start и end
boolean addAll(int index, Collection<? extends E> col): добавляет в список по индексу index все элементы коллекции col. 
                                                        Если в результате добавления список был изменен, то возвращается true, 
                                                        иначе возвращается false
*/