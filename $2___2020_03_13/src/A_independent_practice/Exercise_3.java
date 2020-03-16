package A_independent_practice;

import javax.swing.*;

/**
 * 3.4.6 独立实践
 * <p>
 * 3、二进制加法器
 * <p>
 * 定义如下方法：
 * 实现位数相同的两个二进制数相加，并将二进制数相加的结果以字符串的显示返回。
 * 并编写程序测试该方法。
 * <p>
 * public static String caculator(String x, String y)
 */
public class Exercise_3 {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String title = "Add Two Binary numbers";
        String binary1 = showInputDialog("Binary number 1 :" + CRLF, title);
        String binary2 = showInputDialog("Binary number 2 :" + CRLF, title);

        String result = addTwoBinary(binary1, binary2);

        showMessageDialog(
                "The Result is :" + CRLF + result,
                title
        );
    }


    public static String caculator(String x, String y) {
        return addTwoBinary(x, y);
    }

    /**
     * Calculate two binary number.
     *
     * @param binaryNum1
     * @param binaryNum2
     * @return A binary number but it could be negative.
     */
    private static String addTwoBinary(String binaryNum1, String binaryNum2) {
        SignBitStatus sbs;


        //judge two binary numbers ' symbol
        boolean binaryNum1_arePositive = false;
        boolean binaryNum2_arePositive = false;
        if (binaryNum1.toCharArray()[0] == '0') {
            binaryNum1_arePositive = true;
        }
        if (binaryNum2.toCharArray()[0] == '0') {
            binaryNum2_arePositive = true;
        }


        if (binaryNum1_arePositive && binaryNum2_arePositive) {
            sbs = new SignBitStatus(SignBitStatus.TWO_POSITIVE);
        } else if (binaryNum1_arePositive || binaryNum2_arePositive) {
            sbs = new SignBitStatus(SignBitStatus.ONE_POSITIVE_ONE_NEGATIVE);
        } else {
            sbs = new SignBitStatus(SignBitStatus.TWO_NEGATIVE);
        }

        //Handle according SignBitStatus
        if (sbs.getStatus() == SignBitStatus.TWO_POSITIVE) {
            String result = addTwoPositiveBinary(binaryNum1, binaryNum2);
            if (result.toCharArray()[0] == '1') {
                return new StringBuilder(result).insert(0, "0").toString();
            }
            return result;
        } else if (sbs.getStatus() == SignBitStatus.TWO_NEGATIVE) {
            //translate to complement
            String r = addTwoPositiveBinary(
                    new StringBuilder(binaryNum1).deleteCharAt(0).toString(),   //remove the symbols
                    new StringBuilder(binaryNum2).deleteCharAt(0).toString()    //remove the symbols
            );

            return new StringBuilder(r).insert(0, '1').toString();   //append the symbols

        } else if (sbs.getStatus() == SignBitStatus.ONE_POSITIVE_ONE_NEGATIVE) {


        }


        return "";

    }

    /**
     * Add two positive binary numbers
     *
     * @param binary1
     * @param binary2
     * @return A positive binary number which is no fraction part.
     */
    private static String addTwoPositiveBinary(String binary1, String binary2) {
        StringBuilder b1 = new StringBuilder(binary1);
        StringBuilder b2 = new StringBuilder(binary2);
        StringBuilder result = new StringBuilder();

        //make two binary equal lenth
        while (b1.length() > b2.length()) {
            b2.insert(0, "0");
        }
        while (b1.length() < b2.length()) {
            b1.insert(0, "0");
        }


        //come true additive function
        b1.reverse();
        b2.reverse();
        int currentIndex = 0;
        StringBuilder toAppend = new StringBuilder();
        boolean carryFlag = false;
        char[] string1 = b1.toString().toCharArray();
        char[] string2 = b2.toString().toCharArray();

        while (currentIndex < string1.length) {
            if (string1[currentIndex] == '1' && string2[currentIndex] == '1') {
                if (carryFlag) {
                    toAppend.append("1");
                } else {
                    toAppend.append("0");
                }

                carryFlag = true;

            } else if (string1[currentIndex] == '1' || string2[currentIndex] == '1') {
                if (carryFlag) {
                    toAppend.append("0");
                    carryFlag = true;
                } else {
                    toAppend.append("1");
                    carryFlag = false;
                }

            } else if (string1[currentIndex] == '0' && string2[currentIndex] == '0') {
                if (carryFlag) {
                    toAppend.append("1");
                } else {
                    toAppend.append("0");
                }

                carryFlag = false;
            }


            currentIndex++;
        }

        toAppend.reverse();
        return toAppend.toString();


    }

    private static String toComplementCode(String sourceCode) {
        char[] string = sourceCode.toCharArray();
        int currentIndex = 1;   //Begin from index_1
        boolean carryFlag = true;

        //Convert to opposite
        while (currentIndex < string.length) {
            if (string[currentIndex] == '0') {
                string[currentIndex] = '1';
            } else {
                string[currentIndex] = '0';
            }

            currentIndex++;
        }

        //Add 1
        currentIndex = string.length - 1;
        while (currentIndex > 0) {
            if (string[currentIndex] == '1') {
                if (carryFlag) {
                    string[currentIndex] = '0';
                    carryFlag = true;
                }

            } else {
                if (carryFlag) {
                    string[currentIndex] = '1';
                }
                carryFlag = false;
            }

            currentIndex--;
        }

        return new String(string);
    }

    private static String toSourceCode(String complementCode) {
        char[] string = complementCode.toCharArray();
        int currentIndex = 1;   //Begin from index_1
        boolean borrowFlag = true;

        //Sub 1
        currentIndex = string.length - 1;
        while (currentIndex > 0 && borrowFlag) {
            if (string[currentIndex] == '1') {
                string[currentIndex] = '0';
                borrowFlag = false;
            } else {
                string[currentIndex] = '1';
            }

            currentIndex--;
        }

        //Convert to opposite
        currentIndex = 1;
        while (currentIndex < string.length) {
            if (string[currentIndex] == '0') {
                string[currentIndex] = '1';
            } else {
                string[currentIndex] = '0';
            }

            currentIndex++;
        }


        return new String(string);
    }


    /**
     * Describe two binary numbers
     */
    static class SignBitStatus {
        public static final int TWO_POSITIVE = 0;
        public static final int ONE_POSITIVE_ONE_NEGATIVE = 1;
        public static final int TWO_NEGATIVE = 2;

        private int status;

        public SignBitStatus(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }


    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

}
