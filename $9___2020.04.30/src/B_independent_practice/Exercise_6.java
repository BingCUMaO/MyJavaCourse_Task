package B_independent_practice;


/**
 * 7.8.3 独立实践
 * <p>
 * 6、修改Time类，增加如下两个方法
 *
 * 以待定的时间（以小时为单位）返回此Time的副本
 * minusHours(long hoursToSubstract)
 * plusHours(long hoursToAdd)
 */
public class Exercise_6 {
    public static void main(String[] args) throws Exception{
        Time t1 = new Time(10, 30, 0);
        System.out.println(t1.toUniversalString());

        t1 = t1.plusHours(10);
        System.out.println(t1.toUniversalString());

        t1 = t1.minusHours(5);
        System.out.println(t1.toUniversalString());
    }

    //24小时制
    private static class Time{
        private long hour;
        private long minute;
        private long second;

        public Time() throws Exception {
            this(12, 0, 0);
        }

        public Time(long hour, long minute) throws Exception {
            this(hour, minute, 0);
        }

        public Time(long hour, long minute, long second) throws Exception {
            setHour(hour);
            setMinute(minute);
            setSecond(second);
        }
        
        public Time minusHours(long hoursToSubstract) throws Exception {
            if(hour- hoursToSubstract<0) throw new Exception("TimeFormatLimitExceeded");
            return new Time(hour - hoursToSubstract, this.minute, this.second);
        }

        public Time plusHours(long hoursToAdd) throws Exception {
            if(hour- hoursToAdd>=24) throw new Exception("TimeFormatLimitExceeded");
            return new Time(hour + hoursToAdd, this.minute, this.second);
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

        public long getHour() {
            return hour;
        }

        public void setHour(long hour) throws Exception {
            if (hour >= 0 && hour < 24) {
                this.hour = hour;
                return;
            } else {
                throw new Exception("TimeFormatLimitExceeded");
            }
        }

        public long getMinute() {
            return minute;
        }

        public void setMinute(long minute) throws Exception {
            if (minute >= 0 && minute < 60) {
                this.minute = minute;
                return;
            } else {
                throw new Exception("TimeFormatLimitExceeded");
            }
        }

        public long getSecond() {
            return second;
        }

        public void setSecond(long second) throws Exception {
            if (second >= 0 && second < 60) {
                this.second = second;
                return;
            } else {
                throw new Exception("TimeFormatLimitExceeded");
            }
        }
    }
}


