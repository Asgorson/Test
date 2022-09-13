///////////////////////////////////////////////
//            Работа с объектами класса      //
///////////////////////////////////////////////
/*
 * 
 * Передача обекта класса в метод в качестве параметра
 * 
 */

package packtest;

public class ClassWork {
    public static void main(String args[]){
        Laptop laptop = new Laptop();
        laptop.SetData("Acer",12, "Intel", 1200);
        laptop.ShowData();
        changeData(laptop);//передается копия ссылки на объект
        laptop.ShowData();
        Laptop lap = new Laptop();
        lap.ShowData();
    }
    static void changeData(Laptop lt){ //передается копия ссылки на объект 

        lt.modelName = "Asus";
    }
}

class Laptop{
    public String modelName; 
    public int mass; 
    private String Company;
    private int price; 

    Laptop (){
        modelName = "Undefined."; 
        mass = 0; 
        Company = "Undefined";
        price = 0;
    }
    public void SetData(String modelName, int mass, String Company, int price){
        this.modelName=modelName; 
        this.mass=mass; 
        this.Company=Company; 
        this.price=price;
    }
    public void ShowData(){
        System.out.printf("LapTop data:\n Model name: %s\t Mass: %d\t Company: %s\t Price: %d\n", modelName, mass, Company, price);
    }
}
