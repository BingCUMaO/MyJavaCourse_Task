package A_independent_practice;

import javax.swing.*;
import java.text.NumberFormat;

/**
 * 2.3.9    独立实践
 *
 * 6、温度转换
 *
 * 编写一个应用程序，输入以摄氏为单位的温度，输出以华氏为单位的温度。
 * 输入以华氏为单位的温度，输出以摄氏为单位的温度。
 * 摄氏转化为华氏的公式为：F = (9/5)*C + 32
 * 华氏转化为摄氏的公式为：C = (F-32)*5/9
 */
public class Exercise_6 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        float fahrenheit;
        float centigrade;
        String title = "TemperatureTranslation";

        fahrenheit =
                TemperatureTranslation.toC(Float.parseFloat(showInputDialog("Fahrenheit to centigrade:" + CRLF, title)));

        showMessageDialog(
                "The Fahrenheit is :"+CRLF+fahrenheit,
                title
        );
    }

    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static class TemperatureTranslation{

        private static NumberFormat nf;

        static {
            nf = NumberFormat.getInstance();
            nf.setMaximumIntegerDigits(6);
            nf.setMaximumFractionDigits(5);
        }

        static float toC (float fahrenheit){
            fahrenheit = Float.parseFloat(nf.format(fahrenheit));
            return (fahrenheit - 32) * 5 / 9;
        }
        static float toF(float centigrade){
            centigrade = Float.parseFloat(nf.format(centigrade));
            return (9 / 5) * centigrade + 32;
        }
    }
}
