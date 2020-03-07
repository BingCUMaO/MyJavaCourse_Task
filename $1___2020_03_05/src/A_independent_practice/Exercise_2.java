package A_independent_practice;

import javax.swing.*;

/**
 * 2.3.9    独立实践
 *
 * 2、互换变量的值
 *
 * 编写程序给变量a和b输入数据，然后互换a，b的值，最后将a，b的值输出
 */
public class Exercise_2 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String a = new String();
        String b = new String();
        String title  = "Swap two values";

        a = showInputDialog("Value of A:" + CRLF, title);
        b = showInputDialog("Value of B:" + CRLF, title);

        Swap swap = new Swap(a, b);

        showMessageDialog(
                "The value of A is :"+CRLF+swap.getValue1().toString(),
                title
        );

        showMessageDialog(
                "The value of B is :"+CRLF+swap.getValue2().toString(),
                title
        );

    }


    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static class Swap{
        private Object value1;
        private Object value2;

        Swap(Object value1,Object value2){
            this.value2 = value1;
            this.value1 = value2;
        }

        public Object getValue1() {
            return value1;
        }

        public Object getValue2() {
            return value2;
        }
    }


}
