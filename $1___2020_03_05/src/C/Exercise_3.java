package C;

import javax.swing.*;

/**
 * 任务3：工资发放（版本1）
 *
 * 某公司销售员的工资包括基本工资和销售提成。销售提成根据表给出的方式计算。
 *======================================
 *          销售额（元）          |           提成
 *-----------------------------------------------------------------------------
 *  30.00~299.99                  |     销售额的5%
 *  300.00~999.99                |      销售额的10%
 *  >=1000.00                       |       销售额的15%
 *  ======================================
 *
 *编写一应用程序，输入销售员编号、基本工资和销售额，计算工资额，并输出工资单。
 *
 */
public class Exercise_3 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Payment Of Wages";

        String id = showInputDialog("Emplyee ID :" + CRLF, title);
        double basicSalary = Double.parseDouble(showInputDialog("Basic salary" + CRLF, title));
        double sale = Double.parseDouble(showInputDialog("Sales Amount :" + CRLF, title));
        double salary = calcSalary(basicSalary, sale);

        Emplyee emplyee = new Emplyee(id, salary);
        showMessageDialog(
                "The Emplyee 's ID :" + CRLF + emplyee.getId() + CRLF +
                        "Salary :" + CRLF + salary,
                title
        );
    }

    static double calcSalary(double basicSalary, double salesAmount){
        double salary = basicSalary;
        if(salesAmount>=30&&salesAmount<=299.99){
            salary *= (1 + 0.05);
        }else if(salesAmount>=300&&salesAmount<=999.99){
            salary *= (1 + 0.1);
        }else if(salesAmount>=1000){
            salary *= (1 + 0.15);
        }

        return salary;
    }

    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }


    static  class Emplyee{
        private String id ;
        private double salary;

        Emplyee(String id, double salary) {
            this.id = id;
            this.salary = salary;
        }

        public String getId() {
            return id;
        }

        public double getSalary() {
            return salary;
        }
    }
}
