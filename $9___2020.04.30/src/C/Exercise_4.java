package C;



/**
 *  （4）Bradshaw项目中除了Customer类外，还有船台类Slip，
 *           Slip类有3个属性：
 *                  slipID（船台ID）、
 *                  width（船台宽度）、
 *                  slipLength（船台长度）
 *           Bradshaw公司会工具船台的宽度来计算船台的出租费用。
 *
 *    ①创建Slip类，声明一个含有3个参数的构造函数初始化对象。
 *        声明另一个含有一个参数的构造函数将船台编号初始化为
 *        参数指定的值，将船台宽度和船台长度的默认值设置为12
 *        和25（要求使用this关键字）。声明一个无参数的leaseSlip
 *        方法计算船台的出租费用。声明另一个有一个参数的leaseSlip
 *        方法，该参数指定出租费用的折扣百分比，该方法计算打
 *        折后的出租费用。
 *
 *    ②创建测试程序，测试Slip类。
 */
public class Exercise_4 {
    public static void main(String[] args) {
        Slip slip = new Slip("XAB");
        System.out.println(slip.leaseSlip());
        System.out.println(slip.leaseSlip(0.5));
    }

    private static class Slip{
        private String slipID;
        private int width;
        private int slipLength;

        public Slip(String slipID, int width, int slipLength) {
            this.slipID = slipID;
            this.width = width;
            this.slipLength = slipLength;
        }

        public Slip(String slipID) {
            this(slipID, 12, 25);
        }

        public double leaseSlip(){
            return leaseSlip(1);
        }

        public double leaseSlip(double discount) {
            double annualRent = 0;

            switch (this.width) {
                case 10: annualRent = 800;break;
                case 12:annualRent = 900;break;
                case 14:annualRent = 1100;break;
                case 16:annualRent = 1500;break;
                default:
            }

            return annualRent * discount;
        }

        public String getSlipID() {
            return slipID;
        }

        public void setSlipID(String slipID) {
            this.slipID = slipID;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getSlipLength() {
            return slipLength;
        }

        public void setSlipLength(int slipLength) {
            this.slipLength = slipLength;
        }
    }

    private static class Customer{

        private String name;
        private String address;
        private String phone;

        public Customer(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
        }

        public String tellAboutSelf(){
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", address='" + address + '\'' +
                    ", phone='" + phone + '\'' +
                    '}';
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}


