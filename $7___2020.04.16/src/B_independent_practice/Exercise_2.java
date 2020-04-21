package B_independent_practice;


/**
 * 7.4.5 独立实践
 *
 * 2、温度转换
 *
 * （1）编写一个Temperature类，要求该类只有一个属性，但有两个
 *          set方法，分别设置华氏温度和摄氏温度的值，有两个get方法，
 *          分别获取华氏温度的值和摄氏温度的值。
 * （2）创建Temperature 类的对象t1，设置t1对象摄氏温度的值，分
 *          别使用get方法读取t1对象华氏温度的值和摄氏温度的值并输出。
 *          修改t1对象华氏温度的值，分别使用get方法读取t1对象华氏温
 *          度的值和摄氏温度的值并输出。
 *
 */
public class Exercise_2 {
    public static void main(String[] args) {
        Temperature t1 = new Temperature();
        System.out.println(t1.getCentigrade());
        System.out.println(t1.getFahrenheit());

        System.out.println("=========================");

        t1.setCentigrade(0);
        System.out.println(t1.getFahrenheit());
    }

    private static class Temperature{
        public final double ABSOLUTE_ZERO_CENTIGRADE = -273.15;
        public final double ABSOLUTE_ZERO_FAHRENHEIT = -459.67;

        private double fahrenheit;

        public Temperature() {
            this.fahrenheit = ABSOLUTE_ZERO_FAHRENHEIT;
        }

        public double getFahrenheit() {
            return fahrenheit;
        }

        public void setFahrenheit(double fahrenheit) {
            this.fahrenheit = fahrenheit;
        }

        public double getCentigrade() {
            return 5*(fahrenheit-32)/9;
        }

        public void setCentigrade(double centigrade) {
            this.fahrenheit = 9 * centigrade / 5 + 32;
        }
    }

}


