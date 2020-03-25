package A_independent_practice;

/**
 * 3.5.4 独立实践
 * <p>
 * 2、计算矩形面积（版本2）
 * <p>
 * 修改版本1中的Rectangle类，将描述属性的每个字段声明为private，
 * 为每个字段增加set和get方法以给字段赋值和读取字段的值。使用
 * 修改后的Rectable类计算特定矩形的面积
 */
public class Exercise_2 {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(10, 20);
        System.out.println(rect.getArea());
    }

    static class Rectangle {
        private double width;
        private double height;

        public Rectangle(double width, double height) {
            setWidth(width);
            setHeight(height);
        }

        public double getWidth() {
            return width;
        }

        public void setWidth(double width) {
            if (width >= 0)
                this.width = width;
            else
                this.width = 0;
        }

        public double getHeight() {
            return height;
        }

        public void setHeight(double height) {
            if (height >= 0)
                this.height = height;
            else
                this.height = 0;
        }

        public double getArea() {
            return width * height;
        }
    }
}


