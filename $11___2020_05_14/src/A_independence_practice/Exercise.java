package A_independence_practice;

/**
 * 8.2.3独立实践
 * <p>
 * 计时工人工资计算(版本3)
 * <p>
 * 1、
 * (1) 声明雇员类Employee, Employee类属性有:雇员编号、姓名、身份证
 * 号码。声明计时工人类Hourlyworker, Hourlyworker 类继承Employee 类。
 * 使用Hourlyworker 对象计算计时工人的工资。
 * 薪水=计时工资+加班费
 * （每小时工资*工作小时数+加班小时*1.5*每小时报酬）
 * 【每周超过40小时，就算加班】
 * <p>
 * (2)编写测试程序， 完成计时工人工资计算，输出工资单。并测试public，protected
 * 或private的区别和用法。
 */
public class Exercise {
    public static void main(String[] args) {
        HourlyWorker worker = new HourlyWorker("XX01", "zhangsan", "550232412454612456");
        System.out.println(worker.getSalary());

        worker.setWagesCalculator(50, 4);
        System.out.println(worker.getSalary());

        worker.setOvertimeInfo(2, 100);
        System.out.println(worker.getSalary());

//        worker.testPrivate;       //无法获取
        System.out.println("[DEBUG]==Test Public>>>>>"+worker.testPublic);  //对外公开且能获取
        System.out.println("[DEBUG]==Test Protected>>>>>"+worker.testProtected);   //仅对同一个包下的类与对应子类的访问公开
    }

    private static class Employee {
        private int testPrivate = 1;
        protected int testProtected = 2;
        public int testPublic = 3;

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
            return hour > hourLimit&&hourLimit>0 ? hourLimit * wage + overtimeFactor * (hour - hourLimit)*wage : hour * wage;
        }
    }
}
