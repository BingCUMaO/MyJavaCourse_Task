package A_independent_practice_Revision;

import javax.swing.*;

/**
 * 3.4.6 独立实践
 * <p>
 * 2、判断回文（2）
 * <p>
 * 编写程序，检查一个字符串是否是回文，不计非字母和非数值字符。
 */
public class Exercise_2 {
    public static void main(String[] args) {
        String title = "Judge Palindromic String ";
        String s = showInputDialog("String:", title);
        boolean arePS = arePalindromicString_Filter(s);
        showMessageDialog("Result :"+arePS, title);

    }

    private static boolean arePalindromicString_Filter(String string){
        char[] elements = string.toCharArray();
        StringBuilder filtering = new StringBuilder();
        for(char element : elements){
            if(  (element>=48&&element<=57)||(element>=65&&element<=90)||(element>=97&&element<=122 ) ){
                filtering.append(element);
            }
        }

//        无法过滤中文字符
//        for(char element : elements){
//            if(Character.isLetterOrDigit(element))
//                filtering.append(element);
//        }

        System.out.println(filtering);

        return arePalindromicString(filtering.toString());
    }

    private static boolean arePalindromicString(String string) {
        boolean areEvenNumberOfLength = false;
//        char[] reverseStr = new StringBuilder(string).reverse().toString().toCharArray();
        char[] sourceStr = string.toCharArray();
        int halfLength = string.length() / 2;
        int sourceLength = string.length();
        char[] halfString = string.substring(0, halfLength).toCharArray();

        if (string.length() % 2 == 0) {
            areEvenNumberOfLength = true;
        }

//        for (int i = 0; i < halfLength; i++)
//            if (halfString[i] != reverseStr[i])
//                return false;
        for(int i = 0;i<halfLength;i++){
            if(halfString[i]!=sourceStr[sourceLength-i-1])
                return false;
        }


        return true;
    }


    static String showInputDialog(String message,String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message,String title){
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

}
