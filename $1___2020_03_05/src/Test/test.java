package Test;

import javax.swing.*;

/**
 * 独立实践
 * <p>
 * 编写程序输入两个位数相同的两个二进制数，求这两个二进制数的和并输出。
 */
public class test {
    private static final String CRLF = "\r\n";

    public static void main(String[] args) {
        String result = addTwoBinary("01110001", "11100000");
        System.out.println(result);



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
            if(result.toCharArray()[0]=='1'){
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
            StringBuilder negativeBinary = new StringBuilder(
                    binaryNum1.toCharArray()[0] == '1' ? binaryNum1 : binaryNum2
            );
            StringBuilder positiveBinary = new StringBuilder(
                    binaryNum2.toCharArray()[0] == '0' ? binaryNum2 : binaryNum1
            );

            //to complement code
            negativeBinary = new StringBuilder(toComplementCode(negativeBinary.toString()));

            //change the symbol of negativeBinary to '0'
            positiveBinary.replace(0, 1, "0");

            //make two binary equal lenth
            while (negativeBinary.length() > positiveBinary.length()) {
                positiveBinary.insert(0, "0");
            }
            while (negativeBinary.length() < positiveBinary.length()) {
                negativeBinary.insert(0, "1");
            }



            //to be calculation between two positive binary numbers
            String result =
                    addTwoPositiveBinary(positiveBinary.toString(), negativeBinary.toString());

//            if (result.toCharArray()[0] == '1') {
//                result = new StringBuilder(result).replace(0, 0, "0").toString();
//                return result;
//            } else {
//                //return source code
//                return toSourceCode(result);
//            }

            return toSourceCode(result);

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


    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
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


}


/**
 * 算法：
 * 1、判断两数符号，标记符号位boolean
 * <①>if（两数为负，删除两数符号位）
 * <③> if（一正一负，转化为补码）
 * 2、使两数位数相等
 * <p>
 * <②>
 * 一、if两数为正
 * 1、直接相加
 * 2、先判断符号位boolean
 * if(两数为正){
 * 判断result符号位，若为"1"则在首位添"0"。
 * }
 * if(两数为负){
 * 直接在首部添"1"。
 * }
 * <p>
 * 二、if两数为负
 * 1、<①>
 * 2、<②>
 * <p>
 * 三、一正一负
 * 1、<③>
 * 2、补码间相加，并保持两数的位数始终不变
 * 3、补码形式to原码
 */



