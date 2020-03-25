package C;

import javax.swing.*;

/**
 * 任务1：计时工人工资计算
 * <p>
 * 某公司有各类雇员，如销售员、计时工人。计时工人的薪水计算方法如下：
 * 薪水=计时工资+加班费
 * （每小时工资*工作小时数+加班小时*1.5*每小时报酬）
 * 【每周超过40小时，就算加班】
 * <p>
 * 编写程序，输入计时工人的编号，每小时工资和工作小时数，计算计时工人的薪水，
 * 并输出工资单。
 */
public class Exercise_1 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Calculate Salary";
        String id = showInputDialog("Emplyee 's ID :" + CRLF, title);

        int hourlyWage = Integer.parseInt(showInputDialog("Hourly wage :" + CRLF, title));
        int hours = Integer.parseInt(showInputDialog("Working hours :" + CRLF, title));

        double salary = calcSalary(hours, hourlyWage);
        Emplyee emplyee = new Emplyee(id, salary);


        showMessageDialog(
                "The Emplyee 's ID:" + CRLF + emplyee.getId() + CRLF +
                        "The salary is :" + CRLF + emplyee.getSalary(),
                title
        );
    }

    static double calcSalary(int hours, int hourlyWage) {
        int overtime = 0;
        if (hours > 40) {
            overtime = hours - 40;
            hours = 40;
        }

        return hourlyWage * hours + overtime * 1.5 * hourlyWage;
    }

    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }




    static class Emplyee {
        private String id;
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

        public void setId(String id) {
            this.id = id;
        }

        public void setSalary(double salary) {
            if (salary > 0)
                this.salary = salary;
        }
    }
}
