package A_independent_practice;

import javax.swing.*;

/**
 * 4.9.2 独立实践
 *
 * 2、打印字母表及对应的ASCII码
 *
 * 写一应用程序，打印A~Z，每行5个字符，到Z时结束。
 *
 */
public class Exercise_2 {

    public static void main(String[] args) {
        String str = ASCII.regularize(ASCII.getASCIIs('A', 'Z'), 5);
        JOptionPane.showMessageDialog(
                null,
                str,
                "消息",
                JOptionPane.PLAIN_MESSAGE
        );
    }

    static class ASCII{
        private static final String CRLF = "\r\n";
        private static final String TAB = "    ";

        public ASCII() {
        }

        public static String regularize(String str, int row) {
            String[] strArray = str.split(TAB);
            StringBuilder result = new StringBuilder();

            for(int tick = 0;tick<strArray.length;tick += row){
                for(int indexOfArray = tick; indexOfArray< tick+row&&indexOfArray<strArray.length; indexOfArray++){
                    result.append(strArray[indexOfArray]+TAB);
                }
                result.append(CRLF);
            }

            return result.toString();
        }

        public static String getASCIIs(int head, int end){
            if(head>end) return "";

            StringBuilder sb = new StringBuilder();

            for(int tick = head;tick<=end;tick++){
                sb.append(tick+'='+(char)tick+TAB);
            }

            return sb.toString();
        }

        public static String getASCIIs(char head, char end){
            if(head>end) return "";

            StringBuilder sb = new StringBuilder();

            for(int tick = (int)head;tick<=(int)end;tick++){
                sb.append((int)tick+"="+(char)tick+TAB);
            }

            return sb.toString();
        }
    }
}


