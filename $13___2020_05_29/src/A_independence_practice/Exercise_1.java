package A_independence_practice;


import java.awt.*;

/**
 * 独立实践 9.2.3
 *
 * （1）创建绘制图形的一些类，Shape是所有图形的基类，它提供抽象
 * 方法draw(Graphics g) 绘制图形，直线(Line)、矩形(Rectangle)、圆(Circle)、
 * 椭圆类(Ellipse) 继承Shape类，实现抽象方法draw 绘制直线、矩形、圆、椭
 * 圆。创建Shape、Line、Rectangle、Circle、Ellipse类。
 */
public class Exercise_1 {
    private static abstract class Shape{
        public abstract void draw(Graphics g);
    }



    private static class Line extends Shape {
        private int x1;
        private int y1;
        private int x2;
        private int y2;

        public Line() {
        }

        public Line(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public void draw(Graphics g) {
            g.drawLine(x1, y1, x2, y2);
        }

        public int getX1() {
            return x1;
        }

        public void setX1(int x1) {
            this.x1 = x1;
        }

        public int getY1() {
            return y1;
        }

        public void setY1(int y1) {
            this.y1 = y1;
        }

        public int getX2() {
            return x2;
        }

        public void setX2(int x2) {
            this.x2 = x2;
        }

        public int getY2() {
            return y2;
        }

        public void setY2(int y2) {
            this.y2 = y2;
        }
    }

    private static class Rectangle extends Shape {
        private int x;
        private int y;
        private int width;
        private int height;

        public Rectangle() {
        }

        /**
         *
         * @param x 矩形左上角点的横坐标
         * @param y 矩形左上角点的纵坐标
         * @param width
         * @param height
         */
        public Rectangle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            g.drawRect(x, y, width, height);
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

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }

    private static class Circle extends Shape {
        private int x;
        private int y;
        private int diameter;

        public Circle() {
        }

        /**
         *
         * @param x 圆心的横坐标
         * @param y 圆心的纵坐标
         * @param diameter 直径
         */
        public Circle(int x, int y, int diameter) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
        }

        @Override
        public void draw(Graphics g) {
            g.drawOval(x-diameter/2, y-diameter/2, diameter, diameter);
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

        public int getDiameter() {
            return diameter;
        }

        public void setDiameter(int diameter) {
            this.diameter = diameter;
        }
    }

    private static class Ellipse extends Shape {
        private int x;
        private int y;
        private int width;
        private int height;

        public Ellipse() {
        }

        /**
         *
         * @param x 椭圆两焦点间中点的横坐标
         * @param y 椭圆两焦点间中点的纵坐标
         * @param width 椭圆的整体宽度
         * @param height 椭圆的整体高度
         */
        public Ellipse(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        @Override
        public void draw(Graphics g) {
            g.drawOval(x-width/2, y-height/2, width, height);
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

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }
    }
}
