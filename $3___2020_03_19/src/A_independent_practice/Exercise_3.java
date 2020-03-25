package A_independent_practice;

/**
 * 3.5.4 独立实践
 * <p>
 * 3、计算计件工人工资
 * <p>
 * 某公司有各类员工，如销售员、计时工人、计件工人、经理，他们的薪水
 * 计算方法是不同的，计件工人的薪水计算方法如下：
 * <p>
 * 薪水 = 计件工资 * 生产的产品件数
 * <p>
 * 试创建计件工人 类Pieceworker，使用Pieceworker类创建计件工人对象，
 * 计算每个计件工人的工资，并输出工资单。
 */
public class Exercise_3 {
    public static void main(String[] args) {
        PieceWorker pw = new PieceWorker();

        pw.setPieceWage(30);
        pw.setNumOfUnitProduced(50);

        System.out.println(pw.getSalary());
    }

    static class PieceWorker {
        private double pieceWage;
        private int numOfUnitProduced;

        public double getSalary() {
            return pieceWage * numOfUnitProduced;
        }

        public double getPieceWage() {
            return pieceWage;
        }

        public void setPieceWage(double pieceWage) {
            if (pieceWage > 0)
                this.pieceWage = pieceWage;
            else
                this.pieceWage = 0;
        }

        public int getNumOfUnitProduced() {
            return numOfUnitProduced;
        }

        public void setNumOfUnitProduced(int numOfUnitProduced) {
            if (numOfUnitProduced > 0)
                this.numOfUnitProduced = numOfUnitProduced;
            else
                this.numOfUnitProduced = 0;
        }
    }
}


