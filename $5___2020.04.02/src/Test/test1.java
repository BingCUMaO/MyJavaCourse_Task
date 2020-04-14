package Test;

import java.util.Arrays;
import java.util.stream.Collectors;

import static java.lang.Math.sqrt;

public class test1 {
    public static void main(String[] args) {
        //test int[] getPrimes(int numOfPrimes)
        Utils<Integer> utils1 = new Utils<Integer>();
        int[] primes = utils1.getPrimes(10);
        for (int tick : primes) {
            System.out.print(tick+"\t");
        }
        System.out.println();

        System.out.println("-------------------------------------------");

        //test void printPrimeByNum(int maxQuantity, int columnOfPrint)
        Utils<Integer> utils2 = new Utils<Integer>();
        Integer[] arr =   Arrays.stream(utils2.getPrimes(10)).boxed().toArray(Integer[]::new);
        String[] sts = utils2.getPrimeRows(arr, 3);
        for (int i = 0; i < sts.length; i++) {
            System.out.println(sts[i]);
        }
        
        
    }

    static class Utils<T>{
        private static final String TAB = "\t\t\t";
        private static final String CRLF = "\r\n";

        public Utils(){}

        public  String[] getPrimeRows(T[] array, int row){
            int column = (array.length % row == 0) ? (array.length / row) : (array.length / row + 1);

            StringBuilder sb = new StringBuilder();

            int crlfTag = 1;
            for (int tick = 0; tick < array.length; tick++) {
                sb.append(array[tick] + TAB);

                //加个换行
                if (crlfTag % column == 0) {
                    sb.append(CRLF);
                }
                crlfTag++;
            }

            sb.append(CRLF);
            return sb.toString().split(TAB+CRLF);
        }

//        public static String getPrimeRows(int numOfPrimes, int row){
//            int[] primes = getPrimes(numOfPrimes);
//            int column = (primes.length % row == 0) ? (primes.length / row) : (primes.length / row + 1);
//
//            StringBuilder sb = new StringBuilder();
//
//            int crlfTag = 1;
//            for (int tick = 0; tick < primes.length; tick++) {
//                sb.append(primes[tick] + TAB);
//
//                //加个换行
//                if (crlfTag % column == 0) {
//                    sb.append(CRLF);
//                }
//                crlfTag++;
//            }
//
//            return sb.toString();
//        }

        public int[] getPrimes(int numOfPrimes){
            if (numOfPrimes <= 1) {
                throw new NumberFormatException();
            }

            int[] result = new int[numOfPrimes];

            int testNum = 2;
            for (int tick = 0; tick < result.length; tick++) {
                while (!arePrime(testNum)) {
                    testNum += 2;
                }

                result[tick] = testNum;

                if (testNum == 2) {
                    testNum++;
                } else {
                    testNum += 2;
                }


            }

            return result;
        }

//        public static int[] getPrimes(int numOfPrimes){
//            if (numOfPrimes <= 1) {
//                throw new NumberFormatException();
//            }
//
//            int[] result = new int[numOfPrimes];
//
//            int testNum = 2;
//            for (int tick = 0; tick < result.length; tick++) {
//
//                //每次自增1，然后交给while去判断
//                //如果不是质数，testNum就自增到是质数为止
//                while (!arePrime(testNum)) {
//                    testNum ++;
//                }
//
//                //将找到的质数添加到int[] 数组
//                result[tick] = testNum;
//
//                //testNum自增1，继续找质数，直到将int[] 数组填满
//                testNum++;
//            }
//
//            return result;
//        }

        public boolean arePrime(int num)
        {

            if(2 == num) return true;   //2是质数
            if(num < 2 || 0 == num%2) return false;      //小于2的数和偶数都是非质数

            int maxEqualNum = (int)sqrt(num);     //减少for循环的时间复杂度

            //tick初始为2，自增量为2
            // 因为上面已经排除了偶数的可能性，所以不必重复判断偶数
            for(int tick = 3; tick <= maxEqualNum; tick += 2)
                if(0 == num%tick)
                    return false;

            return true;
        }


    }
}



