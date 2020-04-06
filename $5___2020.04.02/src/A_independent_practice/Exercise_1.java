package A_independent_practice;

import static java.lang.Math.sqrt;

/**
 * 4.9.2 独立实践
 *
 * 1、打印素数
 *
 */
public class Exercise_1 {
    public static void main(String[] args) {
        Prime.printPrimeByNum(50,10);
    }

    static class Prime{
        private static final String TAB = "\t\t\t";

        public Prime(){}

        /**
         *
         * @param biggestLimitNum 所输出的素数能达到的最大值界限
         * @param columnOfPrint 打印的列数
         */
        public static void printPrimeByLimit(int biggestLimitNum, int columnOfPrint){
            int printlnTag = 0;     //换行标识符
            for(int foo = 2;foo<=biggestLimitNum;foo++){
                if (arePrime(foo)) {
                    System.out.print(foo + TAB);

                    //换行
                    printlnTag++;
                    if(0 == printlnTag%columnOfPrint)
                        System.out.println();
                }
            }
        }

        /**
         *
         * @param maxQuantity 所输出的素数的个数
         * @param columnOfPrint 打印的列数
         */
        public static void printPrimeByNum(int maxQuantity, int columnOfPrint){
            int printlnTag = 0;     //换行标识符

            for (int foo = 1;true; foo++){
                if (arePrime(foo)) {
                    System.out.print(foo + TAB);

                    //换行
                    printlnTag++;
                    if(0 == printlnTag%columnOfPrint)
                        System.out.println();

                    //如果tag的值自增到maxQuantity，是时候结束了
                    if(printlnTag==maxQuantity)
                        return;
                }
            }
        }

        public static boolean arePrime(int num)
        {

            if(num < 2 || 0 == num%2) return false;      //小于2的数和偶数都是非质数
            if(2 == num) return true;   //2是质数

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


