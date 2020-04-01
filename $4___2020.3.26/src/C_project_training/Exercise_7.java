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
 * 7、计算复利存款1
 *
 * 问题描述：
 * 某人新开一个帐户，编写一应用程序（如图6）输入开始存入的
 * 金额（本金），年利率以及存款周期（年）。假定所有的利息收
 * 入都重新存入帐户，请计算并输出在存款周期里，每年年终的帐
 * 面金额。其金额的计算公式为：
 *
 * a=p(1+r)n
 *
 * 其中，p是最开始存入的金额（本金），r是年利率，n是年数，a是在第n年年终的复利存款。
 */
public class Exercise_7 {
    public static void main(String[] args) {
        CompoundInterestLoans cil = new CompoundInterestLoans("复利贷款应用程序");

        cil.setVisible(true);
    }

    private static class CompoundInterestLoans extends JFrame {
        private static final int COLUMN = 20;
        private static final int TEXT_COLUMN = 30;
        private static final String TAB = "\t";
        private static final String CRLF = "\r\n";
        private static final String ERROR = "你输入的不是数字，请重试";
        private static final String HABLE_HEADER = "年" + TAB + "工资" + CRLF;


        private JLabel labelCapital;
        private JLabel labelAnnualInterestRate;
        private JLabel labelYears;

        private JTextField textFieldCapital;
        private JTextField textFieldAnnualInterestRate;
        private JTextField textFieldYears;

        private JTextArea textArea;
        private JScrollPane scrollPane;

        private JButton buttonCalc;
        private JButton buttonClearInput;


        public CompoundInterestLoans(String title) {
            init();
            layoutPanels();
            registerEventListener();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
        }

        private void init() {
            labelCapital = new JLabel("本金");
            labelAnnualInterestRate = new JLabel("年利率");
            labelYears = new JLabel("年数");

            textFieldCapital = new JTextField();
            textFieldAnnualInterestRate = new JTextField();
            textFieldYears = new JTextField();

            textArea = new JTextArea();
            scrollPane = new JScrollPane(textArea);


            buttonCalc = new JButton("计算");
            buttonClearInput = new JButton("清除");

            textArea.setText(HABLE_HEADER);

            textFieldCapital.setColumns(COLUMN);
            textFieldAnnualInterestRate.setColumns(COLUMN);
            textFieldYears.setColumns(COLUMN);
            textArea.setColumns(TEXT_COLUMN);
        }

        private void layoutPanels() {
            JPanel labelPanel = new JPanel(new GridLayout(0, 1));
            labelPanel.add(labelCapital);
            labelPanel.add(labelAnnualInterestRate);
            labelPanel.add(labelYears);

            JPanel textFieldPanel = new JPanel(new GridLayout(0, 1));
            textFieldPanel.add(textFieldCapital);
            textFieldPanel.add(textFieldAnnualInterestRate);
            textFieldPanel.add(textFieldYears);

            JPanel buttonPanel = new JPanel(new BorderLayout());
            buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 10, 20));
            buttonPanel.add(buttonCalc, BorderLayout.CENTER);
            buttonPanel.add(buttonClearInput, BorderLayout.LINE_END);

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
            buttonCalc.addActionListener(new CalcLoansEventHandler());
            buttonClearInput.addActionListener(new ClearInputEventHandler());
        }

        private class CalcLoansEventHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Content
                String capital = textFieldCapital.getText();
                String annualInterestRate = textFieldAnnualInterestRate.getText();
                String years = textFieldYears.getText();

                //RegEx
                String numRegex = "^\\d+$|^\\d+[.]\\d+$";
                Pattern pattern = Pattern.compile(numRegex);
                Matcher basicSalaryMatcher = pattern.matcher(annualInterestRate);
                Matcher saleAmountMatcher = pattern.matcher(years);

                if (basicSalaryMatcher.matches() && saleAmountMatcher.matches()) {
                    //Calculate loans
                    NumberFormat nf = NumberFormat.getCurrencyInstance();
                    nf.setMaximumFractionDigits(2);

                    String loan = null;
                    for (int year = 1; year <= Integer.parseInt(years); year++) {
                        loan = nf.format(calcLoans(Double.parseDouble(capital), Double.parseDouble(annualInterestRate),year));
                        textArea.append(year + TAB + loan + CRLF);
                    }

                }

                if (!basicSalaryMatcher.matches())
                    textFieldAnnualInterestRate.setText(ERROR);
                if (!saleAmountMatcher.matches())
                    textFieldYears.setText(ERROR);

            }

            private double calcLoans(double capital, double annualInterestRate, int year) {
                return capital + capital * annualInterestRate*year;
            }
        }

        private class ClearInputEventHandler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldCapital.setText("");
                textFieldAnnualInterestRate.setText("");
                textFieldYears.setText("");
            }
        }
        

    }


}


