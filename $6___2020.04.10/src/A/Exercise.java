package A;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *  假定5个学生参加了两门的考试，试统计出全部学生的最高分和全部学生的最低分及每个学生
 *  的平均成绩，并输出。
 *  根据问题描述,需要声明创建一个5行2列的数组score用来存储5个学生两门课的考试成绩。
 *          定义一个方法Maximum求指定二维数组中每个元素的最大值。
 *          定义一个Minimum求指定二维数组中每个元素的最小值。
 *          定义一个方法Average 求指定二维数组中指定行的平均值。
 *  通过调用这几个方法可分别求出全部学生的最高分和全部学生的最低分及每个学生的平均成绩。
 *  (1) 方法Maximum的算法如下。
 *          ①声明一个变量max, 将max的初始值设置为数组的第一个元素的值。
 *          ②编写嵌套循环，将数组中每个元素与max进行比较，如果数组元素的值比max大，就
 *          用该元素的值更新max的值。
 *          ③将max返回。
 *  (2) 方法Average的算法如下。
 *          ①声明变量total, 将其初始化为0。
 *          ②编写 for循环，顺序读取指定行的每一列的值， 并将其累加到total。
 *          ③计算(total/二维的长度)， 并将其返回。
 */
public class Exercise {
    public static void main(String[] args) {

        double[][] arr  = {
                {50,50},
                {60,60},
                {70,70},
                {80,80},
                {90,90}
        };
        Double[][] score = Utils.toDoubleWrapper(arr);


        //show datas
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < score[0].length; j++) {
                System.out.println(score[i][j]);
            }
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

        //T extends Number，get Max
        public static <T extends Number>T  Maximum(T[][] array){

            T max = array[0][0];
            for (T[] tickRow : array)
                for (T tickColumn : tickRow)
                    if (max.doubleValue() < tickColumn.doubleValue())
                        max = tickColumn;

            return max;
        }

        //T extends Number，get Min
        public static <T extends Number>T  Minimum(T[][] array){

            T min = array[0][0];
            for (T[] tickRow : array)
                for (T tickColumn : tickRow)
                    if (min.doubleValue() > tickColumn.doubleValue())
                        min = tickColumn;

            return min;
        }

        //T extends Number，get Avg
        public static <T extends Number>T Average(T[][] array, int whichRow){
            double total = 0;
            for (int i = 0; i < array[0].length; i++) {
                total += array[whichRow][i].doubleValue();
            }

            double avg = total/array[0].length;
            return (T) new Double(avg);
        }
    }

}


