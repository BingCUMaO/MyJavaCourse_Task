package B_project_training;


/**
 * 6.10 项目实战
 *
 * 1、计算三角形面积
 *
 * 创建一个MyTriangle 类，包含如下两个方法：
 *
 * //如果两边之和大于第三遍，则返回true
 * public static boolean IsValid(double side1,double side2,double side3)
 * //返回该三角形的面积
 * public static double Area(double side1, double side2, double side3)
 *
 * 面积计算公式如下：
 *          s = (side1+side2+side3)/2
 *          面积 = sqrt(  s*(s-side1)*(s-side2)*(s-side3)  )
 *
 *  编写一个测试程序，读入三角形三边的值，若输入有效，则计算并
 *  输出面积，否则显示输入无效
 *
 */
public class Exercise_1 {
    public static void main(String[] args) {
        System.out.println(MyTriangle.areValid(3, 3, 3));
        System.out.println(MyTriangle.area(3, 3, 3));
    }


    private static class MyTriangle{
        public MyTriangle(){
        }

        public static boolean areValid(double side1, double side2, double side3) {
            return (side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1);
        }

        public static double area(double side1, double side2, double side3){
            double s = (side1 + side2 + side3) / 2;
            double area = Math.sqrt(  s * (s - side1) * (s - side2) * (s - side3)  );

            return area;
        }


    }

}


