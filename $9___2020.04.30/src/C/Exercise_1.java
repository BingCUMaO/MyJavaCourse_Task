package C;



/**
 * Bradshaw是一家私人公司，该公司的主要业务是
 * 向客户出租划艇船只和船台。在想客户出租船台
 * 时，可按年出租和按日出租。Bradshaw希望能够
 * 拥有自动化系统来跟踪客户、船台和船只的信息，
 * 并能够执行基本的日常业务任务，如创建逐月、
 * 计算租金等。
 * 请为Bradshaw公司开发该系统。
 * <p>
 * （1）Bradshaw公司要跟踪的客户信息有姓名、地
 * 址和电话，要求你创建客户类Customer，并
 * 编写测试该类的代码。
 */
public class Exercise_1 {
    public static void main(String[] args) {
        Customer customer = new Customer("张某三", "上海市", "110120119");

        System.out.println(customer.getName());
        System.out.println(customer.getAddress());
        System.out.println(customer.getPhone());
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


