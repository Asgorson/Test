//import java.util.Scanner;
public class TestJava {
    public static void main (String args[]){
        /*
        //----вывод всех символов кода UTF - 16------------------------//

        char Ch = 0;
        for (int i=0; i<128; i++){
            Ch = (char)i;
            System.out.print("Nubmer of char: "+i); 
            System.out.println(" Char: " + Ch);
        }
        //-------------------------------------------------------------//
        */
        /*
        //--------------Пример привдения типов-------------------------//

        int  i = 32322; 
        short b = 32000;
        short c = 0;  
        c = b; 
        System.out.println("c(b): " + c);
        c = (short)i;
        System.out.println("c(i): " + c);
        //-------------------------------------------------------------//
        */
        /*
        //-----------------------------вывод на консоль----------------------------//
        System.out.println("i: " + c + "\tb: " + b + "\nПеренос строки");
        float pi = 3.1428f;
        double g = 1.12345342342;
        int f = 123;  
        System.out.printf("Pi num: %.3f \tG Num: %e \tint Num: %d\n", pi, g, f);

        //-------------------------------------------------------------------------//
        */
        /*
        //---------------------------ввод с консоли-------------------//
        Scanner in = new Scanner(System.in);

        System.out.print("Input an Int number: "); 
        int num = in.nextInt(); 
        System.out.printf("Num is: %d\n", num); 

        System.out.print("Inup a float number: "); 
        float fl = in.nextFloat();
        System.out.print("Input something: \n");
        in.nextLine(); 
        String smth = in.nextLine();
        System.out.printf("Num is: %.3f\t String is: %s\n", fl, smth);

        System.out.print("Input text: ");
        String text=in.nextLine();
        System.out.printf("Text is: %s", text);
        in.close();

        //--------------------------------------------------------------//
        */
        /*
        //---------Работа с условным оператором If{} else{} -------//

        int num_1=25, num_2=15; 

        if (num_1<num_2){
            System.out.println("Первое меньше второго.");
        }else {
            if (num_1>num_2){
                System.out.println("Первое больше второго.");
            }
            else {
                System.out.println("Два числа равны.");
            }
        }
        //---------------------------------------------------------//

        //------------Использование оператора else if {}------------//
        if (num_1<num_2){
            System.out.println("Первое меньше второго.");
        } else if(num_1>num_2){
            System.out.println("Первое больше второго.");
        } else{
            System.out.println("Два числа равны.");
        }
        //----------------------------------------------------------//
        */
        /*
        //------------------------Работа с массивами-------------------------------------//

        int[] arr_1 = new int[3]; //можно по-разному объявлять 
        int arr_2[]= new int[3];
        float arr_3[] = {1,2,3,2}; 

        System.out.printf("Arr_3: %.2f",arr_3[0]);

        //---------------узнать длину массива----------------------//
        int lngth = arr_3.length;
        System.out.printf("Lenth of arr_3: %d", lngth);
        //---------------------------------------------------------//

        int arr_4[][] = new int[2][2]; //объявление n-мерного массива и так далее

        //-------зубчатый массив----------//
        int arr_5[][] = new int[3][]; 
        arr_5[0] = new int[5];
        arr_5[1] = new int[10]; 
        arr_5[2] = new int[15]; 
        //--------------------------------//
        //-----------------------------------------------------------------------------//
        */
        /*
        //-----------------------Методы--------------------------//
        //Объявление и определение их только вне метода main
        //перегрузка методов такая же как и в C++
        //рекурсия такая же как и в C++
        int sum = SimpleFunc(12, 6);
        System.out.printf("Reuslt of sum: %d\n", sum);
        Func("Pavel", 12);
        //-------------------------------------------------------//
        */
        //-----------------Обработка исключений------------------//

        //-------------------------------------------------------//

    }
    //----------------------Работа с методами------------------------------------------//
    static int SimpleFunc(int first, int second){
        return first+second; 
    }
    static void Func(String Name, int Age){
        System.out.printf("Name: %s\tAge: %d", Name, Age);
    }
    //---------------------------------------------------------------------------------//

    
}
