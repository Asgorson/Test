/////////////////////////////////////////////////
//              работа с пакетами              //
/////////////////////////////////////////////////
package packtest; 

public class JavaPackage{
    public int mass, height;
    private static int ID =0; 

    {//инициализатор может быть статическим для определения статических переменных 
        mass = 0; 
        height = 0; 
    }
    public JavaPackage (){
        ID++; 
    }
    public JavaPackage(int mass, int height){
        ID++;
        this.mass=mass; 
        this.height=height; 
    }
    public void showResult(){//методы вызываются в исходном файле см. TestJava.java
        System.out.printf("ID: %d\tBody mass: %d\tBody height: %d\n",ID, mass, height);
    }

    public static int sum(int f1, int f2){

        return f1+f2;
    }


    public static void main(String args[]){
        /*
        //------для использования одинаковых методов из импорта необходимо явное объявление------------//
        java.util.Date utilDate = new java.util.Date(); 
        java.sql.Date sqlDate = new java.sql.Date(0); 
        //---------------------------------------------------------------------------------------------//
        */
    }
}
