package C_project_training;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *  项目实战
 *
 * 5、求数的绝对值
 *
 * 问题描述：
 * 有一函数：
 *               {   -x      （x<0）
 *      y   = {   0      （x=0）
 *               {   x       （x>0）
 * 编写一程序，输入一个x值，输出y值。
 */
public class Exercise_5 {
    public static void main(String[] args) {
        CalcWindow cw = new CalcWindow("求数的绝对值");

        cw.setVisible(true);
    }

    private static class CalcWindow extends JFrame{
        private JTextField textField;
        private JButton button;

        public CalcWindow(String title){
            init();
            layoutPanels();
            registerEventHander();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        private void init(){
            textField = new JTextField();
            button = new JButton("计算");

            textField.setColumns(20);
        }

        private void layoutPanels(){
            JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            topPanel.add(textField);

            JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            bottomPanel.add(button);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            panel.add(topPanel, BorderLayout.CENTER);
            panel.add(bottomPanel, BorderLayout.SOUTH);

            this.getContentPane().add(panel);
        }

        private void registerEventHander(){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    double result = toAbsoluteValue(Double.parseDouble(textField.getText()));

                    JOptionPane.showMessageDialog(
                            null,
                            "X = " + textField.getText() + "      " +
                                    "Y = " + result,
                            "消息",
                            JOptionPane.PLAIN_MESSAGE
                    );
                }
            });
        }

        private double  toAbsoluteValue(double value){
            if (value < 0) {
                value *= -1;
            }

            return value;
        }


    }



}


