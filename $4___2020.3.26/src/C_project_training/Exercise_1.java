package C_project_training;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;


/**
 *  项目实战
 *
 * 1、使用面向对象思想，改写下面程序。
 *
 * 创建贷款类对象，得到总付款
 */

/**
 * private class computeButtonActionEventHander implements ActionListener{
 *         public void actionPerformed(ActionEvent e) {
 *           final int MOMTHS_IN_YEAR  = 12;
 *           float annualInterestRate ;
 *           int loanPeriod,numberOfPayments ;
 *           double loanAmount, monthlyPayment, totalPayment ;
 *           double  monthlyInterestRate;
 *           loanAmount = Double.parseDouble(amountField.getText());
 *           annualInterestRate = Float.parseFloat(rateField.getText());
 *           loanPeriod =Integer.parseInt(numPeriodsField.getText()) ;
 *                monthlyInterestRate = annualInterestRate / 100.0 / MOMTHS_IN_YEAR;
 *                numberOfPayments = loanPeriod * MOMTHS_IN_YEAR;
 *                monthlyPayment = (loanAmount * monthlyInterestRate) /
 *                          (1 - (Math.pow((1 + monthlyInterestRate), -numberOfPayments)));
 *                totalPayment = monthlyPayment * numberOfPayments;
 *           NumberFormat currencyformatter=NumberFormat.getCurrencyInstance();
 *           paymentField.setText(currencyformatter.format(monthlyPayment));
 *           totalpaymentField.setText(currencyformatter.format(totalPayment));
 *         }
 *     }
 */
public class Exercise_1 {
    public static void main(String[] args) {
        Loans ls = new Loans("贷款");

        ls.setVisible(true);
    }

    private static class Loans extends JFrame{
        private static final int COLUMN = 20;

        private JLabel labelAmount;
        private JLabel labelRate;
        private JLabel labelNumPeriods;
        private JLabel labelPayment;
        private JLabel labelTotalPayment;

        private JTextField amountField;
        private JTextField rateField;
        private JTextField numPeriodsField;
        private JTextField paymentField;
        private JTextField totalpaymentField;

        private JButton buttonCalc;


        public Loans(String title){
            init();
            layoutPanel();
            registerEventHandler();

            setTitle(title);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            pack();
        }

        private void init(){
            labelAmount = new JLabel("本金");
            labelRate = new JLabel("年利率");
            labelNumPeriods = new JLabel("年数");
            labelPayment = new JLabel("月付款");
            labelTotalPayment = new JLabel("总付款");

            amountField = new JTextField();
            rateField = new JTextField();
            numPeriodsField = new JTextField();
            paymentField = new JTextField();
            totalpaymentField = new JTextField();

            buttonCalc = new JButton("计算");

            amountField.setColumns(COLUMN);
            rateField.setColumns(COLUMN);
            numPeriodsField.setColumns(COLUMN);
            paymentField.setColumns(COLUMN);
            paymentField.setEditable(false);
            totalpaymentField.setColumns(COLUMN);
            totalpaymentField.setEditable(false);

        }

        private void layoutPanel(){
            JPanel labelPanel = new JPanel(new GridLayout(0, 1));
            labelPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            labelPanel.add(labelAmount);
            labelPanel.add(labelRate);
            labelPanel.add(labelNumPeriods);
            labelPanel.add(labelPayment);
            labelPanel.add(labelTotalPayment);

            JPanel fieldPanel = new JPanel(new GridLayout(0, 1));
            fieldPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            fieldPanel.add(amountField);
            fieldPanel.add(rateField);
            fieldPanel.add(numPeriodsField);
            fieldPanel.add(paymentField);
            fieldPanel.add(totalpaymentField);

            JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            buttonPanel.add(buttonCalc);

            JPanel panel = new JPanel(new BorderLayout());
            panel.add(labelPanel, BorderLayout.WEST);
            panel.add(fieldPanel, BorderLayout.EAST);
            panel.add(buttonPanel, BorderLayout.SOUTH);

            this.getContentPane().add(panel);
        }

        private void registerEventHandler(){
            buttonCalc.addActionListener(new computeButtonActionEventHander());
        }


        private class computeButtonActionEventHander implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                final int MOMTHS_IN_YEAR  = 12;
                float annualInterestRate ;
                int loanPeriod,numberOfPayments ;
                double loanAmount, monthlyPayment, totalPayment ;
                double  monthlyInterestRate;

                loanAmount = Double.parseDouble(amountField.getText());
                annualInterestRate = Float.parseFloat(rateField.getText());
                loanPeriod =Integer.parseInt(numPeriodsField.getText()) ;
                monthlyInterestRate = annualInterestRate / 100.0 / MOMTHS_IN_YEAR;
                numberOfPayments = loanPeriod * MOMTHS_IN_YEAR;
                monthlyPayment = (loanAmount * monthlyInterestRate) /
                        (1 - (Math.pow((1 + monthlyInterestRate), -numberOfPayments)));
                totalPayment = monthlyPayment * numberOfPayments;

                NumberFormat currencyformatter= NumberFormat.getCurrencyInstance();
                paymentField.setText(currencyformatter.format(monthlyPayment));
                totalpaymentField.setText(currencyformatter.format(totalPayment));
            }
        }
    }





}


