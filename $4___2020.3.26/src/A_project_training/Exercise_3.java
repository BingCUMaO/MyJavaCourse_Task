package A_project_training;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 4.4.3 项目实战
 * <p>
 * 3、创建如图4.11（a）、（b） 所示的三个窗体。
 * 【样式见3.png】
 */
public class Exercise_3 {
    public static void main(String[] args) {
        CalcComplexNumber ccn = new CalcComplexNumber("复数计算程序");
        ccn.setVisible(true);

        Calculator cltr = new Calculator("计算器");
        cltr.setVisible(true);

    }

    private static class CalcComplexNumber extends JFrame {
        private static final int COLUMN = 20;
        private static boolean areAdding = true;        //用于“+”、“-” button
        private static String operator = "+";

        private static String realPart1 = "";
        private static String realPart2 = "";
        private static String imaginaryPart1 = "";
        private static String imaginaryPart2 = "";

        //RegEx
        private static String numRegex = "^-?\\d+$|^-?\\d+[.]\\d+$";
        private static String positionNumRegex = "^\\d+$|^\\d+[.]\\d+$";
        private static Pattern numPattern = Pattern.compile(numRegex);
        private static Pattern positionNumPattern = Pattern.compile(positionNumRegex);

        private JLabel realPartLabel;
        private JLabel imaginaryPartLabel;

        private JTextField realPartTextField;
        private JTextField imaginaryPartTextField;

        private JTextField outputTextField;

        private JButton settingNumButton_1;
        private JButton settingNumButton_2;
        private JButton operatorAddButton;
        private JButton operatorSubButton;

        public CalcComplexNumber(String title) {
            init();
            layoutPanels();
            registerEventHandler();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }

        private void init() {
            realPartLabel = new JLabel("实部");
            imaginaryPartLabel = new JLabel("虚部");

            realPartTextField = new JTextField();
            imaginaryPartTextField = new JTextField();

            outputTextField = new JTextField();

            settingNumButton_1 = new JButton("设置第一个复数");
            settingNumButton_2 = new JButton("设置第二个复数");
            operatorAddButton = new JButton("+");
            operatorSubButton = new JButton("-");

            realPartLabel.setHorizontalAlignment(JLabel.RIGHT);
            imaginaryPartLabel.setHorizontalAlignment(JLabel.RIGHT);
            realPartTextField.setColumns(COLUMN);
            imaginaryPartTextField.setColumns(COLUMN);
            outputTextField.setEditable(false);
            outputTextField.setColumns(COLUMN);
        }

        private void layoutPanels() {
            JPanel topPanel = new JPanel(new GridLayout(2, 3, 20, 20));
            topPanel.add(realPartLabel);
            topPanel.add(realPartTextField);
            topPanel.add(settingNumButton_1);
            topPanel.add(imaginaryPartLabel);
            topPanel.add(imaginaryPartTextField);
            topPanel.add(settingNumButton_2);


            JPanel middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            middlePanel.add(operatorAddButton);
            middlePanel.add(operatorSubButton);

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            bottomPanel.add(outputTextField);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            panel.add(topPanel, BorderLayout.PAGE_START);
            panel.add(middlePanel, BorderLayout.CENTER);
            panel.add(bottomPanel, BorderLayout.PAGE_END);

            this.getContentPane().add(panel);
        }

