package A_independent_practice;

import javax.swing.*;

/**
 * 3.4.6 独立实践
 * <p>
 * 1、判断回文（1）
 * <p>
 * 编写程序，检查一个字符串是否是回文。
 */
public class Exercise_1 {
    public static void main(String[] args) {
        String title = "Judge Palindromic String ";
        String s = showInputDialog("String:", title);
        boolean arePS = arePalindromicString(s);
        showMessageDialog("Result :"+arePS, title);
    }

    private static boolean arePalindromicString(String string) {
        boolean areEvenNumberOfLength = false;
        char[] reverseStr = new StringBuilder(string).reverse().toString().toCharArray();
        int halfLength = string.length() / 2;
        char[] halfString = string.substring(0, halfLength).toCharArray();

        if (string.length() % 2 == 0) {
            areEvenNumberOfLength = true;
        }


        for (int i = 0; i < halfLength; i++)
            if (halfString[i] != reverseStr[i])
                return false;


        return true;
    }


    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

}
