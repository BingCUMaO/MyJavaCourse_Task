package B_project_training;

/**
 * 3,6 项目实战
 * <p>
 * 4、二进制加法器
 * <p>
 * 采用面向对象的思维方法编写程序实现两个二进制数相加，并编写程序测试
 */
public class Exercise_4 {
    public static void main(String[] args) {
        String input1 = "0111";
        String input2 = "100100";

        String result = Calculator.caculator(input1, input2);
        System.out.println(result);

    }


    static class Calculator{
        public static String caculator(String x, String y) {
            StringBuilder cCode1;      //Complement Code 1
            StringBuilder cCode2;      //Complement Code 2
            String result;
            boolean areNegative1 = false;
            boolean areNegative2 = false;

            //to complement code
            if (x.toCharArray()[0] == '1') {
                areNegative1 = true;
                cCode1 = new StringBuilder(toComplementCode(x));
            } else {
                cCode1 = new StringBuilder(x);
            }
            if (y.toCharArray()[0] == '1') {
                areNegative2 = true;
                cCode2 = new StringBuilder(toComplementCode(y));
            } else {
                cCode2 = new StringBuilder(y);
            }

            //make two binary equal lenth
            while (cCode1.length() > cCode2.length()) {
                if(areNegative2)
                    cCode2.insert(0, "1");
                else
                    cCode2.insert(0, "0");
            }
            while (cCode1.length() < cCode2.length()) {
                if(areNegative1)
                    cCode1.insert(0, "1");
                else
                    cCode1.insert(0, "0");
            }

            //calculate....
            result = addTwoBinaries(cCode1.toString(), cCode2.toString());

            //to source code
            if (result.toCharArray()[0] == '1'&&(areNegative1||areNegative2)) {
                result = toSourceCode(result);
            }else {
                result = '0' + result;
            }

            return result;
        }

        private static String addTwoBinaries(String binary1, String binary2) {
            char[] b1 = binary1.toCharArray();
            char[] b2 = binary2.toCharArray();
            int len = binary1.length();
            StringBuilder result_byXOR = new StringBuilder();
            StringBuilder result_byCarryBit = new StringBuilder();

            if(!binary2.contains("1")){
                return binary1;
            }



            for(int i = 0;i<len;i++){
                //calculate XOR
                //binary1 ^ binary2
                if(b1[i]!=b2[i]){
                    result_byXOR.append('1');
                }else{
                    result_byXOR.append('0');
                }

                //calculate carry bit
                //(binary1 & binary2)<<1
                if(b1[i]=='1'&&b2[i]=='1'){
                    result_byCarryBit.append('1');
                }else {
                    result_byCarryBit.append('0');
                }
            }


            //keep same length of carryBit
            result_byCarryBit.append('0');
            result_byCarryBit.deleteCharAt(0);





            //Recursion
            return addTwoBinaries(result_byXOR.toString(), result_byCarryBit.toString());

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
    }
}




