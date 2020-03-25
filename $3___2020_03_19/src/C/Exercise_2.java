package C;

import javax.swing.*;

/**
 * 任务2：显示时间（版本1）
 *
 * 编写一应用程序，运行程序后，分别在三个输入对话框中输入小时数、分钟
 * 数以及秒数，在消息框中安标准时间格式（hh：mm：ss  PM/AM）显示所
 * 设置的时间。
 */
public class Exercise_2 {
    private static final String CRLF = "\r\n";
    private static final String BLANK = " ";

    public static void main(String[] args) {
        String title = "Display Standard Time Format";
        int hour = Integer.parseInt(showInputDialog("Hour:" + CRLF, title));
        int minute = Integer.parseInt(showInputDialog("Minute:" + CRLF, title));
        int second = Integer.parseInt(showInputDialog("Second:" + CRLF, title));

        String standardTime = Timer.getStandardTimeFormat(hour, minute, second);
        showMessageDialog(
                "Standard Time :" + CRLF + standardTime,
                title
        );
    }

    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }



    static class Timer{
        static String getStandardTimeFormat(int hour, int minute, int second) {
            boolean areAM = true;

            if (hour < 0 || hour >= 24 ||
                    minute < 0 || minute >= 60 ||
                    second < 0 || second >= 60
            ) {
                return "";
            }

            if (hour >= 12) {
                areAM = false;
                hour -= 12;
            }

            StringBuilder time = new StringBuilder(hour + ": " + second + ": " + second + BLANK);
            if (areAM) {
                time.append("AM");
            } else {
                time.append("PM");
            }

            return time.toString();
        }
    }
}
