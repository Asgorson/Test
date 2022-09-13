package packtest;

public class Enum_1 {
    public static void main(String args[]){

        /*enum Keys{//перечисления можно обявлять где угодно, кроме главвного класса. Область видимости, по правилам
            UP,
            DOWN,
            LEFT,
            RIGHT
        }*/

        Day Current = Day.Monday; 
        System.out.printf("Day of week: %s\n", Current); 
        //Keys Arrow = Keys.UP; 
        //System.out.printf("Arrow is: %s\n", Arrow);
        Answer Solution = Answer.YES; 
        System.out.printf("Decision is: %s\n", Solution);

    }
    enum Day{
        Monday,
        Tuesday, 
        Wednsday,
        Thursday, 
        Friday, 
        Saturday,
        Sunday
    }
    
}
enum Answer{
    YES, 
    NO
}
