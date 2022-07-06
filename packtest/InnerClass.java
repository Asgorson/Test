////////////////////////////////////////////
//      Внутренние и вложенные классы     //
////////////////////////////////////////////
package packtest;

public class InnerClass {
    public static void main(String args[]){

        ///////////////////////////////////////////////////
        //InClassTypeCar TYPECAR = new InClassTypeCar(); // объект не может быть создан вне класса, 
        /////////////////////////////////////////////////// в котором этот класс находится

        /*OutClassCar Car_1 = new OutClassCar(); // не будет выполняться, так как в конструкторе OutClassCar()
        Car_1.ShowData();                        // нет выделения памяти под объект класса InClassTypeCar
        Car_1.typeCar.ShowData(); 
        Car_1.typeCar2.ShowData();*/
        /*
        OutClassCar Car_2 = new OutClassCar("Opel", 100_000);
        Car_2.ShowData();
        Car_2.typeCar.ShowData();
        Car_2.typeCar2.ShowData();
        
        //класс обявленный в функции//
        OutClassCar classInfunc = new OutClassCar(); 
        classInfunc.ClassInFunc(10);
        */
        ////////////////////////////////////////////
        // работа с вложенным статическим классом //
        ////////////////////////////////////////////
        OuterClass.InerClass innerclassObj = new OuterClass.InerClass(); 
        OuterClass.digit = 10; ; 
        System.out.printf("outerclass.getOuterClassVar: %d\n", innerclassObj.getOuterClassVar());
        innerclassObj.setOuterClassVar(99);
        System.out.printf("OuterClass.digit: %d\n", OuterClass.digit); 
    }

}
//////////////////////////////////////////////////////////////////////////////////////////
//                              пример работы внутренного класса                        //
//////////////////////////////////////////////////////////////////////////////////////////
class OutClassCar{      //внешний класс, все его поля, включая private, могут быть доступны из внутреннего класса InClassType
    public String CarName; 
    private int coast; 

    InClassTypeCar typeCar;
    InClassTypeCar typeCar2;
    OutClassCar(){
        CarName = "Undefined."; 
        coast = 0; 
    }
    OutClassCar(String CarName, int coast){
        this.CarName = CarName; 
        this.coast = coast;
        typeCar = new InClassTypeCar(); 
        typeCar2 = new InClassTypeCar("Mazda", 100);

    }

    public void ShowData(){
        System.out.printf("Car name: %s\t Coast: %d\n", CarName, coast);
    }

    public class InClassTypeCar{//внутренний класс, все его поля, включая private, могут быть доступны из внешнего класса OutClassCar
        public String CarType;  // также его можно запихать в метод и даже в цикл
        private int mass; 

        InClassTypeCar(){
            CarType = "Undefined."; 
            mass = 0; 
        }
        InClassTypeCar(String CarType, int mass){
            this.CarType = CarType; 
            this.mass = mass; 
        }
        public void ShowData(){
            System.out.printf("Car type: %s\t Car mass: %d\n", CarType, mass);
        }
    }
    ////////////////////////////////////////////////////////////
    //          создание класса в функции                     //
    ////////////////////////////////////////////////////////////
    public void ClassInFunc(int something){

        class FuncClass{

            void display(){
                System.out.printf("Digit: %d\n", something);
            }
        }
        FuncClass funcClass = new FuncClass(); 
        funcClass.display();
    }
}

////////////////////////////////////////////////////////////////////
//           работа с статическим вложенным классом               //
////////////////////////////////////////////////////////////////////

class OuterClass {
    public static int digit; 

    static class InerClass{
        
        public InerClass(){

        }

        int getOuterClassVar(){
            
            return OuterClass.digit; 
        }
        void setOuterClassVar(int var){
            OuterClass.digit = var; 
        }
    }

}
