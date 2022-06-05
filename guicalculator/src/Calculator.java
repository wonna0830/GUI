import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
 
 
public class Calculator extends JFrame implements ActionListener {
JLabel label;           
boolean state = false; 
double num1, num2; 
double result;        
String func = "";    
String nInput = ""; 
 
String btn[] = { "7", "8", "9", "��", "4", "5", "6", "��", "1", "2", "3", "-",  "0", "C", "=", "+" };        // ��ư �ȿ� �� �迭
 
 
public Calculator() {
 
    super("Calculator"); 
    super.setResizable(true); 
 
    label = new JLabel("0", JLabel.RIGHT); 
 
    JPanel mainView = new JPanel();
    label.setFont(new Font("Serif", Font.BOLD, 50)); 
    label.setBackground(Color.WHITE); 
    label.setOpaque(true);
 
    // ��ư â GUI
    JPanel btnView = new JPanel();
 
    btnView.setLayout(new GridLayout(5, 4, 2, 2));
 
    JButton button[] = new JButton[btn.length];
 
    for (int i = 0; i < btn.length; i++) {
        button[i] = new JButton(btn[i]);
        button[i].setFont(new Font("Serif", Font.BOLD, 25)); 
        button[i].addActionListener(this); 
 
        if (i == 0 || i == 1 || i == 18)
            button[i].setForeground(Color.RED); 
        if (i == 2 || i == 3 || i == 7 || i == 11 || i == 15 || i == 19)
            button[i].setForeground(Color.BLUE);
 
        btnView.add(button[i]);
 
    }
 
   
    mainView.setLayout(new BorderLayout());
    add(label, BorderLayout.CENTER); 
    add(btnView, BorderLayout.SOUTH);
 
    setBounds(100, 100, 300, 400); 
    setDefaultCloseOperation(EXIT_ON_CLOSE); 
    setVisible(true); 
 
}
 
public void actionPerformed(ActionEvent e) {
 
    String input = e.getActionCommand(); // �̺�Ʈ�� �߻���Ų ��ü�� ���ڿ��� �����ͼ� input�� ����
 
    if (input.equals("+")) {
        num1 = num2;  
        func = "+";
        nInput = ""; // �������� ���� ������ ����
 
    } else if (input.equals("-")) {
        num1 = num2;
        func = "-";
        nInput = "";
 
    } else if (input.equals("��")) {
        num1 = num2;
        func = "��";
        nInput = "";
 
    } else if (input.equals("��")) {
        num1 = num2;
        func = "��";
        nInput = "";
 
    } else if (input.equals("C")) {  // Clear
        nInput = "";
        num2 = 0;
        num1 = 0;
        label.setText("0");
 
    } else if (input.equals("=")) {
        if (func.equals("+")) {
            result = num1 + num2;
            label.setText(String.valueOf(result)); //������� ���ڿ��� ��ȯ�Ͽ� ���â�� ���
            state = true; // ��� ���� ���� �� ���� �Է��� ������ �� ȭ�鿡 ǥ�õ� ��� ���� �����.
 
        } else if (func.equals("-")) {
            result = num1 - num2;
            label.setText(String.valueOf(result));
            state = true;
 
        } else if (func.equals("��")) {
            result = num1 * num2;
            label.setText(String.valueOf(result));
            state = true;
 
        } 
    } else {
        if (state) {
            label.setText("0");
            state = false;
            num1 = 0;
            num2 = 0;
            nInput = "";
        }
 
        nInput += e.getActionCommand();
        label.setText(nInput);
        num2 = Double.parseDouble(nInput); //���ڿ����� double�� ��
 
    }
 
}
 
private void setBackSpace(String bs) {
    label.setText(bs);
}
 
private String getBackSpace() {
    return label.getText();
  }
}