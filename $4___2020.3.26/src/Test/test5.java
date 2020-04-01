package Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class test5 extends JFrame{
    //声明文本框组件和按钮框组件
    private JTextField inputText;
    private JTextField outputText;
    private JButton btnShow;

    public test5() {
        createComponents();//调用createComponents方法创建组件
        layoutComponents();//调用layoutComponents实现界面布局
        registerEventHandlers();

        setTitle("Egg-Peggy文字游戏");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    //创建组件
    private void createComponents() {
        inputText = new JTextField();
        inputText.setColumns(20);
        inputText.setEditable(true);
        outputText = new JTextField();
        outputText.setColumns(20);
        outputText.setEditable(false);
        btnShow = new JButton("开始");
    }

    //界面布局
    private void layoutComponents() {
        Container c = getContentPane();

        JPanel fieldPane = new JPanel(new GridLayout(0,1));
        fieldPane.add(inputText);
        fieldPane.add(outputText);

        JPanel buttonPane = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPane.add(btnShow);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20,20,10,20));
        panel.add(fieldPane,BorderLayout.CENTER);
        panel.add(buttonPane,BorderLayout.PAGE_END);

        c.add(panel);
    }

    private class Connection implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String input = inputText.getText();

            StringBuilder inputString = new StringBuilder(input);
            StringBuilder outputString = new StringBuilder();

            char letter;
            int i = 0;
            while (i < inputString.length()) {
                letter = inputString.charAt(i);
                if (letter == 'A' || letter == 'a' ||
                        letter == 'E' || letter == 'e' ||
                        letter == 'I' || letter == 'i' ||
                        letter == 'O' || letter == 'o' ||
                        letter == 'U' || letter == 'u') {
                    outputString.append("egg");
                    outputString.append(String.valueOf(letter));
                }
                else {
                    outputString.append(String.valueOf(letter));
                    i++;
                }

                outputText.setText(outputString.toString());
            }
        }
    }

    private void registerEventHandlers() {
        Connection hander = new Connection();
        btnShow.addActionListener(hander);
    }

    public static void main(String[] args) {
        JFrame.setDefaultLookAndFeelDecorated(true);
        test5 frame = new test5();
        frame.setVisible(true);
    }
}

