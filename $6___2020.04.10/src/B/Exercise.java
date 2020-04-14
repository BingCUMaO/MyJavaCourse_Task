package B;


/**
 * 2.产品销售额统计
 * (1)定义一个类Mydataarray,该类的字段和构造函数声明如下:
 * public class Mydataarray{
 *      private int size0,size1;
 *      private double[][] data;
 *      public Mydataarray(double[][] array){
 *              size0=array.length;
 *              size1=array[0].length;
 *              data=new double[size0][size1];
 *              for(int i=0;i<data.length;i++)
 *                  for(int j=0;j<data[i].length;j++)
 *                      data[i][j]=array[i][j];
 *      }
 * }
 *
 * 继续完成该类，要求在该类中声明如下方法:
 *      方法GetTotal,该方法返回data数组所有元素的和。
 *      方法GetAveragValue，该方法返回data数组所有元素的平均值。
 *      方法GetMaxValue,该方法返回data数组所有元素中的最大值元素的值及位置。
 *                  提示:使用名为max的变量存储最大值元素的值。max的初始值设置为data[0][0],
 *                              为求data数组所有元素中的最大值，将data中的每个元素与max进行比较，
 *                              若数组元素值比max大，就用该数组元素值更新max。
 *
 *       方法GetMinValue,该方法返回data数组所有元素中的最小值元素的值及位置。
 *       方法Get(inti,intj),该方法返回data[i][j]元素的值。
 *       方法RowAverage(int k)，该方法返回第k+1行所有元素的平均值。
 *       方法RowTotal(int k)，该方法返回第k+1行所有元素的和。
 *       方法ColmTotal(int k),该方法返回策.k+1列所有元素的和。
 */
public class Exercise {
    public static void main(String[] args) {

    }


    public class Mydataarray{
         private int size0,size1;
         private double[][] data;

         public Mydataarray(double[][] array){
                 size0=array.length;
                 size1=array[0].length;
                 data=new double[size0][size1];

                 for(int i=0;i<data.length;i++)
                     for(int j=0;j<data[i].length;j++)
                         data[i][j]=array[i][j];
         }

        public double GetTotal( ){
             double total = 0;
             for (double[] ticks : data)
                for(double tick: ticks)
                    total += tick;

             return total;
        }

        public double GetAveragValue(){
            return GetTotal() / (data.length * data[0].length);
        }

        public double GetMaxValue(){
            double max = data[0][0];
            for(double[] ticks: data)
                for(double tick: ticks)
                    if(max<tick)
                        max = tick;

            return max;
        }

        public double GetMinValue(){
            double min = data[0][0];
            for(double[] ticks: data)
                for(double tick: ticks)
                    if(min>tick)
                        min = tick;

            return min;
        }

        public double Get(int i,int j){
            return data[i][j];
        }

        public double RowAverage(int k){
             double total = 0;
            for (int i = 0; i < size1; i++) {
                total += data[k + 1][i];
            }

            return total;
        }

        public double ColmTotal(int k){
             double total = 0;
            for (int i = 0; i < size0; i++) {
                total += data[i][k + 1];
            }

            return total;
        }
    }


}


