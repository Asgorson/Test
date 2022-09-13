package packtest;
//  Работа с интерфейсами позволяет частично решить проблему отстутствия множественного наследования в java
//  Один класс может применить множество интерфейсов
//  Интерфейсы, как и классы, могут наследоваться, однако класс, использующий интерфейс наследник должен определить 
//  методы предка и потомка.


public class InterfaceWork{
    public static void main(String[] args){

        //Printable print = new Printable(); нельзя напрямую создавать объект интерфейса 
        Manga books = new Manga("Attack on titan", "Hadzime");
        books.print();

        //Класс Book и класс Journal связаны тем, что они реализуют интерфейс Printable. 
        //Поэтому мы динамически в программе можем создавать объекты Printable как экземпляры обоих классов:
        Printable Print_1 = new Manga("Awari no seraph", "Kagami");  
        Print_1.print();
        Print_1 = new Anime("Death note");
        Print_1.print();

        //Работа со статическим методом в интерфейсе такая же как и в обычных классах.
        Pring.StatMethod();

        // метод по умолчанию позволяет измбегать повторения кода, в случаях когда несколько классов включают в себя один 
        // интефейс. Нет необходимости переопределять методы в каждом классе.    
        Manga man = new Manga("mfn", "nsmf");
        man.DefMethod();

        //применение приватного метода в интерфейсе
        Printable calc= new Calc();  
        System.out.printf("Result of Private method sum(int a, int b): %d\n", calc.sum(1,2)); 
        System.out.printf("Result of Private method sum(int a, int b, int c): %d\n", calc.sum(1,2,3)); 

        //использование внутреннего интерфейса
        Printer.innerInterface InInterface = new ClassForIneerInterface(); 
        InInterface.show();
    }
    
}

interface Printable{ // если участвует в качестве контейнера, необходимо чтобы не было пересечений в названии классов, 
                     // а то ошибку не показывает, но и не запускает программу, изначально были реализованы классы Book, 
                     // Journal не работало. После изменения названия классов все заработало. 

    int Incr = 0;   // Статическая константа, по умолчанию имеет модификатор доступа public static final
                    // доступна из любомо места программы

    void print();    // обязательно должен быть определен в классе

    default int sum(int a, int b){
        return SumAll(a,b);
    }
    default int sum(int a, int b, int c){
        return SumAll(a,b,c);
    }
    private int SumAll(int... values){ //приватные методы могут использоваться только внутри интерфейса, в котором они 
                                       //определены
        int result = 0; 
        for(int n : values){
            result+=n;
        }
        return result; 
       
    }
}
//////////////////////////////////////////
//          Методы по умолчанию         //
//////////////////////////////////////////
interface Pring{

    default void DefMethod(){
        System.out.printf("Default method.\n");
        //метод Метод по умолчанию - это обычный метод без модификаторов, который помечается ключевым словом default. 
        //Затем в классе Manga нам не обязательно этот метод реализовать, хотя мы можем его и переопределить.
        //Только они могут быть определениы в интерфейсе.
    };

    static void StatMethod(){
        System.out.printf("Static method.\n"); 
        //Чтобы обратиться к статическому методу интерфейса также, как и в случае с классами, 
        //пишут название интерфейса и метод. 
    }
}

//////////////////////////////////////////
class Calc implements Printable{

    public void print(){

    }
}



class Manga extends Calc implements Pring{ 
                                        // если класс применяет интерфейс, то он должен реализовать все методы интерфейса
    String name, author;               
                  
    Manga(String name, String author){
        this.name=name; 
        this.author=author;
    }

    public void print(){
        System.out.printf("Name: %s\t\t Author: %s\n",name, author);
    }
     
}

class Anime implements Printable, Pring{ // один класс может применить множество интерфейсов, а также наследовать свойства 
                                         // другого класса одновременно
    private String name; 

    Anime(String name){
        this.name=name; 
    }

    public void print(){
        System.out.printf("Name: %s\n", name);
    }
}

//  Интерфейсы, как и классы, могут быть вложенными. 
//  Пример:
class Printer{
    interface innerInterface{
        void show();
    }
}

class ClassForIneerInterface implements Printer.innerInterface{  //указывается имя интерфейса вместе с именеи класса
    public void show(){
        System.out.printf("Inner Interface.");
    }
}
//ИНТЕРФЕЙСЫ КАК ПАРАМЕТРЫ И РЕЗУЛЬТАТЫ МЕТОДОВ 
//И также как и в случае с классами, интерфейсы 
//могут использоваться в качестве типа параметров метода или в качестве возвращаемого типа
