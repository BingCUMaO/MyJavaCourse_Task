package B_independent_practice;



/**
 * 7.8.3 独立实践
 * <p>
 * 3、放大圆的副本
 *
 * 修改2中放大圆的方法，使该方法将参数指定的圆对象的副本
 * 放大指定量，并将放大的副本返回，不修改原始圆的对象
 */
public class Exercise_3 {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c.getArea());

        c= c.magnify(5);
        System.out.println(c.getArea());
    }

    private static class Circle {
        private static final double PI = 3.14159265358979;
        private double radius;

        public Circle(double radius){
            this.radius = radius;
        }

        /**
         *  放大圆
         * @param factor 负载因子
         */
        public Circle magnify(int factor){
            return new Circle(radius * factor);
        }

        public double getArea(){
            return PI * Math.pow(radius, 2);
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }

        public double getDiameter() {
            return radius*2;
        }

        public void setDiameter(double diameter) {
            this.radius = diameter / 2;
        }
    }


}


