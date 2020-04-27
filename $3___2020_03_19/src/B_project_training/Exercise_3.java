package B_project_training;

/**
 * 3,6 项目实战
 * <p>
 * 3、判断回文
 * <p>
 * 采用面向对象的思维方法编写程序，检查一个字符串是否是回文。
 */
public class Exercise_3 {
    public static void main(String[] args) {
        String str = "ABCCBA";
        boolean arePString = Judge.arePalindromicString(str);

        System.out.println(arePString);
    }

    static class Judge{
        public static boolean arePalindromicString(String string) {
            boolean areEvenNumberOfLength = false;
            char[] sourceStr = string.toCharArray();
            int halfLength = string.length() / 2;
            int sourceLength = string.length();
            char[] halfString = string.substring(0, halfLength).toCharArray();

            if (string.length() % 2 == 0) {
                areEvenNumberOfLength = true;
            }

            for(int i = 0;i<halfLength;i++){
                if(halfString[i]!=sourceStr[sourceLength-i-1])
                    return false;
            }

            return true;
        }
    }

}




