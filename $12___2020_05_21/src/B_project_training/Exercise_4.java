package B_project_training;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 8.8 项目实践
 *
 * （4）继续项目任务3，在Sailboat类和Powerboat类中，将所有类输出属性值的
 * PrintXXXInfo方法的名称修改为toString，通过继承实现多态性。
 * 编写测试程序测试是否实现了多态性。
 */
public class Exercise_4 {
    private static class Test{
        public static void main(String[] args) {
            Boat boat01 = new Sailboat(10, "Amazon");
            Boat boat02 = new Powerboat(20, "Alibaba");

            System.out.println(boat01);
            System.out.println(boat02);
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

    private static class Sailboat extends Boat{
        private static final short NONE = 0;
        private static final short INBOARD = 1;
        private static final short OUTBOARD = 2;

        private double keelDepth;
        private String sailID;
        private short motorType;

        public Sailboat() {
        }

        public Sailboat(int lengthOfBody, String manufacturer) {
            super(lengthOfBody, manufacturer);
        }

        public Sailboat(int lengthOfBody, String manufacturer, int year, int month, int day) {
            super(lengthOfBody, manufacturer, year, month, day);
        }

        public Sailboat(int lengthOfBody, String manufacturer, LocalDate producedDate) {
            super(lengthOfBody, manufacturer, producedDate);
        }

        @Override
        public String toString() {
            return "Sailboat{" +
                    "serialKey='" + getSerialKey() + '\'' +
                    ", lengthOfBody=" + getLengthOfBody() +
                    ", manufacturer='" + getManufacturer() + '\'' +
                    ", producedDate=" + getProducedDate() +
                    ", keelDepth=" + keelDepth +
                    ", sailID='" + sailID + '\'' +
                    ", motorType=" + motorType +
                    '}';
        }

        @Override
        public String printBoatInfo() {
            return super.printBoatInfo();
        }

        @Override
        public String getSerialKey() {
            return super.getSerialKey();
        }

        @Override
        public void setSerialKey(String serialKey) {
            super.setSerialKey(serialKey);
        }

        @Override
        public int getLengthOfBody() {
            return super.getLengthOfBody();
        }

        @Override
        public void setLengthOfBody(int lengthOfBody) {
            super.setLengthOfBody(lengthOfBody);
        }

        @Override
        public String getManufacturer() {
            return super.getManufacturer();
        }

        @Override
        public void setManufacturer(String manufacturer) {
            super.setManufacturer(manufacturer);
        }

        @Override
        public LocalDate getProducedDate() {
            return super.getProducedDate();
        }

        @Override
        public void setProducedDate(int year, int month, int day) {
            super.setProducedDate(year, month, day);
        }

        @Override
        public void setProducedDate(LocalDate producedDate) {
            super.setProducedDate(producedDate);
        }

        public double getKeelDepth() {
            return keelDepth;
        }

        public void setKeelDepth(double keelDepth) {
            this.keelDepth = keelDepth;
        }

        public String getSailID() {
            return sailID;
        }

        public void setSailID(String sailID) {
            this.sailID = sailID;
        }

        public short getMotorType() {
            return motorType;
        }

        public void setMotorType(short motorType) {
            this.motorType = motorType;
        }

    }

    private static class Powerboat extends Boat{
        private static final short GAS = 0;
        private static final short DIESEL = 1;

        private int numberEngines;
        private short fuelType;

        public Powerboat() {
        }

        public Powerboat(int lengthOfBody, String manufacturer) {
            super(lengthOfBody, manufacturer);
        }

        public Powerboat(int lengthOfBody, String manufacturer, int year, int month, int day) {
            super(lengthOfBody, manufacturer, year, month, day);
        }

        public Powerboat(int lengthOfBody, String manufacturer, LocalDate producedDate) {
            super(lengthOfBody, manufacturer, producedDate);
        }

        @Override
        public String toString() {
            return "Powerboat{" +
                    "serialKey='" + getSerialKey() + '\'' +
                    ", lengthOfBody=" + getLengthOfBody() +
                    ", manufacturer='" + getManufacturer() + '\'' +
                    ", producedDate=" + getProducedDate() +
                    ", numberEngines=" + numberEngines +
                    ", fuelType=" + fuelType +
                    '}';
        }

        @Override
        public String printBoatInfo() {
            return super.printBoatInfo();
        }

        @Override
        public String getSerialKey() {
            return super.getSerialKey();
        }

        @Override
        public void setSerialKey(String serialKey) {
            super.setSerialKey(serialKey);
        }

        @Override
        public int getLengthOfBody() {
            return super.getLengthOfBody();
        }

        @Override
        public void setLengthOfBody(int lengthOfBody) {
            super.setLengthOfBody(lengthOfBody);
        }

        @Override
        public String getManufacturer() {
            return super.getManufacturer();
        }

        @Override
        public void setManufacturer(String manufacturer) {
            super.setManufacturer(manufacturer);
        }

        @Override
        public LocalDate getProducedDate() {
            return super.getProducedDate();
        }

        @Override
        public void setProducedDate(int year, int month, int day) {
            super.setProducedDate(year, month, day);
        }

        @Override
        public void setProducedDate(LocalDate producedDate) {
            super.setProducedDate(producedDate);
        }

        public int getNumberEngines() {
            return numberEngines;
        }

        public void setNumberEngines(int numberEngines) {
            this.numberEngines = numberEngines;
        }

        public short getFuelType() {
            return fuelType;
        }

        public void setFuelType(short fuelType) {
            this.fuelType = fuelType;
        }
    }
}
