package B_project_training;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 6.10 项目实战
 *
 * 5、字符数字到数字整数的装换
 *
 * 在Convert类中，定义如下方法：
 *
 * //将数字字符digitChar转换为整数数字（例如，'6'转换为6）
 * public static int charToDigit(char digitChar)
 * //将单个整数数字digitChar转换为数字字符（例如，6转换为'6'）
 * public static char digitToChar(int digit)
 * //将整数数字字符串转化为十进制整数
 * public static int parseInt(String digitString)
 *
 * 编写一个测试程序，测试这些方法。
 *
 */
public class Exercise_2 {
    public static void main(String[] args) {
        System.out.println(Convert.charToDigit('6'));
        System.out.println(Convert.digitToChar(6));

        System.out.println(Convert.parseInt("666"));

    }

    private static class Convert{
        public Convert() {
        }

        public static int charToDigit(char digitChar) {
            if (digitChar >= '0' && digitChar <= '9') {
                return digitChar - '0';
            }else {
                throw new NumberFormatException();
            }
        }

        public static char digitToChar(int digit) {
            if (digit >= 0 && digit <= 9) {
                return (char) (digit + '0');
            }else {
                throw new NumberFormatException();
            }
        }

        public static int parseInt(String digitString) {
            String regexNumer = "^\\d+$";
            Pattern numberPatten = Pattern.compile(regexNumer);

            Matcher numberMatcher = numberPatten.matcher(digitString);

            if (numberMatcher.matches()) {
                int total = 0;
                int posit = 1;
                for (int i = digitString.length()-1; i>=0; i--) {
                    total += (digitString.charAt(i) - '0') * posit;
                    posit *= 10;
                }
                return total;
            } else {
                throw new NumberFormatException();
            }
        }

    }
}


