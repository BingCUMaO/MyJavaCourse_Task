package B_project_training;

import java.text.NumberFormat;

/**
 * 3,6 项目实战
 * <p>
 * 2、摄氏度转换为华氏温度
 * <p>
 * 编写一个Temperature类，该类的celsius字段储存摄氏温度的值，该类
 * 的getFahrenheit 方法将celsius 的值转化为以华氏为单位的温度值并将
 * 该值作为方法的值返回。使用Temperature 类的对象将摄氏温度转换为
 * 华氏温度并输出。
 *
 *   摄氏转化为华氏的公式为：F = (9/5)*C + 32
 *   华氏转化为摄氏的公式为：C = (F-32)*5/9
 */
public class Exercise_2 {
    public static void main(String[] args) {
        Temperature t = new Temperature(10, Temperature.CELSIUS);

        System.out.println("celsiuis:\t"+t.getCelsius());
        System.out.println("fahrenheit:\t"+t.getFahrenheit());

        t.setFahrenheit(68);
        System.out.println("celsiuis:\t"+t.getCelsius());
        System.out.println("fahrenheit:\t"+t.getFahrenheit());
    }

    static class Temperature {
        public static final int CELSIUS = 0;
        public static final int FAHRENHEIT = 1;

        private double celsius;
        private double fahrenheit;

        public Temperature(double value, final int unitName) {
            switch (unitName) {
                case CELSIUS :
                    celsius = value;
                    toFahrenheit();
                    break;
                case FAHRENHEIT:
                    fahrenheit = value;
                    toCelsius();
                    break;
                default:
            }
        }

        private void toFahrenheit(){
            fahrenheit = (9/5.0)*celsius+32;
        }

        private void toCelsius(){
            celsius = (fahrenheit-32)*5/9.0;
        }

        public double getCelsius() {
            return celsius;
        }

        public void setCelsius(double celsius) {
            this.celsius = celsius;
            toFahrenheit();
        }

        public double getFahrenheit() {
            return fahrenheit;
        }

        public void setFahrenheit(double fahrenheit) {
            this.fahrenheit = fahrenheit;
            toCelsius();
        }
    }
}




