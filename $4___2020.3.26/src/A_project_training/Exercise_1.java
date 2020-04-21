package A_project_training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 4.4.3 项目实战
 *
 * 1、创建如图4.9 (a) 、(b)、(c)三个窗体
 * 【窗体样式看1.png】
 */
public class Exercise_1 {
    public static void main(String[] args) {
        Frame_A a = new Frame_A("猜数");
        a.setVisible(true);

        Frame_B b = new Frame_B("显示时间");
        b.setVisible(true);

        Frame_C c = new Frame_C("简易计算器");
        c.setVisible(true);
    }

    //猜数
    private static class Frame_A extends JFrame{
        private JLabel label;
        private JTextField textField;
        private JButton button;

        public Frame_A(String title){
            init();
            layoutPanels();
            registerEventListener();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        private void init(){
            label = new JLabel("请输入1到10之间的一个数字");
            textField = new JTextField();
            button = new JButton("猜猜");

            textField.setColumns(10);
        }

        private void layoutPanels(){
            Container ctn = this.getContentPane();

            //Add to panel
            JPanel labelPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            labelPanel.add(label);
            JPanel textPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            textPanel.add(textField);
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            buttonPanel.add(button);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBounds(20, 20, 10, 20);

            panel.add(labelPanel, BorderLayout.PAGE_START);
            panel.add(textPanel, BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.PAGE_END);

            ctn.add(panel);
        }

        private void registerEventListener(){
            button.addActionListener(new GuessEventHandler());
        }

        private class GuessEventHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = textField.getText();

                //RegEx
                String regex = "^\\d+$";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(content);

                if(matcher.matches()){
                    if(Integer.parseInt(content)==(int)(Math.random()*10)){
                        textField.setText("你猜对了");
                        return;
                    }
                }

                textField.setText("很遗憾，猜错了");

            }
        }

    }



    //显示时间
    private static class Frame_B extends JFrame {
        private static final int COLUMN = 10;

        private JLabel hourLabel;
        private JLabel minuteLabel;
        private JLabel secondLabel;

        private JTextField hourTextField;
        private JTextField miniteTextField;
        private JTextField secondTextField;

        private JTextField outputTextField;

        private JButton button;

        public Frame_B(String title){
            init();
            layoutPanels();
            registerEventHandler();

            this.setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }

        private void init(){
            hourLabel = new JLabel("小时");
            minuteLabel = new JLabel("分钟");
            secondLabel = new JLabel("秒");

            hourTextField = new JTextField();
            miniteTextField = new JTextField();
            secondTextField = new JTextField();

            outputTextField = new JTextField();

            button = new JButton("显示时间");


            //Set column of fields.
            hourTextField.setColumns(COLUMN);
            miniteTextField.setColumns(COLUMN);
            secondTextField.setColumns(COLUMN);

            outputTextField.setEditable(false);
            outputTextField.setColumns(COLUMN);
        }

        private void layoutPanels(){
            JPanel timeLabelPanel = new JPanel(new GridLayout(0, 1));
            timeLabelPanel.add(hourLabel);
            timeLabelPanel.add(minuteLabel);
            timeLabelPanel.add(secondLabel);

            JPanel timeTextFieldPanel = new JPanel(new GridLayout(0, 1));
            timeTextFieldPanel.add(hourTextField);
            timeTextFieldPanel.add(miniteTextField);
            timeTextFieldPanel.add(secondTextField);

            JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            outputPanel.add(outputTextField);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            buttonPanel.add(button);


            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 50, 10, 50));
            panel.add(timeLabelPanel,BorderLayout.CENTER);
            panel.add(timeTextFieldPanel,BorderLayout.LINE_END);
            panel.add(outputPanel,BorderLayout.PAGE_START);
            panel.add(buttonPanel, BorderLayout.PAGE_END);

            Container ctn = this.getContentPane();
            ctn.add(panel);
        }

        private void registerEventHandler(){
            button.addActionListener(new VisibleTime());
        }

        private class VisibleTime implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String hour = hourTextField.getText();
                String minute = miniteTextField.getText();
                String second = secondTextField.getText();

                //RegEx
                String hourRegex = "^\\d$|^([12][0-3])$";
                String minuteRegex = "^\\d$|^[1-5]\\d$";
                String secondRegex = "^\\d$|^[1-5]\\d$";

                Pattern hourPattern = Pattern.compile(hourRegex);
                Pattern minutePattern = Pattern.compile(minuteRegex);
                Pattern secondPattern = Pattern.compile(secondRegex);

                Matcher hourMatcher = hourPattern.matcher(hour);
                Matcher minuteMatcher = minutePattern.matcher(minute);
                Matcher secondMatcher = secondPattern.matcher(second);

                if(hourMatcher.matches()&&minuteMatcher.matches()&&secondMatcher.matches()){
                    String format = "A.M.";
                    int hourNum = Integer.parseInt(hour);

                    if(hourNum>=12){
                        format = "P.M.";
                        hourNum -= 12;
                    }
                    outputTextField.setText(hourNum + ":" + minute + ":" + second + " " + format);

                    return;
                }

                outputTextField.setText("输入格式错误，请重新输入");

            }
        }
    }



    //简易计算器
    private static class Frame_C extends JFrame{
        private static final int COLUMN = 20;

        private JLabel numLabel_1;
        private  JLabel numLabel_2;
        private JLabel operatorLabel;
        private JLabel resultLabel;

        private JTextField numTextField_1;
        private JTextField numTextField_2;
        private JTextField operatorTextField;
        private JTextField resultTextField;

        private JButton calcButton;
        private JButton clearButton;

        public Frame_C(String title){
            init();
            layoutPanels();
            registerEventHandler();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        private void init(){
            numLabel_1 = new JLabel("操作数1");
            numLabel_2 = new JLabel("操作数2");
            operatorLabel = new JLabel("操作符");
            resultLabel = new JLabel("结果");

            numTextField_1 = new JTextField();
            numTextField_2 = new JTextField();
            operatorTextField = new JTextField();
            resultTextField = new JTextField();

            calcButton = new JButton("计算");
            clearButton = new JButton("清除");

            numTextField_1.setColumns(COLUMN);
            numTextField_2.setColumns(COLUMN);
            operatorTextField.setColumns(COLUMN);
            resultTextField.setColumns(COLUMN);
            resultTextField.setEditable(false);
        }

        private void layoutPanels(){
            JPanel labelPanel = new JPanel(new GridLayout(0, 1));
            labelPanel.add(numLabel_1);
            labelPanel.add(operatorLabel);
            labelPanel.add(numLabel_2);
            labelPanel.add(resultLabel);

            JPanel textPanel = new JPanel(new GridLayout(0, 1));
            textPanel.add(numTextField_1);
            textPanel.add(operatorTextField);
            textPanel.add(numTextField_2);
            textPanel.add(resultTextField);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            buttonPanel.add(calcButton);
            buttonPanel.add(clearButton);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            panel.add(labelPanel, BorderLayout.CENTER);
            panel.add(textPanel, BorderLayout.LINE_END);
            panel.add(buttonPanel, BorderLayout.PAGE_END);


            Container ctn = this.getContentPane();
            ctn.add(panel);
        }

        private void registerEventHandler(){
            calcButton.addActionListener(new CalcButtonEventHandler());
            clearButton.addActionListener(new ClearButtonEventHandler());
        }

        private class CalcButtonEventHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                String num1 = numTextField_1.getText();
                String num2 = numTextField_2.getText();
                String operator = operatorTextField.getText();
                int result = 0;

                //RegEx
                String numberRegex = "^\\d+$";
                String operatorRegex = "^[[+]-*/]$";

                Pattern numPattern = Pattern.compile(numberRegex);
                Pattern operPattern = Pattern.compile(operatorRegex);

                Matcher numMatcher1 = numPattern.matcher(num1);
                Matcher numMatcher2 = numPattern.matcher(num2);
                Matcher operMatcher = operPattern.matcher(operator);

                if(numMatcher1.matches()&&numMatcher2.matches()&&operMatcher.matches()){
                    switch (operator){
                        case "+":
                            result = Integer.parseInt(num1) + Integer.parseInt(num2);
                            break;
                        case "-":
                            result = Integer.parseInt(num1) - Integer.parseInt(num2);
                            break;
                        case "*":
                            result = Integer.parseInt(num1) * Integer.parseInt(num2);
                            break;
                        case "/":
                            result = Integer.parseInt(num1) / Integer.parseInt(num2);
                            break;
                    }

                    resultTextField.setText(String.valueOf(result));
                    return;
                }

                resultTextField.setText("输入格式错误，请重新输入");
            }
        }

        private class ClearButtonEventHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                numTextField_1.setText("");
                numTextField_2.setText("");
                operatorTextField.setText("");
                resultTextField.setText("");
            }
        }

    }
}


