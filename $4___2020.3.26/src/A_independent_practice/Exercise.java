package A_independent_practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  4.4.3 独立实践
 *
 *  文字游戏
 *
 *  编写一个与用户一起玩的Eggy-Peggy 文字游戏的引用程序，该程序
 *  把用户指定的字符串转化为新字符串，在指定字符串的所有元音字母
 *  前增加“egg” 单词。
 */
public class Exercise {
    public static void main(String[] args) {
        GameFrame gf = new GameFrame();

        gf.setVisible(true);
    }


    private static class GameFrame extends JFrame{
        private static final int ROW = 10;
        private static final int COLUMN = 40;

        private JLabel inputLabel;
        private  JLabel outputLabel;
        private JTextArea inputArea;
        private JTextArea outputArea;
        private JButton beginButton;

        //Constructor
        public GameFrame() {
            init();
            layoutPanels();
            registerEventHandlers();

            setTitle("Word Games");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        /**
         * Init attributes.
         */
        private void init(){
            inputLabel = new JLabel("Input");
            outputLabel = new JLabel("Output");
            inputArea = new JTextArea();
            outputArea = new JTextArea();
            beginButton = new JButton("Begin");

            inputArea.setRows(ROW);
            inputArea.setColumns(COLUMN);

            outputArea.setEditable(false);
            outputArea.setRows(ROW);
            outputArea.setColumns(COLUMN);
        }

        /**
         * Layout the position of panels.
         */
        private void layoutPanels(){
            Container ctn = this.getContentPane();

            JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            inputPanel.add(inputLabel);
            inputPanel.add(inputArea);
            JPanel outputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            outputPanel.add(outputLabel);
            outputPanel.add(outputArea);
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            buttonPanel.add(beginButton);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setBounds(20, 20, 10, 20);
            panel.add(inputPanel,BorderLayout.PAGE_START);
            panel.add(outputPanel,BorderLayout.CENTER);
            panel.add(buttonPanel, BorderLayout.PAGE_END);
            ctn.add(panel);
        }

        private void registerEventHandlers(){
            beginButton.addActionListener(new BeginButtonEventHandler());
        }

        private class BeginButtonEventHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String content = inputArea.getText();
                StringBuilder result = new StringBuilder();
                int len = content.length();

                //regEx
                String regex = "[aeiouAEIOU]";
                Pattern ptn = Pattern.compile(regex);
                Matcher matcher = null;

                for(int i  = 0;i<len;i++){
                    char character = content.charAt(i);
                    matcher = ptn.matcher(Character.toString(character));
                    //If successfully matching, add "egg" to result String.
                    if(matcher.matches()){
                        result.append("egg");
                    }
                    result.append(character);
                }

                outputArea.setText(result.toString());
            }
        }

    }
}


