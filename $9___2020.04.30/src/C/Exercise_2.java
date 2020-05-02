package C;



/**
 *  （2）修改Customer类，声明一个含有三个参数的构造函数
 *              初始化对象，并声明一个TellAboutSelf方法，该方法
 *              将所有属性的值格式华为一个字符串并将该字符串返回。
 *
 *     编写一个Test类，在该类的Main方法中，创建3个Customer对象，
 *     调用TellAboutSelf方法输出每个对象属性的值
 */
public class Exercise_2 {
    public static void main(String[] args) {
        Customer customer = new Customer("张某三", "上海市", "110120119");

        System.out.println(customer.tellAboutSelf());
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


