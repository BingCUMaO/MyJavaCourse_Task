package B_independent_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

/**
 * 5.2.3 独立实践
 *
 * 1、销售额分析（版本1）
 *
 * （1）定义一个类MyArray，该类的字段和构造函数声明如下：
 *
 *                      public class MyArray{
 *                          private double[] array;
 *
 *                          public MyArray(double[] arr){
 *                              array = new double[arr.length];
 *
 *                              for(int i = 0; i<array.length; i++){
 *                                  array[i] = arr[i];
 *                              }
 *                          }
 *                      }
 *
 *                      继续完成该类，要求在该类中声明如下方法：
 *
 *                      方法getTotal，该方法返回array数组所有元素的和。
 *                      方法getAverageValue，该方法返回array数组所有元素的平均值。
 *                      方法getMaxValue，该方法还会array数组所有元素中的最大值元素的值。
 *                               tip：使用名为max的变量存储最大值元素的值。max的初始值设置为
 *                                         array[0]，为丘array数组所有元素中的最大值，将array中的每
 *                                         个元素与max进行比较，若数组元素值比max大，就使用该数组
 *                                         元素值更新max。
 *                      方法getMinValue，该方法还会array数组所有元素中的最小值元素的值
 *                      方法get(int i)，该方法返回array数组索引为i的元素的值。
 *                      方法indexOf(double value)，该方法查询array数组中是否包含持有value值的
 *                               元素，如果数组中存在这样的元素，将第一个查到的元素的索引返回。
 *                      方法sort()，该方法将数组array的元素按从小到大排序。并在代码中注释使用
 *                               的是什么排序。
 *
 *
 *
 *
 *
 *  （2）编写程序，从命令窗口中输入10个雇员的销售额，使用自定义的MyArray类，
 *              求总销售额、平均销售额、最大销售额和最小销售额，有多少个雇员的销售
 *              额在平均销售额之上，有多少个雇员的销售额在平均销售额之下，并输出这
 *              些求出的值。同时将销售额按从小到大排序，并输出排序后的销售额。
 *
 */
public class Exercise_1 {
    private static final int numOfEmployee = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] array = new double[numOfEmployee];

        //赋值
        System.out.println("请输入"+numOfEmployee+"个雇员的销售额：");
        for (int i = 0; i < numOfEmployee; i++) {
            array[i] = Double.parseDouble(br.readLine());
        }

        //输出
        MyArray ma = new MyArray(array);
        int numOfMoreThanAverage = 0;
        int numOfLessThanAverage = 0;
        System.out.println("总销售额：" + ma.getTotal());
        System.out.println("平均销售额：" + ma.getAverageValue());
        System.out.println("最大销售额：" + ma.getMaxValue());
        System.out.println("最小销售额：" + ma.getMinValue());
        System.out.print("销售额：\t");
        for (double tick : ma.sort()) {
            if(tick>ma.getAverageValue())
                numOfMoreThanAverage++;
            if(tick<ma.getAverageValue())
                numOfLessThanAverage++;

            System.out.print(tick + "\t\t\t");
        }
        System.out.println();
        System.out.println("大于平均销售额的人数："+numOfMoreThanAverage);
        System.out.println("小于平均销售额的人数："+numOfLessThanAverage);

        br.close();
    }

    static class MyArray{
        private double[] array;

        public MyArray(double[] arr){
            array = new double[arr.length];

            for(int i = 0; i<array.length; i++){
                array[i] = arr[i];
            }
        }

        /**
         *
         * @return 方法getTotal，该方法返回array数组所有元素的和。
         */
        public double getTotal(){
            double total = 0;
            for (double tick : array) {
                total += tick;
            }

            return total;
        }

        /**
         *
         * @return 方法getAverageValue，该方法返回array数组所有元素的平均值。
         */
        public double getAverageValue(){
            double total = 0;

            if (0 == getTotal()) {
                total = getTotal();
            }

            double average = total / array.length;
            return average;
        }

        /**
         *
         * @return 方法getMaxValue，该方法还会array数组所有元素中的最大值元素的值。
         */
        public double getMaxValue(){
            double max = array[0];
            for (double tick : array) {
                if(tick>max)
                    max = tick;
            }

            return max;
        }

        /**
         *
         * @return 方法getMinValue，该方法还会array数组所有元素中的最小值元素的值
         */
        public double getMinValue(){
            double min = array[0];
            for (double tick : array) {
                if(tick<min)
                    min = tick;
            }

            return min;
        }

        /**
         *
         * @param index
         * @return 方法get(int i)，该方法返回array数组索引为i的元素的值。
         */
        public double get(int index){
            return array[index];
        }

        /**
         *
         * @param value 方法indexOf(double value)，该方法查询array数组中是否包含持有value值的元素
         * @return 如果数组中存在这样的元素，将第一个查到的元素的索引返回。
         */
        public int indexOf(double value){
            for(int tick = 0;tick<array.length;tick++){
                if(value == array[tick])
                    return tick;
            }

            return -1;
        }

        /**
         * 选择算法
         * 方法sort()，该方法将数组array的元素按从小到大排序。
         */
        public double[] sort(){
            for (int i = 0; i < array.length-1; i++)
                for (int j = i+1; j < array.length; j++)
                    if (array[j] < array[i]) {
                        double temp = array[i];
                        array[i] = array[j];
                        array[j] = temp;
                    }


            return this.array;
        }
    }

}
