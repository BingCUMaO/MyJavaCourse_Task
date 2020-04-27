package A_independent_practice;


/**
 * 7.5.5 独立实践
 * <p>
 * 3、分数运算（版本2）
 * <p>
 * 创建一个分数类。
 * 这个类包含构造函数和分数的加(add)、减(subtract)、乘(multiply)、
 * 除(divide)方法。
 * ##要求分数的运算结果为分数。并编写程序测试该类。
 */
public class Exercise_3 {
    public static void main(String[] args) throws Exception {
        Fraction frac = new Fraction(3, 5);
        System.out.println(frac.add(5, 6));
        System.out.println(frac.subtract(2, 3));
        System.out.println(frac.multiply(5, 5));
        System.out.println(frac.divide(2, 9));
    }

    private static class Fraction {
        private int baseNumerator;
        private int baseDenominator;

        public Fraction(int baseNumerator, int baseDenominator) {
            this.baseNumerator = baseNumerator;
            this.baseDenominator = baseDenominator;

            reduceFrac();
        }

        //简单的分数约分操作
        private void reduceFrac(){
            int min = Math.min(baseDenominator, baseNumerator);
            min = min < 0 ? min * (-1) : min;

            for (int i = 2; i <= min; i++) {
                if (baseNumerator % i == 0 && baseDenominator % i == 0) {
                    baseNumerator /= i;
                    baseDenominator /= i;
                }
            }
        }

        public String add(int numerator, int denominator) {
            baseNumerator = baseNumerator * denominator + numerator * baseDenominator;
            baseDenominator *= denominator;

            reduceFrac();
            return baseNumerator + "/" + baseDenominator;
        }

        public String subtract(int numerator, int denominator){
            baseNumerator = baseNumerator * denominator - numerator * baseDenominator;
            baseDenominator *= denominator;

            reduceFrac();
            return baseNumerator + "/" + baseDenominator;
        }

        public String multiply(int numerator, int denominator){
            baseNumerator *= numerator;
            baseDenominator *= denominator;

            reduceFrac();
            return baseNumerator + "/" + baseDenominator;
        }

        public String divide(int numerator, int denominator){
            return multiply(denominator, numerator);
        }

    }
}


