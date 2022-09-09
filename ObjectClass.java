// класс object и его методы 
// работать с ним в пакете не стоит, так как система выдает ошибку сборки.

public class ObjectClass {
    public static void main(String args[]){
        
        Human Tom = new Human("Tom"); 
        System.out.println("toString() method: " + Tom.toString());  //метод toString служит для представления объетка в виде строки. 
                                            // для нормального представления данный метод нередко переопределяют. 

        System.out.println("hashCode() method: " + Tom.hashCode()); //метод hashCode позволяет задать некоторе числовое значение, которое будет 
                                            //соответствовать даанному объекту. По данному числу можно сравнивать объекты

        System.out.println("getClass() method: " + Tom.getClass()); //метод позволяет получить тип данного объекта
        
        Human Tom_2 = new Human("Tom"); //метод equals сравнивает два объекта на равенство
                                             
        Human Max = new Human("Max");

        System.out.println("equals() method (Tom, Tom_2) : " + Tom.equals(Tom_2)); 
        System.out.println("equals() method (Tom, Max) : " + Tom.equals(Max)); 
    }
}

class Human{
    private String name;

    public Human(String name){
        this.name=name; 
    }

    @Override
    public String toString(){
        return "Human " + name; 
    }
    
    @Override 
    public int hashCode(){
        return 15*name.hashCode() + 123; 
    }

    @Override 
    public boolean equals(Object obj){
        if (!(obj instanceof Human)){   //метод instanceof позволяет выяснить, является ли переданный объект
                                        //объектом определенного класса
            return false;
        }
        Human h = (Human)obj;
        return this.name.equals(h.name); 
    }
}
