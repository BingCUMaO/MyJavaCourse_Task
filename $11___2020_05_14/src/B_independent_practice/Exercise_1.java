package B_independent_practice;


/**
 * 独立实践 8.3.3
 *
 * 1、计时工人工资计算（版本4）
 *
 * （1）修改Employee类和HourlyWorker类，
 * 在Employee类中声明一个含有3个参数的构造函数，使用这3个参数初始化Employee对象3个属性的值。
 * 在HourlyWorker类中声明含有5个参数的构造函数，使用这5个参数指定的值初始化HourlyWorker对象的每个属性的值。
 * 在每个类中都定义一个toString方法，该方法将该类所有属性的值格式化为一字符串，并将该字符串返回。
 *
 * （2）创建测试Employee类和HourlyWorker类的Test类，在Test类中的main方法中完成以下任务
 * ①    创建2个Employee对象employee1和employee2，创建两个HourlyWorker对象hourlyworker1和hourlyworker2。
 * 计算HourlyWorker类每个对象的工资并输出，调用每个对象的toString方法输出每个对象属性的值。
 *
 * ②如果计算计时工人的工资的方法为getSalary，employee1可以调用该方法嘛？为什么？
 * 答：【不能，因为Employee类中没有声明getSalary方法，所以类型为Employee的employee1没法找到getSalary方法。】
 *
 * ③能够将hourlyworker1赋给employee1嘛？为什么？
 * 答：【能，因为hourlyworker1是employee1对象的类型子类对象，所以hourlyworker1能够向上转型为Employee类型。】
 *
 * 如果可以赋值，赋值后，调用employee1对象的toString方法，输出的是哪个对象属性的值？输出了hourlyworker1对象特有属性的值了嘛？为什么？
 * 答：【输出的是原来hourlyworker1的toString方法。输出了hourlyworker1对象特有的属性。
 * 首先，HourlyWorker重写了父类的toString方法，所以在Employee类中看得到toString的方法入口。
 * 不过employee的类型虽然是Employee，但本身实例的类型却是HourlyWorker，在内存中储存的是
 * HourlyWorker里的toString方法的数据内容，而不是Employee里的toString方法数据内容。】
 *
 * hourlyworker1赋给employee1后，可以将employee1赋给hourlyworker1嘛？为什么？
 * 答：【可以，因为尽管在赋值时可以将HourlyWorker类型的实例当成Employee类型的实例，但这只是改变了引用的类型，在内存中储存的数据始终
 * 都是hourlyworker类型的数据。因此尽管之前将hourlyworker1赋值给了employee1，但由于数据本身没有变化，而只是改变了引用类型，所以可以
 * 重新赋值hourlyworker1。】
 *
 * 可以将employee1强制转换为Hourlyworker后赋给hourlyworker1嘛？为什么？
 * 答：【可以，因为尽管在赋值时可以将HourlyWorker类型的实例当成Employee类型的实例，但这只是改变了引用的类型，在内存中储存的数据始终
 *  * 都是hourlyworker类型的数据。因此尽管之前将hourlyworker1赋值给了employee1，但由于数据本身没有变化，而只是改变了引用类型，所以可以
 *  * 强制类型转换，然后赋值hourlyworker1。】
 *
 * 可以将employee2赋给hourlyworker2嘛？为什么
 * 答：【可以，因为在Employee与HourlyWorker是继承关系，继承关系的两个类型之间可以互相转换】
 *
 * 可以将employee2强制转换为Hourlyworker赋给hourlyworker2嘛？为什么？
 * 答：【可以，因为在Employee与HourlyWorker是继承关系，继承关系的两个类型之间可以互相转换。但需要注意的是，如果在内存中的实例类型是
 * HourlyWorker类型，那么则可以成功向上转型。如果在内存中的实例类型是Employee，尽管由于这两个类型是继承关系，可以在Source阶段互相转
 * 换，但却可能会造成RuntimeException，因为转型成HourlyWorker类型后，当调用的方法或使用到的属性是HourlyWorker类型所特有的，Employee
 * 类型的employee2在内存中根本没有储存这些数据信息，因此在Runtime期间企图使用逆变赋值后的hourlyworker2访问这些数据，那么程序将会出错】
 *
 * ④删除2中编写的代码，声明一个含有4个元素的Employee类型的数组employees，
 * 将employee1、employee2、hourlyworker1和hourlyworker2设置为employee数组的4个元素的值。
 *
 * 编写一个方法printEmployeeInfo(Employee[] employees)，该方法迭代数组employees，使每个元素调用toString方法，输出每个对象属性的值。
 * 从输出结果看，它们调用的是哪个类的toString方法？
 * 答：从结果上看，当new出来的实例为Employee，则调用Employee中的toString方法。当new出来的实例为HourlyWorker，则调用HourlyWorker
 * 中的toString方法
 *
 */
public class Exercise_1 {

    //题目1.（2）.①
    private static class Test01{
        public static void main(String[] args) {

            Employee employee1 = new Employee("EP01", "张三","43415461451236414634531");
            Employee employee2 = new Employee("EP02", "李四","51342618341838518934535");
            HourlyWorker hourlyworker1 = new HourlyWorker("HW01", "狂人", "G13284519203814710");
            HourlyWorker hourlyworker2 = new HourlyWorker("HW02", "闲人", "G45192038345344367");

            //设置工作时薪与工作时长
            hourlyworker1.setWagesCalculator(30, 60);
            hourlyworker2.setWagesCalculator(20, 70);

            System.out.println("[DEBUG]==>" + "hourlyworker1   Salary" + hourlyworker1.getSalary());
            System.out.println("[DEBUG]==>" + "hourlyworker2   Salary" + hourlyworker2.getSalary());

            System.out.println("[DEBUG]==>"+employee1);
            System.out.println("[DEBUG]==>"+employee2);
            System.out.println("[DEBUG]==>"+hourlyworker1);
            System.out.println("[DEBUG]==>"+hourlyworker2);
        }
    }

    //题目1.（2）.④
    private static class Test02{
        public static void main(String[] args) {
            Employee[] employees = new Employee[4];

            employees[0] = new Employee("EP01", "张三","43415461451236414634531");
            employees[1] = new Employee("EP02", "李四","51342618341838518934535");
            employees[2] = new HourlyWorker("HW01", "狂人", "G13284519203814710");
            employees[3] = new HourlyWorker("HW02", "闲人", "G45192038345344367");

            printEmployeeInfo(employees);
        }

        private static void printEmployeeInfo(Employee[] employees) {
            for (Employee employee : employees) {
                System.out.println(employee);
            }
        }
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
