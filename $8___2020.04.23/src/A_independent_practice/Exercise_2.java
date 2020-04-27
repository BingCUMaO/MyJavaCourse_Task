package A_independent_practice;


import javax.naming.TimeLimitExceededException;

/**
 * 7.5.5 独立实践
 *
 * 2、时间类（版本2）
 *
 * 继续独立实践：时间类(版本1)，定义一个构造函数，
 * 它含有3个整型参数myhour、myminute、 mysecond,
 * 并用它们来设置时间。属性Hour、Minute、Second的
 * 定义应包括数据检查，如果数据不合理，应给出提示
 * 信息，并将属性的值设置为0。使用定义的构造函数创
 * 建Time类的两个实例，编译和测试Time类。
 *
 */
public class Exercise_2 {
    public static void main(String[] args) throws Exception {
        Time timer1 = new Time(5, 3, 6);
        Time timer2 = new Time(24, 60, 60);
        System.out.println(timer1.toUniversalString());
        System.out.println(timer2.toUniversalString());
    }

    //24小时制
    private static class Time{
       private int hour;
       private int minute;
       private int second;

        public Time() throws Exception {
            this(0, 0, 0);
        }

        public Time(int hour, int minute, int second) throws Exception {
            setHour(hour);
            setMinute(minute);
            setSecond(second);
        }

        public String toUniversalString(){
            String h = String.valueOf(hour);
            h = h.length() == 1 ? '0' + h : h;
            String m = String.valueOf(minute);
            m = m.length() == 1 ? '0' + m : m;
            String s = String.valueOf(second);
            s = s.length() == 1 ? '0' + s : s;

            return h + m + s;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) throws Exception {
            if (hour >= 0 && hour < 24) {
                this.hour = hour;
                return;
            } else {
                throw new Exception("TimeFormatLimitExceeded");
            }
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) throws Exception {
            if (minute >= 0 && minute < 60) {
                this.minute = minute;
                return;
            } else {
                throw new Exception("TimeFormatLimitExceeded");
            }
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) throws Exception {
            if (second >= 0 && second < 60) {
                this.second = second;
                return;
            } else {
                throw new Exception("TimeFormatLimitExceeded");
            }
        }
    }

}


