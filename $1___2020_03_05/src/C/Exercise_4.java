package C;

import javax.swing.*;

/**
 * 任务4：计算器（版本1）
 *
 * 创建简易版计算器应用程序，用户输入两个数及运算符，求出两数的运算结果
 * 并显示输出结果。
 */
public class Exercise_4 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Simple Calculator";
        double number1 = Double.parseDouble(showInputDialog("number 1 :" + CRLF, title));
        String o = showInputDialog("operator :" + CRLF, title);
        char operator = 0;
        if(1==o.length()){
            operator = o.charAt(0);
        }
        double number2 = Double.parseDouble(showInputDialog("number 2 :" + CRLF, title));

        double result = calc(number1, number2, operator);
        showMessageDialog(
                "The Result :" + CRLF + result,
                title
        );

    }

    static double calc(double value1,double value2,char operator){
        switch (operator){
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                return value1 / value2;
        }

        return 0;
    }


    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

}
