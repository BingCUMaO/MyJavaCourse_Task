package B_independent_practice;


/**
 * 7.8.3 独立实践
 * <p>
 * 7、完成如下方法
 * <p>
 * //@param original
 * //@param newLength
 * //@return public static int[] copyOf(int[] original, int newLength) {
 * //.......
 * //}
 * <p>
 * 其中：original表示源数组
 * newLength表示要复制的长度
 */
public class Exercise_7 {
    public static void main(String[] args) {
        int[] arr1 = {10, 20, 30};
        int[] arr2 = copyOf(arr1, 2);

        for (int tick : arr2) {
            System.out.println(tick);
        }
    }

    /**
     * @param original  源数组
     * @param newLength 新数组返回的长度
     * @return
     */
    public static int[] copyOf(int[] original, int newLength) {
        if (original.length < newLength)
            throw new IndexOutOfBoundsException("ParamNewLengthIndexOutOfBoundsException");

        int[] newArr = new int[newLength];
        for (int i = 0; i < newLength; i++) {
            newArr[i] = original[i];
        }

        return newArr;
    }
}


