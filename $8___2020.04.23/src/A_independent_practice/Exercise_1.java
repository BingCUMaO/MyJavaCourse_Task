package A_independent_practice;


/**
 * 7.5.5 独立实践
 *
 * 1、时间类（版本1）
 *
 * 创建时间Time类，包含3个整型属性： Hour、 Minute、 Second，
 * 它们用于表示采取统一时间格式(24小时制)的一个时间。
 *
 * 并定义一个不含参数的toUniversalString方法，该方法采用统一
 * 的时间格式返回一个字符串，它包括6个数位——两个用于表示
 * 小时,两个表示分钟，其余两个表示秒。
 *
 * 创建Time类的两个实例，编译和测试Time类。
 *
 */
public class Exercise_1 {
    public static void main(String[] args) {
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

        public Time() {
            this(0, 0, 0);
        }

        public Time(int hour, int minute, int second) {
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

        public void setHour(int hour) {
            if(hour>=0&&hour<24)
                this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            if(minute>=0&&minute<60)
                this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            if(second>=0&&second<60)
                this.second = second;
        }
    }

}


