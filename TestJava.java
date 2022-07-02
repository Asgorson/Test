import java.util.Scanner;
public class TestJava {
    public static void main (String args[]){
        //----вывод всех символов кода UTF - 16------------//
        /*char Ch = 0;
        for (int i=0; i<128; i++){
            Ch = (char)i;
            System.out.print("Nubmer of char: "+i); 
            System.out.println(" Char: " + Ch);
        }*/
        //-------------------------------------------------------------//
        //--------------Пример привдения типов--------------------------//
        int  i = 32322; 
        short b = 32000;
        short c = 0;  
        c = b; 
        System.out.println("c(b): " + c);
        c = (short)i;
        System.out.println("c(i): " + c);
        //------------------------------------------------------------//
        //----------------вывод на консоль-------------------------//
        System.out.println("i: " + c + "\tb: " + b + "\nПеренос строки");
        float pi = 3.1428f;
        double g = 1.12345342342;
        int f = 123;  
        System.out.printf("Pi num: %.3f \tG Num: %e \tint Num: %d", pi, g, f);

        //----------------------------------------------------------------//
        //---------------------------ввод с консоли-------------------//
        
    }
    
}
