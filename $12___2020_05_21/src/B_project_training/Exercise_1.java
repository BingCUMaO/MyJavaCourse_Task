package B_project_training;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 8.8 项目实践
 *
 * 完成Bradshaw项目中的一下各项任务。
 *
 * （1）Bradshaw项目需要储存所有船只的信息，包括注册号、长度、制造商和
 * 生产年份。创建一个Boat类，储存船只的信息，声明一个方法PrintBoatInfo，
 * 该方法将所以属性的值格式转化为一个字符串并将该字符串返回。创建Boat类
 * 的两个实例，测试Boat类。
 *
 */
public class Exercise_1 {
    private static class Test{
        public static void main(String[] args) {
            Boat b1 = new Boat(10, "Sun");
            Boat b2 = new Boat(20, "Apache", 2000, 3, 5);

            System.out.println("[DEBUG]==>" + b1.printBoatInfo());
            System.out.println("[DEBUG]==>" + b2.printBoatInfo());
        }
    }

    private static class Boat{
        //序列号
        private String serialKey;
        //船体长度
        private int lengthOfBody;
        //制造商
        private String manufacturer;
        //生产日期
        private LocalDate producedDate;

        {
            serialKey = createSerialKey();
        }

        public Boat() {
        }

        public Boat(int lengthOfBody, String manufacturer) {
            this(lengthOfBody, manufacturer, LocalDate.now());
        }

        public Boat(int lengthOfBody, String manufacturer, int year, int month, int day) {
            this.lengthOfBody = lengthOfBody;
            this.manufacturer = manufacturer;
            setProducedDate(year, month, day);
        }

        public Boat(int lengthOfBody, String manufacturer, LocalDate producedDate) {
            this.lengthOfBody = lengthOfBody;
            this.manufacturer = manufacturer;
            this.producedDate = producedDate;
        }

        /**
         * 获取随机序列号
         * @return serial key
         */
        private static String createSerialKey(){
            return UUID.randomUUID().toString();
        }

        public String printBoatInfo(){
            return "Boat{" +
                    "serialKey='" + serialKey + '\'' +
                    ", lengthOfBody=" + lengthOfBody +
                    ", manufacturer='" + manufacturer + '\'' +
                    ", producedDate=" + producedDate +
                    '}';
        }

        public String getSerialKey() {
            return serialKey;
        }

        public void setSerialKey(String serialKey) {
            this.serialKey = serialKey;
        }

        public int getLengthOfBody() {
            return lengthOfBody;
        }

        public void setLengthOfBody(int lengthOfBody) {
            this.lengthOfBody = lengthOfBody;
        }

        public String getManufacturer() {
            return manufacturer;
        }

        public void setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
        }

        public LocalDate getProducedDate() {
            return producedDate;
        }

        public void setProducedDate(int year, int month, int day) {
            this.setProducedDate(LocalDate.of(year, month, day));
        }

        public void setProducedDate(LocalDate producedDate) {
            this.producedDate = producedDate;
        }
    }
}
