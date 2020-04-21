package A_project_training;


import javax.swing.*;
import java.awt.*;

/**
 * 4.4.3 项目实战
 * <p>
 * 6、创建如图4.17 所示的窗体。
 *
 */
public class Exercise_6 {
    public static void main(String[] args) {
        TabWindow tw = new TabWindow("数据处理程序");

        tw.setVisible(true);
    }

    private static class TabWindow extends JFrame{
        private static final int COLUMN_QUARTER = 10;
        private static final int COLUMN_A_HLLF = 20;
        private static final int COLUMN_THREE_FOURTHS = 30;
        private static final int COLUMN = 40;

        private JLabel labelEmployeeId;
        private JLabel labelLastName;
        private JLabel labelFirstName;
        private JLabel labelJob;
        private JLabel labelHonorableName;
        private JLabel labelBirthdate;
        private JLabel labelHireDate;
        private JLabel labelAddress;
        private JLabel labelCity;
        private JLabel labelRegion;
        private JLabel labelPostalCode;
        private JLabel labelCountry;
        private JLabel labelHomeTelephone;
        private JLabel labelExtensionTelephone;
        private JLabel labelSuperior;

        private JTextField textFieldEmployeeId;
        private JTextField textFieldLastName;
        private JTextField textFieldFirstName;
        private JTextField textFieldJob;
        private JTextField textFieldHonorableName;
        private JTextField textFieldBirthdate;
        private JTextField textFieldHireDate;
        private JTextField textFieldAddress;
        private JTextField textFieldCity;
        private JTextField textFieldRegion;
        private JTextField textFieldPostalCode;
        private JTextField textFieldCountry;
        private JTextField textFieldHomeTelephone;
        private JTextField textFieldExtensionTelephone;
        private JTextField textFieldSuperior;

        private JButton buttonFirst;
        private JButton buttonLast;
        private JButton buttonPrevious;
        private JButton buttonNext;
        private JButton buttonModify;
        private JButton buttonAdd;
        private JButton buttonDelete;

