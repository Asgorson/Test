import java.util.*; 
/*
 * Данный код является дополнением к коду TreeSet_Class.java
 * Для того, чтобы объеткы Person можно было сравнивать и сортировать, они должны применять интерфейс Comparable<E>.
 * При применении интерфейса он типизируется текущим классом.
 * Если интерфейс Comparable<E> не был реализован или его реализация нас не устраивет, есть более гибкий способ, который 
 * предполагает использование интерфейса Comaparator<E> 
 */
public class ComparableAndComparator {
    public static void main(String[] args){

        TreeSet<SomePers> ITgroup = new TreeSet<SomePers>();
        ITgroup.add(new SomePers("John",24)); 
        ITgroup.add(new SomePers("Elizaveth",44));
        ITgroup.add(new SomePers("Jane", 35));
        ITgroup.add(new SomePers("John",18));

        for (SomePers o: ITgroup){
            o.ShowInfomation();
        }

        /*
         * Для создания TreeSet здесь используется одна из версий конструктора, которая в качестве параметра принимает компаратор. 
         * Теперь вне зависимости от того, реализован ли в классе SomePers интерфейс Comparable, логика сравнения и сортировки будет 
         * использоваться та, которая определена в классе компаратора.
         */
        PersonAgeComparator compAge = new PersonAgeComparator(); 
        TreeSet<SomePers> ITgroup_2 = new TreeSet<SomePers>(compAge);
        ITgroup_2.add(new SomePers("John",24)); 
        ITgroup_2.add(new SomePers("Elizaveth",44));
        ITgroup_2.add(new SomePers("Jane", 35));
        ITgroup_2.add(new SomePers("John",18));

        System.out.println("\n");
        for(SomePers o: ITgroup_2){
            o.ShowInfomation();
        }

        PersonNameComparator compName = new PersonNameComparator();
        TreeSet<SomePers> ITgroup_3 = new TreeSet<SomePers>(compName);
        ITgroup_3.add(new SomePers("John",24)); 
        ITgroup_3.add(new SomePers("Elizaveth",44));
        ITgroup_3.add(new SomePers("Jane", 35));
        ITgroup_3.add(new SomePers("John",18));
        
        System.out.println("\n");
        for(SomePers o: ITgroup_3){
            o.ShowInfomation();
        }
    }
}
/*
 * Реализация интерфейса Comparable<E>
 */
class SomePers implements Comparable<SomePers>{
    private String name; 
    private int age;

    SomePers(String name, int age){
        this.name = name; 
        this.age = age; 
    }

    String GetPname(){
        return name;
    }
    
    int getPAge(){
        return age; 
    }

    void ShowInfomation(){
        System.out.println("Name: " + this.name + "\tAge: " + this.age);
    }

    public int compareTo(SomePers o) {

        return name.compareTo(o.GetPname());
    }
}

/*
 * Реализация интерфейса Comparator<E>
 * Используется, когда необходимо переопределить функционал Comparable()
 * Также можно применить несколько компараторов по принципу приоритета
 */
class PersonAgeComparator implements Comparator<SomePers>{

    public int compare(SomePers a, SomePers b){
        if (a.getPAge() > b.getPAge()){
            return 1; 
        }else if (a.getPAge() < b.getPAge()){
            return -1; 
        }else{
            return 0;
        }
    }
}
class PersonNameComparator implements Comparator<SomePers>{

    public int compare(SomePers a, SomePers b){

        return a.GetPname().compareTo(b.GetPname());
    }
}
