package C_project_training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  项目实战
 *
 * 6、计算器
 *
 * 问题描述：
 * 创建如图5所示的应用程序，用户输入两个数及运算符，
 * 当单击“计算”按钮时，求出两数的运算结果并显示在“结
 * 果”文本框中。
 */
public class Exercise_6 {
    public static void main(String[] args) {
        Frame_C c = new Frame_C("简易计算器");
        c.setVisible(true);
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


