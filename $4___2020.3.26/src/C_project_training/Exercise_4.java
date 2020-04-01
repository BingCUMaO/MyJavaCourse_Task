package C_project_training;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *  项目实战
 *
 * 4、工资发放程序
 *
 * 问题描述：
 * 某公司雇员的工资包括基本工资和销售提成。销售提成根据下面公式计算：
 * XXXX
 *
 * 编写一应用程序（如图3），输入雇员编号，基本工资和销售额，计算工资，
 * 输出工资单。
 */
public class Exercise_4 {
    public static void main(String[] args) {
        FinanceDepartment fd = new FinanceDepartment("工资发放程序");
        fd.setVisible(true);
    }

    private static class FinanceDepartment extends JFrame {
        private static final int COLUMN = 20;
        private static final int TEXT_COLUMN = 30;
        private static final String TAB = "\t";
        private static final String CRLF = "\r\n";
        private static final String ERROR = "你输入的不是数字，请重试";
        private static final String HABLE_HEADER =
                "编号" + TAB +
                        "基本工资" + TAB +
                        "销售额" + TAB +
                        "工资" + CRLF;


        private JLabel idLabel;
        private JLabel basicSalaryLabel;
        private JLabel salesAmountLabel;

        private JTextField idTextField;
        private JTextField basicSalaryTextField;
        private JTextField salesAmountTextField;

        private JTextArea textArea;
        private JScrollPane scrollPane;

        private JButton calcSalaryButton;
        private JButton clearInputButton;
        private JButton clearTextButton;


        public FinanceDepartment(String title) {
            init();
            layoutPanels();
            registerEventListener();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }

        private void init() {
            idLabel = new JLabel("编号");
            basicSalaryLabel = new JLabel("基本工资");
            salesAmountLabel = new JLabel("销售额");

            idTextField = new JTextField();
            basicSalaryTextField = new JTextField();
            salesAmountTextField = new JTextField();

            textArea = new JTextArea();
            scrollPane = new JScrollPane(textArea);


            calcSalaryButton = new JButton("工资计算");
            clearInputButton = new JButton("清除输入");
            clearTextButton = new JButton("清除显示框内容");

            textArea.setText(HABLE_HEADER);

            idTextField.setColumns(COLUMN);
            basicSalaryTextField.setColumns(COLUMN);
            salesAmountTextField.setColumns(COLUMN);
            textArea.setColumns(TEXT_COLUMN);
        }

        private void layoutPanels() {
            JPanel labelPanel = new JPanel(new GridLayout(0, 1));
            labelPanel.add(idLabel);
            labelPanel.add(basicSalaryLabel);
            labelPanel.add(salesAmountLabel);

            JPanel textFieldPanel = new JPanel(new GridLayout(0, 1));
            textFieldPanel.add(idTextField);
            textFieldPanel.add(basicSalaryTextField);
            textFieldPanel.add(salesAmountTextField);

            JPanel buttonPanel = new JPanel(new BorderLayout());
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            buttonPanel.add(calcSalaryButton, BorderLayout.CENTER);
            buttonPanel.add(clearInputButton, BorderLayout.LINE_END);
            buttonPanel.add(clearTextButton, BorderLayout.PAGE_END);

            JPanel leftPanel = new JPanel(new BorderLayout());
            leftPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            leftPanel.add(labelPanel, BorderLayout.CENTER);
            leftPanel.add(textFieldPanel, BorderLayout.LINE_END);
            leftPanel.add(buttonPanel, BorderLayout.PAGE_END);

            JPanel rightPanel = new JPanel(new BorderLayout());
            rightPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            rightPanel.add(scrollPane, BorderLayout.CENTER);


            JPanel panel = new JPanel(new GridLayout(1, 1));

            panel.add(leftPanel);
            panel.add(rightPanel);

            Container ctn = this.getContentPane();
            ctn.add(panel);
        }

        private void registerEventListener() {
            calcSalaryButton.addActionListener(new CalcSalaryEventHandler());
            clearInputButton.addActionListener(new ClearInputEventHandler());
            clearTextButton.addActionListener(new ClearTextEventHandler());
        }

        private class CalcSalaryEventHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Content
                String id = idTextField.getText();
                String basicSalary = basicSalaryTextField.getText();
                String saleAmount = salesAmountTextField.getText();

                //RegEx
                String numRegex = "^\\d+$";
                Pattern pattern = Pattern.compile(numRegex);
                Matcher basicSalaryMatcher = pattern.matcher(basicSalary);
                Matcher saleAmountMatcher = pattern.matcher(saleAmount);

                if (basicSalaryMatcher.matches() && saleAmountMatcher.matches()) {
                    //Calculate salary
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setMaximumFractionDigits(1);
                    String salary = nf.format(calcSalary(Double.parseDouble(basicSalary), Double.parseDouble(saleAmount)));


                    textArea.append(
                            id + TAB +
                                    basicSalary + TAB +
                                    saleAmount + TAB +
                                    salary + CRLF
                    );

                    idTextField.setText("");
                    basicSalaryTextField.setText("");
                    salesAmountTextField.setText("");
                    return;
                }

                if (!basicSalaryMatcher.matches())
                    basicSalaryTextField.setText(ERROR);
                if (!saleAmountMatcher.matches())
                    salesAmountTextField.setText(ERROR);

            }

            private double calcSalary(double basicSalary, double salesAmount) {
                double salary = basicSalary;
                if (salesAmount >= 30 && salesAmount <= 299.99) {
                    salary *= (1 + 0.05);
                } else if (salesAmount >= 300 && salesAmount <= 999.99) {
                    salary *= (1 + 0.1);
                } else if (salesAmount >= 1000) {
                    salary *= (1 + 0.15);
                }

                return salary;
            }
        }

        private class ClearInputEventHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                idTextField.setText("");
                basicSalaryTextField.setText("");
                salesAmountTextField.setText("");
            }
        }

        private class ClearTextEventHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(HABLE_HEADER);
            }
        }

    }


}