        public TabWindow(String title){
            init();
            layoutPanels();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        private void init(){
            //Initialize labels
            labelEmployeeId = new JLabel("雇员ID");
            labelLastName = new JLabel("姓氏");
            labelFirstName = new JLabel("名字");
            labelJob = new JLabel("职务");
            labelHonorableName = new JLabel("尊称");
            labelBirthdate = new JLabel("出生日期");
            labelHireDate = new JLabel("雇佣日期");
            labelAddress = new JLabel("地址");
            labelCity = new JLabel("城市");
            labelRegion = new JLabel("区域");
            labelPostalCode = new JLabel("邮政编码");
            labelCountry = new JLabel("国家");
            labelHomeTelephone = new JLabel("家庭电话");
            labelExtensionTelephone = new JLabel("分机");
            labelSuperior = new JLabel("上级");

            //Initialize text fields
            textFieldEmployeeId = new JTextField();
            textFieldLastName = new JTextField();
            textFieldFirstName = new JTextField();
            textFieldJob = new JTextField();
            textFieldHonorableName = new JTextField();
            textFieldBirthdate = new JTextField();
            textFieldHireDate = new JTextField();
            textFieldAddress = new JTextField();
            textFieldCity = new JTextField();
            textFieldRegion = new JTextField();
            textFieldPostalCode = new JTextField();
            textFieldCountry = new JTextField();
            textFieldHomeTelephone = new JTextField();
            textFieldExtensionTelephone = new JTextField();
            textFieldSuperior = new JTextField();

            //Initialize buttons
            buttonFirst = new JButton("第一条");
            buttonLast = new JButton("最后一条");
            buttonPrevious = new JButton("上一条");
            buttonNext = new JButton("下一条");
            buttonModify = new JButton("修改");
            buttonAdd = new JButton("添加");
            buttonDelete = new JButton("删除");

            //Set columns
            textFieldEmployeeId.setColumns(COLUMN_QUARTER);
            textFieldLastName.setColumns(COLUMN_A_HLLF);
            textFieldFirstName.setColumns(COLUMN_A_HLLF);
            textFieldJob.setColumns(COLUMN);
            textFieldHonorableName.setColumns(COLUMN_QUARTER);
            textFieldBirthdate.setColumns(COLUMN_A_HLLF);
            textFieldHireDate.setColumns(COLUMN_A_HLLF);
            textFieldAddress.setColumns(COLUMN);
            textFieldCity.setColumns(COLUMN_QUARTER);
            textFieldRegion.setColumns(COLUMN_QUARTER);
            textFieldPostalCode.setColumns(COLUMN_QUARTER);
            textFieldCountry.setColumns(COLUMN_A_HLLF);
            textFieldHomeTelephone.setColumns(COLUMN_A_HLLF);
            textFieldExtensionTelephone.setColumns(COLUMN_A_HLLF);
            textFieldSuperior.setColumns(COLUMN_QUARTER);
        }

        private void layoutPanels(){
            //Label panel
            JPanel labelPanel = new JPanel(new GridLayout(0, 1));
            labelPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            labelPanel.add(labelEmployeeId);
            labelPanel.add(labelLastName);
            labelPanel.add(labelFirstName);
            labelPanel.add(labelJob);
            labelPanel.add(labelHonorableName);
            labelPanel.add(labelBirthdate);
            labelPanel.add(labelHireDate);
            labelPanel.add(labelAddress);
            labelPanel.add(labelCity);
            labelPanel.add(labelRegion);
            labelPanel.add(labelPostalCode);
            labelPanel.add(labelCountry);
            labelPanel.add(labelHomeTelephone);
            labelPanel.add(labelExtensionTelephone);
            labelPanel.add(labelSuperior);

            //Text field panel
            JPanel textFieldPanel = new JPanel(new GridLayout(0, 1));
            textFieldPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            JPanel flowPanel1   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel2   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel3   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel4   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel5   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel6   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel7   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel8   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel9   = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel10 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel11 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel12 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel13 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel14 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel flowPanel15 = new JPanel(new FlowLayout(FlowLayout.LEFT));
            flowPanel1.add(textFieldEmployeeId);
            flowPanel2.add(textFieldLastName);
            flowPanel3.add(textFieldFirstName);
            flowPanel4.add(textFieldJob);
            flowPanel5.add(textFieldHonorableName);
            flowPanel6.add(textFieldBirthdate);
            flowPanel7.add(textFieldHireDate);
            flowPanel8.add(textFieldAddress);
            flowPanel9.add(textFieldCity);
            flowPanel10.add(textFieldRegion);
            flowPanel11.add(textFieldPostalCode);
            flowPanel12.add(textFieldCountry);
            flowPanel13.add(textFieldHomeTelephone);
            flowPanel14.add(textFieldExtensionTelephone);
            flowPanel15.add(textFieldSuperior);
            textFieldPanel.add(flowPanel1);
            textFieldPanel.add(flowPanel2);
            textFieldPanel.add(flowPanel3);
            textFieldPanel.add(flowPanel4);
            textFieldPanel.add(flowPanel5);
            textFieldPanel.add(flowPanel6);
            textFieldPanel.add(flowPanel7);
            textFieldPanel.add(flowPanel8);
            textFieldPanel.add(flowPanel9);
            textFieldPanel.add(flowPanel10);
            textFieldPanel.add(flowPanel11);
            textFieldPanel.add(flowPanel12);
            textFieldPanel.add(flowPanel13);
            textFieldPanel.add(flowPanel14);
            textFieldPanel.add(flowPanel15);

            //button panel
            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(buttonFirst);
            buttonPanel.add(buttonLast);
            buttonPanel.add(buttonPrevious);
            buttonPanel.add(buttonNext);
            buttonPanel.add(buttonModify);
            buttonPanel.add(buttonAdd);
            buttonPanel.add(buttonDelete);


            //The main panel of 个人信息
            JPanel personalInfoPanel = new JPanel(new BorderLayout());
            personalInfoPanel.add(labelPanel, BorderLayout.WEST);
            personalInfoPanel.add(textFieldPanel, BorderLayout.CENTER);
            personalInfoPanel.add(buttonPanel, BorderLayout.SOUTH);

            //To be tabbed pane
            JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
            tabbedPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            tabbedPane.addTab("个人信息", null, personalInfoPanel, "雇员的个人信息");
            tabbedPane.addTab("其他信息", null, new JPanel(), "照片、备注");

            this.getContentPane().add(tabbedPane);
        }
    }

}

