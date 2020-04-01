package C_project_training;


import B_project_training.Exercise_1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *  项目实战
 *
 * 3、显示时间
 *
 * 问题描述：
 * 设计图2所示窗体，运行程序，在三个文本框中分别输入
 * 小时数，分钟数及秒数，单击“显示时间”按钮，在窗体上
 * 以时间格式（hh:mm:ss PM/AM）显示所设置的时间。
 */
public class Exercise_3 {
    public static void main(String[] args) {
        Frame_B b = new Frame_B("显示时间");
        b.setVisible(true);

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




}


