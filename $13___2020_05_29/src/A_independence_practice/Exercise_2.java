package A_independence_practice;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Exercise_2 {

    private static class Test01{
        public static void main(String[] args) {
            ShapeDraw dw = new ShapeDraw("DRAW WINDOW-----01");
            dw.setVisible(true);

            Shape[] shapes = new Shape[4];
            shapes[0] = new Line(100, 100, 200, 200);
            shapes[1] = new Rectangle(111, 20, 100, 100);
            shapes[2] = new Circle(400, 500, 200);
            shapes[3] = new Ellipse(600, 500, 200, 300);



            for (Shape s : shapes) {
//                s.draw(dw.getDrawingBoardGraphics());
                dw.draw(s);
                System.out.println("draw shapes...");
            }

        }
    }

    private static class Test02{
        public static void main(String[] args) {
            ShapeDraw dw = new ShapeDraw("DRAW WINDOW-----02");
            dw.setVisible(true);
        }
    }


    private static class ShapeDraw extends JFrame {
        /**
         * 为什么要添加这个manager呢？
         * 因为每次调用完draw方法后，JFrame都会对这个页面进行刷新，
         * 为了使得JFrame能够不断记录之前的所画的所有图形，然后在
         * 重写的paint方法里显示地轮询之前所画的所有Shape。
         *
         * 添加这个属性主要是为了Test01，如果不记录所画的Shape，每次Test01中
         * Shape[] 调用完所有的draw方法后或者改变窗口页面大小时，都会对整个页
         * 面进行刷新。就会把之前画的图形都给清理掉，而我们不想这样。
         */
        private ArrayList<Shape> shapesLog = new ArrayList<Shape>();

        private static final int COLUMN = 10;
        private static final String ERROR_MSG_OUT_LIMIT = "Please input the correct number format!";
        private static final String ERROR_MSG_UNKNOW_CHARACTER = "Contain unknow character!";

        private JLabel labelLine;
        private JLabel labelLine_x1;
        private JLabel labelLine_x2;
        private JLabel labelLine_y1;
        private JLabel labelLine_y2;
        private JLabel labelRectangle;
        private JLabel labelRectangle_x;
        private JLabel labelRectangle_y;
        private JLabel labelRectangle_width;
        private JLabel labelRectangle_height;
        private JLabel labelCircle;
        private JLabel labelCircle_x;
        private JLabel labelCircle_y;
        private JLabel labelCircle_diameter;
        private JLabel labelEllipse;
        private JLabel labelEllipse_x;
        private JLabel labelEllipse_y;
        private JLabel labelEllipse_width;
        private JLabel labelEllipse_height;

        private JTextField tfLine_x1;
        private JTextField tfLine_x2;
        private JTextField tfLine_y1;
        private JTextField tfLine_y2;
        private JTextField tfRectangle_x;
        private JTextField tfRectangle_y;
        private JTextField tfRectangle_width;
        private JTextField tfRectangle_height;
        private JTextField tfCircle_x;
        private JTextField tfCircle_y;
        private JTextField tfCircle_diameter;
        private JTextField tfEllipse;
        private JTextField tfEllipse_x;
        private JTextField tfEllipse_y;
        private JTextField tfEllipse_width;
        private JTextField tfEllipse_height;

        private JButton drawLineButton;
        private JButton drawRectangleButton;
        private JButton drawCircleButton;
        private JButton drawEllipseButton;

        private JPanel drawingBoardPanel;
        private JTextField tfAlert;



        {
            initProperties();
            initPanelLayout();
            registerEventHandler();
            initSettings();
            System.out.println("initing");
        }

        public ShapeDraw(String title) throws HeadlessException {
            super(title);
        }

        private void initSettings(){
//            this.setSize(600, 500);
//            this.setResizable(false);
//            this.setLocationRelativeTo(null);
//            this.setLayout(new FlowLayout());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.pack();
        }

        private void initProperties(){
            labelLine = new JLabel("Line：");
            labelLine_x1 = new JLabel("x1：");
            labelLine_x2 = new JLabel("x2：");
            labelLine_y1 = new JLabel("y1：");
            labelLine_y2 = new JLabel("y2：");
            labelRectangle = new JLabel("Rectangle：");
            labelRectangle_x = new JLabel("x： ");
            labelRectangle_y = new JLabel("y： ");
            labelRectangle_width = new JLabel("width：");
            labelRectangle_height = new JLabel("height：");
            labelCircle = new JLabel("Circle：");
            labelCircle_x = new JLabel("x：");
            labelCircle_y = new JLabel("y：");
            labelCircle_diameter = new JLabel("diameter：");
            labelEllipse = new JLabel("Ellipse：");
            labelEllipse_x = new JLabel("x：");
            labelEllipse_y = new JLabel("y：");
            labelEllipse_width = new JLabel("width：");
            labelEllipse_height = new JLabel("height：");

            tfLine_x1 = new JTextField();
            tfLine_x2 = new JTextField();
            tfLine_y1 = new JTextField();
            tfLine_y2 = new JTextField();
            tfRectangle_x = new JTextField();
            tfRectangle_y = new JTextField();
            tfRectangle_width = new JTextField();
            tfRectangle_height = new JTextField();
            tfCircle_x = new JTextField();
            tfCircle_y = new JTextField();
            tfCircle_diameter = new JTextField();
            tfEllipse = new JTextField();
            tfEllipse_x = new JTextField();
            tfEllipse_y = new JTextField();
            tfEllipse_width = new JTextField();
            tfEllipse_height = new JTextField();

            tfLine_x1.setColumns(COLUMN);
            tfLine_x2.setColumns(COLUMN);
            tfLine_y1.setColumns(COLUMN);
            tfLine_y2.setColumns(COLUMN);
            tfRectangle_x.setColumns(COLUMN);
            tfRectangle_y.setColumns(COLUMN);
            tfRectangle_width.setColumns(COLUMN);
            tfRectangle_height.setColumns(COLUMN);
            tfCircle_x.setColumns(COLUMN);
            tfCircle_y.setColumns(COLUMN);
            tfCircle_diameter.setColumns(COLUMN);
            tfEllipse.setColumns(COLUMN);
            tfEllipse_x.setColumns(COLUMN);
            tfEllipse_y.setColumns(COLUMN);
            tfEllipse_width.setColumns(COLUMN);
            tfEllipse_height.setColumns(COLUMN);

            drawLineButton = new JButton("Draw Line");
            drawRectangleButton = new JButton("Draw Rectangle");
            drawCircleButton = new JButton("Draw Circle");
            drawEllipseButton = new JButton("Draw Ellipse");

            tfAlert = new JTextField();
            tfAlert.setEditable(false);

            drawingBoardPanel = new JPanel();
            drawingBoardPanel.setPreferredSize(new Dimension(1000, 500));
            drawingBoardPanel.setBorder(BorderFactory.createMatteBorder(10, 40, 10, 40,Color.GRAY));
        }

        private void initPanelLayout(){
            JPanel panelLine = new JPanel(new GridLayout(0, 1, 10, 10));
            JPanel panelLine_x1 = new JPanel(new BorderLayout());
            panelLine_x1.add(labelLine_x1, BorderLayout.WEST);
            panelLine_x1.add(tfLine_x1, BorderLayout.EAST);
            JPanel panelLine_x2 = new JPanel(new BorderLayout());
            panelLine_x2.add(labelLine_x2, BorderLayout.WEST);
            panelLine_x2.add(tfLine_x2, BorderLayout.EAST);
            JPanel panelLine_y1 = new JPanel(new BorderLayout());
            panelLine_y1.add(labelLine_y1, BorderLayout.WEST);
            panelLine_y1.add(tfLine_y1, BorderLayout.EAST);
            JPanel panelLine_y2 = new JPanel(new BorderLayout());
            panelLine_y2.add(labelLine_y2, BorderLayout.WEST);
            panelLine_y2.add(tfLine_y2, BorderLayout.EAST);
            panelLine.add(labelLine);
            panelLine.add(panelLine_x1);
            panelLine.add(panelLine_y1);
            panelLine.add(panelLine_x2);
            panelLine.add(panelLine_y2);
            panelLine.add(drawLineButton);

            JPanel panelRectangle = new JPanel(new GridLayout(0, 1, 10, 10));
            JPanel panelRectangle_x = new JPanel(new BorderLayout());
            panelRectangle_x.add(labelRectangle_x, BorderLayout.WEST);
            panelRectangle_x.add(tfRectangle_x, BorderLayout.EAST);
            JPanel panelRectangle_y = new JPanel(new BorderLayout());
            panelRectangle_y.add(labelRectangle_y, BorderLayout.WEST);
            panelRectangle_y.add(tfRectangle_y, BorderLayout.EAST);
            JPanel panelRectangle_width = new JPanel(new BorderLayout());
            panelRectangle_width.add(labelRectangle_width, BorderLayout.WEST);
            panelRectangle_width.add(tfRectangle_width, BorderLayout.EAST);
            JPanel panelRectangle_height = new JPanel(new BorderLayout());
            panelRectangle_height.add(labelRectangle_height, BorderLayout.WEST);
            panelRectangle_height.add(tfRectangle_height, BorderLayout.EAST);
            panelRectangle.add(labelRectangle);
            panelRectangle.add(panelRectangle_x);
            panelRectangle.add(panelRectangle_y);
            panelRectangle.add(panelRectangle_width);
            panelRectangle.add(panelRectangle_height);
            panelRectangle.add(drawRectangleButton);

            JPanel panelCircle = new JPanel(new GridLayout(0, 1, 10, 10));
            JPanel panelCircle_x = new JPanel(new BorderLayout());
            panelCircle_x.add(labelCircle_x, BorderLayout.WEST);
            panelCircle_x.add(tfCircle_x, BorderLayout.EAST);
            JPanel panelCircle_y = new JPanel(new BorderLayout());
            panelCircle_y.add(labelCircle_y, BorderLayout.WEST);
            panelCircle_y.add(tfCircle_y, BorderLayout.EAST);
            JPanel panelCircle_diameter = new JPanel(new BorderLayout());
            panelCircle_diameter.add(labelCircle_diameter, BorderLayout.WEST);
            panelCircle_diameter.add(tfCircle_diameter, BorderLayout.EAST);
            panelCircle.add(labelCircle);
            panelCircle.add(panelCircle_x);
            panelCircle.add(panelCircle_y);
            panelCircle.add(panelCircle_diameter);
            panelCircle.add(drawCircleButton);

            JPanel panelEllipse = new JPanel(new GridLayout(0, 1, 10, 10));
            JPanel panelEllipse_x = new JPanel(new BorderLayout());
            panelEllipse_x.add(labelEllipse_x, BorderLayout.WEST);
            panelEllipse_x.add(tfEllipse_x, BorderLayout.EAST);
            JPanel panelEllipse_y = new JPanel(new BorderLayout());
            panelEllipse_y.add(labelEllipse_y, BorderLayout.WEST);
            panelEllipse_y.add(tfEllipse_y, BorderLayout.EAST);
            JPanel panelEllipse_width = new JPanel(new BorderLayout());
            panelEllipse_width.add(labelEllipse_width, BorderLayout.WEST);
            panelEllipse_width.add(tfEllipse_width, BorderLayout.EAST);
            JPanel panelEllipse_height = new JPanel(new BorderLayout());
            panelEllipse_height.add(labelEllipse_height, BorderLayout.WEST);
            panelEllipse_height.add(tfEllipse_height, BorderLayout.EAST);
            panelEllipse.add(labelEllipse);
            panelEllipse.add(panelEllipse_x);
            panelEllipse.add(panelEllipse_y);
            panelEllipse.add(panelEllipse_width);
            panelEllipse.add(panelEllipse_height);
            panelEllipse.add(drawEllipseButton);


            //开始整体布局
            JPanel panelTop = new JPanel(new BorderLayout());
            panelTop.add(drawingBoardPanel, BorderLayout.NORTH);
            panelTop.add(tfAlert, BorderLayout.SOUTH);

            JPanel panelBottom = new JPanel(new GridLayout(1, 4, 200, 20));
            panelBottom.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
            panelBottom.add(panelLine);
            panelBottom.add(panelRectangle);
            panelBottom.add(panelCircle);
            panelBottom.add(panelEllipse);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(panelTop, BorderLayout.NORTH);
            panel.add(panelBottom, BorderLayout.SOUTH);

            this.getContentPane().add(panel);
        }

        private void draw(Shape s){
            Graphics g = drawingBoardPanel.getGraphics();

            System.out.println("Drawing before");
            s.draw(g);
            shapesLog.add(s);
            System.out.println("Drawing after");
        }

        private void registerEventHandler(){
            Pattern patternCoordValue = Pattern.compile("[-]?\\d+");
            Pattern patternLengthValue = Pattern.compile("\\d+");
            Pattern patternContainChar = Pattern.compile(".*[^0-9].*");

            drawLineButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(patternContainChar.matcher(tfLine_x1.getText()).matches()
                            ||patternContainChar.matcher(tfLine_x2.getText()).matches()
                            ||patternContainChar.matcher(tfLine_y1.getText()).matches()
                            ||patternContainChar.matcher(tfLine_y2.getText()).matches()){
                        alert(ERROR_MSG_UNKNOW_CHARACTER);

                    }else{
                        if (patternCoordValue.matcher(tfLine_x1.getText()).matches()
                                &&patternCoordValue.matcher(tfLine_x2.getText()).matches()
                                &&patternCoordValue.matcher(tfLine_y1.getText()).matches()
                                &&patternCoordValue.matcher(tfLine_y2.getText()).matches()){

                            clearAlertMsg();

                            //Button的业务处理
                            Line line = new Line();
                            line.setX1(Integer.parseInt(tfLine_x1.getText()));
                            line.setX2(Integer.parseInt(tfLine_x2.getText()));
                            line.setY1(Integer.parseInt(tfLine_y1.getText()));
                            line.setY2(Integer.parseInt(tfLine_y2.getText()));
                            draw(line);

                        }else {
                            alert(ERROR_MSG_OUT_LIMIT);
                        }
                    }
                }
            });

            drawRectangleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(patternContainChar.matcher(tfRectangle_x.getText()).matches()
                            ||patternContainChar.matcher(tfRectangle_y.getText()).matches()
                            ||patternContainChar.matcher(tfRectangle_width.getText()).matches()
                            ||patternContainChar.matcher(tfRectangle_height.getText()).matches()){
                        alert(ERROR_MSG_UNKNOW_CHARACTER);

                    }else{
                        if (patternCoordValue.matcher(tfRectangle_x.getText()).matches()
                                &&patternCoordValue.matcher(tfRectangle_y.getText()).matches()
                                &&patternLengthValue.matcher(tfRectangle_width.getText()).matches()
                                &&patternLengthValue.matcher(tfRectangle_height.getText()).matches()){

                            clearAlertMsg();

                            //Button的业务处理
                            Rectangle rect = new Rectangle();
                            rect.setX(Integer.parseInt(tfRectangle_x.getText()));
                            rect.setY(Integer.parseInt(tfRectangle_y.getText()));
                            rect.setWidth(Integer.parseInt(tfRectangle_width.getText()));
                            rect.setHeight(Integer.parseInt(tfRectangle_height.getText()));
                            draw(rect);
                        }else {
                            alert(ERROR_MSG_OUT_LIMIT);
                        }
                    }
                }

            });

            drawCircleButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(patternContainChar.matcher(tfCircle_x.getText()).matches()
                            ||patternContainChar.matcher(tfCircle_y.getText()).matches()
                            ||patternContainChar.matcher(tfCircle_diameter.getText()).matches()){

                        alert(ERROR_MSG_UNKNOW_CHARACTER);


                    }else{
                        if (patternCoordValue.matcher(tfCircle_x.getText()).matches()
                                &&patternCoordValue.matcher(tfCircle_y.getText()).matches()
                                &&patternLengthValue.matcher(tfCircle_diameter.getText()).matches()){

                            clearAlertMsg();

                            //Button的业务处理
                            Circle circle = new Circle();
                            circle.setX(Integer.parseInt(tfCircle_x.getText()));
                            circle.setY(Integer.parseInt(tfCircle_y.getText()));
                            circle.setDiameter(Integer.parseInt(tfCircle_diameter.getText()));
                            draw(circle);

                        }else {
                            alert(ERROR_MSG_OUT_LIMIT);
                        }
                    }
                }

            });

            drawEllipseButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(patternContainChar.matcher(tfEllipse_x.getText()).matches()
                            ||patternContainChar.matcher(tfEllipse_y.getText()).matches()
                            ||patternContainChar.matcher(tfEllipse_width.getText()).matches()
                            ||patternContainChar.matcher(tfEllipse_height.getText()).matches()){

                        alert(ERROR_MSG_UNKNOW_CHARACTER);

                    }else{
                        if (patternCoordValue.matcher(tfEllipse_x.getText()).matches()
                                &&patternCoordValue.matcher(tfEllipse_y.getText()).matches()
                                &&patternLengthValue.matcher(tfEllipse_width.getText()).matches()
                                &&patternLengthValue.matcher(tfEllipse_height.getText()).matches()){

                            clearAlertMsg();

                            //Button的业务处理
                            Ellipse ellipse = new Ellipse();
                            ellipse.setX(Integer.parseInt(tfEllipse_x.getText()));
                            ellipse.setY(Integer.parseInt(tfEllipse_x.getText()));
                            ellipse.setWidth(Integer.parseInt(tfEllipse_width.getText()));
                            ellipse.setHeight(Integer.parseInt(tfEllipse_height.getText()));
                            draw(ellipse);

                        }else {
                            alert(ERROR_MSG_OUT_LIMIT);
                        }
                    }
                }
            });
        }

        private void  alert(String errMsg) {
            tfAlert.setText(errMsg);
        }

        private void  clearAlertMsg(){
            tfAlert.setText("");
        }


        public Graphics getDrawingBoardGraphics() {
            return this.drawingBoardPanel.getGraphics();
        }

        /**
         * 重写paint方法，每次页面进行自动刷新时，都重新读log中的shape进行重绘。
         * @param g 当前JFrame的画笔
         */
        @Override
        public void paint(Graphics g) {
            super.paint(g);
            for (Shape s : shapesLog) {
                s.draw(this.drawingBoardPanel.getGraphics());
            }
            System.out.println("Override paint method");
        }

    }











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
