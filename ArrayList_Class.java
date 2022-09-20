import java.util.ArrayList; //реализация простого списка. Аналогичен безразмерному массиву.
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
        for(int i=0; i<names.size(); i++){
            System.out.println(names.get(i));
        }

        if(names.contains("Tom")){
            System.out.println("Name Tom is in list.");
        }else {
            System.out.println("Not found.");
        }
        names.add("Petro");
        names.add("Suarez");
        ShowList(names);
        names.remove("Tom"); //тут можно удалять объекты по следующим параметрам: -имени
                             //                                                   -индексу 
        ShowList(names);
        names.set(1,"Ivan"); //можно изменить необходимый элемент
        ShowList(names);   
        String someHuman = names.get(1);
        System.out.println("names.get(1) result: " + someHuman);  

        ArrayList<Object> ArrayOfObjects = new ArrayList<Object>();
        SomeObject Hum_1 = new SomeObject("Lis", 21); 
        ArrayOfObjects.add(Hum_1);
        Hum_1 = new SomeObject("Grace", 32);
        ArrayOfObjects.add(Hum_1);
        ShowObjects(ArrayOfObjects);
                                                 
    }

    public static <T> void ShowList(ArrayList<T> obj){
        System.out.println("\nNames is: ");
        for (T someChar: obj){
            System.out.println(someChar);
        }
    }

    public static void ShowObjects(ArrayList obj){
        System.out.println("\nThere are list of objects: \n");
        for(int i=0; i<obj.size(); i++){
            SomeObject SOb = (SomeObject) obj.get(i);
            SOb.ShowData();
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
