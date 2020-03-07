package A_independent_practice;

import javax.swing.*;


/**
 * 2.3.9    独立实践
 *
 * 3、字母大小写转换
 *
 * 编写一程序，输入的字母中小写字母转换为大写字母
 * （提示，大小写字母对应的整数相差32）
 */
public class Exercise_3 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "To Case";

        String result1 = ToCase.toLowerCase(showInputDialog("To Lower Case:", title));
        String result2 = ToCase.toUpperCase(showInputDialog("To Upper Case:", title));

        showMessageDialog(
                "After Converting to Lower letters:"+CRLF +result1,
                title
        );
        showMessageDialog(
                "After Converting to Upper letters:"+CRLF +result2,
                title
        );
    }

    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static class ToCase{
        public static String  toLowerCase(String string){
            char[] s = string.toCharArray();
            int len = s.length;
            for(int index = 0;index<len;index++){
                if(s[index]>=65&&s[index]<=90){
                    s[index] += 32;
                }
            }

            return new String(s);
        }

        public static String  toUpperCase(String string){
            char[] s = string.toCharArray();
            int len = s.length;
            for(int index = 0;index<len;index++){
                if(s[index]>=97&&s[index]<=122){
                    s[index] -= 32;
                }
            }

            return new String(s);
        }


    }


}
