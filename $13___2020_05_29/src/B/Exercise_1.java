package B;


/**
 * 1、比较对象（1）
 *
 * 假设要求设计一个比较两个对象大小的一般方法。对象可以是同一类型的
 * 矩形对象、圆的对象、圆柱对象。因为不同类型对象的比较方法是不同的。
 * 矩形对象和矩形对象矩形比较可以用它们的面积矩形比较，一个圆的对象
 * 和另一个圆的对象进行比较可以用它们的半径进行比较，一个圆柱对象和
 * 另一个圆柱对象矩形比较可以用它们的提及进行比较。
 * 可以用接口定义一个一般的方法CompareTo，如下所示：
 * interface Comparable{
 *     double compareTo(Object obj)
 * }
 *
 * compareTo方法比较当前实例与同一类型的另一对obj的大小。如果当前实例
 * 小于、等于、大于对象obj时，该方法分别返回负整数、0、正整数。
 * comparable接口是类库的接口，定义在java.lang包中。
 *
 * 修改任务9.2中的矩形、圆和圆柱类，让它们都实现comparable接口，以便能够将
 * 当前实例与同一类型的另一对象进行比较。并编写测试程序，比较同一类型
 * 的矩形对象（面积大的矩形大）、圆的对象（面积大的圆大）、圆柱对象的
 * 大小（体积大的圆柱大）。
 */
public class Exercise_1 {
    private static class Test{
        public static void main(String[] args) {
            Rectangle rect01 = new Rectangle(10, 20);
            Rectangle rect02 = new Rectangle(10, 20);
            Circle circle01 = new Circle(40);
            Circle circle02 = new Circle(50);
            Cylinder cylinder01 = new Cylinder(2500, 30);
            Cylinder cylinder02 = new Cylinder(25, 30);

            System.out.println(rect01.compareTo(rect02));
            System.out.println(circle01.compareTo(circle02));
            System.out.println(cylinder01.compareTo(cylinder02));
        }
    }

    private static abstract class Shape{
        abstract public String getName();
        abstract public double getArea();
    }

    private static abstract class TwoDimensionalShape extends Shape{
        abstract public double getCircumference();
    }

    private static abstract class ThreeDimensionalShape  extends Shape{
        abstract public double getVolume();
    }

    private static class Rectangle extends TwoDimensionalShape implements Comparable{
        private String name;
        private double width;
        private double height;

        {
            name = "Rectangle";
        }

        public Rectangle() {
        }

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getCircumference() {
            return 2*(width+height);
        }

        @Override
        public double getArea(){
            return width * height;
        }


        @Override
        public int compareTo(Object o) {
            return this.getArea()==((Rectangle)o).getArea()?0: this.getArea() < ((Rectangle) o).getArea() ? -1 : 1;
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            this.height = height;
        }
    }

    private static class Circle extends TwoDimensionalShape implements Comparable{
        public static final double PI = 3.14159265358979;

        private String name;
        private double diameter;

        {
            name = "Circle";
        }

        public Circle() {
        }

        public Circle(double diameter) {
            this.diameter = diameter;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public double getCircumference() {
            return PI * diameter;
        }

        @Override
        public double getArea(){
            return PI * Math.pow(diameter / 2, 2);
        }

        @Override
        public int compareTo(Object obj) {
            return this.diameter == ((Circle) obj).diameter ? 0 : this.diameter < ((Circle) obj).diameter ? -1 : 1;
        }

        public double getDiameter() {
            return diameter;
        }

        public void setDiameter(double diameter) {
            this.diameter = diameter;
        }
    }

    private static class Cylinder extends ThreeDimensionalShape  implements Comparable{
        public static final double PI = 3.14159265358979;

        private String name;
        private double diameter;
        private double height;

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
            return this.getVolume() == ((Cylinder) o).getVolume() ? 0 : this.getVolume() < ((Cylinder) o).getVolume() ? -1 : 1;
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
