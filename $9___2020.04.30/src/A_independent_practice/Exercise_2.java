package A_independent_practice;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

/**
 * 7.7.5 独立实践
 * <p>
 * 2、创建订单
 *
 * 创建一个订单类，记录订单号。第一笔订单的时间、订购产品
 * 的ID、客户ID、提交订单的时间、发货时间、送货的地址，
 * 且能够使用该类记录已经创建订单的总数。
 *
 * 编写程序，使用订单类创建三个订单，并输出每个订单的信息
 * 和第一个订单的时间及订单的数目。
 *
 */
public class Exercise_2 {
    public static void main(String[] args) {
        //客户和产品信息
        Client me = new Client("XXX" , "法外狂徒张某三");
        Product product01 = new Product("SAX-0101", "毒鼠强");
        Product product02 = new Product("SAX-1030", "布加迪威龙");
        Product product03 = new Product("TTS-BAB", "Apache");
        String myAddress = "北京市";
        String info = "老板，记得在包装时，进行“套娃式”包装";



        //订单01
        Order order01 = new Order(me, product01, myAddress, info);
        order01.submit();
        print(order01);

        //订单02
        Order order02 = new Order(me, product02, myAddress);
        Order order03 = new Order(me, product03, myAddress);

        //此时未提交订单
        print(order02);
        print(order03);

        //提交订单
        order02.submit();
        order03.submit();

        print(order02);
        print(order03);
    }
    
    private static void print(Order order){
        LocalDateTime distriTime = order.getTimeOfDistribution();
        LocalDateTime submitTime = order.getTimeOfSubmittal();

        System.out.println("客户：" + order.getClient().getName());

        if (submitTime != null) {
            System.out.println("订单号："+order.getIdOfOrder());
            System.out.println("下单时间：" + submitTime.getYear() + "-" + submitTime.getMonthValue() + "-" + submitTime.getDayOfMonth()
                    + "#" + submitTime.getHour() + ":" + submitTime.getMinute() + ":" + submitTime.getSecond());
            System.out.println("到货时间：" + distriTime.getYear() + "-" + distriTime.getMonthValue() + "-" + distriTime.getDayOfMonth()
                    + "#" + distriTime.getHour() + ":" + distriTime.getMinute() + ":" + distriTime.getSecond());

        } else {
            System.out.println("订单号："+"未下单");
            System.out.println("下单时间：" +"未下单");
            System.out.println("到货时间：" + "未下单");
        }

        System.out.println("订单总数量：" + Order.sumOfOrder);
        System.out.println("剩余订单数量：" + Order.sumOfRemainingOrder);
        System.out.println("================================");
    }

    private static class Order{
        private static long sumOfOrder = 0;
        private static long sumOfRemainingOrder = 0;

        //IDs
        private String idOfOrder;   //订单号
        private Product product; //产品
        private Client client;  //客户

        //Date Times
        private LocalDateTime timeOfFirstOrder; //第一笔订单的时间
        private LocalDateTime timeOfSubmittal;  //提交订单的时间
        private LocalDateTime timeOfDistribution;   //发货时间

        private String addressOfDelivery;   //送货的地址
        private String info;

        {
            //记录所创建订单的总数
            ++sumOfOrder;
            ++sumOfRemainingOrder;

            //简单地根据时间戳生成id
            this.idOfOrder =
                    String.valueOf(new Date().getTime()).getBytes().hashCode()
                            +"-"
                            +sumOfOrder;

            //记录第一笔订单的时间
            if(sumOfOrder==1) this.timeOfFirstOrder = LocalDateTime.now();
        }

        public Order( Client client,Product product,String addressOfDelivery) {
            this(client, product, addressOfDelivery, "");
        }

        public Order( Client client,Product product,String addressOfDelivery, String info) {
            this.client = client;
            this.product = product;
            this.addressOfDelivery = addressOfDelivery;
            this.info = info;
        }

        public void submit()  {
            if (this.timeOfSubmittal == null) {
                this.timeOfSubmittal = LocalDateTime.now();

                //简单地模拟送货所花的时间
                int day = (int) (Math.random() * 20);
                LocalDateTime distrTime = timeOfSubmittal.plusDays(day);
                distrTime = distrTime.plusHours(day);
                distrTime = distrTime.plusMinutes(day);
                distrTime = distrTime.plusSeconds(day);
                setTimeOfDistribution(distrTime);

                //当前未完成的订单减一
                --sumOfRemainingOrder;
            }
        }

        public void setTimeOfDistribution(LocalDateTime timeOfDistribution) {
            this.timeOfDistribution = timeOfDistribution;
        }

        public void setTimeOfDistribution(int year, int month, int day, int hour, int minute, int second) {
            setTimeOfDistribution(LocalDateTime.of(
                    LocalDate.of(year, month, day),
                    LocalTime.of(hour, minute, second)
            ));
        }

        public void setTimeOfDistribution(int year, int month, int day) {
            LocalTime now = LocalTime.now();
            setTimeOfDistribution(
                    year, month, day,
                    now.getHour(), now.getMinute(), now.getSecond());
        }

        public void setTimeOfDistribution(long hour, long minute, long second) {
            LocalDate now = LocalDate.now();
            setTimeOfDistribution(
                    now.getYear(), now.getMonthValue(), now.getDayOfMonth(),
                    (int)hour, (int)minute, (int)second);
        }

        public LocalDateTime getTimeOfDistribution() {
            return timeOfDistribution;
        }

        public LocalDateTime getTimeOfSubmittal() {
            return timeOfSubmittal;
        }

        public String getIdOfOrder() {
            return idOfOrder;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public Product getProduct() {
            return product;
        }

        public Client getClient() {
            return client;
        }
    }

    private static class Product{
        private String id;
        private String name;
        private String info;

        public Product(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }

    private static class Client{
        private String id;
        private String name;
        private String info;

        public Client(String id, String name) {
            this.id = id;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public String getId() {
            return id;
        }

        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }
    }


}


