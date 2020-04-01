package B_project_training;


import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 4.4.3 项目实战
 * <p>
 * 5、创建如图4.15 所示的窗体。
 * 【样式见8.png】
 */
public class Exercise_5 {
    public static void main(String[] args) {
        RCBox rcb = new RCBox("复选框和单选按钮");
        rcb.setVisible(true);
    }

    private static class RCBox extends JFrame{
        private static final int COLUMN = 8;
        private static final int ROW = 5;

        private JRadioButton redRadio;
        private JRadioButton blackRadio;
        private JRadioButton blueRadio;
        private JRadioButton greenRadio;

        private JScrollPane scrollPane;

        private JCheckBox boldFontBox;
        private JCheckBox italicFontBox;

        public RCBox(String title){
            init();
            layoutPanels();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }

        private void init(){
            redRadio = new JRadioButton("红色", false);
            blackRadio = new JRadioButton("黑色", false);
            blueRadio = new JRadioButton("蓝色", false);
            greenRadio = new JRadioButton("绿色", false);

            JTextArea textArea = new JTextArea();
            scrollPane = new JScrollPane(textArea);

            boldFontBox = new JCheckBox("粗体", false);
            italicFontBox = new JCheckBox("斜体", false);

            textArea.setColumns(COLUMN);
            textArea.setRows(ROW);
            textArea.setLineWrap(true);
            textArea.setFont(new Font("宋体", Font.BOLD, 20));

        }

        private void layoutPanels(){
            //titles
            Border titleRadio = BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                    "颜色"
            );
            Border titleBox = BorderFactory.createTitledBorder(
                    BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                    "字体"
            );

            //button groups
            ButtonGroup btnGroupRadio = new ButtonGroup();
            btnGroupRadio.add(redRadio);
            btnGroupRadio.add(blackRadio);
            btnGroupRadio.add(blueRadio);
            btnGroupRadio.add(greenRadio);

            //panels
            JPanel radioPanel = new JPanel(new GridLayout(0, 1));
            radioPanel.add(redRadio);
            radioPanel.add(blackRadio);
            radioPanel.add(blueRadio);
            radioPanel.add(greenRadio);
            JPanel boxPanel = new JPanel(new GridLayout(0, 1));
            boxPanel.add(boldFontBox);
            boxPanel.add(italicFontBox);

            //add title and border for panels
            radioPanel.setBorder(titleRadio);
            boxPanel.setBorder(titleBox);

            //Layout panels
            JPanel panel = new JPanel(new BorderLayout());
            panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            panel.add(radioPanel, BorderLayout.WEST);
            panel.add(scrollPane, BorderLayout.CENTER);
            panel.add(boxPanel, BorderLayout.EAST);

            this.getContentPane().add(panel);
        }
    }

}

