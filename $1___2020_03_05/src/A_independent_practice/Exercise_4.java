package A_independent_practice;

import javax.swing.*;
import java.text.NumberFormat;

/**
 * 2.3.9    独立实践
 *
 * 4、计算BMI
 *
 * 称为“身体质量指数”（BMI）的量用来计算与体重有关的健康
 * 问题的危险程度。
 * BMI按下面的公式计算：BMI=w/h^2。
 *
 * 其中w是以千克为单位的体重。
 * h是以米为单位的身高。
 *
 * 20至25的BMI的值认为是“正常的”。
 * 编写一个应用程序，输入体重和身高并输出BMI。
 */
public class Exercise_4 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Calculate BMI";
        double weight = Double.parseDouble(showInputDialog("Weight:" + CRLF, title));
        double height = Double.parseDouble(showInputDialog("Height:" + CRLF, title));

        //Format BMI
        double bmi = calcBMI(weight, height);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumIntegerDigits(6);
        nf.setMaximumFractionDigits(3);
        bmi = Double.parseDouble(nf.format(bmi));


        showMessageDialog(
                "The BMI is :"+CRLF+ bmi,
                title
        );

    }

    static double calcBMI(double weight,double height){
        return weight / (height * height);
    }

    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}
