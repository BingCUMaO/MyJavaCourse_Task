package A_independent_practice;


import java.io.BufferedInputStream;
import java.io.InputStream;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * 7.7.5 独立实践
 * <p>
 * 1、银行活动账户(选做题)
 * <p>
 * 创建一个活期账户类。
 * <p>
 * 参考如下积数计息法：
 * 银行主要采用积数计息法和逐笔计息法计算利息。
 * 积数计息法变阿玉对计息期间账户余额可能会发生变化
 * 的储蓄存款计算利息。因此，银行主要对活期性质的储
 * 蓄账户采取积数计息法计算利息，包括活期存款、零存
 * 整取、通知存款。而对于定期性质的存款，包括整存争
 * 取、整存零取、存本取息、定活两便，银行采用逐笔计
 * 息法计算利息。
 * <p>
 * 积数计息法就是按照实际天数每日累计账户余额，以累
 * 计积数乘以日利率计算利息的方法。
 * <p>
 * 积数计息法的计息公式为：
 * 利息 = 累计计息积数 ×  日利率
 * <p>
 * 其中累计计息积数 = 账户每日余额合计数。
 */
public class Exercise_1 {
    public static void main(String[] args) throws Exception {

        LocalDate startDate = LocalDate.of(2007, 1, 2);
        LocalDate endDate = LocalDate.of(2007, 3, 20);

        ActiveBankAcount aba = new ActiveBankAcount("XXA", 10000, startDate, endDate, 0.0072);
        System.out.println("Current Capital: " + aba.getCurrentCapital());
        aba.withdraw(3000, 2007, 2, 3);
        System.out.println("Current Capital: " + aba.getCurrentCapital());
        aba.deposit(5000, 2007, 3, 11);
        System.out.println("Current Capital: " + aba.getCurrentCapital());

        System.out.println(aba.getFinalInterest());
    }


    private static class ActiveBankAcount {
        //设置利率与利息的数字格式
        private static NumberFormat nf;

        static {
            nf = NumberFormat.getInstance();

            nf.setMaximumFractionDigits(2);
            nf.setMaximumFractionDigits(2);
        }

        //Account ID
        private String id;
        //本金
        private long capital;
        //年利率
        private double annualInterestRate;
        //存取活动日期表
        private LinkedList<LocalDate> operationDateList;
        //结息日期
        private LocalDate terminatedDate;
        //存取活动的金额列表。用负数代表取款，正数代表存款
        private LinkedList<Long> operationList;


        /**
         * @param accountId          ID
         * @param capital            本金
         * @param initDate           开始计息日期
         * @param terminatedDate     结息日期
         * @param annualInterestRate 年利率
         */
        public ActiveBankAcount(String accountId, long capital, LocalDate initDate, LocalDate terminatedDate, double annualInterestRate) {
            operationDateList = new LinkedList<>();
            operationList = new LinkedList<>();

            this.id = accountId;
            this.capital = capital;
            this.operationDateList.add(initDate);
            this.terminatedDate = terminatedDate;
            this.annualInterestRate = annualInterestRate;
        }

        public ActiveBankAcount(String accountId, long capital, LocalDate terminatedDate, double annualInterestRate) {
            this(accountId, capital, LocalDate.now(), terminatedDate, annualInterestRate);
        }

        /**
         * @param money 存款金额
         * @param date  存款日期
         * @return 是否成功存入
         */
        public void deposit(long money, LocalDate date) throws IllegalArgumentException {
            //检查money与date是否合法
            if (!checkLegalDate(date)) throw new IllegalArgumentException("DateExccedTerminateDateException");
            if (money < 0) throw new IllegalArgumentException("MoneyFormatException");

            operationDateList.add(date);
            operationList.add(money);
        }

        public void deposit(long money, int year, int month, int day) throws IllegalArgumentException {
            deposit(money, LocalDate.of(year, month, day));
        }

        /**
         * @param money 取款金额
         * @param date  取款日期
         * @return 是否成功取款
         */
        public void withdraw(long money, LocalDate date) throws IllegalArgumentException {
            long currentCapital = getCurrentCapital();

            //观察余额是否足够并检查date是否合法
            if (!checkLegalDate(date)) throw new IllegalArgumentException("DateExccedTerminateDateException");
            if (currentCapital - money < 0) throw new IllegalArgumentException("MoneyWithdrawExccedException");

            operationDateList.add(date);
            operationList.add(money * (-1));
        }

        public void withdraw(long money, int year, int month, int day) throws IllegalArgumentException {
            withdraw(money, LocalDate.of(year, month, day));
        }

        /**
         * @return 获取当前剩余的本金
         */
        public long getCurrentCapital() {
            long tempCapital = capital;
            for (long tick : operationList) {
                tempCapital += tick;
            }

            return tempCapital;
        }

        public double getFinalInterest() {
            //日利率
            nf.setMaximumFractionDigits(5);
            double dailyInterestRate = Double.parseDouble(nf.format(annualInterestRate / 360));
            //累计计息积数  calculated interest project
            long calcInterProject = 0;

            /**
             * 计算operationList中的计息积数
             * （不包含   最后一次operate~terminatedDate  之间的计息基数）
             */
            long tempCapital = capital;
            Iterator dateItor = operationDateList.iterator();
            Iterator moneyItor = operationList.iterator();
            LocalDate lastDate = (LocalDate) dateItor.next();   //与nextDate一齐构成固定间距为2的“双指针”滑动窗口
            while (moneyItor.hasNext()) {
                LocalDate nextDate = (LocalDate) dateItor.next();

                //得到两个日期之间相差的间距
                long daysBetweenTwoDate = lastDate.until(nextDate, ChronoUnit.DAYS);
                lastDate = nextDate;

                //随着while循环，计算   累计计息积数
                calcInterProject += daysBetweenTwoDate * tempCapital;

                //计算存取款后的当前余额
                tempCapital += ((Long) moneyItor.next()).longValue();
            }


            //加上     最后一次operate~terminateDate   之间的计息基数
            long daysBetweenTwoDate = operationDateList.getLast().until(terminatedDate, ChronoUnit.DAYS);
            calcInterProject += daysBetweenTwoDate * tempCapital;


            nf.setMaximumFractionDigits(2);
            return Double.parseDouble(nf.format(calcInterProject * dailyInterestRate));
        }

        /**
         * 检查输入的date是否合法
         *
         * @param date
         * @return
         */
        private boolean checkLegalDate(LocalDate date) {
            return date.until(terminatedDate, ChronoUnit.DAYS) >= 0;
        }


        /**
         * Getters And Setters
         */
        public String getId() {
            return id;
        }

        public long getCapital() {
            return capital;
        }

        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }
    }

}


