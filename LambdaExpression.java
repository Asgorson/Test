public class LambdaExpression {
    /*
     * Лямбда выражение состоит из лямбда-оператора, который представляет стрелку "->", он делит выражение на две части: 
     * 1) Левая содержит список параметров выражения
     * 2) Правая представляет тело лямбда-выражения, где выполняются все действия.
     * 
     * Лямбда-выражение образует реализацию одного единственного метода, определенного в функциональном интерфейсе.  
     */
    //ПЕРЕМЕННЫЕ ПРИМЕРА 1
    static int x = 10,
               y = 20;
    public static void main(String[] args){

        SomeOperation SomOp = (xx,yy)->xx+yy;
        int result = SomOp.calculate(10, 12);
        System.out.println("Result is: " + result);

        //Если метод не принимает никаких параметров, то пишутся пустые скобки.
        SomeOperation_2 SomOp_2 = ()->30+20;
        int result_2 = SomOp_2.calculate();
        System.out.println("Result is: " + result_2);

        //Также могут быть и терминальные лямбда-выражения, которые не возвращают никакого значения. 

        SomeOperation_3 SomOp_3 = row->System.out.println(row);
        SomOp_3.show("Hello, world!");

        //Лямбда-выражение может использовать переменные, которые объявлены во вне в более общей области видимости - на уровне класса 
        //или метода, в котором лямбда-выражение определено. Однако в зависимости от того, как и где определены переменные, могут р
        //различаться способы их использования в лямбдах.

        //Пример 1. Использование переменных уровня класса.(Переменные определены в самом верху. См. "ПЕРЕМЕННЫЕ ПРИМЕРА 1")

        SomOp_2 = ()->{ //данный формат выражения демонстрирут второй вариант структуры выражения: блок кода(выделяется фигурными скобками)
                        //сдесь можно использовать условные операторы(if, else), оператор(switch), создавать переменные и т.д.
            x=30;
            return x+y;
        };
        System.out.println("Result is: " + SomOp_2.calculate());
        System.out.println("Value of (x) is: " + x);

        //Пример 2. Использование переменных на уровне метода.

        int n = 70, //значение данных переменных нельзя изменить, более того значение переменной нельзя изменить вне этого выражения
            m = 30; //по сути они имеют парметр final

        SomOp_2 = ()->{ 
            // m = 100 так нельзя сделать 
            return m + n;
        };
        // m = 100 за пределами выражения тоже нельзя изменить значение переменной
        System.out.println("Result is: " + SomOp_2.calculate());

        //Пример 3. Использование обобщенного функционального интерфейса 
        SomeOperation_4<Integer> SomOp_4_1 = (x, y)-> x + y;
        System.out.println("Result is: " + SomOp_4_1.calculate(33, 55));

        SomeOperation_4<Float> SomOp_4_2 = (q, w) -> q + w;
        System.out.println("Result is: " + SomOp_4_2.calculate(2.3f, 5.1f));
    }
}

interface SomeOperation{

    int calculate(int x, int y);
}

interface SomeOperation_2{

    int calculate();
}

interface SomeOperation_3{

    void show(String row);
}

//также есть возможность создать обобщенный функциональный интерфейс

interface SomeOperation_4<T>{

    T calculate(T x, T y);
}