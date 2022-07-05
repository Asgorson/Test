import packtest.*; // пример импорта созданного класса, см. папка Package
import java.util.Scanner;

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
        /*
        //-----------------Обработка исключений------------------//
        try {
            int arr[] = new int[6]; 
            arr[5] = 45; 
            System.out.printf("Arr[%d]: %d\n", 5,arr[5]);
        }catch(Exception ex){//можно созадвать несколько catch() для обработки разных исключений
            ex.printStackTrace();
            System.out.printf("Error. Out of bound.\n");
        }finally{ // необязательный параметр
            System.out.printf("'Finally' block.\n");
        }
        System.out.printf("Programm is over.\n"); 
        //-------------------------------------------------------//
        */
        /*
        //----------------Создание собственного исключения--------//
        try{
            Scanner In = new Scanner(System.in); 
            int B = In.nextInt();
            In.close(); 
            if (B>100){
                throw new Exception("Введенное число больше 100!"); 
            }
        }catch(Exception ex){
            System.out.printf(ex.getMessage());
        }
        //--------------------------------------------------------//
        */
        //Func("Bane", 14);
        /*
        //--------------------работа с классом------------------//
        Password SitePass = new Password();
        SitePass.AddPass();
        SitePass.ShowData();  
        Password SitePass_2 = new Password(2);
        SitePass_2.ShowData();
        //------------------------------------------------------//   
        */
        /*
        //-------------------Работа с созданным импортом-------------//
        JavaPackage body = new JavaPackage(12,15); 
        body.showResult(); 
        body.mass = 22; 
        body.height = 30; 
        body.showResult();
        JavaPackage body2 = new JavaPackage(); 
        body2.showResult();
        //-----------------------------------------------------------//
        */
        /*
        //------------------импорт + работа со статическим методом------//
        System.out.printf("Result of sum: %d", JavaPackage.sum(2,3)); // как видно не создается объект класса
        //--------------------------------------------------------------//
        */
    }
       
    //----------------------Работа с методами------------------------------------------//
    static int SimpleFunc(int first, int second){
        return first+second; 
    }
    static void Func(String Name, int Age){
        System.out.printf("Name: %s\tAge: %d\n", Name, Age);
    }
    //---------------------------------------------------------------------------------//

}

 //------------------------Работа с классами----------------------------------------//
class Password{ //обявление класса происходит вне главного класса, вроде очевидно, но при первом изучении не понятно
    public String passName;
    public int ID;  
    private String pass;

    { // инициализатор, общий для всех конструкторов, может быть статическим 
        passName="undefind";
        ID=10;
        pass=" ";
    }

    Password(int num){ //конструктор 1
        this.ID=num; 
    }
    Password(){ //конструктор 2

    }
    void AddPass(){
        System.out.printf("Input Site for password.\n");
        Scanner in=new Scanner(System.in);
        passName=in.nextLine(); 
        ID++; 
        System.out.printf("Input pass:");  
        pass=in.nextLine();
        in.close();
    }
    void ShowData(){
        System.out.printf("ID: %d\t Site: %s\t Pass: %s\n", ID, passName, pass);
    }   
}
//---------------------------------------------------------------------------------//