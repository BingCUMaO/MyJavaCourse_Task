package A_independent_practice;

import javax.swing.*;
import java.text.NumberFormat;

/**
 * 2.3.9    独立实践
 *
 * 5、复利贷款
 *
 * 将P源存入银行，年利率为r，n年后的总额为P(1+r)^n ，
 * 写一个程序，输入本金P和利率r，计算10年后的存款总额。
 */
public class Exercise_5 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Compound Interest Loans";
        double capital = Double.parseDouble(showInputDialog("Capital:" + CRLF, title));
        double rate = Double.parseDouble(showInputDialog("rate:" + CRLF, title));

        //Format totalDepositj
        double totalDeposit = calcTotalDeposit(capital, rate, 10);
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(3);
        StringBuilder format = new StringBuilder(nf.format(totalDeposit));
        //这里有坑，format转化后，Integer部分会产生","
        while (format.indexOf(",")>0){
            format.deleteCharAt(format.indexOf(","));
        }
        totalDeposit = Double.parseDouble(format.toString());

        showMessageDialog(
                "After ten years, the compound interest loans is :"+CRLF+totalDeposit,
                title
        );

    }

    static double calcTotalDeposit(double capital,double rate,int year){
        return capital * ((1 + rate) * year);
    }

    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }
}
