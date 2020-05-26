package B_project_training;

import java.time.LocalDate;
import java.util.UUID;

/**
 * 8.8 项目实践
 *
 *  （3）继续项目任务2，分别为Boat类、Sailboat类和Powerboat类定义构造函数，
 *  在子类的构造函数中显示调用父类构造函数。并修改子类的方法，在子类方法中
 *  调用父类方法。
 *  编写程序测试修改的类。
 */
public class Exercise_3 {
    private static class Test{
        public static void main(String[] args) {
            Sailboat apacheBoat = new Sailboat(20, "Apache", 2000, 3, 5);
            apacheBoat.setKeelDepth(6);
            apacheBoat.setSailID("XXX01");
            apacheBoat.setMotorType(Sailboat.INBOARD);

            Powerboat oracleBoat = new Powerboat(6, "Oracle");
            oracleBoat.setNumberEngines(3);
            oracleBoat.setFuelType(Powerboat.DIESEL);

            System.out.println("[DEBUG]==>" + "Apache Sailboat：");
            System.out.println(apacheBoat.printSailboatInfo());
            System.out.println();
            System.out.println("[DEBUG]==>" + "Oracle Powerboat：");
            System.out.println(oracleBoat.printPowerboatInfo());
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

        public String printSailboatInfo() {
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

        public String printPowerboatInfo() {
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
