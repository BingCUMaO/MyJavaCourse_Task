package C;



/**
 *  （5）Bradshaw系统需要跟踪船只的总数量，该写Slip类，通过
 *             该类可以获得船只的总数量。
 *             编写代码测试修改后的Slip类。
 */
public class Exercise_5 {
    public static void main(String[] args) {
        int num = 6;
        for (int i = 0; i <num ; i++) {
            new Slip("XX");
        }

        System.out.println(Slip.getSumOfSlip());
    }

    private static class Slip{

        private static int sumOfSlip = 0;
        { ++sumOfSlip;}

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

        public static int getSumOfSlip() {
            return sumOfSlip;
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


