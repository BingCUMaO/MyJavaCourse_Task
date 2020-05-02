package B_independent_practice;


/**
 * 7.8.3 独立实践
 * <p>
 * 4、获取对象的副本
 * <p>
 * （1）在Point类中，定义如下两个方法：
 * distanceTo方法返回当前点到that点的距离
 * copy方法将当前点的副本返回。
 * <p>
 * public double distanceTo(Point that)
 * <p>
 * public Point copy()
 * <p>
 * （2）编写程序，测试Point对象的distanceTo和copy方法
 */
public class Exercise_4 {
    public static void main(String[] args) {
        Point p1 = new Point(10, 30);
        Point p2 = new Point(50, 330);

        System.out.println(p1.distanceTo(p2));

        p1 = p2.copy();
        System.out.println(p1.distanceTo(p2));
    }

    private static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Point that) {
            return Math.sqrt(Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2));
        }

        public Point copy(){
            return new Point(this.x, this.y);
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }


}


