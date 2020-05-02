package B_independent_practice;



/**
 * 7.8.3 独立实践
 * <p>
 * 1、反转数组
 *
 * 修改5.2.3 小节独立实践“3. 销售额分析（版本2）”中的
 * MyArray类，在MyArray类中声明一个方法，该方法将
 * MyArray类的array数组的副本的元素反转并返回。
 *
 * 并编写测试程序。
 */
public class Exercise_1 {
    public static void main(String[] args) {
        double[] arr = {10, 20, 30, 40, 50};
        MyArray ma = new MyArray(arr);

        ma.reverse();
        for (double tick : ma.getArray()) {
            System.out.println(tick);
        }
    }

    private static class MyArray{
        private double[] array;

        public MyArray(double[] arr){
            array = arr.clone();
        }

        public double[] arr(int start, int end) {
            if(start>=end) return null;

            double[] partArr = new double[end - start];
            for (int tick = start; tick < end; tick++) {
                partArr[tick-start] = array[tick];
            }

            return partArr;
        }

        public MyArray reverse(){
            double temp;
            for (int i = 0; i < array.length / 2; i++) {
                temp = array[i];
                array[i] = array[array.length - 1 - i];
                array[array.length - 1 - i] = temp;
            }
            return this;
        }

        public double[] getArray() {
            return array;
        }
    }


}