        /**
         * Register event for buttons
         */
        private void registerEventHandler() {
            settingNumButton_1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String realInput = realPartTextField.getText();
                    String imagInput = imaginaryPartTextField.getText();

                    Matcher realPMatcher = numPattern.matcher(realInput);
                    Matcher imagPMatcher = numPattern.matcher(imagInput);

                    if (realPMatcher.matches() && imagPMatcher.matches()) {
                        realPart1 = realInput;
                        imaginaryPart1 = imagInput;
                        outputTextField.setText(getOutputStr());
                    }
                }
            });

            settingNumButton_2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String realInput = realPartTextField.getText();
                    String imagInput = imaginaryPartTextField.getText();

                    Matcher realPMatcher = numPattern.matcher(realInput);
                    Matcher imagPMatcher = numPattern.matcher(imagInput);

                    if (realPMatcher.matches() && imagPMatcher.matches()) {
                        realPart2 = realInput;
                        imaginaryPart2 = imagInput;
                        outputTextField.setText(getOutputStr());
                    }
                }
            });

            operatorSubButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    areAdding = false;
                    operator = "-";
                }
            });
        }

        private String getOutputStr() {
            StringBuilder expression1;
            StringBuilder expression2;
            String operator = "+";

            if (positionNumPattern.matcher(imaginaryPart1).matches()) {
                expression1 = new StringBuilder(realPart1 + "+" + imaginaryPart1);
            } else {
                expression1 = new StringBuilder(realPart1 + imaginaryPart1);
            }
            if (positionNumPattern.matcher(imaginaryPart2).matches()) {
                expression2 = new StringBuilder(realPart2 + "+" + imaginaryPart2);
            } else {
                expression2 = new StringBuilder(realPart2 + imaginaryPart2);
            }


            if (!expression1.toString().equals("")) {
                expression1.insert(0, "(");
                expression1.append("i)");
            }
            if (!expression2.toString().equals("")) {
                expression2.insert(0, "(");
                expression2.append("i)");
            }

            return expression1.toString() +operator+ expression2.toString() + "=" + calcOutputValue();
        }

        private String calcOutputValue() {
            String result = new String();

            if (numPattern.matcher(realPart1).matches() &&
                    numPattern.matcher(imaginaryPart1).matches() &&
                    numPattern.matcher(realPart2).matches() &&
                    numPattern.matcher(imaginaryPart2).matches()) {

                double realPart = Double.parseDouble(realPart1) + Double.parseDouble(realPart2);
                double imagPart = Double.parseDouble(imaginaryPart1) + Double.parseDouble(imaginaryPart2);

                if(areAdding){
                    realPart = Double.parseDouble(realPart1) + Double.parseDouble(realPart2);
                    imagPart = Double.parseDouble(imaginaryPart1) + Double.parseDouble(imaginaryPart2);
                }else {
                    realPart = Double.parseDouble(realPart1) - Double.parseDouble(realPart2);
                    imagPart = Double.parseDouble(imaginaryPart1) - Double.parseDouble(imaginaryPart2);

                    areAdding = true;
                    operator = "+";
                }
                if (imagPart>0) {
                    result = "("+realPart + "+" + imagPart+"i)";
                } else {
                    result = "("+realPart  + imagPart+"i)";
                }
            }

            return result;
        }


    }

    private static class Calculator extends JFrame{
        private static final int COLUMN = 20;
        private static String showStr = "";
        private static String operator = "";
        private static String num1 = "";
        private static String num2 = "";
        private static boolean zeroAreFirstBit = true;
        private static boolean areEqualed = true;
        private static boolean haveDot = false;

        private JTextArea showTextArea;

        private JButton button_0;
        private JButton button_1;
        private JButton button_2;
        private JButton button_3;
        private JButton button_4;
        private JButton button_5;
        private JButton button_6;
        private JButton button_7;
        private JButton button_8;
        private JButton button_9;
        private JButton button_add;
        private JButton button_sub;
        private JButton button_mul;
        private JButton button_div;
        private JButton button_dot;
        private JButton button_equal;
        private JButton button_c;
        private JButton button_changeSign;
        private JButton button_receprocal;

        public Calculator(String title){
            init();
            layoutPanels();
            registerEventHandler();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }

        private void init(){
            button_0 = new JButton("0");
            button_1 = new JButton("1");
            button_2 = new JButton("2");
            button_3 = new JButton("3");
            button_4 = new JButton("4");
            button_5 = new JButton("5");
            button_6 = new JButton("6");
            button_7 = new JButton("7");
            button_8 = new JButton("8");
            button_9 = new JButton("9");
            button_add = new JButton("+");
            button_sub = new JButton("-");
            button_mul = new JButton("×");
            button_div = new JButton("÷");
            button_dot = new JButton(" . ");
            button_equal = new JButton("=");
            button_c = new JButton("C");
            button_changeSign = new JButton("+/-");
            button_receprocal = new JButton("1/x");

            showTextArea = new JTextArea();
            showTextArea.setColumns(COLUMN);
            showTextArea.setRows(1);
            showTextArea.setText("0");
        }

        private void layoutPanels(){
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
            topPanel.add(showTextArea);

            JPanel leftPanel = new JPanel(new GridLayout(4, 3,10,10));
            leftPanel.add(button_1);
            leftPanel.add(button_2);
            leftPanel.add(button_3);
            leftPanel.add(button_4);
            leftPanel.add(button_5);
            leftPanel.add(button_6);
            leftPanel.add(button_7);
            leftPanel.add(button_8);
            leftPanel.add(button_9);
            leftPanel.add(button_c);
            leftPanel.add(button_0);
            leftPanel.add(button_dot);


            JPanel rightPanel = new JPanel(new BorderLayout());
            rightPanel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));
            JPanel liTop = new JPanel(new GridLayout(3, 2, 10, 10));
            liTop.add(button_add);
            liTop.add(button_sub);
            liTop.add(button_mul);
            liTop.add(button_div);
            liTop.add(button_receprocal);
            liTop.add(button_changeSign);
            JPanel liBottom = new JPanel(new FlowLayout(FlowLayout.CENTER,70,0));
            liBottom.add(button_equal);
            rightPanel.add(liTop, BorderLayout.PAGE_START);
            rightPanel.add(liBottom, BorderLayout.PAGE_END);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panel.add(topPanel, BorderLayout.PAGE_START);
            panel.add(leftPanel, BorderLayout.CENTER);
            panel.add(rightPanel,BorderLayout.LINE_END);
            
            this.getContentPane().add(panel);
        }


        private void registerEventHandler(){
            // 1-9
            addNumberButtonEvent(button_1, "1");
            addNumberButtonEvent(button_2, "2");
            addNumberButtonEvent(button_3, "3");
            addNumberButtonEvent(button_4, "4");
            addNumberButtonEvent(button_5, "5");
            addNumberButtonEvent(button_6, "6");
            addNumberButtonEvent(button_7, "7");
            addNumberButtonEvent(button_8, "8");
            addNumberButtonEvent(button_9, "9");

            // 0
            button_0.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int off = showTextArea.getText().length() - 1;

                    if (!zeroAreFirstBit) {
                        showTextArea.append("0");
                        System.out.println("if");
                    }
                }
            });

            // C
            button_c.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    num1 = "";
                    num2 = "";
                    zeroAreFirstBit = true;
                    showTextArea.setText("0");
                }
            });

            // + - × ÷
            addOperatorButtonEvent(button_add, "+");
            addOperatorButtonEvent(button_sub, "-");
            addOperatorButtonEvent(button_mul, "*");
            addOperatorButtonEvent(button_div, "/");

            // =
            button_equal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    num2 = showTextArea.getText().split("[+-[*]/]")[1];
                    equalAction();
                    num1 = showTextArea.getText();
                    num2 = "";
                    operator = "";
                    areEqualed = true;
                }
            });

            // dot
            button_dot.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(!haveDot)
                        showTextArea.append(".");

                    haveDot = true;
                }
            });

            // 1/x
            button_receprocal.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    num1 = showTextArea.getText();
                    operator = "1/x";

                    equalAction();
                    num1 = showTextArea.getText();
                    num2 = "";
                }
            });

            // +/-
            button_changeSign.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //...
                }
            });


        }

        private void addNumberButtonEvent(JButton button,String contentToAppend){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    zeroAreFirstBit = false;

                    dealWithTextFieldAreZero();
                    showTextArea.append(contentToAppend);
                }
            });
        }

        private void addOperatorButtonEvent(JButton button,String _operator){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    num1 = showTextArea.getText();
                    if(areEqualed){
                        areEqualed = false;
                    }else {
                        System.out.println(operator);
                        String[] ar = showTextArea.getText().split("[+-[*]/]");
                        num1 = ar[0];
                        num2 = ar[1];
                        equalAction();
                        num1 = showTextArea.getText();
                        num2 = "";

                    }

                    operator = _operator;

                    showTextArea.append(_operator);
                }
            });
        }

        private void equalAction(){
            double result = 0;
            if(num1!=""&&num2!=""){
                double number1 = Double.parseDouble(num1);
                double number2 = Double.parseDouble(num2);

                switch (operator){
                    case "+": result = number1+number2;break;
                    case "-":result = number1-number2;
                        break;
                    case "*":
                        result = number1 * number2;break;
                    case "/":result  = number1/number2;break;
                }
                operator = "";
                haveDot = false;
                showTextArea.setText(String.valueOf(result));

            }else if(num1!=""&&num2==""&&operator =="1/x"){
                double number1 = Double.parseDouble(num1);
                result = 1 / number1;

                operator = "";
                haveDot = false;
                showTextArea.setText(String.valueOf(result));
            }


        }


        private void dealWithTextFieldAreZero(){
            if (showTextArea.getText().equals("0")) {
                showTextArea.setText("");
            }
        }
    }
}


