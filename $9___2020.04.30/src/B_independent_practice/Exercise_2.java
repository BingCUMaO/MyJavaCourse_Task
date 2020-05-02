package B_independent_practice;



/**
 * 7.8.3 独立实践
 * <p>
 * 2、放大圆
 *
 * 在以前定义的圆类中，添加一个方法成员，该方法将参数
 * 指定的圆放大指定的量
 * （将圆放大指定的量是指将圆的半径增加指定的量）
 */
public class Exercise_2 {
    public static void main(String[] args) {
        Circle c = new Circle(3);
        System.out.println(c.getArea());

        c.magnify(5);
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
        public void magnify(int factor){
            radius *= factor;
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


