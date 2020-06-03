package B;

/**
 * 2、比较对象（2）
 *
 * 为了让用户指定比较的算法，声明如下接口
 * public interface Comparator{
 *     public boolean compare(Object obj1, Object obj2);
 * }
 *
 * 接口的compare方法比较同一类型的两个对象obj1和obj2的大小。
 * 如果obj1实例小于、大于、大于对象obj2时，该方法分别返回负
 * 整数、0和正整数。
 *
 * 修改比较对象（1）中的圆柱类，给该类添加一个Comparator类
 * 型的属性comparator。
 * 要求：（1）使用comparator让它能够将当前圆柱实例与另一圆柱对象进行比较。
 *            （2）使用comparator让它能够将一个圆柱对象与另一圆柱对象进行比较。
 *
 *  编写测试程序，以便能够将当前实例与另一对象进行比较和将两个圆柱对象进行
 *  比较（比较圆柱对象的大小时，选择体积大的圆柱大或半径大的圆柱大或高大的
 *  圆柱大）
 */
public class Exercise_2 {
    private static class Test{
        public static void main(String[] args) {
            //Use default comparison algorithm：Volume
            Cylinder cylinder01 = new Cylinder(20, 30);
            Cylinder cylinder02 = new Cylinder(50, 30);
            System.out.println("小于："+cylinder01.compareTo(cylinder02));


            //Use custom comparison algorithm：Height
            Cylinder.setComparator(new Comparator() {
                @Override
                public int compare(Object obj1, Object obj2) {
                    return ((Cylinder) obj1).getHeight() == ((Cylinder) obj2).getHeight() ? 0 : ((Cylinder) obj1).getHeight() == ((Cylinder) obj2).getHeight() ? -1 : 1;
                }
            });
            System.out.println("等于："+cylinder01.compareTo(cylinder02));
            System.out.println("等于："+Cylinder.compareTo(cylinder01,cylinder02));
        }
    }

    private static abstract class Shape{
        abstract public String getName();
        abstract public double getArea();
    }

    private static abstract class ThreeDimensionalShape  extends Shape {
        abstract public double getVolume();
    }

    private interface Comparator{
        public int compare(Object obj1, Object obj2);
    }

    private static class Cylinder extends ThreeDimensionalShape implements Comparable{
        public static final double PI = 3.14159265358979;
        private static Comparator comparatorStatic;     //comparison algorithm

        private String name;
        private double diameter;
        private double height;

        static {
            //default static comparison algorithm
            comparatorStatic = new Comparator() {
                @Override
                public int compare(Object obj1, Object obj2) {
                    return ((Cylinder) obj1).getVolume() == ((Cylinder) obj2).getVolume() ? 0 : ((Cylinder) obj1).getVolume() == ((Cylinder) obj2).getVolume() ? -1 : 1;
                }
            };
        }

        {
            name = "Cylinder";
        }

        public Cylinder() {
        }

        public Cylinder(double diameter, double height) {
            this.diameter = diameter;
            this.height = height;
        }

        public void setName(String name) {
            this.name = name;
        }

        public static void setComparator(Comparator comparable) {
            Cylinder.comparatorStatic = comparable;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getArea() {
            return 2*PI * Math.pow(diameter / 2, 2)+diameter*PI*height;
        }

        @Override
        public double getVolume(){
            return PI * Math.pow(diameter / 2, 2) * height;
        }

        @Override
        public int compareTo(Object o) {
//            return this.getVolume() == ((Cylinder) o).getVolume() ? 0 : this.getVolume() < ((Cylinder) o).getVolume() ? -1 : 1;
            return comparatorStatic.compare(this, o);
        }

        public static int compareTo(Object obj1, Object obj2) {
            return comparatorStatic.compare(obj1, obj2);
        }

        public double getDiameter() {
            return diameter;
        }

        public void setDiameter(double diameter) {
            this.diameter = diameter;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }
    }

}
