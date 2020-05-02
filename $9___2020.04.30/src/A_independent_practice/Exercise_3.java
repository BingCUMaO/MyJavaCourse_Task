package A_independent_practice;


/**
 * 7.7.5 独立实践
 * <p>
 * 3、数学工具箱（版本5）
 *
 *        在MyMath类中声明Factorial方法，该方法计算参数n指定的
 * 整数的阶乘，并返回计算出的n的阶乘的值。
 *
 * 编写测试程序，输入一个整数，调用MyMath类的Factorial方法，
 * 计算该整数的阶乘，并输出该阶乘的值。
 *
 */
public class Exercise_3 {
    public static void main(String[] args) {
        System.out.println(MyMath.calcFactorial(3));
        System.out.println(MyMath.calcFactorial(5));
        System.out.println(MyMath.calcFactorial(10));
        System.out.println(MyMath.calcFactorial(25));
    }

    private static class MyMath{
        public MyMath() {
        }

        public static long calcFactorial(int n){
            long result = n;
            while (--n > 1 && (result *= n) < Long.MAX_VALUE) ;

            return result;
        }
    }
}


