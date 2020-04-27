package B_project_training;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * 4.4.3 项目实战
 * <p>
 * 4、创建如图4.13 所示的登陆窗体。
 * 【样式见4.png】
 */
public class Exercise_4 {
    public static void main(String[] args) {
        LoginWindow lw = new LoginWindow("登陆窗体", "$4___2020.3.26/src/img/headPortrait.jpg");
        lw.setVisible(true);

    }

    private static class LoginWindow extends JFrame {
        private static final int COLUMN  = 15;
        private static final int ROW = 10;

        private String headPortraitPath;

        private JLabel labelImg;
        private JLabel labelUserName;
        private JLabel labelPwd;
        private JLabel labelBirthdate;
        private JLabel labelJob;
        private JLabel labelIntroduction;

        private JTextField textFieldUserName;
        private JPasswordField textFieldPwd;
        private JTextField textFieldBirthdate;
        private JTextField textFieldJob;
        private JTextArea textAreaIntroduction;

        private JScrollPane scrollPaneIntroduction;

        private JButton buttonOk;
        private JButton buttonExit;

        public LoginWindow(String title, String headPortraitPath){
            this.headPortraitPath = headPortraitPath;

            init();
            layoutPanels();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        private void init(){
            changeSize(100, 150, headPortraitPath);
            ImageIcon img = new ImageIcon(headPortraitPath);
            labelImg = new JLabel(img);


            labelUserName = new JLabel("用户名");
            labelUserName.setHorizontalAlignment(JLabel.RIGHT);
            labelPwd = new JLabel("密码");
            labelPwd.setHorizontalAlignment(JLabel.RIGHT);
            labelBirthdate = new JLabel("出生日期");
            labelBirthdate.setHorizontalAlignment(JLabel.RIGHT);
            labelJob = new JLabel("职务");
            labelJob.setHorizontalAlignment(JLabel.RIGHT);
            labelIntroduction = new JLabel("简介");

            textFieldUserName = new JTextField();
            textFieldPwd = new JPasswordField();
            textFieldBirthdate = new JTextField();
            textFieldJob = new JTextField();

            textAreaIntroduction = new JTextArea();
            textAreaIntroduction.setLineWrap(true);
            scrollPaneIntroduction = new JScrollPane(textAreaIntroduction);

            textFieldUserName.setColumns(COLUMN);
            textFieldPwd.setColumns(COLUMN);
            textFieldBirthdate.setColumns(COLUMN);
            textFieldJob.setColumns(COLUMN);
            textAreaIntroduction.setRows(ROW);
            textAreaIntroduction.setColumns(COLUMN * 2);

            buttonOk = new JButton("确定");
            buttonExit = new JButton("退出");
        }

        private void layoutPanels(){
            JPanel topPanel = new JPanel(new BorderLayout());
            JPanel topCenterPanel = new JPanel(new GridLayout(4, 1));
            topCenterPanel.add(labelUserName);
            topCenterPanel.add(labelPwd);
            topCenterPanel.add(labelBirthdate);
            topCenterPanel.add(labelJob);
            JPanel topEastPanel = new JPanel(new GridLayout(4, 1));
            topEastPanel.add(textFieldUserName);
            topEastPanel.add(textFieldPwd);
            topEastPanel.add(textFieldBirthdate);
            topEastPanel.add(textFieldJob);

            topPanel.add(labelImg, BorderLayout.WEST);
            topPanel.add(topCenterPanel, BorderLayout.CENTER);
            topPanel.add(topEastPanel, BorderLayout.EAST);

            JPanel bottomPanel = new JPanel(new BorderLayout());
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 20));
            buttonPanel.add(buttonOk);
            buttonPanel.add(buttonExit);

            bottomPanel.add(labelIntroduction, BorderLayout.NORTH);
            bottomPanel.add(scrollPaneIntroduction, BorderLayout.CENTER);
            bottomPanel.add(buttonPanel, BorderLayout.SOUTH);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(topPanel, BorderLayout.NORTH);
            panel.add(bottomPanel, BorderLayout.SOUTH);

            this.getContentPane().add(panel);

        }

        public boolean changeSize(int newWidth, int newHeight, String path) {
            BufferedInputStream in = null;
            try {
                in = new BufferedInputStream(new FileInputStream(path));

                //字节流转图片对象
                Image bi = ImageIO.read(in);
                //构建图片流
                BufferedImage tag = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
                //绘制改变尺寸后的图
                tag.getGraphics().drawImage(bi, 0, 0, newWidth, newHeight, null);
                //输出流
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path));
                //JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
                //encoder.encode(tag);
                ImageIO.write(tag, "PNG", out);
                in.close();
                out.close();
                return true;
            } catch (IOException e) {
                return false;
            }
        }


    }

}


