package B_independent_practice;


/**
 * 7.4.5 独立实践
 *
 * 1、定义圆类（版本3）
 *
 * 声明一个圆类，除可读写属性之外，附加一个可读写属性直径，
 * 使用该类计算圆的面积。
 *
 * 编写测试程序，创建圆的对象aCircle，修改aCircle圆的半径值，
 * 计算aCircle圆的面积，并输出aCircle直径属性的值。再修改aCircle
 * 圆的直接的值，计算aCircle圆的面积，并输出aCircle圆的半径属性
 * 的值。
 *
 */
public class Exercise_1 {
    public static void main(String[] args) {
        Circle aCircle = new Circle(5);
        System.out.println(aCircle.getArea());
        System.out.println(aCircle.getDiameter());

        aCircle.setDiameter(20);
        System.out.println(aCircle.getArea());
        System.out.println(aCircle.getRadius());
    }



    private static class Circle {
        private static final double PI = 3.14159265358979;
        private double radius;
        private double diameter;

        public Circle(double radius){
            this.radius = radius;
            this.diameter = radius * 2;
        }

        public double getArea(){
            return PI * Math.pow(radius, 2);
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
            this.diameter = radius * 2;
        }

        public double getDiameter() {
            return diameter;
        }

        public void setDiameter(double diameter) {
            this.diameter = diameter;
            this.radius = diameter / 2;
        }
    }

}


