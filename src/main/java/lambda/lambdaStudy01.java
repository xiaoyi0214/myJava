package lambda;

import javafx.event.EventHandler;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

/**
 * Created by 小逸 on 2020/6/18.
 *
 * @author 小逸
 */
public class lambdaStudy01 {
    private static String HELLO = "hello";

    public static void main(String[] args) {


        lambdaStudy01 lambdaTester = new lambdaStudy01();

        // 1、可以没有类型声明，
        // 2、如果只有唯一表达式返回值，可以不要 return 语句
        // 3、若只有一个参数，可以不用形参括号
        PrintLambda print = message -> System.out.println(message);

        MathOperation addition = (a,b) -> a+b;

        MathOperation subtraction = (int a,int b) -> a - b;

        MathOperation multiplication = (int a, int b) -> {return a * b ;};

        MathOperation division = (int a , int b) -> a / b;

        System.out.println("10 + 5 = "+lambdaTester.opterate(10, 5, addition));
        System.out.println("10 - 5 = "+lambdaTester.opterate(10, 5, subtraction));
        System.out.println("10 * 5 = "+lambdaTester.opterate(10, 5, multiplication));
        System.out.println("10 / 5 = "+lambdaTester.opterate(10, 5, division));

        PrintLambda printLambda = message -> System.out.println(message);
        printLambda.print("Hello lambda!!!");

        // 4、只能引用final的外层局部变量:
        // 不能在lambda内部修改定义在域外的局部变量，否则会编译报错???  不存在这个问题
        PrintLambda printLambdaFinal = message -> {
            HELLO = "hello1";
            System.out.println(HELLO+message);};
        printLambdaFinal.print(" Lambda !!!");

    }

    interface MathOperation{
        int operation(int a, int b);
    }
    interface PrintLambda{
        void print(String message);
    }


    private int opterate (int a,int b, MathOperation mathOperation){
        return mathOperation.operation(a, b);
    }
    
}
