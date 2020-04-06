package B_independent_practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 5.2.3 独立实践
 *
 * 2、反转一个数组
 *
 * （1）编写一个程序，用10个整数初始化一个整型数组numbers，
 *              再声明一个有10个元素的整型数组reverse，然后将numbers
 *              数组元素的值赋给reverse数组中的元素，但复制要满足如下
 *              条件：
 *
 *              reverse内容是numbers内容的反转，即reverse的第二个元素
 *              的值和numbers倒数第二个元素的值相等，如此类推，······
 *              reverse的最后一个元素的值和numbers第一个元素的值相等。
 *
 *              最后输出reverse数组中每个元素的值。
 *
 *
 *
 * （2）在MyArray类中增加一个方法reverse()，该方法反转数组array
 *              的副本，并将反转后的副本返回，并编写程序测试reverse方
 *              法。
 *
 */
public class Exercise_2 {
    private static final int LEN = 10;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = new int[LEN];

        //赋值
        System.out.println("请输入"+LEN+"个数：");
        for (int i = 0; i < LEN; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        MyArray ma = new MyArray(array);
        for (double tick : ma.reverse()) {
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

        public MyArray(int[] arr){
            array = new double[arr.length];

            for(int i = 0; i<array.length; i++){
                array[i] = arr[i];
            }
        }

        public double[] reverse(){
            double[] result = new double[array.length];
            for (int tick = 0; tick < result.length; tick++) {
                result[tick] = array[array.length - 1 - tick];
            }

            return result;
        }
    }



}
