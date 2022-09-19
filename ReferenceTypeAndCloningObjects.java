///////////////////////////////////////
//осуществление неполного копирования//
/////////////////////////////////////// 

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
                                    //в данном примере показано неполное клонирование
        Man_1.display();

        try{
            Person Women_1 = new Person("Liss", 21);
            Person Women_2 = Women_1.clone(); // осуществляется неполное копирование, применяется, если клонируемый объект не содержить сложных 
                                              // объектов
            Women_2.SetName("Mary"); 
            Women_1.display();
            Women_2.display();
        } catch(CloneNotSupportedException ex) {
            System.out.println("Cloneable is not implemented.");
        }

        //пример вывода ошибки 
        try{
            Airplane airplane_1 = new Airplane("AirBus", "SomeData");
            Airplane airplane_2 = airplane_1.clone(); 
            airplane_2.SetYawPitchRoll("SomeData_2"); 
            System.out.println("Data of airplane: " + airplane_1.GetYawPitchRoll()); //при изменении поля второго объекта изменяется и поле первого
                                                                                     //так как поля одного и второго объектов ссылаются на 
                                                                                     //одну и туже область памяти. 

                                                                                     //Airplane airplane_1 ------>   Airplane
                                                                                     //                           ****************
                                                                                     //                           *     name     *       YawPitchRoll
                                                                                     //                           ****************       ************
                                                                                     //                           * YawPitchRoll *-----> * someData *
                                                                                     //                           ****************       ************
                                                                                     //                                                        ^
                                                                                     //                                                       / \
                                                                                     //                                                        |
                                                                                     //Airplane airplane_2 ------>   Airplane                  |
                                                                                     //                           ****************             |
                                                                                     //                           *     name     *             |
                                                                                     //                           ****************             |
                                                                                     //                           * YawPitchRoll *--------------
                                                                                     //                           ****************
        }catch (CloneNotSupportedException ex){
            System.out.println("Cloneable is not implemented.");
        }
    }
  
}

class Person implements Cloneable{

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
    public Person clone() throws CloneNotSupportedException{
        return (Person) super.clone(); 
    }
}

//случай, когда объект содержит в себе сложные объекты.
//он показывает, что в данном случае неполное клонирование приведет к ошибке 

class Airplane implements Cloneable{

    private String name; 
    private Yaw_Pitch_Roll YawPitchRoll; 

    public Airplane(String name, String someData){
        this.name = name; 
        this.YawPitchRoll = new Yaw_Pitch_Roll(someData); 
    }

    public void setName(String name){
        this.name = name; 
    }
    public String getName(){
        return name;
    }

    public void SetYawPitchRoll(String someData){
        YawPitchRoll.setData(someData);
    }
    public String GetYawPitchRoll(){
        return YawPitchRoll.getData(); 
    }
    public Airplane clone() throws CloneNotSupportedException{
        return (Airplane) super.clone();
    }

}

class Yaw_Pitch_Roll{

    private String SomeData; 

    public Yaw_Pitch_Roll(String SomeData){
        this.SomeData = SomeData; 
    }

    public String getData(){
        return SomeData; 
    }
    public void setData(String data){
        this.SomeData = data; 
    }
}