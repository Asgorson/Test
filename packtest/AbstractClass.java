package packtest;

//////////////////////////////////////////////////////
//         Работа с абстрактными классами           //
//////////////////////////////////////////////////////
public class AbstractClass{
      
    public static void main(String[] args) {
             
        Employee sam = new Employee("Sam", "Leman Brothers");
        sam.display();
        Client bob = new Client("Bob", "Leman Brothers");
        bob.display(); 
    }
}
abstract class Person {
    //В абстрактном классе также можно определить поля и методы, но в то же время нельзя создать объект или 
    //экземпляр абстрактного класса. Абстрактные классы призваны предоставлять базовый функционал для классов-наследников. 
    //А производные классы уже реализуют этот функционал.
     
    private String name;
     
    public String getName() { return name; }
    
    public Person(String name){
     
        this.name=name;
    }
  
    public abstract void display();// абстрактный метод должен быть определен в потомке
}
 
class Employee extends Person{
 
    private String bank;
     
    public Employee(String name, String company) {
     
        super(name);
        this.bank = company;
    }
     
    public void display(){//определение абстрактного метода ы
         
        System.out.printf("Employee Name: %s \t Bank: %s \n", super.getName(), bank);
    }
}
 
class Client extends Person
{
    private String bank;
     
    public Client(String name, String company) {
     
        super(name);
        this.bank = company;
    }
     
    public void display(){
         
        System.out.printf("Client Name: %s \t Bank: %s \n", super.getName(), bank);
    }
}