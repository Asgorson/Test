import java.util.HashSet;
import java.util.Iterator;

public class HashSet_Class {    //Представляет собой неупорядоченное множество. Основан на hesh-таблице
                                //В нем хранятся только уникальные элементы по возрастанию или NUll, повтор их невозможен.
                                //Порядок добавления элементов вычисляется с помощью hash-кода.
                                //Можно использовать методы реализованные в родительских классах.
    public static void main(String[] args){
        HashSet<String> Figures = new HashSet<String>(10, 0.5f); //в скобках указывается начальная екмкость, 
                                                                                             //а также коэф. загрузки, то есть если 
                                                                                             //загрузка достигнет этого коэффициента 
                                                                                             //множество расширится в два раза.
        Figures.add("Квадрат");
        Figures.add("Треугольник");
        Figures.add("Круг");

        boolean isAdded = Figures.add("Треугольник");
        System.out.println(isAdded);
        isAdded = Figures.add("треугольник");
        System.out.println(isAdded);

        Figures.remove("треугольник");

        for (String F: Figures){
            System.out.println(F);
        }

        Iterator<String> It = Figures.iterator();

        while(It.hasNext()){
            System.out.println(It.next());
        }
        Figures.clear(); //удаляет все элементы 
        //Figures.add("Трапеция");
        if (Figures.isEmpty()){
            System.out.println("Set is empty.");
        }else {
            System.out.println("Set isn't empty.");
        }
        HashSet<List_Of_Driver> DriverSet = new HashSet<List_Of_Driver>();  
        DriverSet.add(new List_Of_Driver("Shumaher", 44));
        DriverSet.add(new List_Of_Driver("Manchini", 25));
        DriverSet.add(new List_Of_Driver("Shumaher", 43));
        for (List_Of_Driver lod: DriverSet){
            lod.showInfo();
        }
    }
}

class List_Of_Driver {
    private String name; 
    private int age;

    List_Of_Driver(String name, int age){
        this.name = name;
        this.age = age;
    }
    List_Of_Driver(){
        this.name = "Undefined";
        this.age = 0; 
    }
    public void showInfo(){
        System.out.println("Name: " + name + "\tAge: " + age);
    }
    @Override                                                   //Если не переопределить данные методы класса Object, 
    public boolean equals(Object obj){                          //в множество будет добавляться объект с одинаковыми данными. 
        if(!(obj instanceof List_Of_Driver)){                   //Дело в том что объекты с одинаковыми данными будут иметь 
            return false;                                       //разные hash коды, следовательно оба объекта будут добавлены в 
        }                                                       //множество
        List_Of_Driver LOD = (List_Of_Driver) obj;
        return this.name.equals(LOD.name);
    }
    @Override 
    public int hashCode(){
        String ch = Integer.toString(age);
        return name.hashCode()+ch.hashCode(); 
    }
}