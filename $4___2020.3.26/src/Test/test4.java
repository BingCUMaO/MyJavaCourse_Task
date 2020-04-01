package Test;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class test4 {
    public static void main(String[] args) {
        JJFrame jjf = new JJFrame();

        jjf.setVisible(true);
    }

    private static class JJFrame extends JFrame{
        private JTextArea jta;
        private JScrollPane jsp;

        public JJFrame(){
            jta = new JTextArea();
            jsp = new JScrollPane();
            jsp.setViewportView(jta);

            JPanel panel = new JPanel(new BorderLayout());
            panel.setLayout(new BorderLayout(0,0));
            panel.setBorder(new EmptyBorder(5,5,5,5));

            jta.setRows(5);
            jta.setColumns(10);

            panel.add(jta,BorderLayout.CENTER);
            getContentPane().add(panel);

            pack();
        }
    }
}
