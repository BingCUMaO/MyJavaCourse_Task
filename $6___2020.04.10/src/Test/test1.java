package Test;


import java.util.Arrays;

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
public class test1 {
    public static void main(String[] args) {
        long[][] arr = {
                {1,2,3},
                {10,20,30},
                {100,200,300},
                {1000,2000,3000},
        };
        Long[][] array = Utils.toLongWrapper(arr);

        Mydataarray<Long> mdarr = new Mydataarray<Long>(array);
        //show logs
        for (int i = 0; i < mdarr.size0; i++) {
            for (int j = 0; j < mdarr.data[0].length; j++) {
                System.out.println(mdarr.data[i][j]);
            }
        }

        System.out.println("========================");
        System.out.println("Total: "+mdarr.GetTotal());
        System.out.println("Column Total: "+mdarr.ColmTotal(1));
        System.out.println("Max: " + mdarr.GetMaxValue());
        System.out.println("Min: " + mdarr.GetMinValue());
    }


    private static class Mydataarray<T extends Number>{
         private int size0,size1;
         private T[][] data;

         public Mydataarray(T[][] array){
                 size0=array.length;
                 size1=array[0].length;

                data = array.clone();
         }

        public T GetTotal( ){
             double total = 0;
             for (T[] ticks : data)
                for(T tick: ticks)
                    total += tick.doubleValue();

             return (T)new Double(total);
        }

        public double GetAveragValue(){
            return GetTotal().doubleValue() / (data.length * data[0].length);
        }

        public T GetMaxValue(){
            T max = data[0][0];
            for(T[] ticks: data)
                for(T tick: ticks)
                    if(max.doubleValue()<tick.doubleValue())
                        max = tick;

            return max;
        }

        public T GetMinValue(){
            T min = data[0][0];
            for(T[] ticks: data)
                for(T tick: ticks)
                    if(min.doubleValue()>tick.doubleValue())
                        min = tick;

            return min;
        }

        public T Get(int i,int j){
            return data[i][j];
        }

        public T RowAverage(int k){
             double total = 0;
            for (int i = 0; i < size1; i++) {
                total += data[k + 1][i].doubleValue();
            }

            return (T) new Double(total / data[0].length);
        }

        public T ColmTotal(int k){
             double total = 0;
            for (int i = 0; i < size0; i++) {
                total += data[i][k + 1].doubleValue();
            }

            return (T) new Double(total);
        }
    }

    private static class Utils{
        //Forbid to create object
        private Utils(){
        }

        //double[][]基本类型  转化为  Double[][] 装饰器
        public static Double[][] toDoubleWrapper(double[][] array){
            Double[][] result = new Double[array.length][array[0].length];

            for(int i = 0;i<result.length;i++){
                result[i] = Arrays.stream(array[i]).boxed().toArray(Double[]::new);
            }

            return result;
        }

        //long[][]基本类型  转化为  Long[][] 装饰器
        public static Long[][] toLongWrapper(long[][] array){
            Long[][] result = new Long[array.length][array[0].length];

            for(int i = 0;i<result.length;i++){
                result[i] = Arrays.stream(array[i]).boxed().toArray(Long[]::new);
            }

            return result;
        }

    }


}


