package Test;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;


public class test3 extends JFrame{
    private JPanel contentPane;
    private JScrollPane scrollPane;
    private JTextArea textArea;
    public test3(){
        contentPane=new JPanel();
        contentPane.setBorder(new EmptyBorder(5,5,5,5));
        contentPane.setLayout(new BorderLayout(0,0));
        this.setContentPane(contentPane);

        scrollPane=new JScrollPane();
        contentPane.add(scrollPane,BorderLayout.CENTER);

        textArea=new JTextArea();
        //scrollPane.add(textArea);
//        scrollPane.setViewportView(textArea);
        this.setTitle("滚动面板使用");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(100, 100, 250, 200);
        this.setVisible(true);
    }
    public static void main(String []args){
        test3 example=new test3();
    }
}
