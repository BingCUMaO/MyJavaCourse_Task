package B_independent_practice;

import A_independent_practice.Exercise_2;

/**
 * 7.6.3 独立实践
 *
 * 时间类(版本3)
 *
 * 继续7.5.5小节独立实践中的“2.时间类(版本2)”，
 * 重载构造函数：定义一个构造函数，使它含有
 * 两个整型参数，用来设置小时和分钟，秒数被
 * 设置为0。定义一个无参构造函数，在该构造函
 * 数中，调用同类的构造函数，将小时设置为12，
 * 将分钟设置为0，将秒数设置为0。
 *
 * 编写程序使用定义的构造函数测试时间类。
 *
 */
public class Exercise {
    public static void main(String[] args) throws Exception {
        Time timer1 = new Time();
        Time timer2 = new Time(23, 55);
        System.out.println(timer1.toUniversalString());
        System.out.println(timer2.toUniversalString());
    }

    //24小时制
    private static class Time{
        private int hour;
        private int minute;
        private int second;

        public Time() throws Exception {
            this(12, 0, 0);
        }

        public Time(int hour, int minute) throws Exception {
            this(hour, minute, 0);
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
