package D_independent_practice;

import javax.swing.*;

/**
 *1.6.2 独立实践
 *
 * 打印邮寄地址
 *
 * （1）编写一个程序，用于打印一下格式的邮寄地址。
 *          第一行：姓名
 *          第二行：街道，门牌号
 *          第三行：城市名，邮政编码
 * （2）修改上面的程序，使其为邮寄地址添上边框。
 */
public class Exercise {
    private static final String CRLF = "\r\n";
    private static final String TAB = "\t";
    private static String title = "Print Mailing Address";

    public static void main(String[] args) {
        String name = showInputDialog("Name :" + CRLF, title);
        String address = showInputDialog("Address :" + CRLF, title);
        String city = showInputDialog("City :" + CRLF, title);
        String postalCode = showInputDialog("Postal Code :" + CRLF, title);
        String decorativeOperator = showInputDialog("Decorative Operator :" + CRLF, title);

//        printMailingAddress(name, address, city, postalCode);
        printAndDecorateMailingAddress(name, address, city, postalCode, decorativeOperator);
    }

    static void printMailingAddress(String name,String address,String city,String postalCode){
        String message = "Name: " + TAB + name + CRLF +
                "Address: " + TAB + address + CRLF +
                "City:" + TAB + city + CRLF +
                "Postal Code:" + TAB + postalCode + CRLF;
        showMessageDialog(message, title);
    }

    static void printAndDecorateMailingAddress(String name,String address,String city,String postalCode,String decorativeOperator){
        StringBuilder head = new StringBuilder();
        StringBuilder foot = new StringBuilder();


        for(int i = 0;i<30;i++){
            head.append(decorativeOperator);
            foot.append(decorativeOperator);
        }
        head.append(CRLF);

        String message = head+
                "Name: " + TAB + name + CRLF +
                "Address: " + TAB + address + CRLF +
                "City:" + TAB + city + CRLF +
                "Postal Code:" + TAB + postalCode + CRLF+
                foot;
        showMessageDialog(message, title);
    }


    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }


}
