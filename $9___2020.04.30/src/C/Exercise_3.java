package C;



/**
 *  （2）修改2中Test类的Main方法，将创建的3个Customer对象储存
 *              于3个元素的数组中。数组名为Customers，数组的数据类型
 *              为Customer对象。
 *
 *     编写一个循环语句，对数组进行迭代，使用tellAboutSelf方法输出
 *     每个对象属性的值。
 */
public class Exercise_3 {
    public static void main(String[] args) {
        Customer customer01 = new Customer("张某三", "上海市", "110120119");
        Customer customer02 = new Customer("张某四", "北京市", "210120119");
        Customer customer03 = new Customer("张某五", "天津市", "310120119");

        Customer[] customers = {customer01, customer02, customer03};

        for (Customer c : customers) {
            System.out.println(c.tellAboutSelf());
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


