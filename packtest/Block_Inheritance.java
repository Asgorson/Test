package packtest;

//////////////////////////////////////////
//          Запрет наследования         //
//          и переопределения           //
//////////////////////////////////////////
public class Block_Inheritance {
    public static void main(String args[]){
        /*
        Continent Afrika = new Continent("Afrika");
        Afrika.func();
        */
        Book Oruel_1894 = new Book();
        Oruel_1894.Display();
        Book NatGeo  = new Journal();//передача переменной суперкласса ссылку на объект подкласса
        NatGeo.Display();
    }

}
/*final*/ class Earth{      //если разкоментить final получится запрет на создание потомка, копмилятор выдаст ошибку. 
    public int gravity, mass, volume; 
    Earth(){
        gravity = 50; 
        mass = 100; 
        volume = 130; 
    }
    public /*final*/ void func(){ //если добавить final получится запрет на переопределение метода
        System.out.printf("Data: %d\t %d\t %d\n", gravity, mass, volume); 
    }

}
class Continent extends Earth{
    public String ContName; 
    Continent(String ContName){
        super();
        this.ContName=ContName; 
    }
    @Override
    public void func(){
        super.func();
        System.out.printf("Continent name: %s\n",ContName);
    }


    ///////////////////////////////////////////////
    //    Динамическая диспетчеризация методов   //
    ///////////////////////////////////////////////
}
class Book{
    public String Author; 
    public String Ganre; 

    Book(){
        Author = "Undefined"; 
        Ganre = "Undefined";
    }
    public void SetBookData(String Author, String Ganre){
        this.Author=Author; 
        this.Ganre=Ganre;
    }
    public void Display(){
        System.out.printf("Author: %s\t Ganre: %s\n", Author, Ganre);
    }
}
class Journal extends Book{

    public int JournalNomber;

    Journal(){
        super();
        JournalNomber = 0;
    }
    @Override
    public void Display(){
        System.out.printf("Journal number: %d\n", JournalNomber);
    }
}