package Test;

public class test1 {
    public static void main(String[] args) {

        String input1 = " 000111 ";
        String input2 = "100100 ";
        String result = caculator(input1, input2, 0);

        System.out.println("输入1：" + input1);
        System.out.println("输入2：" + input2);
        System.out.println(result);
    }

    public static String caculator(String x, String y, int cin) {

        StringBuilder sbX;
        StringBuilder sbY;
        boolean areNegative1 = false;
        boolean areNegative2 = false;

        //转换为补码形式
        if (x.toCharArray()[0] == '1') {
            areNegative1 = true;
            sbX = new StringBuilder(toComplementCode(x));
        } else {
            sbX = new StringBuilder(x);
        }
        if (y.toCharArray()[0] == '1') {
            areNegative2 = true;
            sbY = new StringBuilder(toComplementCode(y));
        } else {
            sbY = new StringBuilder(y);
        }

        //使x与y长度相同
        while (sbX.length() > sbY.length()) {
            if(areNegative2)
                sbY.insert(0, "1");
            else
                sbY.insert(0, "0");
        }
        while (sbX.length() < sbY.length()) {
            if(areNegative1)
                sbX.insert(0, "1");
            else
                sbX.insert(0, "0");
        }



        //存入字符数组
        char a[] = sbX.toString().toCharArray();
        char b[] = sbY.toString().toCharArray();
        String sum = "";
        int s = 0;
        int cout = 0;
        String sb = "";

        //逐位求值
        int r = Math.max(a.length, b.length);
        for (int i = r - 1; i >= 0; i--) {
            //字符转为整型
            int l1 = Integer.parseInt(String.valueOf(a[i]));
            int m1 = Integer.parseInt(String.valueOf(b[i]));
            //计算公式
            s = l1 ^ m1 ^ cin;
            cout = (l1 & m1) | (l1 & cin) | (m1 & cin);
            sum = sum + s;
            cin = cout;
        }

        //求和字符串反转为正常次序
        sb = new StringBuilder(sum).reverse().toString();

        //将结果转化为原码
        if (sb.toCharArray()[0] == '1'&&(areNegative1||areNegative2)) {
            sb = toSourceCode(sb);
        }else {
            sb = '0' + sb;
        }

        return "进位输出：" + cout + "" + " " + "求和：" + sb + " " + "结果：" + sb;
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
