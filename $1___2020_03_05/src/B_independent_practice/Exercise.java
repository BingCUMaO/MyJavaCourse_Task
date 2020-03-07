package B_independent_practice;

import javax.swing.*;

/**
 * 2.3.9    独立实践
 *
 * 计算多项式的值
 *
 * 编写程序计算当x为12和x为8时，如下多项式的值（并将结果输出）
 * x^2 + 3x +8
 */
public class Exercise {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Calculate Expression";

        double result1 = calcExpression(12);
        showMessageDialog(
                "When x is 12, the result is :"+CRLF+result1,
                title
        );

        double result2 = calcExpression(8);
        showMessageDialog(
                "When x is 8, the result is :"+CRLF+result2,
                title
        );
    }

    static double calcExpression(double x){
        return x * x + 3 * x + 8;
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}
