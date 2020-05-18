package B_independent_practice;

/**
 * 2、复数相加减
 * <p>
 * (1)  声明一个复数类Complex。定义方法add将当前复数对象
 * 和参数指定的复数对象相加得到一个新的复数，定义方法
 * subtract将当前复数对象和参数指定的复数对象相减得到一个
 * 新的复数。
 * <p>
 * (2)  编写程序利试Complex类。
 * <p>
 * 要求测试的输出结果为:
 * (6+8i)+(10+12i)＝(16+20i)
 * (6+8i)-(10+12i)=(-4-4i)
 * (6+8i)+(6+8i)=(12+16i)
 */
public class Exercise_2 {
    public static void main(String[] args) {
        Complex complex = new Complex(6, 8);

        Complex com01 = new Complex(10, 12);
        Complex com02 = new Complex(10, 12);
        Complex com03 = new Complex(6, 8);

        System.out.println(complex + "+" + com01 + "=" + complex.add(com01));
        System.out.println(complex + "-" + com02 + "=" + complex.sub(com02));
        System.out.println(complex + "+" + com03 + "=" + complex.add(com03));
    }


    private static class Complex{
        private double realPart;
        private double imaginaryPart;

        public Complex(double realPart, double imaginaryPart) {
            this.realPart = realPart;
            this.imaginaryPart = imaginaryPart;
        }

        public Complex add(Complex complex) {
//            this.realPart += complex.realPart;
//            this.imaginaryPart += complex.imaginaryPart;
//            return this;
            return new Complex(this.realPart + complex.realPart, this.imaginaryPart + complex.imaginaryPart);
        }

        public Complex add(double realPart, double imaginaryPart) {
            return add(new Complex(realPart, imaginaryPart));
        }

        public Complex sub(Complex complex) {
//            this.realPart -= complex.realPart;
//            this.imaginaryPart -= complex.imaginaryPart;
//            return this;
            return new Complex(this.realPart - complex.realPart, this.imaginaryPart - complex.imaginaryPart);
        }

        public Complex sub(double realPart, double imaginaryPart) {
            return sub(new Complex(realPart, imaginaryPart));
        }

        @Override
        public String toString() {
            return "("
                    + this.realPart
                    + (this.imaginaryPart < 0 ? "" + this.imaginaryPart : "+" + this.imaginaryPart)
                    + "i)";
        }
    }
}
