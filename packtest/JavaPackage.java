/////////////////////////////////////////////////
//              работа с пакетами              //
/////////////////////////////////////////////////
package packtest; 

public class JavaPackage{
    public int mass, height;

    public static void main(String args[]){
        /*
        //------для использования одинаковых методов из импорта необходимо явное объявление------------//
        java.util.Date utilDate = new java.util.Date(); 
        java.sql.Date sqlDate = new java.sql.Date(0); 
        //---------------------------------------------------------------------------------------------//
        */
    }

    public JavaPackage (){

    }
    public JavaPackage(int mass, int height){
        this.mass=mass; 
        this.height=height; 
    }
    public void showResult(){//методы вызываются в исходном файле см. TestJava.java
        System.out.printf("Body mass: %d\tBody height: %d\n", mass, height);
    }
}
