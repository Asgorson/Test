package packtest;
//И также как и в случае с классами, интерфейсы могут использоваться в качестве 
//типа параметров метода или в качестве возвращаемого типа


public class InterfaceWorkContinuation {

    public static void main(String args[]){
        
        Pprintable printable = createPrintable("Some name", true);
        printable.print(); 
        printable = createPrintable("Some name_2", false);
        printable.print(); 

        read(new bbook("Some book name_3", "Some author")); 
        read(new Jjournal("Some journal name"));

    }   
    static void read(Pprintable p){
        p.print(); 
    }
    static Pprintable createPrintable(String name, boolean option){
        if (option){
            return new bbook(name, "undefind author"); 
        }else {
            return new Jjournal(name);
        }
    }
    
}

interface Pprintable{

    void print(); 
}

class bbook implements Pprintable{
    String name,
           author;

    bbook (String name, String author){
        this.name=name; 
        this.author=author; 
    }

    public void print(){
        System.out.printf("%s (%s)\n", name, author);
    }
}

class Jjournal implements Pprintable{
    private String name; 

    Jjournal(String name){
        this.name=name;
    }

    public void print(){
        System.out.printf("%s\n", name);
    }

}