import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View implements ActionListener {
    private JFrame frame = new JFrame("Polynomial calculator");
    private JPanel panel = new JPanel();
    private Font font1 = new Font("Arial", Font.BOLD, 17);
    private Font font2 = new Font("Arial", Font.BOLD, 15);
    private Color backgroundColor = new Color(208, 204, 177);
    private JLabel labelTitle = new JLabel("Polynomial calculator");
    private JRadioButton btnFirstPolynomial = new JRadioButton("#1 Polynomial");
    private JRadioButton btnSecondPolynomial = new JRadioButton("#2 Polynomial");
    private ButtonGroup buttonGroup = new ButtonGroup();
    private JTextField textFirstPolynomial = new JTextField();
    private JTextField textSecondPolynomial = new JTextField();
    private JLabel labelFirstResult = new JLabel("#1 Result");
    private JLabel labelSecondResult = new JLabel("#2 Result");
    private JLabel labelMessage = new JLabel("");
    private JTextField textFirstResult = new JTextField();
    private JTextField textSecondResult = new JTextField();
    private JButton btnAdd = new JButton("Add");
    private JButton btnSubstract = new JButton("Substract");
    private JButton btnMultiply = new JButton("Multiply");
    private JButton btnDivide = new JButton("Divide");
    private JButton btnIntegrate = new JButton("Integrate");
    private JButton btnDerivate = new JButton("Derivate");
    private JButton[] num = {new JButton("0"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"),
            new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"), new JButton("9")};
    private JButton[] op = {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("^"),
            new JButton("x"), new JButton("del")};

    public View() {
        buttonGroup.add(btnFirstPolynomial);
        buttonGroup.add(btnSecondPolynomial);
        btnFirstPolynomial.setBackground(backgroundColor);
        btnSecondPolynomial.setBackground(backgroundColor);

        labelTitle.setBounds(100, 0, 200, 30);
        btnFirstPolynomial.setBounds(5, 40, 135, 30);
        btnSecondPolynomial.setBounds(5, 70, 135, 30);
        textFirstPolynomial.setBounds(150, 40, 250, 30);
        textSecondPolynomial.setBounds(150, 70, 250, 30);
        labelFirstResult.setBounds(5, 150, 150, 30);
        labelSecondResult.setBounds(5, 180, 150, 30);
        textFirstResult.setBounds(120, 150, 320, 30);
        textSecondResult.setBounds(120, 180, 320, 30);
        labelMessage.setBounds(5, 230, 400, 30);
        btnAdd.setBounds(420, 50, 100, 40);
        btnSubstract.setBounds(520, 50, 100, 40);
        btnMultiply.setBounds(620, 50, 100, 40);
        btnDivide.setBounds(720, 50, 100, 40);
        btnDerivate.setBounds(820, 50, 100, 40);
        btnIntegrate.setBounds(920, 50, 100, 40);
        int num_x = 500, num_y = 120;
        num[9].setBounds(num_x, num_y, 50, 40);
        num[8].setBounds(num_x + 50, num_y, 50, 40);
        num[7].setBounds(num_x + 100, num_y, 50, 40);
        num[6].setBounds(num_x, num_y + 40, 50, 40);
        num[5].setBounds(num_x + 50, num_y + 40, 50, 40);
        num[4].setBounds(num_x + 100, num_y + 40, 50, 40);
        num[3].setBounds(num_x, num_y + 80, 50, 40);
        num[2].setBounds(num_x + 50, num_y + 80, 50, 40);
        num[1].setBounds(num_x + 100, num_y + 80, 50, 40);
        num[0].setBounds(num_x + 50, num_y + 120, 50, 40);
        int op_x = 700, op_y = 140;
        op[0].setBounds(op_x, op_y, 70, 40);
        op[1].setBounds(op_x + 70, op_y, 70, 40);
        op[2].setBounds(op_x + 140, op_y, 70, 40);
        op[3].setBounds(op_x, op_y + 40, 70, 40);
        op[4].setBounds(op_x + 70, op_y + 40, 70, 40);
        op[5].setBounds(op_x + 140, op_y + 40, 70, 40);

        labelTitle.setFont(font1);
        labelMessage.setForeground(Color.RED);
        btnFirstPolynomial.setFont(font2);
        btnSecondPolynomial.setFont(font2);
        textFirstPolynomial.setFont(font2);
        textSecondPolynomial.setFont(font2);
        labelFirstResult.setFont(font2);
        labelSecondResult.setFont(font2);
        textFirstResult.setFont(font2);
        textSecondResult.setFont(font2);
        labelMessage.setFont(font2);

        panel.add(labelTitle);
        panel.add(btnFirstPolynomial);
        panel.add(btnSecondPolynomial);
        panel.add(textFirstPolynomial);
        panel.add(textSecondPolynomial);
        panel.add(labelFirstResult);
        panel.add(labelSecondResult);
        panel.add(textFirstResult);
        panel.add(textSecondResult);
        panel.add(labelMessage);
        panel.add(btnAdd);
        panel.add(btnSubstract);
        panel.add(btnMultiply);
        panel.add(btnDivide);
        panel.add(btnDerivate);
        panel.add(btnIntegrate);
        for (JButton btn : num) {
            panel.add(btn);
        }
        for (JButton btn : op) {
            panel.add(btn);
        }


        btnAdd.setFocusPainted(false);
        btnAdd.setContentAreaFilled(false);
        btnSubstract.setFocusPainted(false);
        btnSubstract.setContentAreaFilled(false);
        btnMultiply.setFocusPainted(false);
        btnMultiply.setContentAreaFilled(false);
        btnDivide.setFocusPainted(false);
        btnDivide.setContentAreaFilled(false);
        btnDerivate.setFocusPainted(false);
        btnDerivate.setContentAreaFilled(false);
        btnIntegrate.setFocusPainted(false);
        btnIntegrate.setContentAreaFilled(false);
        for (JButton btn : num) {
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
        }
        for (JButton btn : op) {
            btn.setFocusPainted(false);
            btn.setContentAreaFilled(false);
        }

        for (JButton btn : num) {
            btn.addActionListener(this);
        }
        for (JButton btn : op) {
            btn.addActionListener(this);
        }

        textFirstPolynomial.setEditable(false);
        textSecondPolynomial.setEditable(false);
        textFirstResult.setEditable(false);
        textSecondResult.setEditable(false);

        panel.setLayout(null);
        panel.setBackground(backgroundColor);
        frame.setSize(1050, 330);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public String getP1() {
        return textFirstPolynomial.getText();
    }

    public String getP2() {
        return textSecondPolynomial.getText();
    }

    public void setR1(String result) {
        textFirstResult.setText(result);
    }

    public void setR2(String result) {
        textSecondResult.setText(result);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (btnFirstPolynomial.isSelected()) {
            for (JButton btn : num) {
                if (e.getSource() == btn) {
                    textFirstPolynomial.setText(textFirstPolynomial.getText() + btn.getText());
                }

            }
            for (JButton btn : op) {
                if (e.getSource() == btn) {
                    if (btn.getText().equals("del")) {
                        if (textFirstPolynomial.getText().length() >= 1)
                            textFirstPolynomial.setText(textFirstPolynomial.getText().substring(0, textFirstPolynomial.getText().length() - 1));
                    } else textFirstPolynomial.setText(textFirstPolynomial.getText() + btn.getText());
                }

            }
        }
        if (btnSecondPolynomial.isSelected()) {
            for (JButton btn : num) {
                if (e.getSource() == btn) {
                    textSecondPolynomial.setText(textSecondPolynomial.getText() + btn.getText());
                }

            }
            for (JButton btn : op) {
                if (e.getSource() == btn) {
                    if (btn.getText().equals("del")) {
                        if (textSecondPolynomial.getText().length() >= 1)
                            textSecondPolynomial.setText(textSecondPolynomial.getText().substring(0, textSecondPolynomial.getText().length() - 1));
                    } else textSecondPolynomial.setText(textSecondPolynomial.getText() + btn.getText());
                }

            }
        }
    }

    public void addAddListener(ActionListener al) {
        btnAdd.addActionListener(al);
    }

    public void addSubstractListener(ActionListener al) {
        btnSubstract.addActionListener(al);
    }

    public void addMultiplyListener(ActionListener al) {
        btnMultiply.addActionListener(al);
    }

    public void addDivideListener(ActionListener al) {
        btnDivide.addActionListener(al);
    }

    public void addDerivateListener(ActionListener al) {
        btnDerivate.addActionListener(al);
    }

    public void addIntegrateListener(ActionListener al) {
        btnIntegrate.addActionListener(al);
    }

    public void setVisible() {
        frame.setVisible(true);
    }

    public void showMessage() {
        setR1("");
        labelMessage.setText("Introduceti un polinom de forma a*x^p-x^q-b*x^r+c!");
    }

    public void clearMessage() {
        labelMessage.setText("");
    }
}
