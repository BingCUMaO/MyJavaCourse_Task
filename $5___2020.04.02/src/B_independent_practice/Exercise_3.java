package B_independent_practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 5.2.3 独立实践
 *
 * 3、
 *
 * 在MyArray类中定义方法arr(int start, int end) 获取数组array索引
 * start到索引end之间的元素组成的数组【包括索引start的元素，但
 * 不包括索引end的元素】。
 * 并编写程序测试该方法。
 *
 */
public class Exercise_3 {
    private static final int LEN = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double[] array = new double[LEN];

        //赋值
        System.out.println("请输入"+LEN+"个数：");
        for (int i = 0; i < LEN; i++) {
            array[i] = Double.parseDouble(br.readLine());
        }

        MyArray ma = new MyArray(array);
        System.out.println("---------->");
        for (double tick : ma.arr(5,8)) {
            System.out.print(tick + "\t\t\t");
        }
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

        public double[] arr(int start, int end) {
            if(start>=end) return null;

            double[] partArr = new double[end - start];
            for (int tick = start; tick < end; tick++) {
                partArr[tick-start] = array[tick];
            }

            return partArr;
        }


    }

}
