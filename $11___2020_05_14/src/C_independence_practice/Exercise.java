package C_independence_practice;



/**
 * 独立实践 8.4.2
 *
 * 计时工人工资计算（版本5）
 *
 * （1）修改HourlyWorker类，在Employee类中声明一个含有3个参数的构造函数，使用这3个参数初始化Employee对象3个属性的值。
 * 在HourlyWorker类中声明含有5个参数的构造函数，该构造函数显示调用基类Employee的3个参数的构造函数用3个参数指定的值初
 * 始化基类3个私有字段的值，用其他两个参数的值初始化HourlyWorker类特有字段的值。
 * 在每个类中都定义一个toString方法，该方法将该类所有属性的值格式化为一字符串，并将该字符串返回。
 *
 * （2）创建测试测序。
 */
public class Exercise {

    public static void main(String[] args) {
       Employee employee = new Employee("EP01", "张三","43415461451236414634531");
        HourlyWorker hourlyworker = new HourlyWorker("HW01", "狂人", "G13284519203814710");

        System.out.println(employee);
        System.out.println(hourlyworker);
    }






    private static class Employee {
        //雇员编号
        protected String serialNumber;
        //姓名
        protected String name;
        //身份证号码
        protected String idNumber;

        public Employee(String serialNumber, String name, String idNumber) {
            this.serialNumber = serialNumber;
            this.name = name;
            this.idNumber = idNumber;
        }

        public String getSerialNumber() {
            return serialNumber;
        }

        public void setSerialNumber(String serialNumber) {
            this.serialNumber = serialNumber;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "serialNumber='" + serialNumber + '\'' +
                    ", name='" + name + '\'' +
                    ", idNumber='" + idNumber + '\'' +
                    '}';
        }
    }




    private static class HourlyWorker extends Employee {
        //工作时长
        private double hour;
        //时薪
        private double wage;
        //工作日时长上限
        private double hourLimit;
        //加班费负载因子
        private double overtimeFactor;

        {
            overtimeFactor = 1.5;
            hourLimit = -1;
        }

        public HourlyWorker(String serialNumber, String name, String idNumber) {
            super(serialNumber, name, idNumber);
        }

        public HourlyWorker(String serialNumber, String name, String idNumber, double hour, double wage) {
            super(serialNumber, name, idNumber);
            setWagesCalculator(hour, wage);
        }

        public HourlyWorker(String serialNumber, String name, String idNumber, double hour, double wage, double hourLimit, double overtimeFactor) {
            this(serialNumber, name, idNumber, hour, wage);
            setOvertimeInfo(hourLimit, overtimeFactor);
        }

        /**
         * 设置时薪与工作时长
         *
         * @param wage 时薪
         * @param hour 工作时长（一般按小时计算）
         */
        public void setWagesCalculator(double wage, double hour) {
            this.hour = hour;
            this.wage = wage;
        }

        /**
         * 手动设置与加班费相关因素
         *
         * @param hourLimit      工作日正常工作时长上限，若超出则算为加班时间，-1表示默认没有上限
         * @param overtimeFactor 计算加班工资的负载因子，该值计时工资n倍，默认值为1.5
         */
        public void setOvertimeInfo(double hourLimit, double overtimeFactor) {
            this.hourLimit = hourLimit;
            this.overtimeFactor = overtimeFactor;
        }

        public void setOvertimeInfo(double hourLimit) {
            this.hourLimit = hourLimit;
        }

        public double getSalary() {
            return hour > hourLimit &&hourLimit>0? hourLimit * wage + overtimeFactor * (hour - hourLimit)*wage : hour * wage;
        }

        @Override
        public String toString() {
            return "HourlyWorker{" +
                    "serialNumber='" + serialNumber + '\'' +
                    ", name='" + name + '\'' +
                    ", idNumber='" + idNumber + '\'' +
                    ", hour=" + hour +
                    ", wage=" + wage +
                    ", hourLimit=" + hourLimit +
                    ", overtimeFactor=" + overtimeFactor +
                    '}';
        }
    }
}
