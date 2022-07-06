package packtest;

////////////////////////////////////////////////////////////
//        Работа с классами. Наследоавание.               //
////////////////////////////////////////////////////////////

public class Inheritance {
    public static void main(String args[]){
        Driver driver_1 = new Driver("Steve", 50); 
        driver_1.ShowDriverData();
        Driverity driverity_1 = new Driverity(123);
        driverity_1.SetName("Johnson");
        driverity_1.ShowDriverData();
    }
}

class Human{

    public String Name;
    
    Human(String Name){
        this.Name = Name; 
    }

    public String GetName(){
         return Name;
    }
    public void Display(){
        System.out.printf("Name is: %s\n", Name);
    }
}
class Driver extends Human{

    public int age; 

    Driver(String Name, int age){
        super(Name);        //инициализировать конструктор предка не надо, если он пустой,см. классы ниже 
        this.age = age; 
    }
    public void ShowDriverData(){
        System.out.printf("Name: %s\t Age: %d", Name, age); 
    }
}

class Humanity{

    public String Name;
    
    Humanity(){
    }

    public void SetName(String Name){
         this.Name = Name;
    }
    public void Display(){
        System.out.printf("Name is: %s\n", Name);
    }
}
class Driverity extends Humanity{

    public int age; 

    Driverity(int age){
                                    //инициализировать конструктор предка не надо, если он пустой
        this.age = age; 
    }
    public void ShowDriverData(){
        System.out.printf("\nName: %s\t Age: %d", Name, age); 
    }
}