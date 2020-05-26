package B_project_training;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 8.8 项目实践
 *
 * （5）为名为Rowboat（划艇）的Boat编写一个Boat的子类。某些特定的属性可能
 * 使用与划艇，特别是材料的类型（wood、fiberglass或inflatable）和桨的类型
 * （paddles、wood oars或metal oars），创建一个Rowboat类，重写方法toString。
 * 编写程序测试创建的类
 */
public class Exercise_5 {
    private static class Test{
        public static void main(String[] args) {
            Boat netscapeBoat = new Rowboat(10, "Netscape");
            System.out.println(netscapeBoat);
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

    private static class Rowboat extends Boat{
        private static final short  WOOD = 0;
        private static final short  FIBERGLASS = 1;
        private static final short  INFLATABLE = 2;

        private static final short PADDLES = 10;
        private static final short WOOD_OARS = 11;
        private static final short METAL_OARS = 12;

        private short materalType;
        private short oarsType;

        {
            oarsType = 10;
        }

        public Rowboat() {
        }

        public Rowboat(int lengthOfBody, String manufacturer) {
            super(lengthOfBody, manufacturer);
        }

        public Rowboat(int lengthOfBody, String manufacturer, int year, int month, int day) {
            super(lengthOfBody, manufacturer, year, month, day);
        }

        public Rowboat(int lengthOfBody, String manufacturer, LocalDate producedDate) {
            super(lengthOfBody, manufacturer, producedDate);
        }

        @Override
        public String toString() {
            return "Rowboat{" +
                    "serialKey='" + getSerialKey() + '\'' +
                    ", lengthOfBody=" + getLengthOfBody() +
                    ", manufacturer='" + getManufacturer() + '\'' +
                    ", producedDate=" + getProducedDate() +
                    ", materalType=" + materalType +
                    ", oarsType=" + oarsType +
                    '}';
        }
    }
}
