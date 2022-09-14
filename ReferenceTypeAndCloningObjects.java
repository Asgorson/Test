public class ReferenceTypeAndCloningObjects {

    public static void main(String[] args){

        Person Man_1 = new Person("John", 24);
        Man_1.display();
        Person Man_2 = Man_1;
        Man_2.SetName("Bob"); //все объекты являются ссылочными типами, которые указывают на объект
                                    //в данном примере объекту man_2 присваивается объект man_1
                                    //изменяя man_2 мы изменим и man_1 так как они оба будут указывать на 
                                    //один участок памяти.
                                    //чтобы это избежать, можно применить один из методов - клонирование
        Man_1.display();
    }
}

class Person{

    private String name; 
    private int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void SetName(String name){
        this.name = name; 
    }
    
    public void SetAge(int age){
        this.age = age;
    }

    public void display(){
        System.out.printf("Person name: %s\tPerson age: %d\n", name, age);
    }
}