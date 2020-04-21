package A_project_training;

import java.text.NumberFormat;

/**
 * 3,6 项目实战
 * <p>
 * 1、投资计算
 * <p>
 * 输入投资额、年利率和投资年限（年），计算投资的未来价值
 * 计算投资的未来价值的公式为：
 * <p>
 * InvestmentValue = amountOfCapital   *（1+interesRate）^   numberOfYears
 * <p>
 * 其中，amountOfCapital是投资额，interesRate 是月利率，，numberOfYears是
 * 投资年数，InvestmentValue 是投资numberOfYears 年后的价值。
 * 编写一个类Investment ，使用Investment 类的对象计算投资的未来价值，并输
 * 出结果。
 */
public class Exercise_1 {
    public static void main(String[] args) {
        double amountOfCapital = 100000;
        double interesRate = 0.2;
        int numberOfYear = 5;

        Investment imt = new Investment(amountOfCapital, interesRate, numberOfYear);

        NumberFormat formater = NumberFormat.getCurrencyInstance();
        formater.setMaximumFractionDigits(2);

        System.out.println("The Total :\t"+formater.format(imt.getTotalAmount()));
    }

    static class Investment {
        //投资额
        private double amountOfCapital;
        //月利率
        private double interesRate;
        //年限
        private int numberOfYears;

        //Constructer
        public Investment(double amountOfCapital,double interesRate,int numberOfYears) {
            setAmountOfCapital(amountOfCapital);
            setInteresRate(interesRate);
            setNumberOfYears(numberOfYears);
        }

        //Method
        public double getTotalAmount(){
            return amountOfCapital * Math.pow((1 + interesRate), numberOfYears);
        }

        public double getAmountOfCapital() {
            return amountOfCapital;
        }

        public void setAmountOfCapital(double amountOfCapital) {
            if (amountOfCapital > 0)
                this.amountOfCapital = amountOfCapital;
            else
                this.amountOfCapital = 0;
        }

        public double getInteresRate() {
            return interesRate;
        }

        public void setInteresRate(double interesRate) {
            if (interesRate > 0)
                this.interesRate = interesRate;
            else
                this.interesRate = 0;
        }

        public int getNumberOfYears() {
            return numberOfYears;
        }

        public void setNumberOfYears(int numberOfYears) {
            if (numberOfYears > 0)
                this.numberOfYears = numberOfYears;
            else
                this.numberOfYears = 0;
        }
    }

}


