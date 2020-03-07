package C;

import javax.swing.*;

/**
 * 任务5：计算销售额
 * <p>
 * 某公司有m种产品，编写一控制台应用程序，输入每种产品在每季度的销售额，
 * 计算每种产品的总销售额并输出（会数组的就使用数组）
 */
public class Exercise_5 {
    private static final String CRLF = "\r\n";
    private static final int M = 2;

    public static void main(String[] args) {
        String title = "Calculate Total Sale";

        Product[] products = new Product[M];
        for(int i = 0;i<M;i++){
            products[i] = new Product();
        }
        for (int i = 0; i < M; i++) {
            double[] fourQuartersOfSales = new double[4];
            for (int j = 0; j < 4; j++) {
                fourQuartersOfSales[j] =
                        Double.parseDouble(showInputDialog("The " + (j + 1) + " th Quarter Sales : " + CRLF, title));
            }
            products[i].setFourQuartersOfSales(
                    fourQuartersOfSales[0],
                    fourQuartersOfSales[1],
                    fourQuartersOfSales[2],
                    fourQuartersOfSales[3]
            );
        }

        int i = 1;
        for(Product product:products){
            showMessageDialog(
                    "The " + i + " th product ' s total sales :" + product.getTotalSales(),
                    title
            );
        }
    }


    static String showInputDialog(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static void showMessageDialog(String message, String title) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.PLAIN_MESSAGE);
    }

    static class Product {
        private double[] fourQuartersOfSales;
        private double totalSales;

        public Product() {
            fourQuartersOfSales = new double[4];
            totalSales = 0;
        }

        public double[] getFourQuartersOfSales() {
            return fourQuartersOfSales;
        }

        public void setFourQuartersOfSales(
                double firstQuarterSales,
                double secondQuarterSales,
                double thirdQuarterSales,
                double fourthQuarterSales
                ) {
            fourQuartersOfSales[0] = firstQuarterSales;
            fourQuartersOfSales[1] = secondQuarterSales;
            fourQuartersOfSales[2] = thirdQuarterSales;
            fourQuartersOfSales[3] = fourthQuarterSales;

            for (double d : fourQuartersOfSales) {
                totalSales += d;
            }
        }

        public double getTotalSales() {
            return totalSales;
        }
    }

}
