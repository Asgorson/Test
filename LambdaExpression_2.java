public class LambdaExpression_2 {
    /*
     * Одним из преимуществ лямбд в java является то, что их можно передавать в качестве параметров в методы. 
     */

    private static int sum(int[] numbers, Expression ex){
            
        int result = 0;
        for(int i: numbers){
            if (ex.Comparison(i)){
                result += 1;
            }
        }
        return result;
    }

    public static void main(String[] args){

        //Expression Ex = n -> n%2==0; можно и не создавать 
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 12, 14, 16};
        System.out.println("Array is: ");
        for (int i: arr){
            System.out.printf("%d\t", i);
        }
        System.out.println("\nКоличество чисел, удовлетворяющих условию (n%2 == 0): " + sum(arr, /*Ex*/n -> n%2==0));

        //также, можно передавать в качестве параметра само выражение, без создания экземпляра интерфейса. 
        int sum_2 = sum(arr, (n) -> n>4);
        System.out.println("\nКоличество чисел, удовлетворяющих условию (n > 4): " + sum_2);
        
    }


}

interface Expression{
    boolean Comparison(int n);
}


