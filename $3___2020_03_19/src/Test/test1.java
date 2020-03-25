package Test;

public class test1 {
    public static void main(String[] args) {
        Loan l = new Loan();
        l.setAnnualInterestRate(1.2);
        l.setLoanAmount(2000);
        l.setLoanPeriod(2);
        System.out.println(l.computeMonthlyPayment());
        System.out.println(l.computeTotalPayment());
    }

    static class Loan {
        private double loanAmount; //声明字段loanAmount
        private int loanPeriod; //声明字段loanPeriod
        private double annualInterestRate; //声明字段annualInterestRate

        //声明计算月付款的值的方法
        public double computeMonthlyPayment() {
            double monthlyInterestRate;
            int numberOfPayments;
            double monthlyPayment;

            monthlyInterestRate = annualInterestRate / 100.0f / 12;
            numberOfPayments = loanPeriod * 12;
            monthlyPayment = (loanAmount * monthlyInterestRate) /
                    (1 - Math.pow(1 + monthlyInterestRate,
                    -numberOfPayments));

            return monthlyPayment;
        }

        //声明计算总付款的值的方法
        public double computeTotalPayment() {
            double totalPayment;
            totalPayment = computeMonthlyPayment() * loanPeriod * 12;
            return totalPayment;
        }

        public double getLoanAmount() {
            return loanAmount;
        }

        public void setLoanAmount(double loanAmount) {
            this.loanAmount = loanAmount;
        }

        public int getLoanPeriod() {
            return loanPeriod;
        }

        public void setLoanPeriod(int loanPeriod) {
            this.loanPeriod = loanPeriod;
        }

        public double getAnnualInterestRate() {
            return annualInterestRate;
        }

        public void setAnnualInterestRate(double annualInterestRate) {
            this.annualInterestRate = annualInterestRate;
        }

    }

}

