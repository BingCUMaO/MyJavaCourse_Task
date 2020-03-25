package A_independent_practice;

/**
 *  3.5.4 独立实践
 *
 *  1、计算矩形面积（版本1）
 *
 *  创建矩形Rectangle，使用该类计算特定矩形的面积。
 */
public class Exercise_1 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10.0, 20.0);
        System.out.println(rect.getArea());
    }

    static class Rectangle{
        private double width;
        private double height;

        public Rectangle(double width,double height){
            this.width = width;
            this.height = height;
        }

        public double getArea(){
            return width*height;
        }
    }
}


