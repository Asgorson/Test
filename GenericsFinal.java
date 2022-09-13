public class GenericsFinal {
    public static void main(String[] args){

        DepositAccount<String, String> Account_1 = new DepositAccount<String, String>("Alpine", "someID");
        DepositAccount<Integer, Integer> Account_2 = new DepositAccount<Integer, Integer>(1234231, 50_30);

        System.out.println("Account_1 id: " + Account_1.getId() + "\tName: " + Account_1.getName());
        System.out.println("Account_2 id: " + Account_2.getId() + "\tName: " + Account_2.getName());

        //преобразование обобщенных типов
        //объект обобщенного типа можно привести к другому типу, если они используют один и тот же тип.
        //Приводить разнотипные объекты нельзя.
        DepositAccount<Integer, String> DepAcc_1 = new DepositAccount<Integer, String>(10, "Alberto");
        Account_<Integer> Acc__1= (Account_<Integer>)DepAcc_1; 
        //но привести объект другого типа как указано ниже нельзя. 
        /*Account_<String> Acc_2=(Account_<String>) DepAcc_1;*/

    }
}

class Account_<T>{

    private T id; 

    Account_(T id){
        this.id = id;
    }
    T getId(){
        return id;
    }
}

class DepositAccount<T, S> extends Account_<T>{ //При наследовании от обобщенного класса, класс-наследник должен передавать данные о  
                                             //типе в конструкции базового класса
                                             //Также наследник может добавлять и использовать какие-то свои параметры типов
    private S idName; 

    DepositAccount(T id, S name){
        super(id);
        this.idName = name;
        
    }

    S getName(){
        return idName; 
    }
}

class Figure<T>{    //класс-наследник может не быть обобщенным. То есть не имеет универсальных параметров. 

    private T figureID; 

    Figure(T figureID){
        this.figureID = figureID;
    }
    T getFigureID(){
        return figureID; 
    }
}

class Circle extends Figure<Integer>{

    Circle(){
        super(4);
    }
}

class Animal{ //ситуация, когда базовый класс может не иметь уникальных параметров, а наследник имеет. 

    private String paroda; 

    Animal(String paroda){
        this.paroda = paroda;
    }

    public String getParoda(){
        return paroda; 
    }
}

class Dog<T> extends Animal{
    private T mass; 

    Dog(T mass){
        super("Dog");
        this.mass=mass;
    }
}
