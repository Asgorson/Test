public class LambdaExpression_5 {
    /*
     * Лямбды как результаты методов.
     */
    public static void main(String[] args){
        //Operation Op = action(1); //можно и не создавать экземпляр интерфейса
        int a = action(1).execute(3, 4);
        System.out.println("Result is: " + a);

        int b = action(2).execute(10, 2);
        System.out.println("Result is: " + b);

        int c = action(3).execute(12, 3);
        System.out.println("Result is: " + c);
    }
    /*
     * Метод Action принимает в качестве параметра число и в зависимости от его значения возвращает то или иное лямбда-выражение. 
     * Формально, возвращаемым типом метода action является интерфейс Operation, а возвращаемое лямбда-выражение должно соответствовать
     * этому интерфейсу. 
     */
    private static Operation action(int number){
        switch(number){
            case 1: return (x, y) -> x + y;
            case 2: return (x, y) -> x - y;
            case 3: return (x, y) -> x * y;
            default: return (x, y) -> 0;
        }
    }
}
interface Operation{
    int execute(int x, int y);
}