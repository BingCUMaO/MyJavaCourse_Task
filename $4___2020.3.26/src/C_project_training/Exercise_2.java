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
 * 2、猜数游戏
 *
 * 问题描述：
 * 创建如图1的应用程序，它要求用户在文本框中输入1到10之间的
 * 一个数字（如图1）。然后单击“猜猜”按钮产生一个随机数字，用
 * 户被告知他选择的数字是否正好等于这个随机数。
 */

public class Exercise_2 {
    public static void main(String[] args) {
        Frame_A a = new Frame_A("猜数");
        a.setVisible(true);

    }

    //猜数
    private static class Frame_A extends JFrame{
        private static final String CRLF = "\r\n";
        private static final String TAB = "\t";

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
                    int correctNum = (int) (Math.random() * 10);

                    JOptionPane.showMessageDialog(
                            null,
                            "正确的数字是" + TAB + correctNum + CRLF +
                                    "你猜的数字是" + TAB + textField.getText() + CRLF +
                                    "欢迎你参加竞赛，下次再来吧",
                            "结果",
                            JOptionPane.PLAIN_MESSAGE
                    );

                    return;

                }

                textField.setText("你输入的不是数字");

            }
        }

    }




}


