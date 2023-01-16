public class LambdaExpression_3 {

    /*
     * Так как в качестве параметра в метод можно передавать ссылку на другой метод. Что тоже применимо и для лямбда-выражения.
     */
    public static void main(String[] args){
        
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //Использование статических методов
        System.out.println("Result of using isPositive method: " + sum(array, LambdaExpression_3::isPositive));
        System.out.println("Reuslt of using isEven method: " + sum(array, LambdaExpression_3::isEven));

        //Использование нестатического метода 
        LambdaExpression_3 LE_3 =  new LambdaExpression_3();

        System.out.println("Result of using isNegative method: " + sum(array, LE_3::isNegative));
    }

    /*
     * Методы, на которые идет ссылка, должны совпадать по парметрам и результату с методом функционального интерфейса.
     */
    public static boolean isEven(int n){
        
        return n%2 == 0;
    } 
    public static boolean isPositive(int n){
        
        return n > 0; 
    }

    public boolean isNegative(int n){
        
        return n < 0; 
    }

    public static int sum(int[] array, SomeExpression ex){

        int result = 0;

        for(int i: array){
            if (ex.equal(i)){
                result += 1;
            }
        }
        return result;
    
    }

   
}
/*
 * Функциональный интерфейс 
 */
interface SomeExpression{

    boolean equal(int n);
}